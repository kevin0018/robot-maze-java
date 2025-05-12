/*
 * FinchMove.java        1.0 Feb 1, 2022
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

public class FinchMove extends FinchAction {

 public FinchMove(String action, Finch finch) {
  super(action, finch); 
  
  
 }
 //Kevin R
 public void execute() {
  
	String[] moveChange = action.split(" ");
	finch.setWheelVelocities(Integer.parseInt(moveChange[1]),
			Integer.parseInt(moveChange[2]), 
			Integer.parseInt(moveChange[0]));
	
 }
 
 @Override
 public String toString() {
  // TO DO
  return action;
 }
 

 
}











