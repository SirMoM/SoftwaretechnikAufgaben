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

	public TouchSensor(SensorPorts port){
		this.setPort(port.getPort());
		this.sensor = new EV3TouchSensor(this.getPort());
		this.sampleProvider = this.sensor.getTouchMode();
	}

	public boolean getValue() throws Exception{
		float x = this.getRawValue()[0];
		if(x == 1.0){
			return true;
		} else if(this.getRawValue()[0] == 0.0){
			return false;
		} else{
			throw new Exception("No readable Touchsensor input!");
		}
	}

	@Override
	float[] getRawValue(){
		float[] sample = new float[this.sensor.sampleSize()];
		this.sampleProvider.fetchSample(sample, 0);
		return sample;
	}
}