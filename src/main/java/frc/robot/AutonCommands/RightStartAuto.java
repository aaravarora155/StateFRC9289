package frc.robot.AutonCommands;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.SubsystemCommands.SwerveDriveCommands;
import frc.robot.commands.CommandConstants;
import frc.robot.subsystems.DrivetrainOld;
import com.pathplanner.lib.commands.PathPlannerAuto;

public class RightStartAuto extends SequentialCommandGroup{
    final double shooterSpeed = 1;


    public RightStartAuto()
    {
        
        addCommands(
            new SwerveDriveCommands(0.2,0,0).withTimeout(0.89),/*Original:0.89 */
            new SwerveDriveCommands(0, 0, -0.3).withTimeout(1.2),/*Original:1.2 */
            new SwerveDriveCommands(0.19, -0.2,0).withTimeout(3), /*Original:2.3 */
            new SwerveDriveCommands(0,0,0).withTimeout(1)
        );
        //Aarav Arora
    }
}
