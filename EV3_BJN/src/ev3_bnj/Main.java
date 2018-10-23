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
public class Main {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TouchSensor ts = new TouchSensor(SensorPorts.S1);
		LightSensor lightSensor = new LightSensor(SensorPorts.S2);
		while(true) 
		{
			try {
				System.out.println("Button pressed: " + ts.getValue());
				System.out.println("Light Value: " + lightSensor.getValue());
				Thread.sleep(1500);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
