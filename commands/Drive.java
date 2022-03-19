// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class Drive extends CommandBase {
  
  //Declaring the drivetrain
  private final DriveTrain driveTrain;
  
  public Drive(DriveTrain dt) {
    //Initializing the drivetrain
    driveTrain = dt;
    addRequirements(driveTrain);
  }
  @Override
  public void execute() {
    driveTrain.drive(RobotContainer.driverJoystick, Constants.DRIVETRAINSPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
