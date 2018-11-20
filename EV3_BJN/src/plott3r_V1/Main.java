package plott3r_V1;

import lejos.hardware.Sound;
import plott3r_V1.figures.Line;
import plott3r_V1.robot.components.Roboter;
import util.Coordinate;
import util.DisplayHandler;

/**
 * @author Noah Ruben, Benjamin Wiemann, J-P Edoh
 * @see <a href="https://github.com/SirMoM/SoftwaretechnikAufgaben">Github</a>
 */
public class Main{

	public static void main(String args[]) throws Exception, Throwable{
		Roboter roboter = new Roboter(); // throws Exception
		Sound.beepSequenceUp();
		roboter.goToStartPos();
		Sound.beepSequence();
		DisplayHandler.writeCurrentCoordinate(roboter.getCurrentCoordinate());
		Line line = new Line(new Coordinate(10, 10));
		roboter.addToQ(line.getInstructionSet());
		roboter.processInstructions();

	}
}