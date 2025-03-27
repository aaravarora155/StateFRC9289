package frc.robot.SubsystemCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator;

public class ElevatorCommands extends Command {
    //Define Motor Attributes
    Elevator climberMotors;
    double power;
    String motor;

   public ElevatorCommands(Elevator _elevatorMotor, double speed)
   {
        //Construct Attributes
        climberMotors = _elevatorMotor;
        power = speed;
        addRequirements(climberMotors);
   }

    @Override
    public void execute() {
        //Move Elevator
        climberMotors.move(power);
    }

    @Override
    public void end(boolean interrupted) {
        //Stop Elevator
        climberMotors.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}

//Created by Aditya-2204