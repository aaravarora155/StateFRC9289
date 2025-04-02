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

public class Claw extends SubsystemBase {
    private SparkMax clawTop = new SparkMax(MotorMiscConstants.CLAW_MOTOR_TOP_ID, MotorType.kBrushless);
    private SparkMax clawBottom = new SparkMax(MotorMiscConstants.CLAW_MOTOR_BOTTOM_ID, MotorType.kBrushless);

    private RelativeEncoder clawTopEncoder;
    private RelativeEncoder clawBottomEncoder;

    public Claw() {
        SparkMaxConfig config = new SparkMaxConfig();
        config
                .inverted(false)
                .idleMode(IdleMode.kCoast);
        config.encoder
                .positionConversionFactor(1000)
                .velocityConversionFactor(1000);
        config.closedLoop
                .feedbackSensor(FeedbackSensor.kPrimaryEncoder);

        clawTop.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        clawBottom.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        this.clawTopEncoder = clawTop.getEncoder();
        this.clawBottomEncoder = clawBottom.getEncoder();
    }

    public void move(double speed) {
        clawTop.set(speed);
        clawBottom.set(-speed);
    }

    public void stop() {
        clawTop.set(0);
        clawBottom.set(0);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Claw Top Power " + MotorMiscConstants.CLAW_MOTOR_TOP_ID, clawTop.get());
        SmartDashboard.putNumber("Claw Bottom Power " + MotorMiscConstants.CLAW_MOTOR_BOTTOM_ID, clawBottom.get());

        SmartDashboard.putNumber("Claw Top Position " + MotorMiscConstants.CLAW_MOTOR_TOP_ID, clawTopEncoder.getPosition());
        SmartDashboard.putNumber("Claw Bottom Position " + MotorMiscConstants.CLAW_MOTOR_BOTTOM_ID, clawBottomEncoder.getPosition());
    }
}
//Wolfram121