/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Spin extends Command {
  public Spin() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.Spinner);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    Robot.Spinner.detectedColor = Robot.Spinner.m_colorSensor.getColor();

    Robot.Spinner.match = Robot.Spinner.m_colorMatcher.matchClosestColor(Robot.Spinner.detectedColor);


    /////// Detect Color ///////

    if (Robot.Spinner.match.color == Robot.Spinner.kBlueTarget) {

      Robot.Spinner.colorString = "Blue";

    } else if (Robot.Spinner.match.color == Robot.Spinner.kRedTarget) {

      Robot.Spinner.colorString = "Red";

    } else if (Robot.Spinner.match.color == Robot.Spinner.kGreenTarget) {

      Robot.Spinner.colorString = "Green";

    } else if (Robot.Spinner.match.color == Robot.Spinner.kYellowTarget) {

      Robot.Spinner.colorString = "Yellow";

    } else {

      Robot.Spinner.colorString = "Unknown";

    }


    /////// Detection And Rotation Logic ///////
    
    if(Robot.Spinner.colorString == Robot.Spinner.colorwarna[0] && Robot.Spinner.prevcolor == Robot.Spinner.colorwarna[0]) {
      return;
    }else if(Robot.Spinner.colorString == Robot.Spinner.colorwarna[0] && Robot.Spinner.prevcolor == Robot.Spinner.colorwarna[1] || Robot.Spinner.prevcolor == Robot.Spinner.colorwarna[2] || Robot.Spinner.prevcolor == Robot.Spinner.colorwarna[3] ) {
      Robot.Spinner.counter = Robot.Spinner.counter + 1;
    }


    if(Robot.Spinner.colorString == Robot.Spinner.colorwarna[1] && Robot.Spinner.prevcolor == Robot.Spinner.colorwarna[1]) {
      return;
    }else if(Robot.Spinner.colorString == Robot.Spinner.colorwarna[1] && Robot.Spinner.prevcolor == Robot.Spinner.colorwarna[0] || Robot.Spinner.prevcolor == Robot.Spinner.colorwarna[2] || Robot.Spinner.prevcolor == Robot.Spinner.colorwarna[3]) {
      Robot.Spinner.counter = Robot.Spinner.counter + 1;
    }


    if(Robot.Spinner.colorString == Robot.Spinner.colorwarna[2] && Robot.Spinner.prevcolor == Robot.Spinner.colorwarna[2]) {
      return;
    }else if(Robot.Spinner.colorString == Robot.Spinner.colorwarna[2] && Robot.Spinner.prevcolor == Robot.Spinner.colorwarna[0] || Robot.Spinner.prevcolor == Robot.Spinner.colorwarna[1] || Robot.Spinner.prevcolor == Robot.Spinner.colorwarna[3]) {
      Robot.Spinner.counter = Robot.Spinner.counter + 1;
    }


    if(Robot.Spinner.colorString == Robot.Spinner.colorwarna[3] && Robot.Spinner.prevcolor == Robot.Spinner.colorwarna[3]) {
      return;
    }else if(Robot.Spinner.colorString == Robot.Spinner.colorwarna[3] && Robot.Spinner.prevcolor == Robot.Spinner.colorwarna[0] && Robot.Spinner.prevcolor == Robot.Spinner.colorwarna[1] && Robot.Spinner.prevcolor == Robot.Spinner.colorwarna[2]) {
      Robot.Spinner.counter = Robot.Spinner.counter + 1;
      
    }

    Robot.Spinner.prevcolor = Robot.Spinner.colorString;

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
