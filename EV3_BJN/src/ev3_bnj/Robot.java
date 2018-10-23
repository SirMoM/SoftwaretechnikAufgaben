/**
 * 
 */
package ev3_bnj;

/**
 * @author jean-
 *
 */
public class Robot {
	
	private StiftMotor stiftMotor;
	private Motor xMotor;
	private Motor yMotor;
	
	/**
	 * @param stiftMotor
	 * @param xMotor
	 * @param yMotor
	 */
	public Robot(StiftMotor stiftMotor, Motor xMotor, Motor yMotor) {
		this.stiftMotor = stiftMotor;
		this.xMotor = xMotor;
		this.yMotor = yMotor;
	}

	public void toStart() 
	{
		
	}
	
}
