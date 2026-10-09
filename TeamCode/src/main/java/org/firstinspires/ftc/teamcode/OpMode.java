package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Chassis.Chassis;
import org.firstinspires.ftc.teamcode.RobotModules.Brake;
import org.firstinspires.ftc.teamcode.RobotModules.Intake;
import org.firstinspires.ftc.teamcode.RobotModules.Intake_Arms;
import org.firstinspires.ftc.teamcode.RobotModules.Shooter;

public class OpMode extends LinearOpMode {

    FtcDashboard dash;
    @Override
    public void runOpMode() throws InterruptedException {
        dash = FtcDashboard.getInstance();
        telemetry = new MultipleTelemetry(telemetry, dash.getTelemetry());
        Shooter shooter = new Shooter(hardwareMap, telemetry);
        Chassis chassis = new Chassis(hardwareMap);
        Intake intake = new Intake(hardwareMap);
        Brake brake = new Brake(hardwareMap);
        Intake_Arms intakeArms = new Intake_Arms(hardwareMap);
        waitForStart();
        while(opModeIsActive()){
            shooter.update();
            telemetry.update();
            chassis.update(gamepad1);
            intake.update(gamepad1);
            brake.update(gamepad1);
            intakeArms.update(gamepad1);
        }
    }
}
