package plott3r_V1;

import lejos.hardware.Sound;
import plott3r_V1.robot.components.Roboter;

/**
 * @author Noah Ruben, Benjamin Wiemann, J-P Edoh
 * @see <a href="https://github.com/SirMoM/SoftwaretechnikAufgaben">Github</a>
 */
public class Main{

	public static void main(String args[]) throws Exception, Throwable{
		Roboter roboter = new Roboter(); // throws Exception
		Sound.beep();
		Sound.beep();
		roboter.addToQ(new Instruction(false, -50, -100));
		roboter.addToQ(new Instruction(true, -50, -100));
		roboter.processInstructions();
	}
}