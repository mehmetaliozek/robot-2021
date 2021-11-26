// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  PWMTalonSRX LMotor = new PWMTalonSRX(Constants.DriveConstants.kLeftRearMotor);
  PWMTalonSRX RMotor = new PWMTalonSRX(Constants.DriveConstants.kRightRearMotor);

  DifferentialDrive m_drive = new DifferentialDrive(LMotor, RMotor);

  public DriveSubsystem() {
  }

  public void curvatureDrive(double x, double y) {
    m_drive.arcadeDrive(x, y, true);
  }

  public void TankDrive(double l, double r) {
    m_drive.tankDrive(l, r, true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
