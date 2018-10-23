/**
 * 
 */
package ev3_bnj;

import lejos.hardware.port.MotorPort;

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
		Robot robot = new Robot(new StiftMotor(MotorPort.D), new Motor(MotorPort.A), new Motor(MotorPort.B), new TouchSensor(SensorPorts.S1), new LightSensor(SensorPorts.S2), new TouchSensor(SensorPorts.S4));
		
		while(true) 
		{

			robot.einzug();
			
		}
	}

}
