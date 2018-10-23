/**
 * 
 */
package ev3_bnj;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.BaseSensor;

import lejos.robotics.SampleProvider;

/**
 * @author jean-
 *
 */
public abstract class Sensor {
	Port port;
	SampleProvider sampleProvider;

	
	abstract float[] getRawValue();


	/**
	 * @return the port
	 */
	public Port getPort() {
		return port;
	}


	/**
	 * @param port the port to set
	 */
	public void setPort(Port port) {
		this.port = port;
	}
	
	
}
