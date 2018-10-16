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

	private static final double beltDruchmesser = 34;

	private static final double beltUmfang = beltDruchmesser * Math.PI;

	private static final double speedRad = distance;

	private static final double blattLaenge = 297.0;

	static RegulatedMotor regulatedMotorA = new EV3LargeRegulatedMotor(MotorPort.A);
	static RegulatedMotor regulatedMotorX = new EV3LargeRegulatedMotor(MotorPort.B);
	static RegulatedMotor regulatedMotorY = new EV3LargeRegulatedMotor(MotorPort.C);
	static LCD lcd;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("TEST1");



		lcd.drawString("STARTING...", 1, 2);

		start();
//		regulatedMotorY.rotate(-360);
		
		toggleStift();
//		regulatedMotorX.setSpeed(24);
//		regulatedMotorX.rotate(-180);
		move(10000, -10, 0);
		
//		System.out.println("Speed: " + speedRad);
//		regulatedMotorC.setSpeed((int) speedRad);
//		regulatedMotorB.setSpeed(50);
//
//		try {
//			long x = System.currentTimeMillis()/1000;
//			move(10000, regulatedMotorC, regulatedMotorB);
//			System.out.println("After: " + (x - (System.currentTimeMillis()/1000)));
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		toggleStift();
	}

	private static void toggleStift() {
		// TODO Auto-generated method stub
		regulatedMotorA.rotate(180);
	}

	public static void aufg1() {
		regulatedMotorA.rotate(180);
		regulatedMotorX.rotate(200);
		regulatedMotorY.rotate(300);

		regulatedMotorA.rotate(-180);
		regulatedMotorX.rotate(-200);
		regulatedMotorY.rotate(-300);

		regulatedMotorY.rotate(12);
		regulatedMotorY.rotate(12);
		regulatedMotorY.rotate(12);
		regulatedMotorY.rotate(12);
		regulatedMotorY.rotate(12);
		regulatedMotorY.rotate(12);
		regulatedMotorY.rotate(12);
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
			regulatedMotorX.forward();
			touch.fetchSample(sample, 0);
		}

		regulatedMotorX.stop();


		regulatedMotorX.rotate(12);
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
			regulatedMotorY.forward();
			light.fetchSample(sample, 0);
		}

		regulatedMotorY.stop();

	}

	public static void start() 
	{
		yNull();
		xNull();
	}

	public static void move(int mmSek, RegulatedMotor motor1, RegulatedMotor motor2) throws InterruptedException {
		motor1.backward();
		motor2.backward();
		Thread.sleep(mmSek);
		motor1.stop();
		motor2.stop();
	}

	public static void move(int mmSek, int xPos, int yPos) {
		double hypoLenght = Math.sqrt(Math.pow(xPos, 2) + Math.pow(yPos,2));

		double distanceRad = (3*360* yPos) / radUmfang;
		double distanceBelt = (360* xPos) /  beltUmfang;

		regulatedMotorY.setSpeed((int) distanceRad);
		regulatedMotorX.setSpeed((int) distanceBelt);

		if (xPos > 0) {
			regulatedMotorX.forward();	
		}else {
			regulatedMotorX.backward();
		}
		
		if (yPos > 0) {
			regulatedMotorY.forward();	
		}else {
			regulatedMotorY.backward();
		}
		
		try {
			Thread.sleep(mmSek);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		regulatedMotorX.stop();
		regulatedMotorY.stop();
	}

}
