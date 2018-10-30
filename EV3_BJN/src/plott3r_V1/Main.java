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
			//testing
			roboter.goToStartPos();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
