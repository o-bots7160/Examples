/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  WPI_TalonSRX _lift = new WPI_TalonSRX(30);
  double P = -0.0004, I = 0, D = 0;
	// CTREEnocder weird stuff
	CTREEncoder enc = new CTREEncoder(_lift);
	// PID controller
	PIDController liftPID = new PIDController(P, I, D, enc, _lift);

  Joystick _joy = new Joystick(0);

  int step2 = 1;

  enum getToBottomModes{
    SETBOTTOMPOINT, TURNLIFTOFF
  }

  getToBottomModes modes;

  @Override
  public void teleopInit() {
    reset();
    step = 1;
    liftPID.setOutputRange(-0.3, 0.5);
    liftPID.setSetpoint(0);
    liftPID.disable();
    modes = getToBottomModes.SETBOTTOMPOINT;
  }

  int step = 1;

  @Override
  public void teleopPeriodic() {
    SmartDashboard.putNumber("Encoder", _lift.getSelectedSensorPosition(0));
    SmartDashboard.putNumber("Step", step);
    SmartDashboard.putNumber("Voltage", _lift.getMotorOutputVoltage());
    SmartDashboard.putNumber("Set point", liftPID.getSetpoint());

    if(_joy.getRawButton(8)){
      liftPID.disable();
      _lift.set(.5);
      liftPID.setSetpoint(_lift.getSelectedSensorPosition(0));
    }else if(_joy.getRawButton(7)){
      liftPID.disable();
      _lift.set(-.3);
      liftPID.setSetpoint(_lift.getSelectedSensorPosition(0));
    // Ball panel heights
    }else if(_joy.getRawButton(3)){
      liftPID.setSetpoint(-7082);
    }else if(_joy.getRawButton(4)){
      liftPID.setSetpoint(-17045);
    }else if(_joy.getRawButton(6)){
      liftPID.setSetpoint(-26330);
    // Hatch height
    }else if(_joy.getRawButton(9)){
      goToBottom();
    }else if(_joy.getRawButton(10)){
      liftPID.setSetpoint(-10200);
    }else if(_joy.getRawButton(11)){
      liftPID.setSetpoint(-20117);
    // Ball height for cargo ship
    }else if(_joy.getRawButton(12)){
      // idk yet
    }
    else{
        switch(step){
          case 1:
          liftPID.disable();
            _lift.set(0);
            if(_joy.getRawButtonPressed(5))
              step++;
            break;
          case 2:
            liftPID.enable();
            if(_joy.getRawButtonPressed(5))
              step--;
            break;
        }
      }

  }

  double getEncoder(){
    return _lift.getSelectedSensorPosition(0);
  }

  void reset() {
		_lift.getSensorCollection().setPulseWidthPosition(0, 100);
		_lift.getSensorCollection().setQuadraturePosition(0, 100);
  }
  
  void goToBottom(){
    switch(modes){
      case SETBOTTOMPOINT:
        liftPID.setSetpoint(-1000);
        modes = getToBottomModes.TURNLIFTOFF;
        break;
      case TURNLIFTOFF:
        if(_lift.getSelectedSensorPosition(0)<-1100)
          step = 1;
          liftPID.disable();
        break;
    }
  }

}

class CTREEncoder implements PIDSource {

  WPI_TalonSRX talon;

  public CTREEncoder(WPI_TalonSRX talon){

      this.talon = talon;
  }
     
  public int get() {
      return talon.getSelectedSensorPosition();
  }
  @Override

  public double pidGet() {
      return get();
  }

  @Override

  public PIDSourceType getPIDSourceType() {
      return PIDSourceType.kDisplacement;

  }

  @Override

  public void setPIDSourceType (PIDSourceType pidSource){
      
  }
}