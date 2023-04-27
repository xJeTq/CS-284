import java.util.NoSuchElementException;
import java.util.Scanner;

/*
	Name: Anthony Curcio-Petraccoro
	Pledge: I pledge my honor that I have abided by the Stevens Honor System. 
*/

public class TestTaskList<E> {
	
	private TaskList<E> toDoList;
	private Scanner scan;
		
	/*
	 * printMenu prints the interface the user interacts with. It prints all the pertinent information. 
	 */
	
	public void printMenu() {
		
		Scanner scan = new Scanner(System.in);
		toDoList = new TaskList<>();

		String ans = "";
		int in = 0;
		
		System.out.print("~~~ TO-DO List Program, created by truly yours ~~~\r\n"
				+ "");
		
		do {
			
			if (toDoList.getActive().getSize() == 0) {
				
				System.out.println("==> Currently there are NO items in the To-Do List");
				
			} else {
				
				System.out.println("Current TO-DO List:\n"
						+ "-------------------");
				toDoList.showActiveTasks();
				
			}
			
			System.out.println("To add a new task without priority information, press 1.\r\n"
					+ "To add a new task with a priority information, press 2.\r\n"
					+ "To cross off the task at the top of the list, press 3.\r\n"
					+ "To cross off a certain task in the list, press 4.\r\n"
					+ "To see the top 3 highest priority tasks, press 5.\r\n"
					+ "To see the completed tasks, press 6.\r\n"
					+ "To see the all tasks that has been completed or still active, press 7.\r\n"
					+ "To quit the program, press 8.");
						
			try {
				
				ans = scan.nextLine().strip();
				in = Integer.parseInt(ans);
				processMenuItem(in);
				
				if (in > 8 || in < 1) {
					
					System.out.println("ERROR! Please enter a number between 1 and 8 (included).");
					
				}
				
			} catch(IllegalArgumentException e) {
				
				System.out.println("ERROR! Please enter a number between 1 and 8 (included).");
				
			}
			
			// processMenuItem(in);

		
		} while(in != 8);
				
	} 
	
	/*
	 * processMenuItem redirects the program to the necessary operations based on what the user selected. 
	 */
	
	private boolean processMenuItem(int menuItem) {
		
		Scanner scan = new Scanner(System.in);
		

		if (menuItem == 1) {
						
			System.out.println("Please enter the task description:");			
			String one = scan.nextLine().strip();
			
			if (one.equals("")) {
				
				System.out.println("Unsuccessful operation! Please try again.");
				
				return false;
				
			}
			toDoList.createTask((E)one);
			System.out.println("Successfully entered the task to the to-do list!");
			
		} else if (menuItem == 2) {
			
			System.out.println("Please enter the task description:");
			
			String two = scan.nextLine().strip();
			
			if (two.equals("")) {
				
				System.out.println("Unsuccessful operation! Please try again.");
				
			} else {
				
				System.out.println("Please enter a priority number (1 indicates highest priority, increasing numbers show lower priority):/r");
				
				try {
					
					int twotwo = Integer.parseInt(scan.nextLine().strip());
					
					toDoList.createTask((E)two, twotwo);
					
				} catch (IllegalArgumentException e) {
					
					System.out.println("Error! Please enter a valid number.");
					
					return false;
					
				}
				
				System.out.println("Successfully entered the task to the to-do list!");
				
			}
									
		} else if (menuItem == 3) {
			
			try {
				
				toDoList.crossOffMostUrgent();
				
			} catch (NoSuchElementException e) {
				
				System.out.println("List is empty.");
				
			}
			
		} else if (menuItem == 4) {
			
			System.out.println("Please enter the task number you would like to cross off the list:"
					+ "");
			
			try {

				int three = Integer.parseInt(scan.nextLine().strip());
								
				if (three > toDoList.getActive().getSize()) {
					
					System.out.println("Unsuccessful operation! Please try again!");
					
				}
				else {
					
					toDoList.crossOffTask(three);
										
					System.out.println("Successfully removed the task number: " + three);
					
				}
				
			} catch(IllegalArgumentException e) {
				
				System.out.println("Error! Please enter a valid number.");
				
			}
			
			//toDoList.crossOffTasks(three);
			
		} else if (menuItem == 5) {
			
			// System.out.println("Top 3 highest priority tasks:\n"+ "------------------------------");
			
			try {
				
				toDoList.printTopThreeTasks();
				
			} catch (NoSuchElementException e) {
				
				System.out.println("Active list is empty.");
				
			}
			
		} else if (menuItem == 6) {
			
			System.out.println("Completed Tasks:\r\n"
					+ "----------------");
			
			toDoList.showCompletedTasks();
			
		} else if (menuItem == 7) {
			
			if (toDoList == null) {
				
				System.out.println("Empty list.");
				
				return false;
				
			} else {
				
				System.out.println("All of the Tasks - Both completed and active:\r\n"
						+ "---------------------------------------------");
				
				toDoList.showAllTasks();
				
				
			}
		
		}
		
		return true;
		
	}
	
	/*
	 * main allows the interface to run properly. 
	 */

	public static void main(String[] args) {
		
		TestTaskList obj = new TestTaskList<>();
		
		obj.printMenu();
		
	}

}
