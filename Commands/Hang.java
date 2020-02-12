/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Hang extends Command {
  public Hang() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.Hanger);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    double encoder = Robot.Hanger.encoder.getPosition();

    if(Robot.OI.getP1Button(RobotMap.P1LBumper) && encoder <= 1) {

      Robot.Hanger.setLifterPower(0.5);

    }else if(Robot.OI.getP1Button(RobotMap.P1B) && encoder >= 0) {

      Robot.Hanger.setLifterPower(-0.5);
      
    }

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
/////// 7719 ///////
