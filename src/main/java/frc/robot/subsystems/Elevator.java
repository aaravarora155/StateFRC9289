package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
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
    
    public Elevator(){
        DAMPENING = 0.5;
        motor_1 = new SparkMax(MotorMiscConstants.ELEVATOR_MOTOR_ID_1, MotorType.kBrushless);
        motor_2 = new SparkMax(MotorMiscConstants.ELEVATOR_MOTOR_ID_2, MotorType.kBrushless);

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
            
        motor_1.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        motor_2.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void move(double speed){
        motor_1.set(speed*DAMPENING);
        motor_2.set(-speed*DAMPENING);
        SmartDashboard.putNumber("Elevator Power", motor_1.get());
    }

    public void stop(){
        motor_1.set(0);
        motor_2.set(0);
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("Elevator Speed", motor_1.get());
    }
}

//Created by Aditya-2204