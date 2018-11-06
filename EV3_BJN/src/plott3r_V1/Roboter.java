package plott3r_V1;

import java.util.ArrayList;
import java.util.List;

import lejos.hardware.Sound;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

public class Roboter {

	private final MultiPositionAchse xAchse = new MultiPositionAchse(new TouchSensor(SensorPort.S1), MotorPort.A, Einbaurichtung.UMGEKEHRT, new Reifen(40.0), new Zahnradsatz(new Zahnrad(Zahnrad.ANZAHL_ZAEHNE_MITTEL), new Zahnrad(Zahnrad.ANZAHL_ZAEHNE_MITTEL)));
	private final MultiPositionAchse yAchse = new MultiPositionAchse(new LichtSensor(SensorPort.S2), MotorPort.B, Einbaurichtung.UMGEKEHRT, new Reifen(43.2), new Zahnradsatz(new Zahnrad(Zahnrad.ANZAHL_ZAEHNE_KLEIN), new Zahnrad(Zahnrad.ANZAHL_ZAEHNE_GROSS)));
	private final DualPositionAchse zAchse = new DualPositionAchse(null, MotorPort.D, Einbaurichtung.REGULAER, null, null);

	private double xPos = 0;
	private double yPos = 0;

	private List<Instruction> instructionQ = new ArrayList<Instruction>();

	public Roboter() {
		Sound.buzz();
		System.out.println("NEW ROBOCOP");
	}

	public void alarm(Plott3rException plott3rException) {
		this.stop();
		Sound.buzz();
		zAchse.deaktiviere();
		// AUSGABE Exception
		Delay.msDelay(2000);
		System.exit(0);
	}

	public void goToStartPos() {
		goToXNull();
		goToYNull();
	}

	// TODO fertig
	public void goToXNull() {
		while (!xAchse.getSensor().isAktiv()) {
			xAchse.forward();
		}

		xAchse.rotateMm(-360);
		xAchse.stop();

	}

	// TODO fertig
	public void goToYNull() {
		while (yAchse.getSensor().isAktiv()) {
			yAchse.forward();
		}
		yAchse.stop();
	}

	// TODO fertig
	public void configure() {
		this.getXAchse().getMotor().synchronizeMotor(this.getYAchse().getMotor());
	}

	// TODO fertig
	public void wrapUp() throws Throwable {

		while (!yAchse.getSensor().isAktiv()) {
			yAchse.forward();
		}
		yAchse.stop();
		finalize();
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

	public void addToQ(Instruction instruction) {
		this.instructionQ.add(instruction);
	}

	private Instruction nextInstruction() {
		Instruction instruction = this.instructionQ.get(0);
		this.instructionQ.remove(0);
		return instruction;
	}

	private boolean hasNextInstruction() {
		return !this.instructionQ.isEmpty();
	}

	public void processInstructions() {
		instructionQ.add(new Instruction(false, 0, 0, 0));
		while (this.hasNextInstruction())
			this.processInstruction(this.nextInstruction());
	}

	private void processInstruction(Instruction instruction) {

		this.xAchse.getMotor().synchronizeMotor(this.getYAchse().getMotor());

		if (instruction.isPenDown()) {
			this.getZAchse().aktiviere();
		} else {
			this.getZAchse().deaktiviere();
		}

		this.getXAchse().getMotor().startSync();
		final int gradToTurnIntX = this.getXAchse().rotateMm(instruction.getxVectorLen());
		final int gradToTurnIntY = this.getYAchse().rotateMm(instruction.getyVectorLen());

		this.getXAchse().setSpeed((int) (gradToTurnIntX / instruction.getTime()));
		this.getYAchse().setSpeed((int) (gradToTurnIntY / instruction.getTime()));

		this.getXAchse().getMotor().endSync();
		this.getXAchse().waitComplete();
		this.getYAchse().waitComplete();

//			if(nextInstruction.getxVectorLen() != 0 && nextInstruction.getyVectorLen() != 0) {
//				
//				xAchse.setSpeed(defaultSpeed);
//				yAchse.setSpeed((int)((defaultSpeed * nextInstruction.getxVectorLen())/nextInstruction.getyVectorLen()));
//				
//				this.getXAchse().getMotor().startSync();
//				this.getXAchse().rotateMm(nextInstruction.getxVectorLen());
//				this.getYAchse().rotateMm(nextInstruction.getyVectorLen());
//				this.getXAchse().getMotor().endSync();
//				
//
//			}else if(nextInstruction.getxVectorLen() != 0) {
//				this.getXAchse().rotateMm(nextInstruction.getxVectorLen());
//
//			}else if(nextInstruction.getyVectorLen() != 0) {
//				this.getYAchse().rotateMm(nextInstruction.getyVectorLen());
//
//			}

	}

// private void moveToPosition(Position2D position2D, int mmSec) throws InterruptedException {

// private void moveToPosition(Position3D position, int mmSec) throws InterruptedException {

	public void stop() {
		xAchse.stop();
		yAchse.stop();
		zAchse.stop();
	}

	/**
	 * @return the zAchse
	 */
	public DualPositionAchse getZAchse() {
		return zAchse;
	}

	/**
	 * @return the xPos
	 */
	public double getxPos() {
		return xPos;
	}

	/**
	 * @return the yPos
	 */
	public double getyPos() {
		return yPos;
	}

	/**
	 * @param xPos the xPos to set
	 */
	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	/**
	 * @param yPos the yPos to set
	 */
	public void setyPos(double yPos) {
		this.yPos = yPos;
	}

}
