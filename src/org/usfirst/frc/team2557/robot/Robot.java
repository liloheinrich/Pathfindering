/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.command.TimedCommand;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2557.robot.commands.CatapultCommandPullingBack;
import org.usfirst.frc.team2557.robot.commands.CatapultCommandShooting;
import org.usfirst.frc.team2557.robot.commands.CatapultSequence;
import org.usfirst.frc.team2557.robot.commands.DriveCommand;
import org.usfirst.frc.team2557.robot.commands.GyroDrive;
import org.usfirst.frc.team2557.robot.commands.GyroDriveAuto;
import org.usfirst.frc.team2557.robot.commands.ArmCommand;
import org.usfirst.frc.team2557.robot.commands.ClimberCommand;
import org.usfirst.frc.team2557.robot.commands.DriveByDistanceAuto;
import org.usfirst.frc.team2557.robot.commands.DriveByTimeAuto;
import org.usfirst.frc.team2557.robot.commands.IntakeCommand;
import org.usfirst.frc.team2557.robot.subsystems.CatapultSubsystem;
import org.usfirst.frc.team2557.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team2557.robot.subsystems.ArmSubsystem;
import org.usfirst.frc.team2557.robot.subsystems.ClimberSubsystem;
import org.usfirst.frc.team2557.robot.subsystems.IntakeSubsystem;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	public static OI m_oi;
	
	public static DriveSubsystem driveSubsystem;
	public static ClimberSubsystem climberSubsystem;
	public static ArmSubsystem armSubsystem;
	public static CatapultSubsystem catapultSubsystem;
	public static IntakeSubsystem intakeSubsystem;
	
//	public static GyroSubsystem gyroSubsystem;
	//public static CatapultCommandShooting catapultCommandShooting;
//	public static CatapultCommandPullingback catapultCommandPullingback;
	public static ClimberCommand climberCommand;
	public static DriveCommand driveCommand;
	public static ArmCommand armCommand;
	public static CatapultCommandPullingBack catapultCommandPullingBack;
	public static CatapultCommandShooting catapultCommandShooting;
	public static CatapultSequence catapultSequence;
	public static IntakeCommand intakeCommand;
	//Command AutoDriveCommand;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
    	RobotMap.init();
		driveSubsystem = new DriveSubsystem();
		driveCommand = new DriveCommand();
		armSubsystem = new ArmSubsystem();
		armCommand = new ArmCommand();
		catapultSubsystem = new CatapultSubsystem();	
		catapultCommandPullingBack = new CatapultCommandPullingBack();
		catapultCommandShooting = new CatapultCommandShooting();
		climberSubsystem = new ClimberSubsystem();
		climberCommand = new ClimberCommand();
		intakeSubsystem = new IntakeSubsystem();
		intakeCommand = new IntakeCommand();
		
		RobotMap.mainGyro.reset();
	
		m_oi = new OI();
		m_chooser.addDefault("Null Auto option", null);
//		m_chooser.addObject("DriveByTimeAuto", new DriveByTimeAuto());
//		m_chooser.addObject("DriveByDistanceAuto", new DriveByDistanceAuto());
//		m_chooser.addObject("Null Auto option", null);
		m_chooser.addObject("Gyro drive", new GyroDriveAuto());
		SmartDashboard.putData("Auto mode", m_chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
		
//		if (autonomousCommand != null) autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
		
//		if (autonomousCommand != null) autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
