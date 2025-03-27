package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorMiscConstants;

public class Elevator extends SubsystemBase {

    SparkMax motor_1;
    SparkMax motor_2;
    
    public Elevator(){
        motor_1 = new SparkMax(MotorMiscConstants.ELEVATOR_MOTOR_ID_1, MotorType.kBrushless);
        motor_2 = new SparkMax(MotorMiscConstants.ELEVATOR_MOTOR_ID_2, MotorType.kBrushless);
    }

    public void move(double speed){
        motor_1.set(speed*0.7);
        motor_2.set(-speed*0.7);
        SmartDashboard.putNumber("Elevator Power", motor_1.get());
    }

    public void stop(){
        motor_1.set(0);
        motor_2.set(0);
    }
}

//Created by Aditya-2204