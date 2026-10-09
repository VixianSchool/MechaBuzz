package org.firstinspires.ftc.teamcode.Chassis;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Chassis {

        DcMotor flm;
        DcMotor frm;
        DcMotor blm;
        DcMotor brm;

        public Chassis(HardwareMap hm) {
            this.flm = hm.get(DcMotor.class,"meh0");
            this.frm = hm.get(DcMotor.class,"meh2");
            this.blm = hm.get(DcMotor.class,"meh1");
            this.brm = hm.get(DcMotor.class, "meh3");

            frm.setDirection(DcMotorSimple.Direction.REVERSE);
            brm.setDirection(DcMotorSimple.Direction.REVERSE);
        }

        public void update(Gamepad gamepad1){

            double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = -gamepad1.left_trigger + gamepad1.right_trigger;

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio,
            // but only if at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            flm.setPower(frontLeftPower);
            blm.setPower(backLeftPower);
            frm.setPower(frontRightPower);
            brm.setPower(backRightPower);

        }
    }

