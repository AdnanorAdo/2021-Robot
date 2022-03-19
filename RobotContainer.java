// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.CameraSwitch;
import frc.robot.commands.Drive;
import frc.robot.commands.DriveForward;
import frc.robot.commands.ElevatorDown;
import frc.robot.commands.ElevatorUp;
import frc.robot.commands.LaunchTube;
import frc.robot.commands.TakeBall;
import frc.robot.commands.TrapDoorMotion;
import frc.robot.commands.Unjam;
import frc.robot.commands.UnjamTube;
import frc.robot.subsystems.Cameras;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.TrapDoor;
import frc.robot.subsystems.Tube;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final Cameras cameras;
  private final CameraSwitch cameraSwitch;

  private final DriveTrain driveTrain;
  private final Drive drive;
  private final DriveForward driveForward;
  
  private final Elevator elevator;
  private final ElevatorUp elevatorUp;
  private final ElevatorDown elevatorDown;

  private final Intake intake;
  private final TakeBall takeBall;
  private final Unjam unjam;

  private final Tube tube;
  private final LaunchTube launchTube;
  private final UnjamTube unjamTube;

  private final TrapDoor trapDoor;
  private final TrapDoorMotion trapDoorMotion;

  
  public static Joystick driverJoystick;
  public static XboxController operator;
  public static JoystickButton switchcams;


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    //Initializing all subsystems and commands. 
    cameras = new Cameras();
    cameraSwitch = new CameraSwitch(cameras);
    cameraSwitch.addRequirements(cameras);
    cameras.setDefaultCommand(cameraSwitch);

    driveTrain = new DriveTrain();
    drive = new Drive(driveTrain);
    drive.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(drive);
    driveForward = new DriveForward(driveTrain);
    driveForward.addRequirements(driveTrain);

    elevator = new Elevator();
    elevatorUp = new ElevatorUp(elevator);
    elevatorUp.addRequirements(elevator);
    elevatorDown = new ElevatorDown(elevator);
    elevatorDown.addRequirements(elevator);

    intake = new Intake();
    takeBall = new TakeBall(intake);
    takeBall.addRequirements(intake);
    unjam = new Unjam(intake);
    unjam.addRequirements(intake);

    tube = new Tube();
    launchTube = new LaunchTube(tube);
    launchTube.addRequirements(tube);
    unjamTube = new UnjamTube(tube);
    unjamTube.addRequirements(tube);

    trapDoor = new TrapDoor();
    trapDoorMotion = new TrapDoorMotion(trapDoor);
    trapDoorMotion.addRequirements(trapDoor);

    driverJoystick = new Joystick(Constants.DRIVER_USB);
    operator = new XboxController(Constants.XBOX_USB);
    //Initializing all subsystems and commands. 
    
    // Configure the button bindings
    configureButtonBindings();
  }

  //This method is pretty self-explanatory, it binds the buttons to the commands. 
  private void configureButtonBindings() {
    
    JoystickButton goingUp = new JoystickButton(operator, XboxController.Button.kBumperRight.value);
    goingUp.whileHeld(new ElevatorUp(elevator));

    JoystickButton goingDown = new JoystickButton(operator, XboxController.Button.kBumperLeft.value);
    goingDown.whileHeld(new ElevatorDown(elevator));

    JoystickButton ballIntake = new JoystickButton(operator, XboxController.Button.kB.value);
    ballIntake.whileHeld(new TakeBall(intake));

    JoystickButton launchTube = new JoystickButton(operator, XboxController.Button.kB.value);
    launchTube.whileHeld(new LaunchTube(tube));

    JoystickButton unjamIntake = new JoystickButton(operator, XboxController.Button.kX.value);
    unjamIntake.whileHeld(new Unjam(intake));

    JoystickButton unjamTube = new JoystickButton(operator, XboxController.Button.kX.value);
    unjamTube.whileHeld(new UnjamTube(tube));

    JoystickButton trapDoorButton = new JoystickButton(operator, XboxController.Button.kA.value);
    trapDoorButton.whileHeld(new TrapDoorMotion(trapDoor));

    switchcams = new JoystickButton(operator, XboxController.Button.kY.value);

  }

  //This method calls for an autonomous command, so we return the command we made. 
  public Command getAutonomousCommand() {
    return driveForward;
  }
}
