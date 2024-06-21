package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.FeederSubsystem;

public class FeedOutCommand extends Command {
    private final FeederSubsystem feederSubsystem;

    public FeedOutCommand(FeederSubsystem feederSubsystem) {
        this.feederSubsystem = feederSubsystem;
        addRequirements(this.feederSubsystem);
    }

    @Override
    public void initialize() {
        feederSubsystem.stop();
    }

    @Override
    public void execute() {
        feederSubsystem.setFeeder(1);
    }

    @Override
    public void end(boolean Interrupted) {
        feederSubsystem.stop();
    }
}
