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

public class IntakeSystem extends SubsystemBase {
  private VictorSPX motor;

  /**
   * Creates a new IntakeSystem.
   */
  public IntakeSystem() {
    motor = new VictorSPX(Constants.MOTOR_INTAKE_ID);
  } 

  @Override
  public void periodic() {
    
  }

  public void setIntakeMotor(double speed){
    if(speed<0){
      motor.setInverted(true);
    }
    else{
      motor.setInverted(false);
    }
    motor.set(ControlMode.PercentOutput, Math.abs(speed));
  }
}
