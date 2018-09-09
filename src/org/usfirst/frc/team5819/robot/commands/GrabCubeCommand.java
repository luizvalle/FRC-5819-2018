package org.usfirst.frc.team5819.robot.commands;

import org.usfirst.frc.team5819.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
/**
 * 
 * @author Luiz Valle
 *
 */
public class GrabCubeCommand extends Command {

	public GrabCubeCommand() {
		
		super ("GrabCube");
		requires(Robot.cubeGrabberSubsystem);
	}
	
	@Override
	protected void initialize() {
		
		Robot.cubeGrabberSubsystem.zeroSpeed();
	}
	
	@Override
	protected void execute() {
		
		Robot.cubeGrabberSubsystem.grabCube();
		
		
	}
	
	@Override
	protected boolean isFinished() {
		
		return !Robot.oi.isGrab();
	}
	
	@Override
	protected void end() {
		
		Robot.cubeGrabberSubsystem.zeroSpeed();
		
	}
	
	@Override
	protected void interrupted() {
		
		end();
	}

	
}
