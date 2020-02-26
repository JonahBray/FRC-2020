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
import frc.robot.subsystems.IntakeSystem;

public class IntakeCommand extends CommandBase {
  private IntakeSystem intakeSystem;
  /**
   * Creates a new IntakeCommand.
   */
  public IntakeCommand(IntakeSystem intakeSystem) {
    this.intakeSystem = intakeSystem;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = 0;
    if(RobotContainer.xbox.getRawButton(Constants.RIGHT_BUMPER)){
      System.out.println("true");
      speed = .25;
    }
    else if(RobotContainer.xbox.getRawButton(Constants.LEFT_BUMPER)){
      System.out.println("false");
      speed = -.25;
    }
    intakeSystem.setIntakeMotor(speed);
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
