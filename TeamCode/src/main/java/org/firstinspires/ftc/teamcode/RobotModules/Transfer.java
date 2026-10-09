package org.firstinspires.ftc.teamcode.RobotModules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Transfer {

    public Servo trans;


    public DcMotor left_arm;
    public DcMotor right_arm;

    public Transfer(HardwareMap hm){
        trans = hm.get(Servo.class,"");

    }

    public void setSr(Servo trans) {
        this.trans = trans;
    }
}