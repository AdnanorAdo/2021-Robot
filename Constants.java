// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
	/*If you ever change the PWM port for a motorcontroller, make sure you update that in this file!
	*The value range for the motors goes from -1.0 to 1.0 so anything in between works. 
	*You don't really need to use the negative values because you can invert that value in a class. 
	*/

	//These values are the respective PWM ports for the drivetrain. 
	public static final int FRONT_LEFT = 7;
	public static final int BACK_LEFT = 6;
	public static final int FRONT_RIGHT = 9;
	public static final int BACK_RIGHT = 8;
	/*These values control the speed of the drivetrain during teleop
	*and autonomous. This also includes the timers for the autonomous
	*round, you can change these values to do some extra testing! 
	*/
	public static final double DRIVETRAINSPEED = 0.8;
	public static final double DT_AUTONOMOUS_SPEED = 0.2;
	public static final double AUTONOMOUS_TIME_1 = 4;
	public static final double AUTONOMOUS_TIME_2 = 13;

	//This value is the respective PWM port for the elevator. 
	public static final int ELEVATOR = 5;
	//This value controls the speed of the elevator, you can change this value.
	public static final double ELEVATOR_SPEED = 0.2;

	//This value is the respective PWM port for the intake. 
	public static final int INTAKE = 2;
	//This value controls the speed of the intake, you can change this value. 
	public static final double INTAKE_SPEED = 0.75;
	
	//This value is the respective PWM port for the tube. 
	public static final int TUBE = 1;
	//This value controls the speed of the tube, you can change this value. 
	public static final double TUBE_SPEED = 0.5;

	//This value is the respective PWM port for the trapdoor.
	public static final int TRAPDOOR = 0;
	//This value controls the speed of the trapdoor, you can change this value. 
	public static final double TRAPDOOR_SPEED = 0.5;

	//These values are for the respective USB ports for the controllers. 
    public static final int XBOX_USB = 0;
    public static final int DRIVER_USB = 1;

}
