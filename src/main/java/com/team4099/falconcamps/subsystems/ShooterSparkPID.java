package com.team4099.falconcamps.subsystems;

import com.revrobotics.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSparkPID extends SubsystemBase {
    private final CANSparkMax shooterLeader = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANSparkMax shooterFollower = new CANSparkMax(14, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANEncoder shooterEncoder = shooterLeader.getEncoder();
    private final CANPIDController pidController = shooterFollower.getPIDController();
    private double targetVelocity = 0;

    public ShooterSparkPID() {
        shooterFollower.follow(shooterLeader);
        pidController.setP(1.7 / 300);
        pidController.setI(0);
        pidController.setD(5.5 * 14000);

    }

    public void setTargetVelocity(double velocity) {
        targetVelocity = velocity;
    }

    @Override
    public void periodic() {
        pidController.setReference(targetVelocity, ControlType.kVelocity);
    }
}
