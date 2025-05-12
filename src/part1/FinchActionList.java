/*
 * FinchActionList.java        1.0 Feb 1, 2022
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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FinchActionList {
 
  private final String fileName;
  private ArrayList<FinchAction> actions;
  private final Finch finch;
  
  //Kevin h
  public FinchActionList(String fileName) {
    this.fileName = fileName;
    this.actions = new ArrayList<FinchAction>();
    this.finch = new Finch();
  }
  
  public ArrayList<FinchAction> getActions() {
    return actions;
  }
  
  public Finch getFinch() {
    return finch;
  }
  //Kevin h
  public void setActions(ArrayList<FinchAction> actions) {
    this.actions = actions;
  }
  
  public String getFileName() {
    return fileName;
  }
  //Kevin h
  public void addAction(FinchAction finchAction) {
	  this.actions.add(finchAction);
  }
  //Kevin h
  public void removeAction(FinchAction finchAction){
    this.actions.remove(finchAction);
  }
  //Kevin h
  public void removeFile(){
    final File file = new File(this.fileName);
    file.delete();
  }
  //Kevin h
  public void importOrders(){
	  Reader fr = new Reader(this.getFileName());
	  String lf = fr.readLine();
	  while (lf != null) {
		  String[] move = lf.split(" ", 2);
		  if (move[0].equals("MOVE")) {
			FinchMove fm = new FinchMove(move[1], this.finch);
			this.addAction(fm);
			System.out.println("Move importado");
		  } else if (move[0].equals("NOSE")) {
			  FinchNose fn = new FinchNose(move[1], this.finch);
			  this.addAction(fn);
			  System.out.println("Nose importado");
		  }
		  lf = fr.readLine();
	  }
	  System.out.println("Ordenes importadas con exito");
	  fr.close();
  }
  //Kevin h
  public void exportOrders(){
    Writer wr = new Writer(this.fileName);
    for (FinchAction fa : this.actions) {
    	wr.println(fa.getAction());
    }
    wr.close();
  }
  //Kevin h
  public void displayOrders(){
	  for (FinchAction fA : this.actions) {
		  System.out.println(fA.getAction());
	  }
  }
  //Kevin h
  public void removeOrders(){
    this.actions.clear();
  }
  //Kevin h
  public void execute(String seconds) {
    for (FinchAction fa : this.actions) {
    	fa.execute();
    	this.finch.sleep(Integer.parseInt(seconds));
    }
  }
  //Kevin h
  public void executeOrder(String order) {
	  String[] move = order.split(" ");
	  String moveS = "";
	  for (int i = 0; i < move.length; i++) {
		  if (move[i].equals("MOVE")) {
			  	moveS = move[i+1] + " " + move[i+2] + " " + move[i+3];
			  	System.out.println(moveS);
				FinchMove fm = new FinchMove(moveS, this.finch);
				fm.execute();
			  } else if (move[i].equals("NOSE")) {
				  moveS = move[i+1] + " " + move[i+2] + " " + move[i+3];
				  FinchNose fn = new FinchNose(moveS, this.finch);
				  System.out.println(moveS);
				  fn.execute();
				  
			  }  
	  }
  }

}
