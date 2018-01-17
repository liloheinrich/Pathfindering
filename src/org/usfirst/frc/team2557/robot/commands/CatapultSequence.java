package org.usfirst.frc.team2557.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CatapultSequence extends CommandGroup {

    public CatapultSequence() {
    	
    	addSequential(new CatapultCommandPullingBack());
    	addSequential(new WaitForButton());
    	addSequential(new CatapultCommandShooting());
    }
}
