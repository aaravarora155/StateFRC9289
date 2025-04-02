package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.PivotArm;
import frc.robot.SubsystemCommands.PivotArmCommands;

public class PivotArmMethods extends Command {
    // Define attributes
    PivotArm _pivotArm;
    Joystick _joystick;

    public PivotArmMethods(PivotArm _pivotArm, Joystick _controller) {
        // Construct Attributes
        this._pivotArm = _pivotArm;
        _joystick = _controller;
        addRequirements(_pivotArm);
    }

    @Override
    public void execute() {
        // Set speeds and directions based on button press
        if (_joystick.getPOV() == CommandConstants.PovLeft) {
            PivotArmCommands _command = new PivotArmCommands(_pivotArm, -.1);
            _command.execute();
        } else if (_joystick.getPOV() == CommandConstants.PovRight) {
            PivotArmCommands _command = new PivotArmCommands(_pivotArm, .1);
            _command.execute();
        } else {
            PivotArmCommands _command = new PivotArmCommands(_pivotArm, 0);
            _command.execute();
        }
        
    }
}
// Wolfram121