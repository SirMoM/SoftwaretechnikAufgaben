/**
 * 
 */
package ev3_bnj;

import lejos.hardware.sensor.EV3TouchSensor;

/**
 * @author jean-
 *
 */
public class TouchSensor extends Sensor{

	private EV3TouchSensor sensor;


	public TouchSensor(SensorPorts port) {
		// TODO Auto-generated constructor stub
		this.setPort(port.getPort());
		sensor = new EV3TouchSensor(this.getPort());
		sampleProvider = sensor.getTouchMode();
	}
	
	float[] getRawValue() {
		float[] sample = new float[sensor.sampleSize()];
		sampleProvider.fetchSample(sample, 0);
		return sample;
	}
	
	
	public boolean getValue() throws Exception{ 
		float x = getRawValue()[0];
		if(x == 1.0) {
			return true;
		}else if(getRawValue()[0] == 0.0) {
			return false;
		}else {
			throw new Exception("No readable Touchsensor input!");
		}
	}
}