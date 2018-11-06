/**
 * 
 */
package plott3r_V1;

/**
 * @author NBJ
 *
 */
/**
 * @author student
 *
 */
public class Coordinate {

	private double xCoord;
	private double yCoord;

	/**
	 * @param xCoord the xPos
	 * @param yCoord the yPos
	 */
	public Coordinate(double xCoord, double yCoord) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	/**
	 * @param xCoord
	 * @param yCoord
	 */
	public void update(double xCoord, double yCoord) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Coordinate [xCoord=");
		builder.append(xCoord);
		builder.append(", yCoord=");
		builder.append(yCoord);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the xCoord
	 */
	public double getxCoord() {
		return xCoord;
	}

	/**
	 * @return the yCoord
	 */
	public double getyCoord() {
		return yCoord;
	}

	/**
	 * @param xCoord the xCoord to set
	 */
	public void setxCoord(double xCoord) {
		this.xCoord = xCoord;
	}

	/**
	 * @param yCoord the yCoord to set
	 */
	public void setyCoord(double yCoord) {
		this.yCoord = yCoord;
	}

}
