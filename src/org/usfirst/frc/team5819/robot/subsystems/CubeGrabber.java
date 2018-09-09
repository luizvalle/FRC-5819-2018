package org.usfirst.frc.team5819.robot.subsystems;

import org.usfirst.frc.team5819.robot.Robot;
import org.usfirst.frc.team5819.robot.RobotMap;
import org.usfirst.frc.team5819.robot.commands.GrabCubeCommand;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 * 
 * @author Luiz Valle
 *
 */
public class CubeGrabber extends Subsystem {
	
	private static CubeGrabber instance;
	
	private Spark leftGrab;
	private Spark rightGrab;
	
	public CubeGrabber() {
		
		leftGrab = new Spark(RobotMap.LEFT_GRABBER_ID);
		rightGrab = new Spark(RobotMap.RIGHT_GRABBER_ID);
	}

	@Override
	protected void initDefaultCommand() {
		
		setDefaultCommand(null);
		
	}
	
	public void releaseCube() {
		
		leftGrab.set(1);
		rightGrab.set(1);
	}
	
	public void grabCube() {
		
		leftGrab.set(-1);
		rightGrab.set(-1);
	}
	
	public void zeroSpeed() {
		
		leftGrab.set(0);
		rightGrab.set(0);
	}
	
	public static CubeGrabber getInstance() {
		
		if (instance == null) {
			
			instance = new CubeGrabber();
		}
		
		return instance;
	}
}
