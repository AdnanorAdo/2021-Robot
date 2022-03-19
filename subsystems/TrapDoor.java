// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TrapDoor extends SubsystemBase {
  //Declare trapdoor motor.
  private final PWMVictorSPX trapDoor;
  
  /** Creates a new TrapDoor. */
  public TrapDoor() {
    //Defining trapdoor motor.
    trapDoor = new PWMVictorSPX(Constants.TRAPDOOR);
  }
  
  //This method opens the trapdoor. 
  public void goingUp(double speed) {
    trapDoor.set(speed);
  }
  
  //This method stops the motor. 
  public void stop() {
    trapDoor.stopMotor();
  }
}
