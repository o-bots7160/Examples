
package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
  WPI_VictorSPX _rghtFront = new WPI_VictorSPX(10);
  WPI_VictorSPX _rghtFoll1 = new WPI_VictorSPX(11);
  WPI_VictorSPX _leftFront = new WPI_VictorSPX(20);
  WPI_VictorSPX _leftFoll1 = new WPI_VictorSPX(21);

  DifferentialDrive _diffDrive = new DifferentialDrive(_leftFront, _rghtFront);

  Joystick _joystick = new Joystick(0);


  @Override
  public void robotInit() {
    _rghtFront.configFactoryDefault();
    _rghtFoll1.configFactoryDefault();
    _leftFront.configFactoryDefault();
    _leftFoll1.configFactoryDefault();

    _rghtFoll1.follow(_rghtFront);
    _leftFoll1.follow(_leftFront);
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
    _diffDrive.arcadeDrive(_joystick.getY(), _joystick.getZ());
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
