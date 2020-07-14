package com.team4099.falconcamps;

import com.team4099.falconcamps.subsystems.ShooterPIDSubsystem;
import com.team4099.falconcamps.subsystems.ShooterSparkPID;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import com.team4099.falconcamps.commands.shooter.ShootPIDSubsystemCommand;
import com.team4099.falconcamps.commands.shooter.ShooterPIDSubsystemIdleCommand;
import com.team4099.falconcamps.commands.shooter.ShooterSparkPIDIdleCommand;
import com.team4099.falconcamps.commands.shooter.ShootSparkPIDCommand;
import edu.wpi.first.wpilibj.XboxController;

public class RobotContainer {
    private final ShooterPIDSubsystem pid = new ShooterPIDSubsystem();
    private final ShooterSparkPID spark = new ShooterSparkPID();
    XboxController driver = new XboxController(0);


    public RobotContainer() {
        new Trigger(driver :: getAButton).whenActive(new ShootPIDSubsystemCommand(pid));
        pid.setDefaultCommand(new ShooterPIDSubsystemIdleCommand(pid));
        new Trigger(driver :: getAButton).whenActive(new ShootSparkPIDCommand(spark));
        spark.setDefaultCommand(new ShooterSparkPIDIdleCommand(spark));
    }
}
