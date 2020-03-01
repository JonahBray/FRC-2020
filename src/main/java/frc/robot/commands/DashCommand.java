/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.*;

public class DashCommand extends CommandBase {
  private ClimbSystem climb;
  private IntakeSystem intake;
  private ArmSystem arm;
  private DriveTrain driveTrain;
  /**
   * Creates a new DashCommand.
   */
  public DashCommand(ClimbSystem climbSystem, IntakeSystem intakeSystem, ArmSystem armSystem, DriveTrain driveTrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.climb = climbSystem;
    this.intake = intakeSystem;
    this.arm = armSystem;
    this.driveTrain = driveTrain;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //ARM INFORMATION
    SmartDashboard.putBoolean("High Switch:", arm.getHighLimit());
    SmartDashboard.putBoolean("Low Switch:", arm.getLowLimit());
    SmartDashboard.putNumber("Arm Motor Speed:",arm.getMotorSpeed());
    SmartDashboard.putString("Arm Position", arm.getPosition()==0? "down" : "up");
    //CLIMB INFORMATION
    SmartDashboard.putNumber("Climb Motor Speed", climb.getMotorSpeed());
    //INTAKE INFORMATION
    SmartDashboard.putNumber("Intake Motor Speed", intake.getMotorSpeed());
    //DRIVE TRAIN INFORMATION
    SmartDashboard.putNumber("Drive Left Motors Speed", driveTrain.getLeftMotorSpeed());
    SmartDashboard.putNumber("Drive Right Motors Speed", driveTrain.getRightMotorSpeed());
    //CONSTANTS 
    SmartDashboard.putNumber("Constant Speed Multiplier:",Constants.SPEED_MULTIPLIER);
    SmartDashboard.putNumber("Driver 1 Port:",Constants.DRIVER_CONTROLLER_PORT);
    SmartDashboard.putNumber("Driver 2 Port:", Constants.DRIVER2_CONTROLLER_PORT);
    SmartDashboard.putNumber("Num Drivers (1-2 ONLY):", Constants.NUM_DRIVERS);
    SmartDashboard.putBoolean("Climber Freedom:", Constants.CLIMB_FREEDOM);
    
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
