package org.usfirst.frc.team5234.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;

public class TankDriveExpo {
	
	private Spark rightDrive;
	private Spark leftDrive;
	private XboxController driveController;
	
	public void initialize(Spark leftDrive, Spark rightDrive, XboxController driveController) {
		this.rightDrive = rightDrive;
		this.leftDrive = leftDrive;
		this.driveController = driveController;
	}
	
	public void process() {
//		double positiveInput = driveController.getTriggerAxis(Hand.kRight);
//		double negativeInput = driveController.getTriggerAxis(Hand.kLeft);
		
		double leftStick = driveController.getRawAxis(0);
		double rightStick = driveController.getRawAxis(1);
				
		double leftExpo = getRate(leftStick);
		double rightExpo = getRate(rightStick);
	
		drive(leftExpo, rightExpo);
	}
	
	private void drive(double left, double right) {
		leftDrive.set(left);
		rightDrive.set(right);
	}
	
	private double getRate(double input) {
		if(input >= 1) {
			return 1;
		} else if(input <= -1) {
			return -1;
		}
		return Math.pow(input,3);
	}

}
