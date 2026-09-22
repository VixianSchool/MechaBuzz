package org.firstinspires.ftc.teamcode.RobotModules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    public DcMotor dci2;
    public DcMotor dci1;

    public Intake(HardwareMap hm){
        dci1 = hm.get(DcMotor.class,"");
        dci2 = hm.get(DcMotor.class,"");
    }

    public void setDci(DcMotor dci2,DcMotor dci1) {
        this.dci2 = dci2;
        this.dci1 = dci1;
    }

    
}
