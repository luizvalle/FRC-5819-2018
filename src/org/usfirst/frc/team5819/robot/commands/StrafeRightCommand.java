package org.usfirst.frc.team5819.robot.commands;

import org.usfirst.frc.team5819.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StrafeRightCommand extends Command {

	public StrafeRightCommand() {
		
		super ("StrafeRight");
		requires(Robot.driveTrainSubsystem);
		
	}
	
	@Override
	protected void initialize() {
		
		Robot.driveTrainSubsystem.zeroSpeed();
	}
	
	@Override
	protected void execute() {
		
		Robot.driveTrainSubsystem.strafeRight();
	}
	
	@Override
	protected boolean isFinished() {
		
		return !Robot.oi.isStrafeRight();
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
