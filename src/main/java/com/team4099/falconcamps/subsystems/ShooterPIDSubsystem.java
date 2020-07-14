package com.team4099.falconcamps.subsystems;

import com.revrobotics.*;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;

public class ShooterPIDSubsystem extends PIDSubsystem {
    private static final double ShooterP = 1;
    private static final double ShooterI = 1;
    private static final double ShooterD = 1;
    private final CANSparkMax shooterLeader = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANSparkMax shooterFollower = new CANSparkMax(14, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANEncoder shooterEncoder = shooterLeader.getEncoder();

    public double getMeasurement() {
        return shooterEncoder.getVelocity();
    }

    public ShooterPIDSubsystem() {
        super(new PIDController(ShooterP, ShooterI, ShooterD));
        shooterFollower.follow(shooterLeader);
        
    }

    public void useOutput(double output, double setpoint) {
        shooterLeader.set(output);
    }

    @Override
    public void periodic() {}
}