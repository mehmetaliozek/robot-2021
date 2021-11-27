// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class AngleCommand extends CommandBase {
  /** Creates a new AngleCommand. */
  DriveSubsystem m_drive;
  Timer timer = new Timer();
  boolean finish;

  public AngleCommand(DriveSubsystem drive) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.m_drive = drive;
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (timer.get() > 0 && timer.get() <= 1) {
      m_drive.TankDrive(-0.5, 0.5);
    } else {
      m_drive.TankDrive(0, 0);
      finish = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finish;
  }
}
