package ev3_bnj;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.SampleProvider;

/**
 * 
 */

/**
 * @author Benjamin, Jean-Paul, Noah oder Ruben
 *
 */
public class Main{
	private static final double radDruchmesser = 43.2;

	private static final double radUmfang = radDruchmesser * Math.PI;

	private static final double distance = (3 * 360 * 10) / radUmfang;

	private static final double beltDruchmesser = 34;

	private static final double beltUmfang = beltDruchmesser * Math.PI;

	private static final double speedRad = distance;

	private static final double blattLaenge = 297.0;

	static RegulatedMotor regulatedMotorA = new EV3LargeRegulatedMotor(MotorPort.D);
	static RegulatedMotor regulatedMotorX = new EV3LargeRegulatedMotor(MotorPort.A);
	static RegulatedMotor regulatedMotorY = new EV3LargeRegulatedMotor(MotorPort.B);
	static LCD lcd;

	/**
	 * AUFGABE 1
	 */
	public static void aufg1(){
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

	/**
	 * @param args
	 */
	public static void main(String[] args){
		lcd.drawString("STARTING...", 1, 2);
		start();
		toggleStift();
		toggleStift();

	}

	/**
	 * AUFGABE 6
	 * 
	 * @param mmSek
	 * @param xPos
	 * @param yPos
	 */
	public static void move(int mmSek, int xPos, int yPos){
		double hypoLenght = Math.sqrt(Math.pow(xPos, 2) + Math.pow(yPos, 2));

		double distanceRad = (3 * 360 * yPos) / radUmfang;
		double distanceBelt = (360 * xPos) / beltUmfang;

		regulatedMotorY.setSpeed((int) distanceRad);
		regulatedMotorX.setSpeed((int) distanceBelt);

		if(xPos > 0){
			regulatedMotorX.forward();
		} else{
			regulatedMotorX.backward();
		}

		if(yPos > 0){
			regulatedMotorY.forward();
		} else{
			regulatedMotorY.backward();
		}

		try{
			Thread.sleep(mmSek);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		regulatedMotorX.stop();
		regulatedMotorY.stop();
	}

	/**
	 * AUFGABE 5
	 * 
	 * @param mmSek
	 * @param motor1
	 * @param motor2
	 * @throws InterruptedException
	 */
	public static void move(int mmSek, RegulatedMotor motor1, RegulatedMotor motor2) throws InterruptedException{
		motor1.backward();
		motor2.backward();
		Thread.sleep(mmSek);
		motor1.stop();
		motor2.stop();
	}

	public static void start(){
		yNull();
		xNull();
	}

	public static void xNull(){
		// check touchsensor
		Port port = LocalEV3.get().getPort("S1");
		EV3TouchSensor sensor = new EV3TouchSensor(port);
		SampleProvider touch = sensor.getTouchMode();
		float[] sample = new float[touch.sampleSize()];
		touch.fetchSample(sample, 0);

		// regulatedMotorB.rotate(-400);

		while (sample[0] == 0){
			// regulatedMotorB.rotate(12);
			regulatedMotorX.backward();
			touch.fetchSample(sample, 0);
		}

		regulatedMotorX.stop();

		regulatedMotorX.rotate(36);
	}

	public static void yNull(){
		// check light
		Port port = LocalEV3.get().getPort("S2");
		EV3ColorSensor sensor = new EV3ColorSensor(port);
		SampleProvider light = sensor.getAmbientMode();
		float[] sample = new float[light.sampleSize()];
		light.fetchSample(sample, 0);

		// regulatedMotorB.rotate(-400);

		while (sample[0] >= 0.18){
			// regulatedMotorB.rotate(12);
			regulatedMotorY.backward();
			light.fetchSample(sample, 0);
		}

		regulatedMotorY.stop();

	}

	private static void toggleStift(){
		regulatedMotorA.rotate(180);
	}

}
