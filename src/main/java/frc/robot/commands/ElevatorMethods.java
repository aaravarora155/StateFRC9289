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
        if (Elevator.currentHeight == 0.0) { //To prevent crashes, if the current height displacement is only 0, then move the elevator
            if(_joystick.getRawButton(CommandConstants.ButtonA)){ //L2
                // Move Elevator Up
                ElevatorCommands _elevatorCommands = new ElevatorCommands(_elevator, 0.37);
                _elevatorCommands.execute();
            }
            else if(_joystick.getRawButton(CommandConstants.ButtonB)){ //L3
                // Move Elevator Down
                ElevatorCommands _elevatorCommands = new ElevatorCommands(_elevator, 0.88);
                _elevatorCommands.execute();
            }
        } else {
            if(_joystick.getRawButton(CommandConstants.ButtonA)){ //L2
                // Move Elevator Up
                ElevatorCommands _elevatorCommands = new ElevatorCommands(_elevator, -Elevator.currentHeight); //move back down to 0.0 height displacement when A is pressed
                _elevatorCommands.execute();
            }
        }
    }
}

//Created by Aditya-2204