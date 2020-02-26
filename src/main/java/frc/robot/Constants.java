/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
    // CAN/MOTOR DEVICE PORTS
    public static final int MOTOR_LEFT_1_ID = 4;
    public static final int MOTOR_LEFT_2_ID = 6;
    public static final int MOTOR_RIGHT_2_ID = 1;
    public static final int MOTOR_RIGHT_1_ID = 3;
    public static final int MOTOR_ARM_ID = 7;
    public static final int MOTOR_CLIMB_ID = 2;
    public static final int MOTOR_INTAKE_ID = 5;

    // SENSOR PORTS
    public static final int SWITCH_ARM_UP_ID = 9;
    public static final int SWITCH_ARM_DOWN_ID = 8;

    // CONTROLLER PORTS
    public static final int DRIVER_CONTROLLER_PORT = 0;

    // CONTROLLER BUTTON
    public static final int LEFT_STICK_X = 0;
    public static final int LEFT_STICK_Y = 1;
    public static final int RIGHT_STICK_X = 4;
    public static final int RIGHT_STICK_Y = 5;
    public static final int LEFT_TRIGGER = 2;
    public static final int RIGHT_TRIGGER = 3;
    public static final int LEFT_BUMPER = 5;
    public static final int RIGHT_BUMPER = 6;
    public static final int BUTTON_START = 8;
    public static final int BUTTON_BACK = 7;
    public static final int BUTTON_A = 1;
    public static final int BUTTON_B = 2;
    public static final int BUTTON_X = 3;
    public static final int BUTTON_Y = 4;
    
    //HOW ZOOMER ARE YOU? (1 = max, 0 = no movement)
    public static final double SPEED_MULTIPLIER = .25;

    //RAMP FORMULA VARIABLES
    public static final double RAMP_MULTIPLIER = 1.75;
    public static final double RAMP_SLOPE = .185;
}
