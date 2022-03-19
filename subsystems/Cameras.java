// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.cameraserver.CameraServer;

public class Cameras extends SubsystemBase {
  
  //Declaring cameras and camera selection for smart dashboard. 
  UsbCamera camera1;
  UsbCamera camera2;
  NetworkTableEntry cameraSelection;
  /** Creates Cameras. */
  public Cameras() {
    
    //Defining cameras and the camera selection. 
    camera1 = CameraServer.getInstance().startAutomaticCapture(0);
    camera2 = CameraServer.getInstance().startAutomaticCapture(1);

    cameraSelection = NetworkTableInstance.getDefault().getTable("").getEntry("CameraSelection");
  }

  /*This method's intention was to switch cameras during the match. 
  *But the driver station software lets you see both cameras at the same time. 
  */
  public void cameraSwitch(JoystickButton button){
    
    
    //This if statement checks for when a button is pressed.
    //If a button is pressed, it will set to camera 2, otherwise it'll be set to 1.
    if(button.get())
    {
      System.out.println("Setting camera 2");
      cameraSelection.setString(camera2.getName());
    }
    else{
      System.out.println("Setting camera 1");
      cameraSelection.setString(camera1.getName());
    }

  }
}
