/**
 * 
 */
package plott3r_V1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Student
 *
 */
public class Line extends GeoFig {

	private Coordinate endPoint = null;
	private double degree = 0.0d;
	private double lenght = 0.0d;
	
	public Line(Coordinate ende) {
		this.endPoint = ende;
	}
	
	public Line(Coordinate mitte, Coordinate currentCoord, double lenght, double degree) {
		super(mitte, currentCoord);
		this.lenght = lenght;
		this.degree = degree;
	}
	
	
	@Override
	public List<Instruction> getInstructionSet() {
		ArrayList<Instruction> instructions = new ArrayList<Instruction>();
		if(endPoint == null) {
			double gegenkathete;
			double ankathete;
			double hypotenuse = lenght;
			
			gegenkathete = Math.sin(degree) * hypotenuse;
			ankathete = Math.cos(degree) * hypotenuse;
			
			double moveToBeginXCoord = getCurrentCoord().getxCoord() - (getMittelpunkt().getxCoord() + ankathete); 
			double moveToBeginYCoord = getCurrentCoord().getyCoord() - (getMittelpunkt().getyCoord() + hypotenuse); 
			
			instructions.add(new Instruction(false, moveToBeginXCoord , moveToBeginYCoord));

			double moveToEndXCoord = getCurrentCoord().getxCoord() - (getMittelpunkt().getxCoord() - ankathete); 
			double moveToEndYCoord = getCurrentCoord().getyCoord() - (getMittelpunkt().getyCoord() - hypotenuse); 
			
			instructions.add(new Instruction(false, moveToEndXCoord , moveToEndYCoord));
		}else {
			instructions.add(new Instruction(true, endPoint.getxCoord(), endPoint.getyCoord()));
		}
		return instructions;
	}
}
