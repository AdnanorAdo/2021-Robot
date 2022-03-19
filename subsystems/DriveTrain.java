// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveTrain extends SubsystemBase {
  
  //Declaring the motors for drivetrain
  PWMVictorSPX frontLeft;
  PWMVictorSPX backLeft;
  PWMVictorSPX frontRight;
  PWMVictorSPX backRight;
  //Declaring the drivetrain
  MecanumDrive drive;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    
    //Defining the motors for drivetrain
    frontLeft = new PWMVictorSPX(Constants.FRONT_LEFT);
    backLeft = new PWMVictorSPX(Constants.BACK_LEFT);
    frontRight = new PWMVictorSPX(Constants.FRONT_RIGHT);
    backRight = new PWMVictorSPX(Constants.BACK_RIGHT);
    //Defining the drivetrain
    drive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
  }
/*
* This function makes use of the mecanum wheels
* to drive omnidirectionally
*/
public void drive(Joystick controller, double speed) {
  drive.driveCartesian(controller.getX()*speed, -controller.getY()*speed, controller.getZ()*speed);
}

//This function is going to be used during autonomous, makes the robot go straight. 
public void driveForward(double speed) {
  drive.driveCartesian(0, speed, 0);
}

//This function is going to be used during autonomous, makes the robot go right. 
public void driveRight(double speed) {
  drive.driveCartesian(speed, 0, 0);
}

//This function is used to stop the drivetrain from doing multiple tasks at one time. 
public void stop() {
  drive.stopMotor();
}

}
