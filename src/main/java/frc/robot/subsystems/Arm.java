package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {

    // Provide all required parameters
    private SparkMax arm1 = new SparkMax(11, MotorType.kBrushless);
    private RelativeEncoder arm_encoder;

    public Arm() {
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
            
        arm1.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        
        this.arm_encoder = arm1.getEncoder();
        arm_encoder.setPosition(0.00);
    }

    public RelativeEncoder getEncoder(){
        return this.arm_encoder;
    }
    public void move(double speed) {
        arm1.set(speed);
        SmartDashboard.putNumber("Arm Motor 11", arm1.get());
        SmartDashboard.putNumber("Arm Position", arm_encoder.getPosition());
    }

    public void stop() {
        arm1.set(0);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Arm Motor 11", arm1.get());
        SmartDashboard.putNumber("Arm Position", arm_encoder.getPosition());
    }
}

//Wolfram