/*
 * Maze.java        1.0 Feb 1, 2022
 *
 * Models the program.
 *
 * Copyright 2022 Rafel Botey Agusti <rbotey@escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
/*
package part2;

import java.util.Scanner;

import finchRobot.Finch;
import part1.FinchActionList;
import part1.FinchMove;
import part1.FinchNose;
import part1.FinchAction;

public class Maze {

// Kevin R
	  public static void main(String[] args) {
	        FinchActionList fal = new FinchActionList("example.db");
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            printMenu();
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline character

	            switch (choice) {
	                case 1:
	                    System.out.println("Enter action details:");
	                    String actionDetails = scanner.nextLine();
	                    FinchAction action = new FinchAction(actionDetails);
	                    fal.addAction(action);
	                    System.out.println("Action added successfully.");
	                    break;

	                case 2:
	                    System.out.println("Enter action index to remove:");
	                    int indexToRemove = scanner.nextInt();
	                    scanner.nextLine(); // Consume the newline character
	                    if (indexToRemove >= 0 && indexToRemove < fal.getActions().size()) {
	                        FinchAction actionToRemove = fal.getActions().get(indexToRemove);
	                        fal.removeAction(actionToRemove);
	                        System.out.println("Action removed successfully.");
	                    } else {
	                        System.out.println("Invalid action index.");
	                    }
	                    break;

	                case 3:
	                    try {
	                        fal.removeDataBaseTable();
	                        System.out.println("Database table removed successfully.");
	                    } catch (ClassNotFoundException e) {
	                        System.out.println("Error: " + e.getMessage());
	                    }
	                    break;

	                case 4:
	                    fal.importOrders();
	                    System.out.println("Orders imported successfully.");
	                    break;

	                case 5:
	                    fal.exportOrders();
	                    System.out.println("Orders exported successfully.");
	                    break;

	                case 6:
	                    fal.removeOrders();
	                    System.out.println("All orders removed successfully.");
	                    break;

	                case 7:
	                    System.out.println("Enter delay in seconds between actions:");
	                    String delay = scanner.nextLine();
	                    fal.execute(delay);
	                    System.out.println("All orders executed successfully.");
	                    break;

	                case 8:
	                    System.out.println("Enter order details:");
	                    String order = scanner.nextLine();
	                    fal.executeOrder(order);
	                    System.out.println("Order executed successfully.");
	                    break;

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }

	            System.out.println();
	        }
	    }

	    private static void printMenu() {
	        System.out.println("\n\nM E N U\n\n");
	        System.out.println("1. Add new action");
	        System.out.println("2. Remove an action");
	        System.out.println("3. Remove table in database");
	        System.out.println("4. Import Orders");
	        System.out.println("5. Export orders");
	        System.out.println("6. Remove all orders");
	        System.out.println("7. Execute all orders");
	        System.out.println("8. Execute an order");
	        System.out.println("Enter your choice:");
	    }
	}
	*/
