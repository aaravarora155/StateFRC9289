package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.SubsystemCommands.ElevatorCommands;
import frc.robot.SubsystemCommands.PivotArmCommands;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.ClawRot;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.PivotArm;

public class PresetMethods extends Command {
    // Define attributes
    Elevator _elevator;
    Joystick _joystick;
    PivotArm _PivotArm;
    ClawRot _ClawRot;
    Claw _Claw;
    boolean scoringDirection; //false is right, true is left

    public  PresetMethods(Elevator _elevator, Joystick _controller, PivotArm _PivotArm, ClawRot _ClawRot, Claw _Claw) {
        // Construct Attributes
        this._elevator = _elevator;
        this._joystick = _controller;
        this.scoringDirection = false;
        this._PivotArm = _PivotArm;
        this._ClawRot = _ClawRot;
        this._Claw = _Claw;
        addRequirements(_elevator);
    }

    @Override
    public void execute() {
            if(_joystick.getPOV() == CommandConstants.PovLeft){
                scoringDirection = true;
                SmartDashboard.putBoolean("Scoring Boolean Left is T, Right is F", scoringDirection);
            }
            else if(_joystick.getPOV() == CommandConstants.PovRight){
                scoringDirection = false;
                SmartDashboard.putBoolean("Scoring Boolean Left is T, Right is F", scoringDirection);
            }
            if(_joystick.getRawButton(CommandConstants.ButtonA)){
                ElevatorCommands _elevatorCommands = new ElevatorCommands(_elevator, 0.1);

                //elevator position first
                if (_elevator.getEncoder1().getPosition() < 13000){
                    _elevatorCommands.execute();
                }   
                else if (_elevator.getEncoder1().getPosition() > 17000){
                    _elevatorCommands = new ElevatorCommands(_elevator, -0.1);
                    _elevatorCommands.execute();
                }
                else{
                    _elevatorCommands = new ElevatorCommands(_elevator, 0.02);
                    _elevatorCommands.execute();
                    //claw rotate
    
                }
                
            }
            else if(_joystick.getRawButton(CommandConstants.ButtonX)){
                ElevatorCommands _elevatorCommands = new ElevatorCommands(_elevator, 0.1);

                if (_elevator.getEncoder1().getPosition() < 20000){
                    _elevatorCommands.execute();
                }   
                else if (_elevator.getEncoder1().getPosition() > 23000){
                    _elevatorCommands = new ElevatorCommands(_elevator, -0.1);
                    _elevatorCommands.execute();
                }
                else{
                    _elevatorCommands = new ElevatorCommands(_elevator, 0.02);
                    _elevatorCommands.execute();
                }
            }
            else if(_joystick.getRawButton(CommandConstants.ButtonB)){
                ElevatorCommands _elevatorCommands = new ElevatorCommands(_elevator, 0.1);

                if (_elevator.getEncoder1().getPosition() < 54000){
                    _elevatorCommands.execute();
                }   
                else if (_elevator.getEncoder1().getPosition() > 58000){
                    _elevatorCommands = new ElevatorCommands(_elevator, -0.1);
                    _elevatorCommands.execute();
                }
                else{
                    _elevatorCommands = new ElevatorCommands(_elevator, 0.02);
                    _elevatorCommands.execute();
                }
            }
            else if(_joystick.getRawButton(CommandConstants.ButtonY)){
                ElevatorCommands _elevatorCommands = new ElevatorCommands(_elevator, 0.1);

                if (_elevator.getEncoder1().getPosition() < 99500){
                    _elevatorCommands.execute();
                }
                else{
                    _elevatorCommands = new ElevatorCommands(_elevator, 0.02);
                    _elevatorCommands.execute();
                }
            }
            else {
                if (_elevator.getEncoder1().getPosition() > 5000 && !_joystick.getRawButton(CommandConstants.ButtonBack)){
                    ElevatorCommands _elevatorCommands = new ElevatorCommands(_elevator, -0.1);
                    _elevatorCommands.execute();
                }
                else{
                    ElevatorCommands _elevatorCommands = new ElevatorCommands(_elevator, 0);
                    _elevatorCommands.execute();
                }
            }
    }
}