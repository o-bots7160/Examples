# Examples
Examples of basic drivetrains, Auton, I2C with arduino, wiring



## Speed Controller naming conventions and configurations for Differential drive
```java
// Talons:
WPI_TalonSRX _rghtFront = new WPI_TalonSRX(1); // Masters are single digits
WPI_TalonSRX _rghtFollower = new WPI_TalonSRX(10); // Followers are the same id as the master but with a 0 added
WPI_TalonSRX _leftFront = new WPI_TalonSRX(2);
WPI_TalonSRX _leftFollower = new WPI_TalonSRX(20);
//
// Victors
WPI_VictorSPX _rghtFront = new WPI_VictorSPX(1);
WPI_VictorSPX _rghtFollower = new WPI_VictorSPX(10);
WPI_VictorSPX _leftFront = new WPI_VictorSPX(2);
WPI_VictorSPX _leftFollower = new WPI_VictorSPX(20);
//
// Diff drive
DifferentialDrive _diffDrive = new DifferentialDrive(_leftFront, _rghtFront); // Main controllers go in the drive
//
// This portion goes into your ro

```
