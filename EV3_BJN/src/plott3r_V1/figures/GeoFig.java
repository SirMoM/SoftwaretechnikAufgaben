/**
 * 
 */
package plott3r_V1.figures;

import java.util.List;

import plott3r_V1.Instruction;
import plott3r_V1.robot.components.Roboter;
import util.Coordinate;

/**
 * @author Noah Ruben, Benjamin Wiemann, J-P Edoh
 * @see <a href="https://github.com/SirMoM/SoftwaretechnikAufgaben">Github</a>
 */
public abstract class GeoFig{

	private Coordinate mittelpunkt;
	private Roboter roboter;
	public GeoFig(){
	}

	/**
	 * @param mittelpunkt
	 */
	public GeoFig(Coordinate mittelpunkt, Roboter roboter){
		this.mittelpunkt = mittelpunkt;
		this.roboter = roboter;
	}

	

	/**
	 * @return A list of Instructions which determine what the Robot has does.
	 */
	public abstract List<Instruction> getInstructionSet();

	/**
	 * @return the mittelpunkt
	 */
	public Coordinate getMittelpunkt(){
		return this.mittelpunkt;
	}

	/**
	 * @return the roboter
	 */
	public Roboter getRoboter() {
		return roboter;
	}

	/**
	 * @param roboter the roboter to set
	 */
	public void setRoboter(Roboter roboter) {
		this.roboter = roboter;
	}

	/**
	 * @param mittelpunkt the mittelpunkt to set
	 */
	public void setMittelpunkt(Coordinate mittelpunkt){
		this.mittelpunkt = mittelpunkt;
	}

}