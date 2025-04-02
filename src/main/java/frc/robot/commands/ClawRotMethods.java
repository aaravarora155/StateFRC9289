package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClawRot;
import frc.robot.SubsystemCommands.ClawRotCommands;

public class ClawRotMethods extends Command {
    ClawRot _clawRot;
    Joystick _joystick;

    public ClawRotMethods(ClawRot _clawRot, Joystick _controller) {
        this._clawRot = _clawRot;
        _joystick = _controller;
        addRequirements(_clawRot);
    }

    @Override
    public void execute() {
        if (_joystick.getRawButton(CommandConstants.ButtonShoulderL)) {
            ClawRotCommands _command = new ClawRotCommands(_clawRot, .1);
            _command.execute();
        } else if (_joystick.getRawButton(CommandConstants.ButtonShoulderR)) {
            ClawRotCommands _command = new ClawRotCommands(_clawRot, -.1);
            _command.execute();
        } else {
            ClawRotCommands _command = new ClawRotCommands(_clawRot, 0);
            _command.execute();
        }
    }
}
//Wolfram121