package org.usfirst.frc.team5819.robot.commands;

import org.usfirst.frc.team5819.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
/**
 * 
 * @author Luiz Valle
 *
 */
public class LiftCubeCommand extends Command{

	public LiftCubeCommand() {
		
		super ("LiftCube");
		requires(Robot.elevatorSubsystem);
	}

	@Override
	protected void initialize() {
		
		Robot.elevatorSubsystem.zeroSpeed();
	}
	
	@Override
	protected void execute() {
		
		Robot.elevatorSubsystem.operateLift();
		
	}
	@Override
	protected boolean isFinished() {
		
		return false;
	}
	
	@Override
	protected void end() {
		
		Robot.elevatorSubsystem.zeroSpeed();
		
	}
	
	@Override
	protected void interrupted() {
		
		end();
	}

}
