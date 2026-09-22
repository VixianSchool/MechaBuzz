package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;

public class PIDControl {
    double integralSum = 0;
    private double kd;
    private double ki;
    private double kp;
    private double lastError = 0;

    ElapsedTime timer = new ElapsedTime();
    public double PIDController(double reference, double state) {
        double error = reference - state;
        integralSum += error + error * timer.seconds();
        double derivative = (error-lastError) / timer.seconds();
        lastError = error;
        timer.reset();
        return (kp* error) + (derivative*kd) + (integralSum * ki);
    }
}