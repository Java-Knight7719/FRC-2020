
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

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.Move;

public class DriveTrain extends Subsystem 
{

  public CANSparkMax m1_dt = new CANSparkMax(RobotMap.m1_neo, MotorType.kBrushless);
  public CANSparkMax m2_dt = new CANSparkMax(RobotMap.m2_neo, MotorType.kBrushless);
  public CANSparkMax m3_dt = new CANSparkMax(RobotMap.m3_neo, MotorType.kBrushless);
  public CANSparkMax m4_dt = new CANSparkMax(RobotMap.m4_neo, MotorType.kBrushless);

  public CANEncoder encoder = m1_dt.getEncoder();
  
  private SpeedControllerGroup rm_dt = new SpeedControllerGroup(m4_dt,m3_dt);
  private SpeedControllerGroup lm_dt = new SpeedControllerGroup(m1_dt,m2_dt);

  private DifferentialDrive m_Drive = new DifferentialDrive(lm_dt,rm_dt);

  public double errorSum = 0;
  public double lastError = 0;
  public double lastTimestamp = 0;
  public double setpoint = 0;
  public boolean driveSwitch = true;
  public double sensorPosition = 0;
  public double error = 0;
  public double dt = 0;
  public double errorRate = 0;
  public double outputPower = 0 ;
  public double LeftStickY;
  public double LeftStickX;

  public final double kP = 0.05;
  public final double kI = 0.1;
  public final double kD = 0.01;
  public final double iLimit = 1;
  public final double kDriveTick2Feet = 10.0 / 128 * 6 * Math.PI / 10;

  @Override
  public void initDefaultCommand() {

    setDefaultCommand(new Move());

    encoder.setPosition(0.0);
    setpoint = 0;
    m1_dt.restoreFactoryDefaults();
    m2_dt.restoreFactoryDefaults();
    m3_dt.restoreFactoryDefaults();
    m4_dt.restoreFactoryDefaults();

  }

  public void setPower(double Y, double X) {

    m_Drive.arcadeDrive(Y, X);

  }

}
