// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;


public class RunMotors extends CommandBase {

  public static final int RIGHT = 0;
  public static final int LEFT = 1;
  public static final int BOTH = 2;

  private Drivetrain drivetrain;
  private int motors;
  private int forward;

  /** Creates a new RunMotors. */
  public RunMotors(Drivetrain drivetrain, int motors, boolean forward) {
    this.drivetrain = drivetrain;
    this.motors = motors;
    if(forward == true){
      this.forward = 1;
    }else{
      this.forward = -1;
    }
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    switch(motors){
      case 0:drivetrain.runRightMotor(forward);
        break;
      case 1:drivetrain.runLeftMotor(forward);
        break;
      case 2:drivetrain.run(forward);
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
