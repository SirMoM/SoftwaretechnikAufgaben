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
	private double time;

	/**
	 * @param isPenDown
	 * @param xVectorLen
	 * @param yVectorLen
	 */
	public Instruction(boolean isPenDown, double xVectorLen, double yVectorLen, double mmSec) {
		this.isPenDown = isPenDown;
		this.xVectorLen = xVectorLen;
		this.yVectorLen = yVectorLen;
		this.time = mmSec;
	}

	/**
	 * @param isPenDown
	 * @param xVectorLen
	 * @param yVectorLen
	 */
	public Instruction(boolean isPenDown, double xVectorLen, double yVectorLen) {
		this(isPenDown, xVectorLen, yVectorLen, Math.sqrt(xVectorLen * xVectorLen + yVectorLen * yVectorLen) / 10);
	}

	public double getTime() {
		return time;
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
