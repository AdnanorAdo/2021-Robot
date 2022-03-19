// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {
  //Declaring elevator motor. 
  PWMVictorSPX elevator;
  
  /** Creates a new Elevator. */

  public Elevator() {
    //Initializing elevator motor. 
    elevator = new PWMVictorSPX(Constants.ELEVATOR);
  }

  //This method makes the elevator go up
  public void GoingUp(double speed) {
    elevator.set(speed);
  }
  
  //This method makes the elevator go down. 
  public void GoingDown(double speed) {
    elevator.set(-speed);
  }

  //This method stops the motor from doing multiple tasks at once. 
  public void stop() {
    elevator.stopMotor();
  }
}


