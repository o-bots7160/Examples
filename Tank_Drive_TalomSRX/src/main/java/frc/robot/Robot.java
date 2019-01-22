
package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.InvertType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
  //**    Type                  varName                PORT ID
      WPI_TalonSRX           _rghtFront      = new WPI_TalonSRX(1);
      WPI_TalonSRX           _rghtFollower   = new WPI_TalonSRX(10);
      WPI_TalonSRX           _leftFront      = new WPI_TalonSRX(2);
      WPI_TalonSRX           _leftFollower   = new WPI_TalonSRX(20);

      Joystick                _joystick1      = new Joystick(0);

      DifferentialDrive       _diffDrive      = new DifferentialDrive(_leftFront, _rghtFront);


  @Override
  public void robotInit() {
      _rghtFront.configFactoryDefault();
      _rghtFollower.configFactoryDefault();
      _leftFront.configFactoryDefault();
      _leftFollower.configFactoryDefault();

      _rghtFollower.follow(_rghtFront);
      _leftFollower.follow(_leftFront);

    /*
     * Flip values so robot moves forward when stick-forward
     */
    _rghtFront.setInverted(true);
    _leftFront.setInverted(false);

    /*
     * set the invert of the followers to match their respective master controllers
     */
    _rghtFollower.setInverted(InvertType.FollowMaster);
    _leftFollower.setInverted(InvertType.FollowMaster);
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    _diffDrive.tankDrive((_joystick1.getY()*-1) /4, (_joystick1.getZ())/4);//*-1 makes the lights flash the correct color
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
