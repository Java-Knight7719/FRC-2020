/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Shoot extends Command {
  public Shoot() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.Shooter);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

      /////// Get Sensor Position ///////

      Robot.Shooter.sensorPosition = Robot.Shooter.encoder.getPosition() * Robot.Shooter.kDriveTick2Feet;


      /////// Get Joystick Command ///////

      if (Robot.OI.getP1Button(RobotMap.P1A) == true) {

        Robot.Shooter.setpoint = 999999999;

      }

  
      /////// Calculations ///////

      Robot.Shooter.error = Robot.Shooter.setpoint - Robot.Shooter.sensorPosition;
      Robot.Shooter.dt = Timer.getFPGATimestamp() - Robot.Shooter.lastTimestamp;
      Robot.Shooter.errorRate = (Robot.Shooter.error - Robot.Shooter.lastError) / Robot.Shooter.dt;
      Robot.Shooter.outputPower = Robot.Shooter.kP * Robot.Shooter.error + Robot.Shooter.kI * Robot.Shooter.errorSum + Robot.Shooter.kD * Robot.Shooter.errorRate;


      /////// Power Capping ///////

      if(-Robot.Shooter.encoder.getVelocity() >= 0 && Robot.OI.getP1Button(RobotMap.P1A) == false) {

        Robot.Shooter.setpoint = 0;
        Robot.Shooter.encoder.setPosition(0.0);
        Robot.Shooter.outputPower = 0.0;
      }else if(-Robot.Shooter.encoder.getVelocity() >= 1500 && -Robot.Shooter.encoder.getVelocity() <= 2000) {

        Robot.Shooter.outputPower = 1.0;

      }else if(-Robot.Shooter.encoder.getVelocity() >= 2000) {

        Robot.Shooter.outputPower = 0.75;

      }
  
  
      /////// Output to Motors ///////

      Robot.Shooter.m1_st.set(-Robot.Shooter.outputPower);
      Robot.Shooter.m2_st.set(Robot.Shooter.outputPower);
  
  
      /////// Update Last- Variables ///////

      Robot.Shooter.lastTimestamp = Timer.getFPGATimestamp();
      Robot.Shooter.lastError = Robot.Shooter.error;

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
