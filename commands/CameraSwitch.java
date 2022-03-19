// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Cameras;

public class CameraSwitch extends CommandBase {
 
  //Declaring the cameras
  private final Cameras cameras;
  
  /*This method implements the cameras, so when we put this into "RobotContainer"
  * it'll only need a couple lines of code. 
  */
  public CameraSwitch(Cameras c) {
    //Initializing the cameras
    cameras = c;
    addRequirements(cameras);
  }

  @Override
  //Since we don't really need this to be called all the time, you put it into the initialize method.
  //Most of the work was done in the "Cameras" class, so all you need to do is call the method you made.
  public void initialize() {
    cameras.cameraSwitch(RobotContainer.switchcams);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
