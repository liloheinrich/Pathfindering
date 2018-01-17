package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.SensorCollection;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveAutoDistanceCmd extends Command {
	private double speed;
	private double distance; // in rotations
	private double angle;
	boolean done;

	public DriveAutoDistanceCmd(double s, double d, double a) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.driveSubsystem);
		RobotMap.mainGyro.reset();
		done = false;
		angle = a;
		speed = s;
		distance = d; // - distance to travel
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		distance = -RobotMap.driveLeft2.getSensorCollection().getQuadraturePosition(); // - distance travelled
		SmartDashboard.putNumber("Encoder end count", distance);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		int pos = -RobotMap.driveLeft2.getSensorCollection().getQuadraturePosition(); // - distance travelled now
		SmartDashboard.putNumber("Encoder count", pos);
		SmartDashboard.putNumber("Gyro angle", RobotMap.mainGyro.getAngle());
		
		if(pos < distance){
			if(angle > RobotMap.mainGyro.getAngle()+2){
				Robot.driveSubsystem.drive(0, -speed);
			}else if(angle < RobotMap.mainGyro.getAngle()-2){
				Robot.driveSubsystem.drive(0, speed);
			}else{
				Robot.driveSubsystem.drive(speed, 0);
			}
		}else{
			Robot.driveSubsystem.drive(0, 0);
			done = true;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return done;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
