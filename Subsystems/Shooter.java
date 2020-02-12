/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Shoot;

public class Shooter extends Subsystem {

  public CANSparkMax m1_st = new CANSparkMax(RobotMap.m5_neo, MotorType.kBrushless);
  public CANSparkMax m2_st = new CANSparkMax(RobotMap.m6_neo, MotorType.kBrushless);

  public CANEncoder encoder = m1_st.getEncoder();

  public double errorSum = 0;
  public double lastError = 0;
  public double lastTimestamp = Timer.getFPGATimestamp();
  public double setpoint = 0;
  public double sensorPosition;
  public double error;
  public double dt;
  public double errorRate;
  public double outputPower;

  public final double kP = 0.05;
  public final double kI = 0.1;
  public final double kD = 0.01;
  public final double iLimit = -1600;
  public final double kDriveTick2Feet = 10.0 / 128 * 6 * Math.PI / 10;
  
  @Override
  public void initDefaultCommand() {

    setDefaultCommand(new Shoot());

  }

}
