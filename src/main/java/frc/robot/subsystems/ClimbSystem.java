/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimbSystem extends SubsystemBase {
  private VictorSPX motor;
  private double motorSpeed;
  /**
   * Creates a new ClimbSystem.
   */
  public ClimbSystem() {
    motor = new VictorSPX(Constants.MOTOR_CLIMB_ID);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setClimbMotor(double speed){
    motor.set(ControlMode.PercentOutput,speed);
    motorSpeed = speed;
  }

  public double getMotorSpeed(){
    return motorSpeed;
  }
}
