
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

public class Move extends Command {
  public Move() {

    requires(Robot.DriveTrain);

  }
  
  @Override
  protected void initialize() {

  }

  @Override
  protected void execute() {

    /////// Switch Drive Mode ///////

    if(Robot.OI.getP1Button(RobotMap.P1Y) && Robot.DriveTrain.driveSwitch == true)
    {

      Robot.DriveTrain.encoder.setPosition(0.0);
      Robot.DriveTrain.setpoint = 0.0;
      Robot.DriveTrain.driveSwitch = false;

    }else if(Robot.OI.getP1Button(RobotMap.P1Y) && Robot.DriveTrain.driveSwitch == false)
    {

      Robot.DriveTrain.outputPower = 0;
      Robot.DriveTrain.encoder.setPosition(0.0);
      Robot.DriveTrain.setpoint = 0.0;
      Robot.DriveTrain.driveSwitch = true;

    }

    if(Robot.DriveTrain.driveSwitch == true)
    {

      ////////////////////////////
      /////// Auto-Drive /////////
      ////////////////////////////
      
      
      /////// Get Joystick Command ///////

      if (Robot.OI.getP1Button(RobotMap.P1A) == true) {
        Robot.DriveTrain.setpoint = 10;
      } else if (Robot.OI.getP1Button(RobotMap.P1B) == true) {
        Robot.DriveTrain.setpoint = 0;
      }


      /////// Get Sensor Position ///////

      Robot.DriveTrain.sensorPosition = Robot.DriveTrain.encoder.getPosition() * Robot.DriveTrain.kDriveTick2Feet;

  
      /////// Calculations ///////

      Robot.DriveTrain.error = Robot.DriveTrain.setpoint - Robot.DriveTrain.sensorPosition;
      Robot.DriveTrain.dt = Timer.getFPGATimestamp() - Robot.DriveTrain.lastTimestamp;
  
      if (Math.abs(Robot.DriveTrain.error) < Robot.DriveTrain.iLimit) {
        Robot.DriveTrain.errorSum += Robot.DriveTrain.error * Robot.DriveTrain.dt;
      }
  
      Robot.DriveTrain.errorRate = (Robot.DriveTrain.error - Robot.DriveTrain.lastError) / Robot.DriveTrain.dt;
      Robot.DriveTrain.outputPower = Robot.DriveTrain.kP * Robot.DriveTrain.error + Robot.DriveTrain.kI * Robot.DriveTrain.errorSum + Robot.DriveTrain.kD * Robot.DriveTrain.errorRate;
  
  
      /////// Output to Motors ///////

      Robot.DriveTrain.m1_dt.set(outputPower);
      Robot.DriveTrain.m2_dt.set(outputPower);
      Robot.DriveTrain.m4_dt.set(-outputPower);
      Robot.DriveTrain.m3_dt.set(-outputPower);
  
  
      /////// Update Last- Variables ///////

      Robot.DriveTrain.lastTimestamp = Timer.getFPGATimestamp();
      Robot.DriveTrain.lastError = Robot.DriveTrain.error;

    }else if(Robot.DriveTrain.driveSwitch == false)
    {

      ////////////////////////////
      /////// Manual Drive ///////
      ////////////////////////////

    Robot.DriveTrain.LeftStickY = Robot.OI.getP1F310Axis(RobotMap.P1LeftY);
    Robot.DriveTrain.LeftStickX = Robot.OI.getP1F310Axis(RobotMap.P1LeftX);

    if(Robot.OI.getP1Button(RobotMap.P1X) == true) {

    Robot.DriveTrain.setPower(-Robot.DriveTrain.LeftStickY, Robot.DriveTrain.LeftStickX);

    }else {

      /////// Boost ///////

    Robot.DriveTrain.setPower(-Robot.DriveTrain.LeftStickY/2, Robot.DriveTrain.LeftStickX/2);

    }

  }

  }

  @Override
  protected boolean isFinished() {

    return false;

  }

  @Override
  protected void end() {

  }

  @Override
  protected void interrupted() {

  }

}
