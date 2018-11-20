/**
 * 
 */
package plott3r_V1.figures;

import java.util.ArrayList;
import java.util.List;

import plott3r_V1.Instruction;
import plott3r_V1.robot.components.Roboter;
import util.Coordinate;

/**
 * @author Noah Ruben, Benjamin Wiemann, J-P Edoh
 * @see <a href="https://github.com/SirMoM/SoftwaretechnikAufgaben">Github</a>
 */
public class Quadrat extends GeoFig{

	private double sideLength;
	private double degree;
	private double radius;
	
	// TODO FERTIG IMPL
	public Quadrat(double sideLength, double degree, Coordinate mittelpunkt,Roboter roboter){
		super(mittelpunkt,roboter);
		this.sideLength = sideLength;
		this.degree = degree;
		this.radius = Math.sqrt(Math.pow((sideLength))
	}

	@Override
	public List<Instruction> getInstructionSet(){
		ArrayList<Instruction> instructions = new ArrayList<Instruction>();
		instructions.add(new Instruction(false,this.getRoboter().getCurrentCoordinate().getxCoord() - this.getMittelpunkt().getxCoord() ,this.getRoboter().getCurrentCoordinate().getyCoord() - this.getMittelpunkt().getyCoord()));
		
		
		instructions.add(new Instruction(false, -(sideLength/2), -(sideLength/2)));
		instructions.addAll(new Line(new Coordinate(0,sideLength)).getInstructionSet());
		instructions.addAll(new Line(new Coordinate(sideLength,0)).getInstructionSet());
		instructions.addAll(new Line(new Coordinate(0,-sideLength)).getInstructionSet());
		instructions.addAll(new Line(new Coordinate(-sideLength,0)).getInstructionSet());
		instructions.add(new Instruction(false, 0,0));
		return null;
	}

}
