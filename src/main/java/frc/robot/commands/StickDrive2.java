/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class StickDrive2 extends CommandBase {
  private final DriveTrain driveTrain;
  private Timer timer;
  private double currentValue;
  private boolean driving;
  /**
   * Creates a new TriggerDrive.
   */
  public StickDrive2(DriveTrain driveTrain) {
    this.driveTrain = driveTrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer = new Timer();
    currentValue = 0.0;
    timer.start();
    driving = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.xbox1.getBButtonPressed()){
     driveTrain.setLeftMotors(0);
     driveTrain.setRightMotors(0);
    }
    double stickVal = - RobotContainer.xbox1.getRawAxis(Constants.LEFT_STICK_Y);
    
    if(driving){
      if(Math.abs(stickVal)<.01){
        driving=false;
        timer.stop();
        currentValue = 0;
      }
      else{
       // currentValue += currentValue * Constants.RA
      }
    }
    else{
      if(!(Math.abs(stickVal)<.01)){
        driving=true;
        timer.reset();
        timer.start();
      }
    }
    double turn = RobotContainer.xbox1.getRawAxis(Constants.RIGHT_STICK_X) * Constants.SPEED_TURN_MULTIPLIER;
    
    //handles actual movement
    if(stickVal>=0){
      driveTrain.setLeftMotors(-Constants.SPEED_MULTIPLIER * (currentValue + turn));
      driveTrain.setRightMotors(-Constants.SPEED_MULTIPLIER * (currentValue - turn));
    }
    else{
      driveTrain.setLeftMotors(Constants.SPEED_MULTIPLIER * (currentValue + turn));
      driveTrain.setRightMotors(Constants.SPEED_MULTIPLIER * (currentValue - turn));
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.setLeftMotors(0);
    driveTrain.setRightMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  //returns the ideal power output based on the time the trigger has been pressed (in seconds)
  private double rampSpeed(double time){
    double ans =Constants.RAMP_MULTIPLIER * Math.sqrt(Constants.RAMP_SLOPE * time);
    if(ans>1.0){
      ans=1.0;
    }
    if(ans<0){
      ans=0;
    }
    return ans;
  }

  private double rampSpeedT(double time){
    double ans =Constants.RAMP_SLOPE_T * time;
    if(ans>1.0){
      ans=1.0;
    }
    if(ans<0){
      ans=0;
    }
    return ans;
  }
}
