/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2557.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
    public static WPI_TalonSRX driveLeft1;
    public static WPI_TalonSRX driveLeft2;
    public static WPI_TalonSRX driveRight1;
    public static WPI_TalonSRX driveRight2;
    public static WPI_TalonSRX catapultMotor;
    public static WPI_TalonSRX climbingMotor;
    public static WPI_TalonSRX leftActuatorMotor;
//    public static WPI_TalonSRX rightActuatorMotor;
    
    public static SpeedControllerGroup left;
    public static SpeedControllerGroup right;
    
    public static DifferentialDrive robotDrive;
    
    public static WPI_TalonSRX intakeMotor;

    public static Servo secondaryArm;

    public static DigitalInput catapultHallEffect;

    public static Accelerometer rioAccelerometer;

    public static ADXRS450_Gyro mainGyro;
    public static AnalogInput leftPotentiometer;
    public static AnalogInput rightPotentiometer;
    
    public static Counter encoder;
    
    public static Timer timer;
    
    public static double timerValue;
    
    public static void init() {
    	
    	/*
    	 * CAN ports 6, 8, 2, and 3 have encoder breakouts.
    	 */
        driveLeft1 = new WPI_TalonSRX(7);
        driveLeft2 = new WPI_TalonSRX(6);
        driveRight1 = new WPI_TalonSRX(8);
        driveRight2 = new WPI_TalonSRX(5);
        catapultMotor = new WPI_TalonSRX(1);
        climbingMotor = new WPI_TalonSRX(9);
        leftActuatorMotor = new WPI_TalonSRX(2);
        driveLeft1.setInverted(true);
        driveLeft2.setInverted(true);
        driveRight1.setInverted(true);
        driveRight2.setInverted(true);
        
        left = new SpeedControllerGroup(driveLeft1, driveLeft2);
        right = new SpeedControllerGroup(driveRight1, driveRight2);
        
        robotDrive = new DifferentialDrive(left, right);
                

//        leftActuatorMotor.enableLimitSwitch(false, false);
//        rightActuatorMotor = new WPI_TalonSRX(3);
//        rightActuatorMotor.enableLimitSwitch(false, false);
        intakeMotor = new WPI_TalonSRX(4);

        secondaryArm = new Servo(4);

        catapultHallEffect = new DigitalInput(0);

        rioAccelerometer = new BuiltInAccelerometer();

        mainGyro = new ADXRS450_Gyro();
 
        leftPotentiometer = new AnalogInput(1);
        rightPotentiometer = new AnalogInput(2);

        timer = new Timer();   
        
    }
}
