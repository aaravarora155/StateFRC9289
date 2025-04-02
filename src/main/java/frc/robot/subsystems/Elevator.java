package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorMiscConstants;

public class Elevator extends SubsystemBase {

    SparkMax motor_1;
    SparkMax motor_2;
    public final double DAMPENING;
    public static double currentHeight;
    
    public Elevator(){
        DAMPENING = 0.5;
        motor_1 = new SparkMax(MotorMiscConstants.ELEVATOR_MOTOR_ID_1, MotorType.kBrushless);
        motor_2 = new SparkMax(MotorMiscConstants.ELEVATOR_MOTOR_ID_2, MotorType.kBrushless);

        SparkMaxConfig config = new SparkMaxConfig();
        config
            .inverted(true)
            .idleMode(IdleMode.kCoast);
        config.encoder
            .positionConversionFactor(1000)
            .velocityConversionFactor(1000);
        config.closedLoop
            .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
            .pid(1.0, 0.0, 0.0);
            
        motor_1.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        motor_2.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        motor_1.getEncoder().setPosition(0);
        motor_2.getEncoder().setPosition(0);
    }

    public void move(double move) {
        // Convert height in meters to encoder
        motor_1.set(move);
        motor_2.set(-move);
        SmartDashboard.putNumber("Elevator Motor 1 Power", motor_1.get());
        SmartDashboard.putNumber("Elevator Motor 2 Power", motor_2.get());
        SmartDashboard.putNumber("Elevator Motor 1 Position", motor_1.getEncoder().getPosition());
        SmartDashboard.putNumber("Elevator Motor 2 Position", motor_2.getEncoder().getPosition() * -1);
    }

    public void stop(){
        motor_1.set(0);
        motor_2.set(0);
    }

    public RelativeEncoder getEncoder1(){
        return motor_1.getEncoder();
    }
    public RelativeEncoder getEncoder2(){
        return motor_2.getEncoder();
    }
    @Override
    public void periodic(){
        SmartDashboard.putNumber("Elevator Height", currentHeight);
        SmartDashboard.putNumber("Elevator Motor 1 Power", motor_1.get());
        SmartDashboard.putNumber("Elevator Motor 2 Power", motor_2.get());
        SmartDashboard.putNumber("Elevator Motor 1 Position", motor_1.getEncoder().getPosition());
        SmartDashboard.putNumber("Elevator Motor 2 Position", motor_2.getEncoder().getPosition() * -1);
    }
}
//Created by Aditya-2204