/**
 * 
 */
package plott3r_V1;

/**
 * @author Noah Ruben, Benjamin Wiemann, JP Edoh
 *
 */
public class Instruction {

	private boolean isPenDown; 
	private double xVectorLen;
	private double yVectorLen;
	
	/**
	 * @param isPenDown
	 * @param xVectorLen
	 * @param yVectorLen
	 */
	public Instruction(boolean isPenDown, double xVectorLen, double yVectorLen) {
		super();
		this.isPenDown = isPenDown;
		this.xVectorLen = xVectorLen;
		this.yVectorLen = yVectorLen;
	}
	
	
	/**
	 * @return the isPenDown
	 */
	public boolean isPenDown() {
		return isPenDown;
	}

	/**
	 * @return the xVectorLen
	 */
	public double getxVectorLen() {
		return xVectorLen;
	}
	/**
	 * @return the yVectorLen
	 */
	public double getyVectorLen() {
		return yVectorLen;
	}
	/**
	 * @param isPenDown the isPenDown to set
	 */
	public void setPenDown(boolean isPenDown) {
		this.isPenDown = isPenDown;
	}
	/**
	 * @param xVectorLen the xVectorLen to set
	 */
	public void setxVectorLen(double xVectorLen) {
		this.xVectorLen = xVectorLen;
	}
	/**
	 * @param yVectorLen the yVectorLen to set
	 */
	public void setyVectorLen(double yVectorLen) {
		this.yVectorLen = yVectorLen;
	}

	
}
