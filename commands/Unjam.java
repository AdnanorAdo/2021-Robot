// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;

public class Unjam extends CommandBase {
 
  private final Intake intake;
  
  /** Creates a new Unjam. */
  public Unjam(Intake i) {
    intake = i;
    addRequirements(intake);
  }
  //Since we are going to be using this command more than one time,
  //we will use the execute method. 
  @Override
  public void execute() {
    intake.unJam(Constants.INTAKE_SPEED);
  }

  //This method stops the motor from doing multiple commands at once.
  @Override
  public void end(boolean interrupted) {
    intake.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
