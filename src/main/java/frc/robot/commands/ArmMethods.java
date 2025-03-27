package frc.robot.commands;

import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.SubsystemCommands.ArmCommands;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Roller;

public class ArmMethods extends Command {
    Arm arm;
    Roller roller;
    Joystick button;
    RelativeEncoder arm_encoder;
    boolean safety = true;


    public ArmMethods(Arm arm, Joystick button) {
        this.arm = arm;
        this.button = button;
        arm_encoder = arm.getEncoder();
        addRequirements(arm);
    }

    @Override
    public void execute() {
        if (button.getRawButton(CommandConstants.ButtonBack)){
            arm_encoder.setPosition(0);
            safety = !safety;
        }
        if (button.getRawButton(CommandConstants.ButtonShoulderL) && arm_encoder.getPosition() < 6000 && safety) {
            ArmCommands cmd = new ArmCommands(.1, arm);
            cmd.execute();
        } else if (button.getRawButton(CommandConstants.ButtonShoulderR) && arm_encoder.getPosition()>0 && safety) {
            ArmCommands cmd = new ArmCommands(-.1, arm);
            cmd.execute();
        }else if (button.getRawButton(CommandConstants.ButtonShoulderL) && !safety) {
            ArmCommands cmd = new ArmCommands(.1, arm);
            cmd.execute();
        } else if (button.getRawButton(CommandConstants.ButtonShoulderR) && !safety) {
            ArmCommands cmd = new ArmCommands(-.1, arm);
            cmd.execute();
        }else {
            ArmCommands cmd = new ArmCommands(-.02, arm);
            cmd.execute();
        }
    }
}