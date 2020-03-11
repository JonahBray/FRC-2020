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
    public static final int MOTOR_LEFT_2_ID = 3;
    public static final int MOTOR_RIGHT_2_ID = 1;
    public static final int MOTOR_RIGHT_1_ID = 2;
    public static final int MOTOR_ARM_ID = 7;
    public static final int MOTOR_CLIMB_ID = 6;
    public static final int MOTOR_INTAKE_ID = 5;
    public static final int MOTOR_LAZYSUSAN_ID = -1; // Change to actual port of motor once installed.

    // SENSOR PORTS
    public static final int SWITCH_ARM_UP_ID = 9;
    public static final int SWITCH_ARM_DOWN_ID = 8;

    // LAZY SUSAN CONTROL
    public static final boolean COLOR_SENSOR_I2C_ONBOARD = true; // Change this to false when using MXP port instead of onboard I2C ports.
    public static final boolean COLOR_SENSOR_VOLTAGE_COMPENSATION = true; // Change to false if you don't want voltage compensation. Bad idea to change it to false.
    public static final double COLOR_SENSOR_VOLTAGE_MAX = 11.87; // Caps the voltage for % output mode to 11.87 as 100%. If it's below it makes difference, if higher no difference as its cappped.
    public static final double RED_TOLERANCE = 10, BLUE_TOLERANCE = 10, GREEN_TOLERANCE = 10; // TOLERANCES FOR THE COLOR SENSOR/COLORS
    public static final int ROTATE_AMOUNT = 4; // How many times should it rotate when being automated rotation. 3-5 is what it said in game manual.

    // CONTROLLER PORTS
    public static int DRIVER_CONTROLLER_PORT = 0;
    public static int DRIVER2_CONTROLLER_PORT = 1;

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
    public static double SPEED_MULTIPLIER = .8;
    public static double SPEED_TURN_MULTIPLIER = .7;

    //RAMP FORMULA VARIABLES
    public static final double RAMP_MULTIPLIER = 1.75;
    public static final double RAMP_SLOPE = .185;
    public static final double RAMP_SLOPE_T = 1.0/1.25;

    //CONTROL VARIABLES
    public static int NUM_DRIVERS = 2; //how many drivers (1 or 2 only)
    public static boolean CLIMB_FREEDOM = false; //set to true in order to move Climber Down
}
