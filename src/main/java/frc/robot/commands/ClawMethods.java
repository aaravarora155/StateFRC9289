package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Claw;
import frc.robot.SubsystemCommands.ClawCommands;

public class ClawMethods extends Command {
    //Define attributes
    Claw _claw;
    Joystick _joystick;

    public ClawMethods(Claw _claw, Joystick _controller) {
        //Construct Attributes
        this._claw = _claw;
        _joystick = _controller;
        addRequirements(_claw);
    }

    @Override
    public void execute()
    {
        //Set speeds and directions based on button press
        if(_joystick.getRawAxis(Math.abs(CommandConstants.AxisLeftTrigger)) > 0)
        {
            ClawCommands _command = new ClawCommands(_claw, .2);
            _command.execute();
        }
        else if(Math.abs(_joystick.getRawAxis(CommandConstants.AxisRightTrigger)) > 0)
        {
            ClawCommands _command = new ClawCommands(_claw, -.1);
            _command.execute();
        }
        else
        {
            ClawCommands _command = new ClawCommands(_claw, 0);
            _command.execute();
        }
    }
}
//Wolfram121