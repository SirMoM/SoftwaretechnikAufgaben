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
public class Line extends GeoFig{

	private Coordinate endPoint = null;
	private double degree = 0.0d;
	private double lenght = 0.0d;

	public Line(Coordinate ende){
		this.endPoint = ende;
	}

	public Line(Coordinate mitte, Coordinate currentCoord, double lenght, double degree){
		super(mitte, currentCoord);
		this.lenght = lenght;
		this.degree = degree;
	}

	@Override
	public List<Instruction> getInstructionSet(){
		ArrayList<Instruction> instructions = new ArrayList<Instruction>();
		if(this.endPoint == null){
			double gegenkathete;
			double ankathete;
			double hypotenuse = this.lenght;

			gegenkathete = Math.sin(this.degree) * hypotenuse;
			ankathete = Math.cos(this.degree) * hypotenuse;

			double moveToBeginXCoord = this.getCurrentCoord().getxCoord() - (this.getMittelpunkt().getxCoord() + ankathete);
			double moveToBeginYCoord = this.getCurrentCoord().getyCoord() - (this.getMittelpunkt().getyCoord() + hypotenuse);

			instructions.add(new Instruction(false, moveToBeginXCoord, moveToBeginYCoord));

			double moveToEndXCoord = this.getCurrentCoord().getxCoord() - (this.getMittelpunkt().getxCoord() - ankathete);
			double moveToEndYCoord = this.getCurrentCoord().getyCoord() - (this.getMittelpunkt().getyCoord() - hypotenuse);

			instructions.add(new Instruction(false, moveToEndXCoord, moveToEndYCoord));
		} else{
			instructions.add(new Instruction(true, this.endPoint.getxCoord(), this.endPoint.getyCoord()));
		}
		return instructions;
	}
}
