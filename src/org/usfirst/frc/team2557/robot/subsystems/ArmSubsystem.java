package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.ArmCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmSubsystem extends Subsystem {
	
	public void Arm(){
		
//		RobotMap.rightActuatorMotor.set(-Robot.m_oi.joystick1.getRawAxis(5)*.75);
		RobotMap.leftActuatorMotor.set(-Robot.m_oi.joystick1.getRawAxis(5)*.75);
		//both of them move from the joystick2
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ArmCommand());
    }
}

