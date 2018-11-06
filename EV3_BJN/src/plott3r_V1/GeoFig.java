/**
 * 
 */
package plott3r_V1;

import java.util.List;

/**
 * @author NBJ
 *
 */
public abstract class GeoFig {

	private Coordinate mittelpunkt;
	private Coordinate currentCoord;

	public abstract List<Instruction> getInstructionSet();

	/**
	 * @param mittelpunkt
	 */
	public GeoFig(Coordinate mittelpunkt, Coordinate currentCoord) {
		this.mittelpunkt = mittelpunkt;
		this.currentCoord = currentCoord;
	}

	public GeoFig() {
	}

	/**
	 * @return the mittelpunkt
	 */
	public Coordinate getMittelpunkt() {
		return mittelpunkt;
	}

	/**
	 * @return the currentCoord
	 */
	public Coordinate getCurrentCoord() {
		return currentCoord;
	}

	/**
	 * @param currentCoord the currentCoord to set
	 */
	public void setCurrentCoord(Coordinate currentCoord) {
		this.currentCoord = currentCoord;
	}

	/**
	 * @param mittelpunkt the mittelpunkt to set
	 */
	public void setMittelpunkt(Coordinate mittelpunkt) {
		this.mittelpunkt = mittelpunkt;
	}

}