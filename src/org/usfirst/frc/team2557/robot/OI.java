/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2557.robot;

import org.usfirst.frc.team2557.robot.commands.CatapultCommandShooting;
import org.usfirst.frc.team2557.robot.commands.ClimberCommand;
import org.usfirst.frc.team2557.robot.commands.IntakeCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick joystick1;
	public static JoystickButton button1;
	public static JoystickButton button2;
	public static JoystickButton button3;
	public static JoystickButton button4;
	public static JoystickButton button5;
	public static JoystickButton button6;
	
	public Joystick joystick2;
	public static JoystickButton button21;
	public static JoystickButton button24;
	public static JoystickButton button25;
	public static JoystickButton button28;
	
	
	public OI(){
		joystick1 = new Joystick(0);
		
		button1 = new JoystickButton (joystick1, 1);
		
	//.whileHeld(new GyroCommand());
		
		button2 = new JoystickButton (joystick1, 2);
		button2.whenPressed(new CatapultCommandShooting());
		
		button3 = new JoystickButton (joystick1, 3);
		button3.whileHeld(new ClimberCommand());	
		
		button4 = new JoystickButton(joystick1, 4);
		
		button5 = new JoystickButton(joystick1, 5);
		
		button6 = new JoystickButton(joystick1, 6);
		//setting buttons to ports
		
		button28 = new JoystickButton(joystick1, 8);
		
		button24 = new JoystickButton(joystick2, 2);
		
		
	}
}
