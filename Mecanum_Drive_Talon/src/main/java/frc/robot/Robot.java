package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.MecanumDrive;


public class Robot extends TimedRobot {

  WPI_TalonSRX _rghtFront = new WPI_TalonSRX(1); // Masters are single digits
  WPI_TalonSRX _rghtBack = new WPI_TalonSRX(10); // Back motors are the same id as the master but with a 0 added
  WPI_TalonSRX _leftFront = new WPI_TalonSRX(2);
  WPI_TalonSRX _leftBack = new WPI_TalonSRX(20);

  MecanumDrive mainDrive = new MecanumDrive(_leftFront, _leftBack, _rghtFront, _rghtBack);

  Joystick _joystick = new Joystick(0);

  @Override
  public void robotInit() {
    _rghtFront.configFactoryDefault();
    _rghtBack.configFactoryDefault();
    _leftFront.configFactoryDefault();
    _leftBack.configFactoryDefault();
  }

  @Override
  public void teleopPeriodic() {
    mainDrive.driveCartesian(_joystick.getY(), _joystick.getX(), _joystick.getZ());
  }

  

}
