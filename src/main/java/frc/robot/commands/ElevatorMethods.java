package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
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
        // Move Elevator

        double climberSpeed = _joystick.getRawAxis(CommandConstants.AxisRightTrigger);
        _elevator.move(climberSpeed);
    }
}

//Created by Aditya-2204