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

public class PivotArm extends SubsystemBase {
    private SparkMax pivotArmMotor = new SparkMax(MotorMiscConstants.PIVOT_ARM_MOTOR_ID, MotorType.kBrushless);

    public PivotArm() {
        SparkMaxConfig config = new SparkMaxConfig();
        config
                .inverted(true)
                .idleMode(IdleMode.kBrake);
        config.encoder
                .positionConversionFactor(1000)
                .velocityConversionFactor(1000);
        config.closedLoop
                .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
                .pid(1.0, 0.0, 0.0);

        pivotArmMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void move(double speed) {
        pivotArmMotor.set(speed);
    }

    public void stop() {
        pivotArmMotor.set(0);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Pivot Arm Power " + MotorMiscConstants.PIVOT_ARM_MOTOR_ID, pivotArmMotor.get());
    }
}
// Wolfram121