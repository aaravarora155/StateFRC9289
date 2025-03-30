package frc.robot.SubsystemCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.PivotArm;

public class PivotArmCommands extends Command {
     // Define Motor Attributes
     PivotArm pivotArm;
     double power;

     public PivotArmCommands(PivotArm _pivotArm, double speed) {
          this.pivotArm = _pivotArm;
          this.power = speed;
          addRequirements(pivotArm);
     }

     @Override
     public void execute() {
          pivotArm.move(power);
     }

     public void executeLeft() {
          while (pivotArm.getEncoder().getPosition() < 45) {
               pivotArm.move(power);
          }
     }

     public void executeRight() {
          while (pivotArm.getEncoder().getPosition() > 0) {
               pivotArm.move(-power);
          }
     }
}