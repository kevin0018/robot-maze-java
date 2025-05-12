/*
 * FinchNose.java        1.0 Feb 1, 2022
 *
 * Models the program.
 *
 * Copyright 2022 Rafel Botey Agusti <rbotey@escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

package part1;
import finchRobot.Finch;

public class FinchNose extends FinchAction {
 
 public FinchNose(String action, Finch finch) {
  super(action, finch);
 }
 
 //Kevin h
 public void execute() {
	String[] colorChange = action.split(" ");
	finch.setLED(Integer.parseInt(colorChange [0]),
			Integer.parseInt(colorChange [1]),
			Integer.parseInt(colorChange [2]));
 }
 
 @Override
 public String toString() {
  return action;
 }

}
