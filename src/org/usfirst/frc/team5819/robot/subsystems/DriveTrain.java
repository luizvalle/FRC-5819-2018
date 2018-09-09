package org.usfirst.frc.team5819.robot.subsystems;


import org.usfirst.frc.team5819.robot.RobotMap;
import org.usfirst.frc.team5819.robot.Robot;
import org.usfirst.frc.team5819.robot.commands.DriveWithController;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 * 
 * @author Luiz Valle and Liam Arzola
 *
 */
public class DriveTrain extends Subsystem {

	private static DriveTrain instance;
	
	private Spark leftFront;
	private Spark leftRear;
	private Spark rightFront;
	private Spark rightRear;
	
	public DriveTrain() {
		
		leftFront = new Spark(RobotMap.FRONT_LEFT_ID);
		leftRear = new Spark(RobotMap.REAR_LEFT_ID);
		rightFront = new Spark(RobotMap.FRONT_RIGHT_ID);
		rightRear = new Spark(RobotMap.REAR_RIGHT_ID);
		
	}

	@Override
	protected void initDefaultCommand() {
		
		setDefaultCommand(new DriveWithController());
		
	}
	
	public void tankDrive() {
		
		double leftX = Robot.oi.getLeft_X_Speed();
		double leftY = Robot.oi.getLeftSpeed();
		double rightX = Robot.oi.getRight_X_Speed();
		double rightY = Robot.oi.getRightSpeed();
		
		leftFront.set(leftX - leftY);
		leftRear.set(-leftY - leftX);
		rightFront.set(rightY + rightX);
		rightRear.set(rightY - rightX);
		
	}
	
	public void strafeLeft () {
		
		
		leftFront.set(-1);
		leftRear.set(1);
		rightFront.set(-1);
		rightRear.set(1);
		
	}
	
	public void strafeRight () {
		
		leftFront.set(1);
		leftRear.set(-1);
		rightFront.set(1);
		rightRear.set(-1);
	}
	
	public void autonomousDrive (double leftF, double leftR, double rightF, double rightR) {
		
		leftFront.set(leftF);
		leftRear.set(leftR);
		rightFront.set(rightF);
		rightRear.set(rightR);
		
	}
	public void zeroSpeed() {
		
		leftFront.set(0);
		leftRear.set(0);
		rightFront.set(0);
		rightRear.set(0);
	}
	//this is a drive train thing ~Liam
	
	public static DriveTrain getInstance() {
		
		if (instance == null) {
			
			instance = new DriveTrain();
			
		}
		
		return instance;
	}
}
