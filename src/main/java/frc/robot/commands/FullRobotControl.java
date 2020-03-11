/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.Color;
import frc.robot.subsystems.*;

public class FullRobotControl extends ParallelCommandGroup {
  private ColorSystem colorSystem;
  /**
   * Creates a new FullRobotControl.
   */
  public FullRobotControl(ClimbSystem climbSystem, IntakeSystem intakeSystem, ArmSystem armSystem, ColorSystem colorSystem, DriveTrain driveTrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.colorSystem = colorSystem;
    addCommands(
      new ClimbCommand(climbSystem),
      new IntakeCommand(intakeSystem),
      new ArmCommand(armSystem),
      new StickDrive(driveTrain),
      new DashCommand(climbSystem, intakeSystem, armSystem, driveTrain),
      new SpinCommand(colorSystem)
    );
  }

  public void setColor(Color color) {
    colorSystem.setColor(color);
  }
}
