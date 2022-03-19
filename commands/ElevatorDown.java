// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Elevator;

public class ElevatorDown extends CommandBase {
  
  //Declaring the elevator. 
  private final Elevator elevator;

  /** Creates a new ElevatorDown. */
  public ElevatorDown(Elevator e) {
    //Initializing the elevator.
    elevator = e;
    addRequirements(elevator);
  }

  //Since we are going to be using this command more than one time,
  //we will use the execute method. 
  @Override
  public void execute() {
    elevator.GoingDown(Constants.ELEVATOR_SPEED);
  }

  //This method stops the motor from doing multiple commands at once.
  @Override
  public void end(boolean interrupted) {
    elevator.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
