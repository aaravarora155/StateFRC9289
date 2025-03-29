package frc.robot.SubsystemCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Claw;

public class ClawCommands extends Command {
    //Define Motor Attributes
    Claw clawMotors;
    double power;

   public ClawCommands(Claw _clawMotors, double speed)
   {
        this.clawMotors = _clawMotors;
        this.power = speed;
        addRequirements(clawMotors);
   } 

   @Override
   public void execute()
   {
    //Move the Motor based on power
     clawMotors.move(power);
   }
}
//Wolfram121