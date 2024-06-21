package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.FeedInCommand;
import frc.robot.commands.FeedOutCommand;
import frc.robot.oi.OI;
import frc.robot.subsystems.FeederSubsystem;

public class RobotContainer {
    private final OI oi = OI.getInstance();
    private final FeederSubsystem feederSubsystem = new FeederSubsystem();

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {
        oi.driverController().button(OI.Buttons.X_BUTTON).whileTrue(new FeedInCommand(feederSubsystem));
        oi.driverController().button(OI.Buttons.Y_BUTTON).whileTrue(new FeedOutCommand(feederSubsystem));
    }

    public Command getAutonomousCommand() {
        return null;
    }
}
