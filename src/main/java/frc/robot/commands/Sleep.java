// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Sleep extends CommandBase {

  private int milliseconds;
  private boolean isDone = false;
  /** Creates a new Sleep. */
  public Sleep(int milliseconds) {
    this.milliseconds = milliseconds;
  
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    try {
      Thread.sleep(milliseconds);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    isDone = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isDone;
  }
}
