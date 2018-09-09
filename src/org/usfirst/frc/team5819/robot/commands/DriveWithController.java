package org.usfirst.frc.team5819.robot.commands;

import org.usfirst.frc.team5819.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
/**
 * 
 * @author Luiz Valle
 *
 */
public class DriveWithController extends Command {

	
	public DriveWithController() {
		
		super ("DriveWithController");
		requires(Robot.driveTrainSubsystem);
		
	}
	
	@Override
	protected void initialize() {
		
		Robot.driveTrainSubsystem.zeroSpeed();
	}
	
	@Override
	protected void execute() {
		
		Robot.driveTrainSubsystem.tankDrive();
	}
	
	@Override
	protected boolean isFinished() {
		
		return false;
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
