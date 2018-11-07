/**
 * 
 */
package plott3r_V1.figures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import plott3r_V1.Instruction;

/**
 * @author Noah Ruben, Benjamin Wiemann, J-P Edoh
 * @see <a href="https://github.com/SirMoM/SoftwaretechnikAufgaben">Github</a>
 */
public class Point extends GeoFig{

	public Point(){
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see plott3r_V1.GeoFig#getInstructionSet()
	 */
	@Override
	public List<Instruction> getInstructionSet(){
		return new ArrayList<Instruction>(Arrays.asList(new Instruction[] { new Instruction(true, 0, 0) }));
	}

}
