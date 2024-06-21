package frc.robot.subsystems;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
    private final TalonFX ShooterMotor = new TalonFX(Constants.ShooterMotor);

    public ShooterSubsystem() {
        ShooterMotor.setNeutralMode(NeutralModeValue.Coast);
        ShooterMotor.getConfigurator().apply(new CurrentLimitsConfigs().withStatorCurrentLimit(4));
    }

    public void setShooter(double speed) {
        if (!Constants.climbing) {
            //ShooterMotor.set(speed);
            ShooterMotor.set(-0.4);//switched from negative

        } else {
            ShooterMotor.set(0);
        }
    }

    public void setShooterVolt(double volts) {
        ShooterMotor.setVoltage(-volts);
    }

    public void stopShooter() {
        ShooterMotor.set(0);
    }

    public double getRate() {
        return ((-ShooterMotor.getVelocity().getValue()));
    }

    public void startClimbing() {
        Constants.climbing = true;
    }

    public void stopClimbing() {
        Constants.climbing = false;
    }
}