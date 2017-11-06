
package org.usfirst.frc.team5234.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;

import org.usfirst.frc.team5234.robot.subsystems.ExampleSubsystem;

public class Robot extends IterativeRobot {
	private Spark rightDrive;
	private Spark leftDrive;
	private Spark leftDrive2;
	private Spark rightDrive2;
	
	private XboxController driveController;
	private XboxController auxController;
	
	private TankDriveExpo tankDriveExpo;
	
	
	
	@Override
	public void robotInit() {
		leftDrive = new Spark(0);
		leftDrive2 = new Spark(1);
		rightDrive = new Spark(2);
		rightDrive2 = new Spark(3);
		
		driveController = new XboxController(0);
		auxController = new XboxController(1);
		
		tankDriveExpo = new TankDriveExpo();
		tankDriveExpo.initialize(leftDrive, rightDrive, driveController);
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
	}

	@Override
	public void autonomousInit() {
	}

	@Override
	public void autonomousPeriodic() {
	}

	@Override
	public void teleopInit() {
	}

	@Override
	public void teleopPeriodic() {
		Timer.delay(20);
		tankDriveExpo.process();
	}

	@Override
	public void testPeriodic() {
	}
	
}
