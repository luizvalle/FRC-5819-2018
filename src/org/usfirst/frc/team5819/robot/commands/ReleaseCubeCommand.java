package org.usfirst.frc.team5819.robot.commands;

import org.usfirst.frc.team5819.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
/**
 * 
 * @author Luiz Valle
 *
 */
public class ReleaseCubeCommand extends Command {

	public ReleaseCubeCommand() {
		
		super ("ReleaseCube");
		requires(Robot.cubeGrabberSubsystem);
	}
	
	@Override
	protected void initialize() {
		
		Robot.cubeGrabberSubsystem.zeroSpeed();
	}
	
	@Override
	protected void execute() {
		
		Robot.cubeGrabberSubsystem.releaseCube();
		
		
	}
	
	@Override
	protected boolean isFinished() {
		
		return !Robot.oi.isRelease();
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
