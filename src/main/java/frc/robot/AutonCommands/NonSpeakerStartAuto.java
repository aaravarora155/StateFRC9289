package frc.robot.AutonCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.SubsystemCommands.SwerveDriveCommands;

public class NonSpeakerStartAuto extends SequentialCommandGroup{
    
    public NonSpeakerStartAuto()
    {
        addCommands(
            new SwerveDriveCommands(.2, 0, 0).withTimeout(4),
            new SwerveDriveCommands(0, 0, 0)
        );
    }
}
