// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  public final Drivetrain drivetrain = new Drivetrain();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {

    driverController.povUp().whileTrue(drivetrain.runEnd(
      () -> drivetrain.MoveForword(),
      () -> drivetrain.Stop()));

    driverController.povDown().whileTrue(drivetrain.runEnd(
      () -> drivetrain.MoveBack(),
      () -> drivetrain.Stop()));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
