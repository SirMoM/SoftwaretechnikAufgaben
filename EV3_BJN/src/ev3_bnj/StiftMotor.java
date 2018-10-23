/**
 * 
 */
package ev3_bnj;

import lejos.hardware.port.Port;

/**
 * @author jean-
 *
 */
public class StiftMotor extends Motor{

	public StiftMotor(Port port) {
		super(port);
	}
	
	public void toggleStift() {
		this.rotate(180);
	}
}
