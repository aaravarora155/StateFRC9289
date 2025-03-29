package frc.robot.SubsystemCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator;

public class ElevatorCommands extends Command {
    //Define Motor Attributes
    Elevator elevatorMotors;
    double heightInMeters;
    String motor;

   public ElevatorCommands(Elevator _elevatorMotor, double heightInMeters)
   {
        //Construct Attributes
        elevatorMotors = _elevatorMotor;
        this.heightInMeters = heightInMeters;
        addRequirements(elevatorMotors);
   }

    @Override
    public void execute() {
        //Move Elevator
        elevatorMotors.move(heightInMeters);
    }

    @Override
    public void end(boolean interrupted) {
        //Stop Elevator
        elevatorMotors.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}

//Created by Aditya-2204