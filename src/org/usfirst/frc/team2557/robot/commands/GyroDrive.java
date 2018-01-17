package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GyroDrive extends Command {
	double angle;
	boolean done;

    public GyroDrive(double a) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSubsystem);
		angle = a;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.mainGyro.reset();
    	done = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("Gyro angle", RobotMap.mainGyro.getAngle());
    	SmartDashboard.putNumber("Gyro rate", RobotMap.mainGyro.getRate());
    	
    	if(angle > RobotMap.mainGyro.getAngle()+2){
			Robot.driveSubsystem.drive(0, -0.5);
		}else if(angle < RobotMap.mainGyro.getAngle()-2){
			Robot.driveSubsystem.drive(0, 0.5);
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
