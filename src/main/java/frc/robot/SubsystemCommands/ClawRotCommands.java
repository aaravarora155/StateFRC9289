package frc.robot.SubsystemCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClawRot;

public class ClawRotCommands extends Command {
     // Define Motor Attributes
     ClawRot clawRot;
     double power;

     public ClawRotCommands(ClawRot _clawRot, double speed) {
          this.clawRot = _clawRot;
          this.power = speed;
          addRequirements(clawRot);
     }

     @Override
     public void execute() {
          clawRot.move(power);
     }

     public void execute90() {
          if (90 - clawRot.getEncoder().getPosition() < 270 - clawRot.getEncoder().getPosition()) {
               while (clawRot.getEncoder().getPosition() < 90) {
                    clawRot.move(-power);
               }
          } else {
               while (clawRot.getEncoder().getPosition() > 270) {
                    clawRot.move(power);
               }
          }
     }
}
// Wolfran121