package org.firstinspires.ftc.teamcode.RobotModules;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake_Arms {

    public Servo arm_1;
    public Servo arm_2;
    public double openPos = 0.5;
    public double closedPos = 0.2;

    private State state;


    public enum State{
        ON,
        OFF;
    }

    public Intake_Arms(HardwareMap hm) {
        this.arm_1 = hm.get(Servo.class,"");
        this.arm_2 = hm.get(Servo.class,"");
        state = State.OFF;
    }

    public void setState(State state) {
        this.state = state;
    }


    public void update(Gamepad gm1) {
        if(gm1.xWasPressed()){
            setState(State.ON);
        }
        else if(gm1.xWasReleased()){
            setState(State.OFF);
        }

        switch (state) {
            case ON:
                arm_1.setPosition(openPos);
                arm_2.setPosition(openPos);
                break;

            case OFF:
                arm_1.setPosition(closedPos);
                arm_2.setPosition(closedPos);
                break;
        }
    }
}
