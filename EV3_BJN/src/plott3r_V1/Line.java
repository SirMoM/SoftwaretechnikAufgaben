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

	final int xEnd;
	final int yEnd;
	
	public Line(int xEnd, int yEnd) {
		this.xEnd = xEnd;
	    this.yEnd = yEnd;
	}
	
	@Override
	public List<Instruction> getInstructionSet() {
		return new ArrayList<Instruction>(Arrays.asList(new Instruction[]{new Instruction(true, xEnd, yEnd)})) ;
	}
}
