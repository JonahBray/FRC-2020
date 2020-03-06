/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TalonDriveTrain extends SubsystemBase {
  private TalonSRX motorLeft1;
  private TalonSRX motorLeft2;
  private TalonSRX motorRight1;
  private TalonSRX motorRight2;
  private double leftMotorSpeed, rightMotorSpeed;

  /**
   * Creates a new DriveTrain.
   */
  public TalonDriveTrain() {
    motorLeft1 = new TalonSRX(Constants.MOTOR_LEFT_1_ID);
    motorLeft2 = new TalonSRX(Constants.MOTOR_LEFT_2_ID);
    motorRight1 = new TalonSRX(Constants.MOTOR_RIGHT_1_ID);
    motorRight2 = new TalonSRX(Constants.MOTOR_RIGHT_2_ID);
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
  public void setLeftMotors(double distance, double robotHeading) {
    //motorLeft1.set(ControlMode.PercentOutput, -speed * Constants.SPEED_MULTIPLIER);
    //motorLeft2.set(ControlMode.PercentOutput, -speed * Constants.SPEED_MULTIPLIER);
    motorLeft1.set(ControlMode.MotionMagic, distance,DemandType.AuxPID,robotHeading);
    motorLeft2.set(ControlMode.MotionMagic, distance,DemandType.AuxPID,robotHeading);
  }

  public void setRightMotors(double speed) {
    rightMotorSpeed = speed;
    //motorRight1.set(ControlMode.PercentOutput, speed * Constants.SPEED_MULTIPLIER);
    //motorRight2.set(ControlMode.PercentOutput, speed * Constants.SPEED_MULTIPLIER);
    motorRight1.set(ControlMode.PercentOutput, speed);
    motorRight2.set(ControlMode.PercentOutput, speed);
  }

  public void setRightMotors(double distance, double robotHeading) {
    //motorLeft1.set(ControlMode.PercentOutput, -speed * Constants.SPEED_MULTIPLIER);
    //motorLeft2.set(ControlMode.PercentOutput, -speed * Constants.SPEED_MULTIPLIER);
    motorRight1.set(ControlMode.MotionMagic, distance,DemandType.AuxPID,robotHeading);
    motorRight2.set(ControlMode.MotionMagic, distance,DemandType.AuxPID,robotHeading);
  }

  public double getRightMotorSpeed(){
    return rightMotorSpeed;
  }
  public double getLeftMotorSpeed(){
    return leftMotorSpeed;
  }

  public void translate(double speed) {
    setLeftMotors(speed);
    setRightMotors(speed);
  }
  public void translate(double distance, double robotHeading) {
    // Precondition: distance is > 0 (positive)
    setLeftMotors(distance,robotHeading);
    setRightMotors(distance,robotHeading);
  }

  public void stop() {
    setLeftMotors(0);
    setRightMotors(0);
  }
  public void rotate(double speed, double rotatespeed) {
    setLeftMotors(speed+rotatespeed);
    setRightMotors(speed-rotatespeed);
  }
  
  // Drive by a distance Example
  //_talonLeft.follow(_talonRght, FollwerType.AuxOutput1); 
  //_talonRght.set(ControlMode.MotionMagic, "targetDistance", DemandType.AuxPID, "desiredRobotHeading");
}
