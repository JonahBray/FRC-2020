/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSystem extends SubsystemBase {
  private VictorSPX motor;
  private DigitalInput highLimit, lowLimit;
  private int position;
  private double motorSpeed;
  /**
   * Creates a new ArmSystem.
   */
  public ArmSystem() {
    motor = new VictorSPX(Constants.MOTOR_ARM_ID);
    highLimit = new DigitalInput(Constants.SWITCH_ARM_UP_ID);
    lowLimit = new DigitalInput(Constants.SWITCH_ARM_DOWN_ID);
    position = 0;
    motorSpeed=0.0;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setArmMotor(double speed){
    motor.set(ControlMode.PercentOutput, speed);
    motorSpeed=speed;
  }
  public boolean getHighLimit(){
    return highLimit.get();
  }
  public boolean getLowLimit(){
    return lowLimit.get();
  }
  public void setPostion(int n){
    position = n;
  }
  public int getPosition(){
    return position;
  }
  public double getMotorSpeed(){
    return motorSpeed;
  }
}
