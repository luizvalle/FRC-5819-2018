package org.usfirst.frc.team5819.robot.subsystems;

import org.usfirst.frc.team5819.robot.Robot;
import org.usfirst.frc.team5819.robot.RobotMap;
import org.usfirst.frc.team5819.robot.commands.LiftCubeCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 * 
 * @author Luiz Valle
 *
 */
public class Elevator extends Subsystem {
	
	private static Elevator instance;
	
	private Spark elevatorMotor;
	private DigitalInput topLimit, bottomLimit;
	
	public Elevator() {
		
		elevatorMotor = new Spark (RobotMap.ELEVATOR_ID);
		topLimit = new DigitalInput(RobotMap.TOP_LIMIT_SWITCH_ID);
		bottomLimit = new DigitalInput(RobotMap.BOTTOM_LIMIT_SWITCH_ID);
		
	}
	
	@Override
	protected void initDefaultCommand() {
		
		setDefaultCommand(new LiftCubeCommand());
		
	}
	
	public void operateLift () {
		double hatLifter = 0;
		double hatLowerer = 0;
			
		hatLifter = Robot.oi.getRaiseZ();
		
		hatLowerer = Robot.oi.getLowerZ();
		
		
		elevatorMotor.set(hatLifter - hatLowerer);
	}
	
	
	public void zeroSpeed() {
		
		elevatorMotor.set(0);
	}
	
	public boolean isTopLimitReached() {
		
		return topLimit.get();
	}
	
	public boolean isBottomLimitReached() {
		
		return bottomLimit.get();
	}
	
	public static Elevator getInstance() {
		
		if (instance == null) {
			
			instance = new Elevator();
		}
		
		return instance;
	}
}
