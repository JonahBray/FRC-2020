/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Wrapper class for lazy susan. Contains all the colors.
 */
public enum Color {
    RED(edu.wpi.first.wpilibj.util.Color.kRed),
    GREEN(edu.wpi.first.wpilibj.util.Color.kLime),
    BLUE(edu.wpi.first.wpilibj.util.Color.kAqua),
    YELLOW(edu.wpi.first.wpilibj.util.Color.kYellow),
    NULL(edu.wpi.first.wpilibj.util.Color.kBlack);

    private edu.wpi.first.wpilibj.util.Color value;
    private Color(edu.wpi.first.wpilibj.util.Color color) {
        this.value = color;
    }
    public edu.wpi.first.wpilibj.util.Color color() {
        return value;
    }
}
