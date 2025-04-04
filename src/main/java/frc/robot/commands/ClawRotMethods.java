package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClawRot;
import frc.robot.SubsystemCommands.ClawRotCommands;
import frc.robot.SubsystemCommands.PivotArmCommands;

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
        if (_joystick.getPOV() == CommandConstants.PovLeft && _clawRot.getEncoder().getPosition() < 12000) {
            ClawRotCommands _ClawRotCommands = new ClawRotCommands(_clawRot, .2);
            _ClawRotCommands.execute();
        } else if (_joystick.getPOV() == CommandConstants.PovRight && _clawRot.getEncoder().getPosition() > -300) {
            ClawRotCommands _ClawRotCommands = new ClawRotCommands(_clawRot, -.2);
            _ClawRotCommands.execute();
        } else if (_joystick.getRawButton(CommandConstants.ButtonStart)) {
            ClawRotCommands _ClawRotCommands = new ClawRotCommands(_clawRot, -.2);
            _ClawRotCommands.execute();
        } 
        else {
            ClawRotCommands _ClawRotCommands = new ClawRotCommands(_clawRot,0);
            _ClawRotCommands.execute();
        }
    }
}
//Wolfram121