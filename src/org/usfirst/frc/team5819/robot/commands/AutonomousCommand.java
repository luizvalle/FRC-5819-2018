package org.usfirst.frc.team5819.robot.commands;

import org.usfirst.frc.team5819.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 * 
 * @author Luiz Valle
 *
 */
public class AutonomousCommand extends CommandGroup {
	
	private static AutonomousCommand instance;
	protected static boolean finished = false;
	
	public  AutonomousCommand() {
		
		addSequential(new AutonomousDrive(-0.5, -0.5, -0.5, -0.5), 2);
	}
	@Override
	protected boolean isFinished() {
		
		return false;
	}

	public static AutonomousCommand getInstance() {
		
		if (instance == null) {
			
			instance = new AutonomousCommand();
			
		}
		
		return instance;
	}
	
	class AutonomousDrive extends Command {
		
		private double leftFront, leftRear, rightFront, rightRear;
		
		public AutonomousDrive (double leftFront, double leftRear, double rightFront, double rightRear) {
			
			super("AutonomousDrive");
			
			this.leftFront = leftFront;
			this.leftRear = leftRear;
			this.rightFront = rightFront;
			this.rightRear = rightRear;
			
			requires(Robot.driveTrainSubsystem);
		}

		@Override
		protected void initialize() {
			
			Robot.driveTrainSubsystem.zeroSpeed();
		}
		
		@Override
		protected void execute() {
			
			Robot.driveTrainSubsystem.autonomousDrive(this.leftFront, this.leftRear, -this.rightFront, -this.rightRear);
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
			
			end ();
		}
	}
}
