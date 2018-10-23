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
			Roboter roboter = new Roboter();
			Sound.beep();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
