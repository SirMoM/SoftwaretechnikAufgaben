/**
 * 
 */
package plott3r_V1.figures;

import java.util.ArrayList;
import java.util.List;

import plott3r_V1.Coordinate;
import plott3r_V1.Instruction;

/**
 * @author Noah Ruben, Benjamin Wiemann, J-P Edoh
 * @see <a href="https://github.com/SirMoM/SoftwaretechnikAufgaben">Github</a>
 */
public class Quadrat extends GeoFig{

	private double sideLength;
	private double degree;
	private Coordinate mittelpunkt;
	
	// TODO FERTIG IMPL
	public Quadrat(double sideLength, double degree, Coordinate mittelpunkt){
		this.sideLength = sideLength;
		this.degree = degree;
		this.mittelpunkt = mittelpunkt;
	}

	@Override
	public List<Instruction> getInstructionSet(){
		ArrayList<Instruction> instructions = new ArrayList<Instruction>();
		instructions.add(new Instruction(false, -(sideLength/2), -(sideLength/2)));
		instructions.addAll(new Line(new Coordinate(0,sideLength)).getInstructionSet());
		instructions.addAll(new Line(new Coordinate(sideLength,0)).getInstructionSet());
		instructions.addAll(new Line(new Coordinate(0,-sideLength)).getInstructionSet());
		instructions.addAll(new Line(new Coordinate(-sideLength,0)).getInstructionSet());
		instructions.add(new Instruction(false, 0,0));
		return null;
	}

}
