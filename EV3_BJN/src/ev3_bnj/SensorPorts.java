/**
 * 
 */
package ev3_bnj;


import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.port.Port;

/**
 * @author jean-
 *
 */
public enum SensorPorts {
	S1(LocalEV3.get().getPort("S1")),
	S2(LocalEV3.get().getPort("S2")),
	S3(LocalEV3.get().getPort("S3")),
	S4(LocalEV3.get().getPort("S4"));
	
	
	private Port port;
	
	SensorPorts(Port port) {
		this.port = port;
		
	}

	/**
	 * @return the port
	 */
	public Port getPort() {
		return port;
	}
}
