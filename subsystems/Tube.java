// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Tube extends SubsystemBase {
  
  //Declare tube motor. 
  PWMVictorSPX tube;

  /** Creates a new Tube. */
  public Tube() {
    //Define tube motor. 
    tube = new PWMVictorSPX(Constants.TUBE);
  }

  //This method runs the tube motor to move the balls up the tube. 
  public void launchTube(double speed) {
    tube.set(speed);
  }

  //In the case that the tube is jammed with balls, it would run the motor in reverse. 
  public void unJamTube(double speed) {
    tube.set(-speed);
  }

  //This method is used to stop the tube motor from doing mutliple tasks at once. 
  public void stop() {
    tube.stopMotor();
  }
}
