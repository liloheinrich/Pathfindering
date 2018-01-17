package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveAutoTimeCmd extends Command {

	private double speed;
	private Timer timer;
	private double time;
	private double angle;

	public DriveAutoTimeCmd(double s, double t, double a) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		RobotMap.mainGyro.reset();
		timer = new Timer();
		requires(Robot.driveSubsystem);
		speed = s;
		angle = a;
		time = t;
	}



	protected void initialize() {
		timer.reset();
		timer.start();
	}

	protected void execute() {
		SmartDashboard.putNumber("Gyro angle", RobotMap.mainGyro.getAngle());
		if(angle > RobotMap.mainGyro.getAngle()+2 || angle < RobotMap.mainGyro.getAngle()-2){
			Robot.driveSubsystem.drive(0, speed);
		}else{
			Robot.driveSubsystem.drive(speed, 0);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if(timer.get() >= time){
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
