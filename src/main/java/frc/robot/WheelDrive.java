package frc.robot;

import java.lang.invoke.StringConcatFactory;
import java.util.concurrent.CancellationException;

import com.ctre.phoenix.sensors.WPI_CANCoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.jni.CANSparkMaxJNI;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class WheelDrive {
    private CANSparkMax angleMotor;
    private CANSparkMax speedMotor;
    private PIDController pidController;
    private WPI_CANCoder encoder;

    private int encCanId;

    public WheelDrive (int angleMotor, int speedMotor, int encoderCanId){
        this.angleMotor = new CANSparkMax(angleMotor, MotorType.kBrushless);
        this.speedMotor = new CANSparkMax(speedMotor, MotorType.kBrushless);
        pidController = new PIDController(0, 0, 0); 
        encoder = new WPI_CANCoder(encoderCanId);
        encCanId = encoderCanId;
    } 
    private final double MAX_VOLTS = 2.50;

    public void drive (double speed, double angle) {
        SmartDashboard.putNumber("Position " + String.valueOf(encCanId) , encoder.getPosition());
    
        // This makes the wheel drive forward/backward
        speedMotor.set (speed);
    
        // All the code here does math for the turn
        double setpoint = angle * (MAX_VOLTS * 0.5) + (MAX_VOLTS * 0.5); // Optimization offset can be calculated here
        if (setpoint < 0) {
            setpoint = MAX_VOLTS + setpoint;
        }
        if (setpoint > MAX_VOLTS) {
            setpoint = setpoint - MAX_VOLTS;
        }

        // // This uses the math and turns the wheel
        angleMotor.set( pidController.calculate( encoder.getPosition(), setpoint));
    }
    

}