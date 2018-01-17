package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.ClimberCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimberSubsystem extends Subsystem {
	
	boolean SecondArmUp = true;
	
    public void ArmGoUp(){
    	if(OI.button3.get()){
    		RobotMap.secondaryArm.set(1);
    		SecondArmUp = true;
    	}else if(SecondArmUp){
    		RobotMap.secondaryArm.set(0);
    	}
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ClimberCommand());
    }
}

