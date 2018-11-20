/**
 * 
 */
package plott3r_V1.figures;

import java.util.List;

import ev3_bnj.Robot;
import plott3r_V1.Coordinate;
import plott3r_V1.Instruction;

/**
 * @author Noah Ruben, Benjamin Wiemann, J-P Edoh
 * @see <a href="https://github.com/SirMoM/SoftwaretechnikAufgaben">Github</a>
 */
public abstract class GeoFig{

	private Coordinate mittelpunkt;
	private Coordinate currentCoord;
	private Robot roboter;
	public GeoFig(){
	}

	/**
	 * @param mittelpunkt
	 */
	public GeoFig(Coordinate mittelpunkt, Coordinate currentCoord){
		this.mittelpunkt = mittelpunkt;
		this.currentCoord = currentCoord;
	}

	/**
	 * @return the currentCoord
	 */
	public Coordinate getCurrentCoord(){
		return this.currentCoord;
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
	 * @param currentCoord the currentCoord to set
	 */
	public void setCurrentCoord(Coordinate currentCoord){
		this.currentCoord = currentCoord;
	}

	/**
	 * @param mittelpunkt the mittelpunkt to set
	 */
	public void setMittelpunkt(Coordinate mittelpunkt){
		this.mittelpunkt = mittelpunkt;
	}

}