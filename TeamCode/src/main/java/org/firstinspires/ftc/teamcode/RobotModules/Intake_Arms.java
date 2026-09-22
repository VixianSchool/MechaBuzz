package org.firstinspires.ftc.teamcode.RobotModules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake_Arms {

    public Servo sl;
    public Servo sr;

    public DcMotor left_arm;
    public DcMotor right_arm;

    public Intake_Arms(HardwareMap hm){
        sl = hm.get(Servo.class,"");
        sr = hm.get(Servo.class,"");
    }

    public void setSr(Servo sr, Servo sl) {
        this.sr = sr;
        this.sl = sl;
    }
}