// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;


public class Turn extends CommandBase {
  private Drivetrain drivetrain;
  private int degrees;
  private boolean specifyDegrees;
  private boolean clockwise = true;
  private double degreesTurned = 0;
  private double startEncoderDistance;

  /** Creates a new Turn. */
  public Turn(Drivetrain drivetrain, int degrees) {
    // Use addRequirements() here to declare subsystem dependencies.
    specifyDegrees = true;
    this.drivetrain = drivetrain;
    this.degrees = degrees;
    if(degrees >= 0){
      clockwise = true;
    }else{
      clockwise = false;
    }
    addRequirements(drivetrain);
  }
  public Turn(Drivetrain drivetrain){
    specifyDegrees = false;
  }

  public Turn(Drivetrain drivetrain, boolean clockwise){
    specifyDegrees = false;
    this.clockwise = clockwise;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.turn(clockwise);
    startEncoderDistance = drivetrain.getLeftDistanceInch();
    degreesTurned = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(!specifyDegrees)
      return true;
    degreesTurned = frc.robot.Constants.drivetrain.completeTurnDistance/(drivetrain.getLeftDistanceInch()-startEncoderDistance);
    return (degreesTurned >= (360/degrees));
  }
}
