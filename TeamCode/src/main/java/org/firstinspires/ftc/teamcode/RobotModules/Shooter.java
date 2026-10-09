package org.firstinspires.ftc.teamcode.RobotModules;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
public class Shooter {
    public static double target = 0;
    public Telemetry tele;
    public DcMotorEx m2;
    private double power = 0;
    public DcMotorEx m1;
    private PIDController PID;
    public static double p=0,i=0,d = 0;
    public static double ks=0,ka=0,kv=0;
    public Shooter(HardwareMap hm, Telemetry tele) {
        this.m1 = hm.get(DcMotorEx.class,"mch1");
        this.m2 = hm.get(DcMotorEx.class,"mch2");
        PID = new PIDController(p,i,d);
        MotorConfigurationType mct = m1.getMotorType();
        mct.setAchieveableMaxRPMFraction(1.0);
        m1.setMotorType(mct);
        m1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        m1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        m1.setDirection(DcMotorSimple.Direction.REVERSE);
        m2.setMotorType(mct);
        m2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        m2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.tele = tele;
    }

    public void update(){
        double velocity = m2.getVelocity();
        double feedforward = ks + kv*target + ka*(target-velocity);
        power = feedforward + PID.calculate(velocity,target);
        power = Math.min(1,Math.max(-1,power));
        m1.setPower(power);
        m2.setPower(power);
        tele.addData("target",target);
        tele.addData("velocity",velocity);
        PID.setPID(p,i,d);
    }
}