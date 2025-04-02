// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.path.PathPlannerPath;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.*;
import frc.robot.subsystems.*;
import frc.robot.AutonCommands.*;
import frc.robot.commands.*;
import frc.robot.SubsystemCommands.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */

public class RobotContainer {
  //Define Subsystems & Commands
  // private static final Chassis _chassis = Chassis.returnInstance();
  public static final Joystick driverController = new Joystick(0);
  public static final JoystickButton resetHeading_Start = new JoystickButton(driverController, CommandConstants.ButtonRightStick);
  private static Hang hang = new Hang();
  private final DrivetrainOld drivetrain = DrivetrainOld.getInstance();
  public static Elevator elevator = new Elevator();
  public static PivotArm _armPivot = new PivotArm();
  public static ClawRot _ClawRot = new ClawRot();
  public static Claw _Claw = new Claw();
  //initializating commands to put up as choices
  //old code
  private final Command leftCommand = new LeftStartAuto();
  private final Command middleCommand = new MiddleStartAuto();
  private final Command rightCommand = new RightStartAuto();
  private final Command nonSpeakerCommand = new NonSpeakerStartAuto();

  SendableChooser<Command> m_chooser;
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // configureBindings();
    CameraServer.startAutomaticCapture();
    configureBindings();
     m_chooser = new SendableChooser<>();

     NamedCommands.registerCommand("Stop Modules", new SwerveDriveCommands(0, 0, 0));

    //set up choices for autonomous program
    m_chooser.setDefaultOption("Leave Start Position", nonSpeakerCommand);
    m_chooser.addOption("Left Start", leftCommand);
    m_chooser.addOption("Middle Start", middleCommand);
    m_chooser.addOption("Right Auto", rightCommand);

    SmartDashboard.putData("Autonomous Chooser", m_chooser);
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() 
  {
    // Configure the trigger bindings
    resetHeading_Start.onTrue(new InstantCommand(drivetrain::zeroHeading, drivetrain));
    hang.setDefaultCommand(new HangMethods(hang, driverController));
    // elevator.setDefaultCommand(new ElevatorMethods(elevator, driverController));
    elevator.setDefaultCommand(new PresetMethods(elevator, driverController, _armPivot, _ClawRot, _Claw));
    _ClawRot.setDefaultCommand(new ClawRotMethods(_ClawRot, driverController));
    _armPivot.setDefaultCommand(new PivotArmMethods(_armPivot, driverController));
    _Claw.setDefaultCommand(new ClawMethods(_Claw, driverController));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return m_chooser.getSelected();
  }
}