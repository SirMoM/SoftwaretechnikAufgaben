/**
 * 
 */
package ev3_bnj;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;

/**
 * @author jean-
 *
 */
public class LightSensor extends Sensor {
	
	private EV3ColorSensor sensor;
	private float pivotPoint = 0.18f;

	/* (non-Javadoc)
	 * @see ev3_bnj.Sensor#getRawValue()
	 */
	
	public LightSensor(SensorPorts port) {
		this.port = port.getPort();
		sensor = new EV3ColorSensor(this.port);
		sampleProvider = sensor.getAmbientMode();
	}
	
	@Override
	float[] getRawValue() {
		float[] sample = new float[sensor.sampleSize()];
		sampleProvider.fetchSample(sample, 0);
		return sample;
	}
	
	public float getValue() 
	{
		return getRawValue()[0];
	}
	
	public boolean isCovered() 
	{
		if(getValue() >= getPivotPoint()) 
		{
			return false;
		}
		else 
		{
			return true;
		}
	}

	public float getPivotPoint() {
		return pivotPoint;
	}

	public void setPivotPoint(float pivotPoint) {
		this.pivotPoint = pivotPoint;
	}

}
