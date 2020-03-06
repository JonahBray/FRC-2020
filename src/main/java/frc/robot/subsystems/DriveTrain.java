/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  private VictorSPX motorLeft1;
  private VictorSPX motorLeft2;
  private VictorSPX motorRight1;
  private VictorSPX motorRight2;
  private double leftMotorSpeed, rightMotorSpeed;

  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
    motorLeft1 = new VictorSPX(Constants.MOTOR_LEFT_1_ID);
    motorLeft2 = new VictorSPX(Constants.MOTOR_LEFT_2_ID);
    motorRight1 = new VictorSPX(Constants.MOTOR_RIGHT_1_ID);
    motorRight2 = new VictorSPX(Constants.MOTOR_RIGHT_2_ID);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setLeftMotors(double speed) {
    speed = -speed;
    leftMotorSpeed = speed;
    //motorLeft1.set(ControlMode.PercentOutput, -speed * Constants.SPEED_MULTIPLIER);
    //motorLeft2.set(ControlMode.PercentOutput, -speed * Constants.SPEED_MULTIPLIER);
    motorLeft1.set(ControlMode.PercentOutput, speed);
    motorLeft2.set(ControlMode.PercentOutput, speed);
  }

  public void setRightMotors(double speed) {
    rightMotorSpeed = speed;
    //motorRight1.set(ControlMode.PercentOutput, speed * Constants.SPEED_MULTIPLIER);
    //motorRight2.set(ControlMode.PercentOutput, speed * Constants.SPEED_MULTIPLIER);
    motorRight1.set(ControlMode.PercentOutput, speed);
    motorRight2.set(ControlMode.PercentOutput, speed);
  }

  public double getRightMotorSpeed(){
    return rightMotorSpeed;
  }
  public double getLeftMotorSpeed(){
    return leftMotorSpeed;
  }
}
