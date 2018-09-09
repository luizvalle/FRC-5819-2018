package org.usfirst.frc.team5819.robot.commands;

import org.usfirst.frc.team5819.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StrafeLeftCommand extends Command {

	public StrafeLeftCommand() {
		
		super ("StrafeLeft");
		requires(Robot.driveTrainSubsystem);
		
	}
	
	@Override
	protected void initialize() {
		
		Robot.driveTrainSubsystem.zeroSpeed();
	}
	
	@Override
	protected void execute() {
		
		Robot.driveTrainSubsystem.strafeLeft();
	}
	
	@Override
	protected boolean isFinished() {
		
		return !Robot.oi.isStrafeLeft();
	}
	
	@Override
	protected void end() {
		
		Robot.driveTrainSubsystem.zeroSpeed();
		
	}
	
	@Override
	protected void interrupted() {
		
		end();
	}

}
