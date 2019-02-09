# Examples
Examples of basic drivetrains, Auton, I2C with arduino, wiring



## Speed Controller naming conventions and configurations for Differential drive and Mecanum
```java
// Joystick
Joystick _joystick = new Joystick(0);
//

// Differential Drive Start //

// Talons 
WPI_TalonSRX _rghtFront = new WPI_TalonSRX(10); // Masters are single digits
WPI_TalonSRX _rghtFollower = new WPI_TalonSRX(11); // Followers are the same id as the master but with a 0 added
WPI_TalonSRX _leftFront = new WPI_TalonSRX(20);
WPI_TalonSRX _leftFollower = new WPI_TalonSRX(21);
//
// Victors
WPI_VictorSPX _rghtFront = new WPI_VictorSPX(10);
WPI_VictorSPX _rghtFollower = new WPI_VictorSPX(11);
WPI_VictorSPX _leftFront = new WPI_VictorSPX(21);
WPI_VictorSPX _leftFollower = new WPI_VictorSPX(21);
//
// Diff drive
DifferentialDrive _diffDrive = new DifferentialDrive(_leftFront, _rghtFront); // Main controllers go in the drive
//
// This portion goes into your robotInit or other
_rghtFront.configFactoryDefault();
_rghtFollower.configFactoryDefault();
_leftFront.configFactoryDefault();
_leftFollower.configFactoryDefault();
_rghtFollower.follow(_rghtFront);
_leftFollower.follow(_leftFront);
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
WPI_TalonSRX _rghtFront = new WPI_TalonSRX(1); // Masters are single digits
WPI_TalonSRX _rghtBack = new WPI_TalonSRX(10); // Back motors are the same id as the master but with a 0 added
WPI_TalonSRX _leftFront = new WPI_TalonSRX(2);
WPI_TalonSRX _leftBack = new WPI_TalonSRX(20);
//
// Victors
WPI_VictorSPX _rghtFront = new WPI_VictorSPX(1);
WPI_VictorSPX _rghtBack = new WPI_VictorSPX(10);
WPI_VictorSPX _leftFront = new WPI_VictorSPX(2);
WPI_VictorSPX _leftBack = new WPI_VictorSPX(20);
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
