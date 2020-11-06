/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ColorSystem;
import edu.wpi.first.wpilibj.util.Color;

public class SpinCommand extends CommandBase {
  /**
   * Creates a new SpinCommand.
   */
  private ColorSystem system;
  private double RED_TOLERANCE, BLUE_TOLERANCE, GREEN_TOLERANCE;

  public SpinCommand(ColorSystem system) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(system);
    this.system = system;
    RED_TOLERANCE = Constants.RED_TOLERANCE / 255;
    BLUE_TOLERANCE = Constants.BLUE_TOLERANCE / 255;
    GREEN_TOLERANCE = Constants.GREEN_TOLERANCE / 255;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // CHECK DPAD (LEFT ARROW/RIGHT MANUAL, UP-ARROW/DOWN-ARROW PRESSED AUTOMATED)
    final int angle = RobotContainer.xbox1.getPOV();

    switch (Dpad.is(angle)) {
    case UP:
      // CODE FOR AUTO ROTATION X TIMES
      rotate(Constants.ROTATE_AMOUNT);
      break;
    case DOWN:
      // CODE FOR AUTO ROTATION TO X COLOR
      rotateToColor();
      break;
    case LEFT:
      // CODE FOR MANUAL ROTATION LEFT
      rotate(-0.1);
      break;
    case RIGHT:
      // CODE FOR MANUAL ROTATION RIGHT
      rotate(0.1);
      break;
    default:
      break;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  // Example code - rotateToColor();
  public void rotateToColor() {
    // NEED TO ADD TOLERANCES
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // COLOR WHEEL GOES IN THIS ORDER YRGB, YRGB, Color sensor is on the right side.
    // The Color needs to be 4 off from the one it started.
    // We can spin in one direction to determine if it is the start of a new
    // sequence or the end of an old. Once we get to start of new sequence we offset
    // by 0.7 in,
    // then once we offset (to make sure the center of the color is under the sensor
    // in the end), we spin by 4 colors. EDIT: We offset after we've reached the
    // needed color. 

    // WE ARE SUPPOSED TO ONLY GO COUNTER CLOCKWISE!!!!

    if (system.getColor() == frc.robot.Color.NULL)
      return;
     Color current = system.getSensor().getColor();
     // IF WE'RE ON A DIVIDER WE NEED TO MOVE OFF OF IT....
     if(current.equals(frc.robot.Color.NULL.color())) {
       while(current.equals(frc.robot.Color.NULL.color())) {
         rotate(0.1);
       }
       current = system.getSensor().getColor();
     }
     // FIND THE COLOR WE NEED TO BE AT.
     Color offset;
     switch(system.getColor()) {
       case BLUE:
       offset = frc.robot.Color.YELLOW.color();
        break;
        case GREEN:
        offset = frc.robot.Color.BLUE.color();
        break;
        case RED:
        offset = frc.robot.Color.GREEN.color();
        break;
        case YELLOW:
        offset = frc.robot.Color.RED.color();
        break;
        default:
        return;
     }
     // IF We're not already on the right color then turn until offset color

      // WE MULTIPLE THIS INT BY POWER TO GO POSITIVE OR NEGATIVE TO GET TO NEW PATTERN/DIRECTION OF NEW PATTERN.
     int posneg = 1;
     if(!offset.equals(current)) {
     // WE NEED TO FIGURE OUT STARTING PATTERN SO WE TURN UNTIL WE FIND YELLOW
     while(!system.getSensor().getColor().equals(frc.robot.Color.YELLOW.color()) || system.getSensor().getColor().equals(frc.robot.Color.NULL.color())) {
       rotate(0.1);
     }
     // ON YELLOW, TURN TO SIDE TO FIND NEXT COLOR
     while(system.getSensor().getColor().equals(frc.robot.Color.YELLOW.color()) || system.getSensor().getColor().equals(frc.robot.Color.NULL.color())) {
       rotate(0.1);
     }
     Color newColor = system.getSensor().getColor();
     // THAT'S BLUE, END OF LAST PATTERN, GO OTHER WAY
     if(newColor.equals(frc.robot.Color.BLUE.color())) {
       posneg = -1;
     } // ELSE That's RED!
     // It's RED WE TURN UNTIL RIGHT COLOR
     while(!system.getSensor().getColor().equals(offset)) {
      rotate(posneg * 0.1);
     }
    }

    // NOW WE ARE ON RIGHT COLOR, WE OFFSET BY AN INCH OR TWO
    // NOT FINISHED

  }

  public void rotate(int times) {
    // NEED TO ADD TOLERANCES
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // (I think this works, YRGB pattern, 1 on each half, should meet its own color
    // 2 times to complete 1 cycle thus 2 * times to complete x revolutions.)
    Color current = system.getSensor().getColor();
    for (int i = 1; i <= times * 2; i++) {
      while (system.getSensor().getColor().equals(current)) {
        rotate(0.1);
      }
      while (!system.getSensor().getColor().equals(current)) {
        rotate(0.1);
      }
    }

  }

  public void rotate(double speed) {
    system.setMotor(speed);
  }

  public enum Dpad {
    UP(0), RIGHT(90), DOWN(180), LEFT(270);

    int degree;

    Dpad(int degree) {
      this.degree = degree;
    }

    public static Dpad is(int i) {
      if (i == 0)
        return UP;
      if (i == 90)
        return RIGHT;
      if (i == 180)
        return DOWN;
      if (i == 270)
        return LEFT;
      return null;
    }
  }
}
