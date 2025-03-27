package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.SubsystemCommands.ElevatorCommands;
import frc.robot.subsystems.Elevator;

public class ElevatorMethods extends Command {
    // Define attributes
    Elevator _elevator;
    Joystick _joystick;

    public ElevatorMethods(Elevator _elevator, Joystick _controller) {
        // Construct Attributes
        this._elevator = _elevator;
        _joystick = _controller;
        addRequirements(_elevator);
    }

    @Override
    public void execute() {
        double speed = _joystick.getRawAxis(CommandConstants.AxisRightStickY);
        ElevatorCommands elevatorCommands = new ElevatorCommands(_elevator, speed);
        elevatorCommands.execute();
    }
}

//Created by Aditya-2204