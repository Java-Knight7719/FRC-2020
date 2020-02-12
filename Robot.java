/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Camera;
import frc.robot.subsystems.Hanger;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Spinner;
import frc.robot.commands.Move;

public class Robot extends TimedRobot {

  public static OI OI;
  public static DriveTrain DriveTrain;
  public static Camera ExtCamera;
  public static Intake Intake;
  public static Shooter Shooter;
  public static Hanger Hanger;
  public static Move Move;
  public static Spinner Spinner;

  @Override
  public void robotInit() {

    Scheduler.getInstance().run();

    OI = new OI();
    DriveTrain = new DriveTrain();
    Intake = new Intake();
    Shooter = new Shooter();
    Spinner = new Spinner();
    Hanger = new Hanger();
    NetworkTableInstance.getDefault().flush();

  }

  @Override
  public void robotPeriodic() {

    Scheduler.getInstance().run();

  }

  @Override
  public void disabledInit() {

    Scheduler.getInstance().run();

  }

  @Override
  public void disabledPeriodic() {

    Scheduler.getInstance().run();

  }

  @Override
  public void autonomousInit() {

    Scheduler.getInstance().run();

  }

  @Override
  public void autonomousPeriodic() {

    Scheduler.getInstance().run();

  }

  @Override
  public void teleopInit() {

    Scheduler.getInstance().run();

  }

  @Override
  public void teleopPeriodic() {

    Scheduler.getInstance().run();

  }

  @Override
  public void testPeriodic() {

  }
  
}
