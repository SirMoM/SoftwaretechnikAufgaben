package plott3r_V1;

import geometrie.Linie;
import geometrie.Position2D;
import geometrie.Position3D;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;
import plott3r_V1.exception.Plott3rException;
import plott3r_V1.move.MoveStrategie;
import plott3r_V1.move.RotateStratgy;
import util.Plott3rLCD;

public class Roboter {
	public static void main(String args[]) {
		try {
			Roboter roboter = new Roboter();
			Sound.beep();
			roboter.moveToHomePosition();
			roboter.bereitePapierVor();

			Linie linie = new Linie(new Position2D(50, 50), 0, 40);
			roboter.zeichneGeometrischeFigur(linie, 20);

			Delay.msDelay(1000);
			roboter.entfernePapier();
			roboter.moveToHomePosition();
			Sound.twoBeeps();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Position3D currentPosition;

	private MoveStrategie moveStrategie = new RotateStratgy();

	private MultiPositionAchse xAchse = new MultiPositionAchse(new TouchSensor(SensorPort.S1), MotorPort.A, Einbaurichtung.UMGEKEHRT, new Reifen(40.0), new Zahnradsatz(new Zahnrad(Zahnrad.ANZAHL_ZAEHNE_MITTEL), new Zahnrad(Zahnrad.ANZAHL_ZAEHNE_MITTEL)));
	private MultiPositionAchse yAchse = new MultiPositionAchse(new LichtSensor(SensorPort.S3), MotorPort.B, Einbaurichtung.UMGEKEHRT, new Reifen(43.2), new Zahnradsatz(new Zahnrad(Zahnrad.ANZAHL_ZAEHNE_KLEIN), new Zahnrad(Zahnrad.ANZAHL_ZAEHNE_GROSS)));
	private DualPositionAchse zAchse = new DualPositionAchse(null, MotorPort.C, Einbaurichtung.REGULAER, null, null);

	public Roboter() throws InterruptedException {

	}

	public void alarm(Plott3rException e) {
		this.stop();
		Sound.buzz();
		zAchse.deaktiviere();
		Plott3rLCD.drawString(e.getMessage());
		Delay.msDelay(2000);
		System.exit(0);
	}

	private void bereitePapierVor() throws InterruptedException {
		Plott3rLCD.drawString("Blatt einlegen und PRESS");
		Button.waitForAnyPress();
		yAchse.setSpeed(1000);
		while (yAchse.isSensorAktiv()) {
			yAchse.forward();
		}
		yAchse.stop();
		yAchse.resetTachoCount();
		Plott3rLCD.drawString("PRESS Programmstarten");
		Button.waitForAnyPress();
	}

	private void entfernePapier() throws InterruptedException {
		zAchse.deaktiviere();
		yAchse.setSpeed(Integer.MAX_VALUE);
		yAchse.backward(2000);
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.exit(0);
	}

	public Position3D getCurrentPosition() {
		return this.currentPosition;
	}

	public MultiPositionAchse getXAchse() {
		return this.xAchse;
	}

	public MultiPositionAchse getYAchse() {
		return this.yAchse;
	}

	protected void moveToHomePosition() throws InterruptedException {
		zAchse.deaktiviere();
		xAchse.setSpeed(50);
		while (!xAchse.isSensorAktiv()) {
			xAchse.backward();
		}
		xAchse.stop();
		xAchse.forward();
		Delay.msDelay(200);
		xAchse.stop();
		this.currentPosition = new Position3D(0, 0, false);
		this.resetTachoCounts();
	}

	private void moveToPosition(Position2D position2D, int mmSec) throws InterruptedException {
	}

	private void moveToPosition(Position3D position, int mmSec) throws InterruptedException {

	}

	private void resetTachoCounts() {
		this.xAchse.resetTachoCount();
		this.yAchse.resetTachoCount();
		if (xAchse.getTachoCount() != 0 || yAchse.getTachoCount() != 0)
			throw new RuntimeException("Konnte Tachocount nicht zurücksetzen");
	}

	public void stop() {
		xAchse.stop();
		yAchse.stop();
		zAchse.stop();
	}

}
