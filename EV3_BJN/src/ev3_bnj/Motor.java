/**
 * 
 */
package ev3_bnj;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;

/**
 * @author jean-
 *
 */
public class Motor extends EV3LargeRegulatedMotor{

	public Motor(Port port) {
		super(port);
	}	
}
