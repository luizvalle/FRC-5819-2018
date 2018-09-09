
package org.usfirst.frc.team5819.robot;

import org.usfirst.frc.team5819.robot.commands.GrabCubeCommand;
import org.usfirst.frc.team5819.robot.commands.ReleaseCubeCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	
	private static OI instance;
	
	private Joystick controller;
	public Button grabButton, releaseButton, strafeLeftButton, strafeRightButton,
	redLedButton, blueLedButton, offLedButton, greenLedButton;
	
	public OI () {
		
		controller = new Joystick(RobotMap.JOYSTICK_PORT);
		
		redLedButton = new JoystickButton(controller, 1);
		blueLedButton = new JoystickButton(controller, 2);
		offLedButton = new JoystickButton(controller, 4);
		greenLedButton = new JoystickButton(controller, 3);
		
		grabButton = new JoystickButton(controller, 5);
		releaseButton = new JoystickButton(controller, 6);
		
		strafeLeftButton = new JoystickButton(controller, 9);
		strafeRightButton = new JoystickButton(controller, 10);
		
				
	}
	
	public double getLeftSpeed () {
		
		return controller.getRawAxis(1);
	}
	
	public double getRightSpeed () {
		
		return controller.getRawAxis(5);
	}
	
	public double getLeft_X_Speed () {
		
		return controller.getRawAxis(0);
	}
	
	public double getRight_X_Speed () {
		
		return controller.getRawAxis(4);
	}
	
	public double getRaiseZ () {
		
		return controller.getRawAxis(2);
		
	}
	
	public double getLowerZ () {
		
		return controller.getRawAxis(3);
	}
	
	public boolean isGrab () {
		
		return controller.getRawButton(5);
	}
	
	public boolean isRelease () {
		
		return controller.getRawButton(6);
	}
	
	public boolean isStrafeLeft () {
		
		return controller.getRawButton(9);
	}
	
	public boolean isStrafeRight () {
		
		return controller.getRawButton(10);
	}
	
	
	public static OI getInstance () {
		
		if (instance == null) {
			
			instance = new OI ();
			
		}
		
		return instance;
	}
	
}
