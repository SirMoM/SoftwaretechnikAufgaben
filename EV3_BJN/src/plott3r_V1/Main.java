/**
 * 
 */
package plott3r_V1;

import lejos.hardware.Sound;
import lejos.utility.Delay;

/**
 * @author NBJ
 *
 */
public class Main {
	
	public static void main(String args[]) {
		try {
			Roboter roboter = new Roboter(); //throws Exception
			Sound.beep();
			roboter.goToStartPos();
			roboter.addToQ(new Instruction(false, 10, 10));
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
