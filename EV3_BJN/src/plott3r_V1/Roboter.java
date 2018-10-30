package plott3r_V1;

import java.util.ArrayList;
import java.util.List;

import lejos.hardware.Sound;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

public class Roboter {

	private final MultiPositionAchse xAchse = new MultiPositionAchse(new TouchSensor(SensorPort.S1), MotorPort.A, Einbaurichtung.UMGEKEHRT, new Reifen(40.0), new Zahnradsatz(new Zahnrad(Zahnrad.ANZAHL_ZAEHNE_MITTEL), new Zahnrad(Zahnrad.ANZAHL_ZAEHNE_MITTEL)));
	private final MultiPositionAchse yAchse = new MultiPositionAchse(new LichtSensor(SensorPort.S3), MotorPort.B, Einbaurichtung.UMGEKEHRT, new Reifen(43.2), new Zahnradsatz(new Zahnrad(Zahnrad.ANZAHL_ZAEHNE_KLEIN), new Zahnrad(Zahnrad.ANZAHL_ZAEHNE_GROSS)));
	private final DualPositionAchse zAchse = new DualPositionAchse(null, MotorPort.C, Einbaurichtung.REGULAER, null, null);

	private double  xPos;
	private double  yPos;
	
	private List<Instruction> instructionQ = new ArrayList<Instruction>();
	
	public Roboter() throws InterruptedException {

	}

	public void alarm(Plott3rException plott3rException) {
		this.stop();
		Sound.buzz();
		zAchse.deaktiviere();
		// AUSGABE  Exception
		Delay.msDelay(2000);
		System.exit(0);
	}

	// TODO goTOSart
	public void goToStartPos() {
		
	}

	//TODO fertig
	public void goToXNull() {
		
	}

	//TODO fertig
	public void goToYNull() {
		
	}
	
	//TODO fertig
	public void wrapUp() throws Throwable {
		yAchse.backward();
		while(yAchse.isSensorAktiv()) {
			
		}
		yAchse.stop();
		finalize();
	}
	
	//TODO fertig
	private void configure() {
		
	}
	
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.exit(0);
	}

	public MultiPositionAchse getXAchse() {
		return this.xAchse;
	}

	public MultiPositionAchse getYAchse() {
		return this.yAchse;
	}

// TODO 	private void moveToPosition(Position2D position2D, int mmSec) throws InterruptedException {

//TODO	private void moveToPosition(Position3D position, int mmSec) throws InterruptedException {

	public void stop() {
		xAchse.stop();
		yAchse.stop();
		zAchse.stop();
	}

	public double getxPos() {
		return xPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

}
