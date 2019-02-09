/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.MecanumDrive;


public class Robot extends TimedRobot {

  WPI_VictorSPX _rghtFront = new WPI_VictorSPX(10); // Masters are single digits
  WPI_VictorSPX _rghtBack = new WPI_VictorSPX(11); // Back motors are the same id as the master but with a 0 added
  WPI_VictorSPX _leftFront = new WPI_VictorSPX(20);
  WPI_VictorSPX _leftBack = new WPI_VictorSPX(21);

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
