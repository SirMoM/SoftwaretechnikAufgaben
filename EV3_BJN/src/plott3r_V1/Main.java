package plott3r_V1;
import lejos.hardware.Sound;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
 /**
 * @author NBJ
 *
 */
public class Main {
	
	public static void main(String args[]) throws Exception, Throwable
	{
		
			Roboter roboter = new Roboter(); //throws Exception
			Sound.beep();
			Sound.beep();
			roboter.addToQ(new Instruction(false, -50, -100));
			roboter.processInstructions();
//			synchroExample();
	}
	
	private static void synchroExample() {
		RegulatedMotor mA = new EV3LargeRegulatedMotor(MotorPort.A);
		RegulatedMotor mB = new EV3LargeRegulatedMotor(MotorPort.B);

		mA.synchronizeWith(new RegulatedMotor[] { mB });

		mA.startSynchronization();
		mA.setSpeed(20);
		mB.setSpeed(360);
		mA.rotate(-360, true);
		mB.rotate(-360, true);
		mA.endSynchronization();
		mA.waitComplete();
		mB.waitComplete();
		
		
		mB.synchronizeWith(new RegulatedMotor[] { mA });

		mB.startSynchronization();
		mB.setSpeed(20);
		mA.setSpeed(360);
		mB.rotate(360, true);
		mA.rotate(360, true);
		mB.endSynchronization();
		mB.waitComplete();
		mA.waitComplete();
	}

 }