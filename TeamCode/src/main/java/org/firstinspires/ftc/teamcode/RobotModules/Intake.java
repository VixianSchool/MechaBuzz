package org.firstinspires.ftc.teamcode.RobotModules;

import static org.firstinspires.ftc.teamcode.RobotModules.Intake.State.IDLE;
import static org.firstinspires.ftc.teamcode.RobotModules.Intake.State.INTAKE;
import static org.firstinspires.ftc.teamcode.RobotModules.Intake.State.REVERSE;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    DcMotor intake;
    private State state;


    public Intake(HardwareMap hm) {
        this.intake = hm.get(DcMotor.class, "mch0");
    }

    public enum State {

        IDLE,
        INTAKE,
        REVERSE

    }


    public void setState(State state) {
        this.state = state;
    }

    public void update(Gamepad gm1) {
        if(gm1.left_bumper){
            setState(REVERSE);
        }
        else if (gm1.right_bumper){
            setState(INTAKE);
        } else{
            setState(IDLE);
        }

        switch (state) {
            case IDLE:
                intake.setPower(0);
                break;
            case INTAKE :
                intake.setPower(1);
                break;
            case REVERSE :
                intake.setPower(-1);
                break;
        }
    }
}
