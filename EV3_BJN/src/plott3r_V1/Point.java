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
public class Point extends GeoFig {

	public Point() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see plott3r_V1.GeoFig#getInstructionSet()
	 */
	@Override
	public List<Instruction> getInstructionSet() {
		return new ArrayList<Instruction>(Arrays.asList(new Instruction[] { new Instruction(true, 0, 0) }));
	}

}
