package frc.robot.SubsystemCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.PivotArm;

public class PivotArmCommands extends Command {
    //Define Motor Attributes
    PivotArm pivotArmMotor;
    double power;

   public PivotArmCommands(PivotArm _pivotArmMotor, double speed)
   {
        this.pivotArmMotor = _pivotArmMotor;
        this.power = speed;
        addRequirements(pivotArmMotor);
   } 

   @Override
   public void execute()
   {
    //Move the Motor based on power
     pivotArmMotor.move(power);
   }
}