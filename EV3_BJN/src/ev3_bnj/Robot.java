/**
 * 
 */
package ev3_bnj;

/**
 * @author jean-
 *
 */
public class Robot{

	private StiftMotor stiftMotor;
	private Motor xMotor;
	private Motor yMotor;

	private TouchSensor xStopper;

	private TouchSensor inputButton;

	private LightSensor lightSensor;

	/**
	 * @param stiftMotor
	 * @param xMotor
	 * @param yMotor
	 */
	public Robot(StiftMotor stiftMotor, Motor xMotor, Motor yMotor, TouchSensor xStopper, LightSensor lightSensor, TouchSensor InputButton){
		this.setStiftMotor(stiftMotor);
		this.xMotor = xMotor;
		this.yMotor = yMotor;
		this.xStopper = xStopper;
		this.inputButton = InputButton;
		this.lightSensor = lightSensor;

	}

	public void einzug(){
		try{
			while (this.inputButton.getValue()){
				this.yMotor.rotate(-36);
			}
		} catch (Exception e){
			e.printStackTrace();
		}

	}

	/**
	 * @return the inputButton
	 */
	public TouchSensor getInputButton(){
		return this.inputButton;
	}

	/**
	 * @return the lightSensor
	 */
	public LightSensor getLightSensor(){
		return this.lightSensor;
	}

	/**
	 * @return the stiftMotor
	 */
	public StiftMotor getStiftMotor(){
		return this.stiftMotor;
	}

	/**
	 * @return the xMotor
	 */
	public Motor getxMotor(){
		return this.xMotor;
	}

	/**
	 * @return the xStopper
	 */
	public TouchSensor getxStopper(){
		return this.xStopper;
	}

	/**
	 * @return the yMotor
	 */
	public Motor getyMotor(){
		return this.yMotor;
	}

	/**
	 * @param inputButton the inputButton to set
	 */
	public void setInputButton(TouchSensor inputButton){
		this.inputButton = inputButton;
	}

	/**
	 * @param lightSensor the lightSensor to set
	 */
	public void setLightSensor(LightSensor lightSensor){
		this.lightSensor = lightSensor;
	}

	/**
	 * @param stiftMotor the stiftMotor to set
	 */
	public void setStiftMotor(StiftMotor stiftMotor){
		this.stiftMotor = stiftMotor;
	}

	/**
	 * @param xMotor the xMotor to set
	 */
	public void setxMotor(Motor xMotor){
		this.xMotor = xMotor;
	}

	/**
	 * @param xStopper the xStopper to set
	 */
	public void setxStopper(TouchSensor xStopper){
		this.xStopper = xStopper;
	}

	/**
	 * @param yMotor the yMotor to set
	 */
	public void setyMotor(Motor yMotor){
		this.yMotor = yMotor;
	}

	public void toStart(){

	}

}
