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
            if(_joystick.getRawButton(CommandConstants.ButtonA)){
                ElevatorCommands _elevatorCommands = new ElevatorCommands(_elevator, 0.3); // prev .8

                // _elevatorCommands.execute();

                if (_elevator.getEncoder1().getPosition() < 14000){
                    _elevatorCommands.execute();
                }   
                else if (_elevator.getEncoder1().getPosition() > 18000){
                    _elevatorCommands = new ElevatorCommands(_elevator, -0.3);
                    _elevatorCommands.execute();
                }
                else{
                    _elevatorCommands = new ElevatorCommands(_elevator, 0.02);
                    _elevatorCommands.execute();
                }
            }
            else if(_joystick.getRawButton(CommandConstants.ButtonB)){
                ElevatorCommands _elevatorCommands = new ElevatorCommands(_elevator, 0.3); // prev .8

                // _elevatorCommands.execute();

                if (_elevator.getEncoder1().getPosition() < 55000){
                    _elevatorCommands.execute();
                }   
                else if (_elevator.getEncoder1().getPosition() > 59000){
                    _elevatorCommands = new ElevatorCommands(_elevator, -0.3);
                    _elevatorCommands.execute();
                }
                else{
                    _elevatorCommands = new ElevatorCommands(_elevator, 0.02);
                    _elevatorCommands.execute();
                }
            }
            else if(_joystick.getRawButton(CommandConstants.ButtonY)){
                ElevatorCommands _elevatorCommands = new ElevatorCommands(_elevator, 0.3);
                if (_elevator.getEncoder1().getPosition() < 105000){
                    _elevatorCommands.execute();
                }
                else{
                    _elevatorCommands = new ElevatorCommands(_elevator, 0.02);
                    _elevatorCommands.execute();
                }
            }
            else {
                if (_elevator.getEncoder1().getPosition() > 5000 && !_joystick.getRawButton(CommandConstants.ButtonBack)){
                    ElevatorCommands _elevatorCommands = new ElevatorCommands(_elevator, -0.1);
                    _elevatorCommands.execute();
                }
                else{
                    ElevatorCommands _elevatorCommands = new ElevatorCommands(_elevator, 0);
                    _elevatorCommands.execute();
                }
            }
    }
}

//Created by Aditya-2204