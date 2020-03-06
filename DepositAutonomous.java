/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ArmSystem;
import frc.robot.subsystems.ClimbSystem;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.IntakeSystem;

public class DepositAutonomous extends CommandBase {
  private DriveTrain drive;
  private IntakeSystem intake;
  private ClimbSystem climb;
  private ArmSystem arm;
  private boolean stop;
  private Timer timer;
  private boolean droveForward;
  private double starttime1, starttime2;
  /**
   * Creates a new DriveOffLineAutonomous.
   */
  public DepositAutonomous(DriveTrain driveTrain, IntakeSystem intakeSystem, ClimbSystem climbSystem, ArmSystem armSystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    drive=driveTrain;
    intake=intakeSystem;
    climb=climbSystem;
    arm=armSystem;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    stop=false;
    droveForward = false;
    arm.setPosition(0);
    timer = new Timer();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(!stop){
      if(arm.getPosition() == 0) {
        arm.setArmMotor(0.1);
        if(arm.getHighLimit()) {
          arm.setPosition(1);
          arm.setArmMotor(0);
          starttime1 = timer.get();
        }
      }
      if(arm.getPosition() == 1) {
        if(!droveForward) {
          drive.setLeftMotors(.5 * Constants.SPEED_MULTIPLIER);
          drive.setRightMotors(.5 * Constants.SPEED_MULTIPLIER);
          if(timer.get()-starttime1>1.5){
            drive.setLeftMotors(0);
            drive.setRightMotors(0);
            droveForward = true;
            starttime2 = timer.get();
          }
        }
        if(droveForward) {
          intake.setIntakeMotor(-0.25);
          if(timer.get()-starttime2>1.0) {
            intake.setIntakeMotor(0);
            stop = true;
            end(false);
          }
        }
      }
    }

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
    SmartDashboard.putNumber("Drive Left Motors Speed", drive.getLeftMotorSpeed());
    SmartDashboard.putNumber("Drive Right Motors Speed", drive.getRightMotorSpeed());
    //CONSTANTS 
    SmartDashboard.putNumber("Constant Speed Multiplier:",Constants.SPEED_MULTIPLIER);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.setLeftMotors(0);
    drive.setRightMotors(0);
    arm.setArmMotor(0);
    intake.setIntakeMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
