
package org.usfirst.frc.team5819.robot;

import org.usfirst.frc.team5819.robot.commands.AutonomousCommand;
import org.usfirst.frc.team5819.robot.commands.DriveWithController;
import org.usfirst.frc.team5819.robot.commands.GrabCubeCommand;
import org.usfirst.frc.team5819.robot.commands.LiftCubeCommand;
import org.usfirst.frc.team5819.robot.commands.ReleaseCubeCommand;
import org.usfirst.frc.team5819.robot.commands.StrafeLeftCommand;
import org.usfirst.frc.team5819.robot.commands.StrafeRightCommand;
import org.usfirst.frc.team5819.robot.subsystems.CubeGrabber;
import org.usfirst.frc.team5819.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5819.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	public static AutonomousCommand autonomousCommand;
	
	public static OI oi;
	public static DriveTrain driveTrainSubsystem;
	public static Elevator elevatorSubsystem;
	public static CubeGrabber cubeGrabberSubsystem;
	
	public static boolean isAutonomousOn;
	
	SendableChooser<Command> chooser = new SendableChooser<>();

	
	@Override
	public void robotInit() {
		
		oi = OI.getInstance();
		
		//Subsystems
		driveTrainSubsystem = DriveTrain.getInstance();
		elevatorSubsystem = Elevator.getInstance();
		cubeGrabberSubsystem = CubeGrabber.getInstance();
		
		chooser.addObject("DriveWithController", new DriveWithController ());
		chooser.addObject("LiftCube", new LiftCubeCommand());
		chooser.addObject("GrabCube", new GrabCubeCommand());
		
		//Button mapping to commands
		oi.grabButton.whenPressed(new GrabCubeCommand());
		oi.releaseButton.whenPressed(new ReleaseCubeCommand());
		oi.strafeLeftButton.whenPressed(new StrafeLeftCommand());
		oi.strafeRightButton.whenPressed(new StrafeRightCommand());
		
		SmartDashboard.putData(driveTrainSubsystem);
		SmartDashboard.putData(elevatorSubsystem);
		SmartDashboard.putData(cubeGrabberSubsystem);
		
		autonomousCommand = AutonomousCommand.getInstance();
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		
	}

	@Override
	public void autonomousInit() {
		
		autonomousCommand.start();
		isAutonomousOn = true;
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		
		if (autonomousCommand != null) {
			
			autonomousCommand.cancel();
		}
		
		isAutonomousOn = false;
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}
}
