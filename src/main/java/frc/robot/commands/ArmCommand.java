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
import frc.robot.subsystems.ArmSystem;

public class ArmCommand extends CommandBase {
  private ArmSystem armSystem;
  //0 = down, 1 = up
  private int position;
  /**
   * Creates a new ArmCommand.
   */
  public ArmCommand(ArmSystem armSystem) {
    this.armSystem = armSystem;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    position= -1;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //STOP THE MOTOR IF ARM WAS DOWN AND HAS NOW PRESSED THE BUTTON
    //System.out.println("HIGH: "+armSystem.getHighLimit() +" // LOW: "+ armSystem.getLowLimit());
    if(armSystem.getHighLimit() && (position==0||position==-1)){
      //System.out.println("HIGH!");
      position = 1;
      armSystem.setPostion(1);
      armSystem.setArmMotor(0);
    } //STOP THE MOTOR IF ARM WAS UP AND HAS NOW PRESSED THE BUTTON
    else if(armSystem.getLowLimit() && (position==0||position==-1)){
      //System.out.println("LOW!!");
      position=0;
      armSystem.setPostion(0);
      armSystem.setArmMotor(0);
    } //IF B BUTTON PRESSED AND ARM IS LOWERED, SET ARM TO MOVE UP
    else if (RobotContainer.xbox.getRawButton(Constants.BUTTON_Y) && (position==0||position==-1)){
      //System.out.println("Y");
      armSystem.setArmMotor(.1);
    } //IF A BUTTON PRESSED AND ARM IS RAISED, SET ARM TO MOVE DOWN
    else if (RobotContainer.xbox.getRawButton(Constants.BUTTON_A) && (position==0||position==-1)){
      //System.out.println("A");
      armSystem.setArmMotor(-.3);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    armSystem.setArmMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
