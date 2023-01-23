package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.drivetrain;

public class Drivetrain extends SubsystemBase{
    private static final Spark leftMotor = new Spark(0);
    private static final Spark rightMotor = new Spark(1);

    private static final Encoder leftEncoder = new Encoder(4,5);
    private static final Encoder rightEncoder = new Encoder(6,7);
    private static double motorSpeed = 1;

    public Drivetrain(){

        leftEncoder.setDistancePerPulse((Math.PI * drivetrain.kWheelDiameterInch) / drivetrain.kCountsPerRevolution);
        rightEncoder.setDistancePerPulse((Math.PI * drivetrain.kWheelDiameterInch) / drivetrain.kCountsPerRevolution);

        rightMotor.setInverted(true);

    }

  public  void stop(){
    leftMotor.set(0);
    rightMotor.set(0);
  }

  public double getLeftDistanceInch(){
    return leftEncoder.getDistance();
  }

  public double getRightDistanceInch(){
    return rightEncoder.getDistance();
  }

  public void resetEncoders(){
    leftEncoder.reset();
    rightEncoder.reset();
  }

  public void run(int forward){
    leftMotor.set(forward*motorSpeed);
    rightMotor.set(forward*motorSpeed);
  }

  public  void runLeftMotor(int forward){
    leftMotor.set(forward*motorSpeed);
  }

  public  void runRightMotor(int forward){
    rightMotor.set(forward*motorSpeed);
  }

  public  void turn(boolean clockwise){
    if(clockwise){
      rightMotor.set(-motorSpeed);
      leftMotor.set(motorSpeed);
    }else{
      rightMotor.set(motorSpeed);
      leftMotor.set(-motorSpeed);
    }
  }

  public  void setMotorSpeed(double percentOutput){
    motorSpeed = percentOutput;
  }
}
