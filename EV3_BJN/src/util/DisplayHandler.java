/**
 * 
 */
package util;

import lejos.hardware.lcd.LCD;

/**
 * @author Noah Ruben
 * @see <a href="https://github.com/SirMoM/SoftwaretechnikAufgaben">Github</a>
 */
public class DisplayHandler{

	// TODO would be nice to show what is drawn ?
	public static void drawLineSymbol(){

	}

	public static void drawProgressbar(int countOfInstructionsToProzess){
		for(int i = 5; i < countOfInstructionsToProzess * 6; i += 6){
			drawBlock(i, 50);
		}
	}

	public static int writeCurrentCoordinate(Coordinate coordinate){
		LCD.clear(2);
		String drawCurrentCoordinateString = String.format("Pos: (%f, %f)", coordinate.getxCoord(), coordinate.getxCoord());
		LCD.drawString(drawCurrentCoordinateString, 0, 20);
		return drawCurrentCoordinateString.length();
	}

	/**
	 * @param xPos the current x-Position of the Robot
	 * @param yPos the current y-Position of the Robot
	 * @return the length of the string to display.
	 */
	public static int writeCurrentCoordinate(int xPos, int yPos){
		LCD.clear(2);
		String drawCurrentCoordinateString = String.format("Pos: (%d, %d)", xPos, yPos);
		LCD.drawString(drawCurrentCoordinateString, 0, 20);
		return drawCurrentCoordinateString.length();
	}

	/**
	 * This overrides the first line of the display.
	 * 
	 * @param whatToWrite the string to write every char that exceeds the limit of
	 *                    17 will be cut off
	 */
	public static void writeFirstLine(String whatToWrite){
		LCD.clear(0);
		if(whatToWrite.length() <= LCD.DISPLAY_CHAR_WIDTH){
			LCD.drawString(whatToWrite, 0, 0);
		} else{
			LCD.drawString(whatToWrite.substring(0, 16), 0, 0);
		}
	}

	private static void drawBlock(int xPosDisplay, int yPosDisplay){
		for(int x = xPosDisplay; x < xPosDisplay + 5; x++){
			for(int y = yPosDisplay; y < yPosDisplay + 5; y++){
				LCD.setPixel(x, y, 1);
			}
		}
	}

}
