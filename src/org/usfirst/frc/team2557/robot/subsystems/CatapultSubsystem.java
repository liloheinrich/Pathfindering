package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.CatapultSequence;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CatapultSubsystem extends Subsystem {

	WPI_TalonSRX motor = RobotMap.catapultMotor;
    DigitalInput hallEffect = RobotMap.catapultHallEffect;
    boolean check = true;
	
	public void OtherPart(){
		SmartDashboard.putBoolean("hallValue", hallEffect.get());
		if(OI.button2.get()){
			motor.set(-.5);
			check = true;
		}
	
		else if(hallEffect.get()==true && check){
			motor.set(-.5);
		}
		else if(hallEffect.get()==false){
			motor.set(0);
			check = false;
		}	
	}
	  protected void initDefaultCommand() {
	        // Set the default command for a subsystem here.
	        //setDefaultCommand(new MySpecialCommand());
		  setDefaultCommand(new CatapultSequence());
	    }
}

