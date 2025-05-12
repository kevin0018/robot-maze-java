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

package part1;

import finchRobot.Finch;
import java.util.Scanner;

public class Maze {

	// Kevin R
 public static void main(String[] args) {
	 Scanner s = new Scanner(System.in);
	 String ordre = " ";
	 String tipo = " ";
	 FinchActionList fal = new FinchActionList("src/part1/part1.txt");
	 int action = 0;
	 while (action != 10) {
	 System.out.println("\n\nM E N U\n\n");
	 System.out.println("1.Execute an order\n");
	 System.out.println("2.Import orders\n");
	 System.out.println("3.Export oders\n");
	 System.out.println("4.Add new action\n");
	 System.out.println("5.Remove action\n");
	 System.out.println("6.Execute all orders\n");
	 System.out.println("7.Remove file with orders\n");
	 System.out.println("8.View all orders\n");
	 System.out.println("9.Remove all orders\n");
	 System.out.println("10.Exit\n");
	 System.out.println("What do you want?\n");
	 action = s.nextInt();
	 s.nextLine();
	 switch(action) {
	 	case 1:
	 		//Kevin H
	 		System.out.println("Ordre a executar separat per \\n");
	 		ordre = s.nextLine();
	 		// "MOVE 200 100 100 \n MOVE 500 200 200 \n NOSE 0 0 255 \n MOVE 2000 100 200 \n MOVE 200 200 100 \n NOSE 0 255 0"
	 		fal.executeOrder(ordre);
	 		break;
	 	case 2:
	 		//Kevin R
	 		fal.importOrders();
	 		break;
	 	case 3:
	 		//Kevin R
	 		fal.exportOrders();
	 	case 4:
	 		//Kevin H
	 		System.out.println("Tipo de orden");
	 		tipo = s.nextLine();
	 		if (tipo.toUpperCase().equals("MOVE")) {
	 			System.out.println("Ordre a importar");
		 		ordre = s.nextLine();
		 		FinchMove fm = new FinchMove(ordre, fal.getFinch());
		 		fal.addAction(fm);
	 		} else if (tipo.toUpperCase().equals("NOSE")) {
	 			System.out.println("Ordre a importar");
		 		ordre = s.nextLine();
		 		FinchNose fn = new FinchNose(ordre, fal.getFinch());
		 		fal.addAction(fn);
	 		} else {
	 			System.out.println("Tipo no valido");
	 		}
	 		break;
	 	case 5:
	 		//Kevin H
	 		System.out.println("Tipo de orden");
	 		tipo = s.nextLine();
	 		if (tipo.toUpperCase().equals("MOVE")) {
	 			System.out.println("Ordre a remover");
		 		ordre = s.nextLine();
		 		FinchMove fm = new FinchMove(ordre, fal.getFinch());
		 		fal.removeAction(fm);
	 		} else if (tipo.toUpperCase().equals("NOSE")) {
	 			System.out.println("Ordre a remover");
		 		ordre = s.nextLine();
		 		FinchNose fn = new FinchNose(ordre, fal.getFinch());
		 		fal.removeAction(fn);
	 		} else {
	 			System.out.println("Tipo no valido");
	 		}
	 		break;
	 	case 6:
	 		//Kevin R
	 		System.out.println("Segundos entre orden");
	 		ordre = s.nextLine();
	 		fal.execute(ordre);
	 		break;
	 	case 7:
	 		//Kevin R
	 		fal.removeFile();
	 		break;
	 	case 8:
	 		//Kevin R
	 		fal.displayOrders();
	 		break;
	 	case 9:
	 		//Kevin R
	 		fal.removeOrders();
	 		break;
	 	default:
	 		//Kevin R
	 		System.out.println("Numero no valido");
	 		
	 	}
	 }
 }
}
