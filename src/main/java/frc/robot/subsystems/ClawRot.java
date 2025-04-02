package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import frc.robot.Constants.MotorMiscConstants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClawRot extends SubsystemBase {
    private SparkMax clawRot = new SparkMax(MotorMiscConstants.CLAW_ROT_MOTOR_ID, MotorType.kBrushless);
    private RelativeEncoder clawRotEncoder;

    public ClawRot() {
        SparkMaxConfig config = new SparkMaxConfig();
        config
                .inverted(false)
                .idleMode(IdleMode.kCoast);
        config.encoder
                .positionConversionFactor(1000)
                .velocityConversionFactor(1000);
        config.closedLoop
                .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
                .pid(1.0, 0.0, 0.0);
        clawRot.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        this.clawRotEncoder = clawRot.getEncoder();
        this.clawRotEncoder.setPosition(0);
    }

    public RelativeEncoder getEncoder() {
        return clawRotEncoder;
    }

    public void move(double speed) {
        clawRot.set(speed);
    }

    public void stop() {
        clawRot.set(0);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Claw Rot Power" + MotorMiscConstants.CLAW_ROT_MOTOR_ID, clawRot.get());
        SmartDashboard.putNumber("Claw Rot Position" + MotorMiscConstants.CLAW_ROT_MOTOR_ID, clawRotEncoder.getPosition());
    }
}
//Wolfram121