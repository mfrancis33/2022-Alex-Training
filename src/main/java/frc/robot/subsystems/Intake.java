package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

/**
 * hi
 * @author Alex Clute, Nicholas Stokes, and Michael Francis
 */
public class Intake extends SubsystemBase { //This is a class declaration

  private TalonFX intakeMotor;
  /** Creates a new ExampleSubsystem. */
  public Intake() { //This is a constructor POG
    // Initialize motor
    intakeMotor = new TalonFX(6);
    
    //Set settings on motor
    intakeMotor.configFactoryDefault();

    intakeMotor.setInverted(true); //TODO: make sure this is correct
    intakeMotor.setNeutralMode(NeutralMode.Coast);

    //Configure a current limit
    StatorCurrentLimitConfiguration intakeCurrentLimitConfig = 
      new StatorCurrentLimitConfiguration();
    intakeCurrentLimitConfig.currentLimit = 50;
    intakeCurrentLimitConfig.enable = true;
    intakeCurrentLimitConfig.triggerThresholdCurrent = 40;
    intakeCurrentLimitConfig.triggerThresholdTime = 3;
    //Push the current limit to the motor
    intakeMotor.configStatorCurrentLimit(intakeCurrentLimitConfig, 0);

    //Configure motor ramp rate
    intakeMotor.configClosedloopRamp(0.5);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  
  }

  /**
   * Sets Intake Motor from -1 to 1
   * @param speed The speed as a percent
   */
  public void setMotorSpeed(double speed) {
    intakeMotor.set(ControlMode.PercentOutput, speed);
  }
  
  public void stopMotor() {
    intakeMotor.set(ControlMode.PercentOutput, 0);
  }

  public double getMotorSpeed(){
    return intakeMotor.getMotorOutputPercent();
  }
}
