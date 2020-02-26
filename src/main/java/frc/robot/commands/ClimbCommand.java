/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ClimbSystem;

public class ClimbCommand extends CommandBase {
  private ClimbSystem climbSystem;
  /**
   * Creates a new ClimbCommand.
   */
  public ClimbCommand(ClimbSystem climbSystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.climbSystem = climbSystem;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double stick = RobotContainer.xbox.getRawAxis(Constants.RIGHT_STICK_Y);
    //climbSystem.setClimbMotor(-Constants.SPEED_MULTIPLIER * stick);
    climbSystem.setClimbMotor(0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
