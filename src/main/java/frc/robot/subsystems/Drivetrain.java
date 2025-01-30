// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

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

  public void Move(double forword, double rotate) {
    driveLeftFront.set(ControlMode.PercentOutput, (forword + rotate) * Constants.maxSpeed);
    driveLeftBack.set(ControlMode.PercentOutput, (forword + rotate) * Constants.maxSpeed);
    driveRightFront.set(ControlMode.PercentOutput, (forword - rotate) * Constants.maxSpeed);
    driveRightBack.set(ControlMode.PercentOutput, (forword - rotate) * Constants.maxSpeed);
  }
}
