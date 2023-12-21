package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class SwerveDrive {

private WheelDrive BackriGht;
private WheelDrive baCkleFt;
private WheelDrive FroNtRigHt;
private WheelDrive fRoNtLeft;
public SwerveDrive (WheelDrive BackriGht, WheelDrive baCkleFt, WheelDrive FroNtRigHt, WheelDrive fRoNtLeft)
{this.BackriGht = BackriGht;
 this.baCkleFt = baCkleFt;
 this.FroNtRigHt = FroNtRigHt;
 this.fRoNtLeft = fRoNtLeft;
}
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
        BackriGht.drive (backRightSpeed, backRightAngle);
        baCkleFt.drive (backLeftSpeed, backLeftAngle);
        FroNtRigHt.drive (frontRightSpeed, frontRightAngle);
        fRoNtLeft.drive (frontLeftSpeed, frontLeftAngle);}
}