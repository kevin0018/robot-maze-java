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
package part2;

import finchRobot.Finch;
import part1.FinchAction;
import part1.FinchMove;
import part1.FinchNose;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.sql.Statement;
import java.util.ArrayList;

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
  
  // Kevin h
  public void removeDataBaseTable() throws ClassNotFoundException{
	  System.out.println("Try to connect");
	  try {
		  String insertSQL;
		  String sentence;
		  ResultSet myResultSet;
		  Class.forName("org.postgresql.Driver");
		  String urlDB = "jdbc:postgresql://localhost:5432/";
			String user = "user2";
			String password = "user2";
			Connection connection = DriverManager.getConnection(urlDB,user, password);
			connection.setAutoCommit(true);
			System.out.println("Create Statement");
			Statement myStatement = connection.createStatement();
			System.out.println("Create SQL");
			
			String deleteSQL = "DROP DATABASE " + this.fileName;
			int result = myStatement.executeUpdate(deleteSQL);
			System.out.println("result: " + result);
			System.out.println("Delete");
	  } catch (SQLException e) {
		  System.out.println("Error connection!");
			
			e.printStackTrace();
	  } catch (ClassNotFoundException e) {
			e.printStackTrace();
	  }

  }
  // Kevin R
  public void importOrders(){
	  System.out.println("Try to connect");
	  try {
		  String insertSQL;
		  String sentence;
		  ResultSet myResultSet;
		  Class.forName("org.postgresql.Driver");
		  String urlDB = "jdbc:postgresql://localhost:5432/";
			String user = "user2";
			String password = "user2";
			Connection connection = DriverManager.getConnection(urlDB,user, password);
			connection.setAutoCommit(true);
			System.out.println("Create Statement");
			Statement myStatement = connection.createStatement();
			System.out.println("Create SQL");
			
			sentence = "SELECT * FROM " + this.fileName;
			myResultSet = myStatement.executeQuery(sentence);
			System.out.println("myResultSet: " + myResultSet);
			//Llegir el ResulSet
			while (myResultSet.next()) {
				if (!myResultSet.wasNull()) 
				System.out.println("id = "+ myResultSet.getInt("id") + " " + " name = " + myResultSet.getString("name"));
			}
			
			connection.close();
	  } catch (SQLException e) {
		  System.out.println("Error connection!");
		  e.printStackTrace();
	  } catch (ClassNotFoundException e) {
		  e.printStackTrace();
	  }
    
  }
  // Kevin R
  public void exportOrders(){
    
	  System.out.println("Try to connect");
	  try {
		  String insertSQL;
		  String sentence;
		  ResultSet myResultSet;
		  Class.forName("org.postgresql.Driver");
		  String urlDB = "jdbc:postgresql://localhost:5432/";
			String user = "user2";
			String password = "user2";
			Connection connection = DriverManager.getConnection(urlDB,user, password);
			connection.setAutoCommit(true);
			System.out.println("Create Statement");
			Statement myStatement = connection.createStatement();
			System.out.println("Create SQL");
			
			insertSQL ="INSERT INTO " + this.getFileName() + this.getActions();
			myStatement.executeUpdate(insertSQL);
			System.out.println("Insert");
			
			connection.close();
	  } catch (SQLException e) {
		  System.out.println("Error connection!");
		  e.printStackTrace();
	  } catch (ClassNotFoundException e) {
		  e.printStackTrace();
	  }
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
				  System.out.println(fn);
				  fn.execute();
				  
			  }  
	  }
  }

}
