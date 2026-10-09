package org.firstinspires.ftc.teamcode.RobotModules;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Brake {

    public Servo s1;
    public Servo s4;
    public Servo s3;
    public Servo s2;

    private double onPos = 0.6;
    private double offPos = 0.1;

    private State state;

    public enum State{
        ON,
        OFF;
    }

    public Brake(HardwareMap hm) {
        s1 = hm.get(Servo.class,"");
        s2 = hm.get(Servo.class,"");
        s3 = hm.get(Servo.class,"");
        s4 = hm.get(Servo.class,"");
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setPosition(double position){
        s1.setPosition(position);
        s2.setPosition(position);
        s3.setPosition(position);
        s4.setPosition(position);
    }


    public void update(Gamepad gm1){

        if(gm1.aWasPressed()){
            setState(State.ON);
        }
        else if(gm1.aWasReleased()){
            setState(State.OFF);
        }
        switch (state) {

            case ON:
                setPosition(onPos);
                break;
            case OFF:
                setPosition(offPos);
                break;
        }
    }

}