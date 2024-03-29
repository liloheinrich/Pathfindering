package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeCommand extends Command {

    public IntakeCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intakeSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.m_oi.joystick1.getRawAxis(2)>0.1 && Robot.m_oi.joystick1.getRawAxis(3) < 0.1){
    		Robot.intakeSubsystem.in(-Robot.m_oi.joystick1.getRawAxis(2));
		}else if (Robot.m_oi.joystick1.getRawAxis(2)<0.1 && Robot.m_oi.joystick1.getRawAxis(3) > 0.1){
			Robot.intakeSubsystem.in(Robot.m_oi.joystick1.getRawAxis(3));
		}else{
			Robot.intakeSubsystem.in(0);
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
