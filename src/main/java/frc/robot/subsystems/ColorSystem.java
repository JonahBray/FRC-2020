/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorSensorV3.ColorSensorMeasurementRate;
import com.revrobotics.ColorSensorV3.ColorSensorResolution;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ColorSystem extends SubsystemBase {
  
  private VictorSPX rotator;
  private ColorSensorV3 sensor;
  private frc.robot.Color color = frc.robot.Color.NULL;
  /**
   * Creates a new ColorSystem.
   */
  public ColorSystem() {
    rotator = new VictorSPX(Constants.MOTOR_LAZYSUSAN_ID);
    rotator.configVoltageCompSaturation(11.87);
    rotator.enableVoltageCompensation(true);
    if (Constants.COLOR_SENSOR_I2C_ONBOARD)
      sensor = new ColorSensorV3(I2C.Port.kOnboard);
    else
      sensor = new ColorSensorV3(I2C.Port.kMXP);
      sensor.configureColorSensor(ColorSensorResolution.kColorSensorRes13bit, ColorSensorMeasurementRate.kColorRate25ms, ColorSensorV3.GainFactor.kGain3x);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setMotor(double speed) {
    rotator.set(ControlMode.PercentOutput, speed);
  }

  public ColorSensorV3 getSensor() {
    return sensor;
  }

  public void setColor(frc.robot.Color color) {
    this.color = color;
  }

  public frc.robot.Color getColor() {
    return color;
  }

}
