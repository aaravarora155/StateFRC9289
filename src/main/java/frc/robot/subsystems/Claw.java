package frc.robot.subsystems;

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

public class Claw extends SubsystemBase {
    private SparkMax clawMotorTop = new SparkMax(MotorMiscConstants.CLAW_MOTOR_TOP_ID, MotorType.kBrushless);
    private SparkMax clawMotorBottom = new SparkMax(MotorMiscConstants.CLAW_MOTOR_BOTTOM_ID, MotorType.kBrushless);

    public Claw() {
        SparkMaxConfig config = new SparkMaxConfig();
        config
                .inverted(true)
                .idleMode(IdleMode.kBrake);
        config.encoder
                .positionConversionFactor(1000)
                .velocityConversionFactor(1000);
        config.closedLoop
                .feedbackSensor(FeedbackSensor.kPrimaryEncoder);

        clawMotorTop.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        clawMotorBottom.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void move(double speed) {
        clawMotorTop.set(speed);
        clawMotorBottom.set(-speed);
    }

    public void stop() {
        clawMotorTop.set(0);
        clawMotorBottom.set(0);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Claw Top Power " + MotorMiscConstants.CLAW_MOTOR_TOP_ID, clawMotorTop.get());
        SmartDashboard.putNumber("Claw Bottom Power " + MotorMiscConstants.CLAW_MOTOR_BOTTOM_ID, clawMotorBottom.get());
    }
}
//Wolfram121