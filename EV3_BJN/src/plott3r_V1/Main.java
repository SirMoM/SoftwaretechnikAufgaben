package plott3r_V1;
import lejos.hardware.Sound;
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
			//roboter.goToStartPos();
			roboter.addToQ(new Instruction(false, 0, 10));
			roboter.processInstructions();
			roboter.getXAchse().rotateMm(1000);
			
			//roboter.wrapUp();
			
	}
 }