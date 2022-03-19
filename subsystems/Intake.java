// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  
  //Declaring intake motor.
  PWMVictorSPX intake;
  
  /** Creates a new Intake. */
  public Intake() {
    //Defining intake motor. 
    intake = new PWMVictorSPX(Constants.INTAKE);
  }
  
  //This method runs the intake motor to take balls.
  public void takeBall(double speed) {
    intake.set(speed);
  }  
  
  //This method is used in the case that the intake/tube is jammed with balls. 
  public void unJam(double speed) {
    intake.set(-speed);
  }
  
  //This method is used to stop the intake motor from doing multiple tasks at once. 
  public void stop() {
    intake.stopMotor();
  }

}
