import java.util.Iterator;

/*
	Name: Anthony Curcio-Petraccoro
	Pledge: I pledge my honor that I have abided by the Stevens Honor System. 
*/

public class TaskList<E> {

	private ListQueue<E> all;
	private ListQueue<E> active;
	private ListQueue<E> completed;
	private int LOW_PRIORITY = Integer.MAX_VALUE;
	private int HIGH_PRIORITY = 1;
	
	/*
	 * TaskList contructs the ListQueue and initializes all the attributes. 
	 */
	
	public TaskList() {
		
		this.all = new ListQueue<E>();
		this.completed = new ListQueue<E>();
		this.active = new ListQueue<E>();
		this.LOW_PRIORITY = Integer.MAX_VALUE;
		this.HIGH_PRIORITY = 1;
		
	}
	
	/*
	 * createTask adds the given data into the active and all list queues with default low priority. 
	 */
	
	public boolean createTask(E item) {
		
		// Node itemNode = new Node(item);
		
		if (item == null) {
			
			return false;
			
		}
		
		/* if (all.getFront() == null) {
			
			all.setFront();
			active.setFront();
			
		} */
		
		all.addRear(item);
		active.addRear(item);
		
		return true;
		
	}
	
	/*
	 * createTask adds given data into the active and all list queues based on given priority. 
	 */
	
	public boolean createTask(E item, int priority) {
		
		if (item == null) {
			
			return false;
			
		}
		
		all.offer(item, priority);
		active.offer(item, priority);
		
		return true;
		
	}
	
	/*
	 * getAll returns the all list queue. 
	 */
	
	public ListQueue<E> getAll() {
		
		return this.all;
		
	}
	
	/*
	 * getCompleted returns the completed list queue, which is a list of all the completed tasks. 
	 */
	
	public ListQueue<E> getCompleted() {
		
		return this.completed;
		
	}
	
	/*
	 * getActive returns the active list queue. 
	 */
	
	public ListQueue<E> getActive() {
		
		return this.active;
		
	}
	
	/*
	 * printTopThreeTasks prints the top three active tasks within the active list queue. 
	 */
	
	public void printTopThreeTasks() {
				
		if (active == null) {
			
			System.out.println("There are no active tasks.");
			
		}
		
		System.out.println("Top 3 highest priority tasks:\n------------------------------\nPrinting Top 3 Tasks...");
		
		Iterator<E> iterator = active.iterator();
		int counter = 1;
		
		while (iterator.hasNext() == true && counter < 4) {
			
			System.out.println(counter + ". " + iterator.next());
			counter ++;
			
		}
		
	}
	
	/*
	 * showActiveTasks prints all the active tasks within the active list queue.  
	 */
	
	public void showActiveTasks() {
		
		printTasks(active);
		
	}
	
	/*
	 * showCompletedTasks prints all the completed tasks within the completed list queue.  
	 */
	
	public void showCompletedTasks() {
		
		printTasks(completed);
		
	}
	
	/*
	 * showAllTasks prints all the tasks within the all list queue.  
	 */
	
	public void showAllTasks() {
		
		printTasks(all);
		
	}
	
	/*
	 * printTasks allows for the all nodes within each list queue to be printed. Each node is iterator through and printed to the console. 
	 */
	
	private void printTasks(ListQueue<E> queue) {
		
		Iterator<E> iter = queue.iterator();
		
		for(int i = 1; i < queue.getSize() + 1; i ++) {
			
			if(!iter.hasNext()) {
				
				break;
				
			}
			
			System.out.println(i + ". " + iter.next());
		
		}
		
	}
	
	/*
	 * crossOffMostUrgent removes the first node within the active list queue and adds it to the completed list queue. 
	 */
	
	public boolean crossOffMostUrgent() {
		
		if (active.getFront() == null) {
			
			System.out.println("Unsuccessful operation! Please try again!");
			
			return false;
			
		}
		
		System.out.println("Task is completed and removed from the list: " + active.getFront().getData() +"\n"
				+ "Successfully removed the most urgent task/top of the list task!");
		
		completed.addRear(active.getFront().getData());
		active.remove(active.getFront());
		
		
		return true;
		
	}
	
	/*
	 * crossOffTask removes the first node within the active list queue and adds it to the completed list queue. 
	 */
	
	public boolean crossOffTask(int taskNumber) {
		
		if (taskNumber <= 0 || taskNumber > active.getSize() || active.getFront() == null) {
			
			System.out.println("Unsuccessful operation! Please try again!");
			
			return false;
			
		}
		
		ListQueue.Node<E> curr = active.getFront();
		
		for (int i = 1; i < taskNumber; i ++) {
			
			curr = curr.getNext();
			
		}
		
		System.out.println("Task number " + taskNumber + " is removed: " + curr.getData());
		
		completed.addRear(curr.getData());
		active.remove(curr);
		
		return true;
				
	}

}
