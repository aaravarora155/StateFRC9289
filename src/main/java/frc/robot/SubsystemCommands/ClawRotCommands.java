package frc.robot.SubsystemCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClawRot;

public class ClawRotCommands extends Command {
    //Define Motor Attributes
    ClawRot clawRotMotor;
    double power;

   public ClawRotCommands(ClawRot _clawRotMotor, double speed)
   {
        this.clawRotMotor = _clawRotMotor;
        this.power = speed;
        addRequirements(clawRotMotor);
   } 

   @Override
   public void execute()
   {
    //Move the Motor based on power
     clawRotMotor.move(power);
   }
}
//Wolfran121