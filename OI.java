/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.RobotMap;

public class OI {
  RobotMap m = new RobotMap();

  public Joystick P1F310 = new Joystick(RobotMap.P1F310);
  public Joystick P2F310 = new Joystick(RobotMap.P2F310);
  
  public double getP1F310Axis (int axis) 
  {
    return P1F310.getRawAxis(axis);
  }
  public double getP2F310Axis (int axis)
  {
    return P2F310.getRawAxis(axis);
  }

  public Button P1AButton     = new         JoystickButton(P1F310, RobotMap.P1A),
                P1F310BButton     = new         JoystickButton(P1F310, RobotMap.P1B),
                P1F310XButton     = new         JoystickButton(P1F310, RobotMap.P1X),
                P1F310YButton     = new         JoystickButton(P1F310, RobotMap.P1Y),
                P1F310LBmpr       = new   JoystickButton(P1F310, RobotMap.P1LBumper),
                P1F310RBmpr       = new   JoystickButton(P1F310, RobotMap.P1RBumper),
                P1F310BackButton  = new      JoystickButton(P1F310, RobotMap.P1Back),
                P1F310StartButton = new     JoystickButton(P1F310, RobotMap.P1Start),

                P2F310AButton     = new         JoystickButton(P2F310, RobotMap.P2A),
                P2F310BButton     = new         JoystickButton(P2F310, RobotMap.P2B),
                P2F310XButton     = new         JoystickButton(P2F310, RobotMap.P2X),
                P2F310YButton     = new         JoystickButton(P2F310, RobotMap.P2Y),
                P2F310LBmpr       = new   JoystickButton(P2F310, RobotMap.P2LBumper),
                P2F310RBmpr       = new   JoystickButton(P2F310, RobotMap.P2RBumper),
                P2F310BackButton  = new      JoystickButton(P2F310, RobotMap.P2Back),
                P2F310StartButton = new     JoystickButton(P2F310, RobotMap.P2Start);      
  
  public boolean getP1Button(int Button)
  {
    return P1F310.getRawButton(Button);
  }
  public boolean getP2Button(int Button)
  {
    return P2F310.getRawButton(Button);
  }
  
}
