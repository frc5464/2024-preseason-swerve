package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class SwerveDrive {
    //Turn motors
    //CANSparkMax FLturn = new CANSparkMax(5, MotorType.kBrushless);
    // CANSparkMax FRturn = new CANSparkMax(4, MotorType.kBrushless);
    // CANSparkMax BLturn = new CANSparkMax(1, MotorType.kBrushless);
    // CANSparkMax BRturn = new CANSparkMax(7, MotorType.kBrushless);

    //Drive motors
    // CANSparkMax FLdrive = new CANSparkMax(2, MotorType.kBrushless);
    // CANSparkMax FRdrive = new CANSparkMax(3, MotorType.kBrushless);
    // CANSparkMax BLdrive = new CANSparkMax(9, MotorType.kBrushless);
    // CANSparkMax BRdrive = new CANSparkMax(8, MotorType.kBrushless);

    // measurements are in inches
    public final double Length = 22.75;
    public final double Width = 22.75;

    public void drive (double x1, double y1, double x2) {
        double r = Math.sqrt ((Length * Length) + (Width * Width));
        y1 *= -1;
    
        double a = x1 - x2 * (Length / r);
        double b = x1 + x2 * (Length / r);
        double c = y1 - x2 * (Width / r);
        double d = y1 + x2 * (Width / r);

        double backRightSpeed = Math.sqrt ((a * a) + (d * d));
        double backLeftSpeed = Math.sqrt ((a * a) + (c * c));
        double frontRightSpeed = Math.sqrt ((b * b) + (d * d));
        double frontLeftSpeed = Math.sqrt ((b * b) + (c * c));

        double backRightAngle = Math.atan2 (a, d) / Math.PI;
        double backLeftAngle = Math.atan2 (a, c) / Math.PI;
        double frontRightAngle = Math.atan2 (b, d) / Math.PI;
        double frontLeftAngle = Math.atan2 (b, c) / Math.PI;
    }
}