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
			roboter.addToQ(new Instruction(true, -50, -100));
			roboter.processInstructions();
	}
 }