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
  DigitalInput highLimit, lowLimit;

  /**
   * Creates a new ArmSystem.
   */
  public ArmSystem() {
    motor = new VictorSPX(Constants.MOTOR_ARM_ID);
    highLimit = new DigitalInput(Constants.SWITCH_ARM_UP_ID);
    lowLimit = new DigitalInput(Constants.SWITCH_ARM_DOWN_ID);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setArmMotor(double speed){
    motor.set(ControlMode.PercentOutput, speed);
  }
  public boolean getHighLimit(){
    return highLimit.get();
  }
  public boolean getLowLimit(){
    return lowLimit.get();
  }
}
