import org.jfree.chart.renderer.xy.SamplingXYLineRenderer;

import lejos.ev3.tools.LCDDisplay;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.hardware.sensor.SensorModes;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.SampleProvider;
/**
 * 
 */

/**
 * @author jean-
 *
 */
public class Main {
	private static final double radDruchmesser = 43.2;
	
	private static final double radUmfang = radDruchmesser * Math.PI;
	
	private static final double distance = (3*360* 10) / radUmfang;
	
	private static final double speed = distance; 
	
	private static final double blattLaenge = 297.0;

	static RegulatedMotor regulatedMotorA = new EV3LargeRegulatedMotor(MotorPort.A);
	static RegulatedMotor regulatedMotorB = new EV3LargeRegulatedMotor(MotorPort.B);
	static RegulatedMotor regulatedMotorC = new EV3LargeRegulatedMotor(MotorPort.C);
	static LCD lcd;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("TEST1");



		lcd.drawString("STARTING...", 1, 2);
		
//		start();
		toggleStift();
		System.out.println("Speed: " + speed);
		regulatedMotorC.setSpeed((int) speed);
		
		try {
			long x = System.currentTimeMillis()/1000;
			move(10000, regulatedMotorC);
			System.out.println("After: " + (x - (System.currentTimeMillis()/1000)));
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		toggleStift();
	}

	private static void toggleStift() {
		// TODO Auto-generated method stub
		regulatedMotorA.rotate(180);
	}

	public static void aufg1() {
		regulatedMotorA.rotate(180);
		regulatedMotorB.rotate(200);
		regulatedMotorC.rotate(300);

		regulatedMotorA.rotate(-180);
		regulatedMotorB.rotate(-200);
		regulatedMotorC.rotate(-300);

		regulatedMotorC.rotate(12);
		regulatedMotorC.rotate(12);
		regulatedMotorC.rotate(12);
		regulatedMotorC.rotate(12);
		regulatedMotorC.rotate(12);
		regulatedMotorC.rotate(12);
		regulatedMotorC.rotate(12);
	}

	public static void yNull() 
	{
		//check touchsensor
		Port port = LocalEV3.get().getPort("S3");
		EV3TouchSensor sensor = new EV3TouchSensor(port);
		SampleProvider touch= sensor.getTouchMode();
		float[] sample = new float[touch.sampleSize()];
		touch.fetchSample(sample, 0);

		//regulatedMotorB.rotate(-400);

		while(sample[0] == 0) 
		{
			//regulatedMotorB.rotate(12);
			regulatedMotorB.forward();
			touch.fetchSample(sample, 0);
		}

		regulatedMotorB.stop();


		regulatedMotorB.rotate(12);
	}

	public static void xNull() 
	{
		//check touchsensor
		Port port = LocalEV3.get().getPort("S2");
		EV3ColorSensor sensor = new EV3ColorSensor(port);
		SampleProvider light= sensor.getAmbientMode();
		float[] sample = new float[light.sampleSize()];
		light.fetchSample(sample, 0);

		//regulatedMotorB.rotate(-400);

		while(sample[0] <= 0.18) 
		{
			//regulatedMotorB.rotate(12);
			regulatedMotorC.forward();
			light.fetchSample(sample, 0);
		}

		regulatedMotorC.stop();

	}

	public static void start() 
	{
		yNull();
		xNull();
	}

	public static void move(int mmSek, RegulatedMotor motor) throws InterruptedException {
		motor.backward();
		Thread.sleep(mmSek);
		motor.stop();
	}

}