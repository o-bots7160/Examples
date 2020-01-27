# Examples
Examples of basic drivetrains, Auton (WPI), I2C with arduino (WPI), wiring (WPI)



## Speed Controller naming conventions and configurations for Differential drive and Mecanum
```java
// Joystick
Joystick _joystick = new Joystick(0);
//

// Differential Drive Start //

// Talons 
WPI_TalonSRX _rghtFront = new WPI_TalonSRX(10); // Masters are increments of 10,
WPI_TalonSRX _rghtFoll1 = new WPI_TalonSRX(11); // Followers will have the same tenths place but the second value is 1-9
WPI_TalonSRX _leftFront = new WPI_TalonSRX(20);
WPI_TalonSRX _leftFoll1 = new WPI_TalonSRX(21);
//
// Victors
WPI_VictorSPX _rghtFront = new WPI_VictorSPX(10);
WPI_VictorSPX _rghtFoll1 = new WPI_VictorSPX(11);
WPI_VictorSPX _leftFront = new WPI_VictorSPX(21);
WPI_VictorSPX _leftFoll1 = new WPI_VictorSPX(21);
//
// Diff drive
DifferentialDrive _diffDrive = new DifferentialDrive(_leftFront, _rghtFront); // Main controllers go in the drive
//
// This portion goes into your robotInit or other
_rghtFront.configFactoryDefault();
_rghtFoll1.configFactoryDefault();
_leftFront.configFactoryDefault();
_leftFoll1.configFactoryDefault();
_rghtFoll1.follow(_rghtFront);
_leftFoll1.follow(_leftFront);
//

/* Differential drive is special and has two modes. Arcade and Tank */
// Arcade drive uses one joystick and looks for the Y and Z values from it. Y is forward/back. Z is Rotation
_diffDrive.arcadeDrive(_joystick.getY(), _joystick.getZ());

// Tank drive uses two sticks on a single joystick or two seperate joysticks
// Single Joystick. Y is forward/back left motors. Z is forward/back for right motors. 
_diffDrive.tankDrive((_joystick1.getY(), joystick1.getZ());
// Two Joysticks. Joystick1 Y is forward/back left motors. Joystick2 Z is forward/back for right motors.
_diffDrive.tankDrive((_joystick1.getY(), _joystick2.getY());// Two Joysticks

// Differential Drive End//

// Mecanum Drive Start //

// Talons
WPI_TalonSRX _rghtFront = new WPI_TalonSRX(10); // Mecanum doesn't have master follower-IDS are 10's for right side
WPI_TalonSRX _rghtBack = new WPI_TalonSRX(11); // back motors are 1 digit behind front motors
WPI_TalonSRX _leftFront = new WPI_TalonSRX(20); // Left motors are 20's
WPI_TalonSRX _leftBack = new WPI_TalonSRX(21);
//
// Victors
WPI_VictorSPX _rghtFront = new WPI_VictorSPX(10);
WPI_VictorSPX _rghtBack = new WPI_VictorSPX(11);
WPI_VictorSPX _leftFront = new WPI_VictorSPX(20);
WPI_VictorSPX _leftBack = new WPI_VictorSPX(21);
//
// Mecanum Drive
MecanumDrive mainDrive = new MecanumDrive(_leftFront, _leftBack, _rghtFront, _rghtBack);
//
// This goes into the robotInit
_rghtFront.configFactoryDefault();
_rghtBack.configFactoryDefault();
_leftFront.configFactoryDefault();
_leftBack.configFactoryDefault();
//
// This goes into teleopPeriodic and controls the robot
mainDrive.driveCartesian(_joystick.getY(), _joystick.getX(), _joystick.getZ());
//
// Mecanum Drive End //
```
