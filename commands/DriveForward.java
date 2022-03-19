// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class DriveForward extends CommandBase {
  
  //Initializing the drivetrain
  //Declaring the timer and a boolean.
  private final DriveTrain driveTrain;
  private boolean finish = false;
  Timer timer;

  /** Creates a new DriveForward. */
  public DriveForward(DriveTrain dt) {
    //Initializing the drivetrain
    //Defining the timer. 
    driveTrain = dt;
    addRequirements(driveTrain);
    timer = new Timer();
  }

  /*Since this is going to be the autonomous command, we put it into the initialize method
  * since it only needs to be done once. 
  * This method makes the robot move right first for a set amount of time, then it moves
  * forward for a set amount of time.
  */
  @Override
  public void initialize() {
    
    timer.reset();
    timer.start();

    while(timer.get() < Constants.AUTONOMOUS_TIME_1){
      driveTrain.driveRight(Constants.DT_AUTONOMOUS_SPEED);
    }

    timer.reset();
    timer.start();

    while(timer.get() < Constants.AUTONOMOUS_TIME_2){
      driveTrain.driveForward(Constants.DT_AUTONOMOUS_SPEED);
    }

    finish = true;
  }

  //This stops the drivetrain from doing multiple commands at once. 
  @Override
  public void end(boolean interrupted) {
    driveTrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finish;
  }
}
