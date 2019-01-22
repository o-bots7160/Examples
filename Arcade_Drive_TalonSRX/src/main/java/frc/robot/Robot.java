
package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
  WPI_TalonSRX _rghtFront = new WPI_TalonSRX(1);
  WPI_TalonSRX _rghtFollower = new WPI_TalonSRX(10);
  WPI_TalonSRX _leftFront = new WPI_TalonSRX(2);
  WPI_TalonSRX _leftFollower = new WPI_TalonSRX(20);

  DifferentialDrive _diffDrive = new DifferentialDrive(_leftFront, _rghtFront);

  Joystick _joystick = new Joystick(0);


  @Override
  public void robotInit() {
    _rghtFront.configFactoryDefault();
    _rghtFollower.configFactoryDefault();
    _leftFront.configFactoryDefault();
    _leftFollower.configFactoryDefault();

    _rghtFollower.follow(_rghtFront);
    _leftFollower.follow(_leftFront);
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
    _diffDrive.arcadeDrive(_joystick.getY(), _joystick.getX());
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
