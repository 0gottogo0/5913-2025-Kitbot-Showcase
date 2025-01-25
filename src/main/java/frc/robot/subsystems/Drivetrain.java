// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  private TalonSRX driveLeftFront = new TalonSRX(1);
  private TalonSRX driveLeftBack = new TalonSRX(2);
  private TalonSRX driveRightFront = new TalonSRX(3);
  private TalonSRX driveRightBack = new TalonSRX(4);

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    driveLeftFront.configFactoryDefault();
    driveLeftBack.configFactoryDefault();
    driveRightFront.configFactoryDefault();
    driveRightBack.configFactoryDefault();

    driveLeftFront.setInverted(false);
    driveLeftBack.setInverted(false);
    driveRightFront.setInverted(true);
    driveRightBack.setInverted(true);

    driveLeftFront.setNeutralMode(NeutralMode.Brake);
    driveLeftBack.setNeutralMode(NeutralMode.Brake);
    driveRightFront.setNeutralMode(NeutralMode.Brake);
    driveRightBack.setNeutralMode(NeutralMode.Brake);

    driveLeftFront.clearStickyFaults();
    driveLeftBack.clearStickyFaults();
    driveRightFront.clearStickyFaults();
    driveRightBack.clearStickyFaults();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void MoveForword() {
    driveLeftFront.set(ControlMode.PercentOutput, 0.2);
    driveLeftBack.set(ControlMode.PercentOutput, 0.2);
    driveRightFront.set(ControlMode.PercentOutput, 0.2);
    driveRightBack.set(ControlMode.PercentOutput, 0.2);
  }

  public void MoveBack() {
    driveLeftFront.set(ControlMode.PercentOutput, -0.2);
    driveLeftBack.set(ControlMode.PercentOutput, -0.2);
    driveRightFront.set(ControlMode.PercentOutput, -0.2);
    driveRightBack.set(ControlMode.PercentOutput, -0.2);
  }

  public void Stop() {
    driveLeftFront.set(ControlMode.PercentOutput, 0);
    driveLeftBack.set(ControlMode.PercentOutput, 0);
    driveRightFront.set(ControlMode.PercentOutput, 0);
    driveRightBack.set(ControlMode.PercentOutput, 0);
  }
}
