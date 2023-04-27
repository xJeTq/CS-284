import java.util.Random;
import java.util.Stack;

/*
 * Name: Anthony Curcio-Petraccoro 
 * Pledge: I pledge my honor that I have abided by the Stevens Honor System. 
 */

public class Treap<E extends Comparable<E>> {

	private static class Node<E> {
		
		public E data; // Key for search. 
		public int priority; // Random heap priority. 
		public Node<E> left; 
		public Node<E> right;
		
		/*
		 * Constructs a new node with specific data and priority. 
		 */
		
		public Node(E data, int priority) {
			
			if (data == null) {
				
				throw new IllegalArgumentException();
				
			}
			
			this.data = data;
			this.priority = priority;
			this.left = null;
			this.right = null;
			
		}
		
		/*
		 * Rotates a Binary Search Tree to the right, meaning the root is shifts to the right node. 
		 */
		
		public Node<E> rotateRight() {
			
			/*Node<E> L = this.left;
			Node<E> R = this.left.right;
			L.right = this;
			this.left = R;
			
			return L;*/
			
			if (this.left == null) {
				
				return this;
				
			}

			Node<E> temp = this.left;
			
			this.left = temp.right;
			temp.right = this;
			
			return temp;
            
		}
		
		/*
		 * Rotates a Binary Search Tree to the left, meaning the root is shifts to the left node. 
		 */
		
		public Node<E> rotateLeft() {
			
			/*Node<E> R = this.right.left;
			Node<E> L = this.right;
			R.left = this;
			this.right = L;
			
			return R;*/
			
			if (this.right == null) {
				
				return this;
				
			}
			
			Node<E> temp = this.right;
			
			this.right = temp.left;
			temp.left = this;
			
			return temp;
        
		}
	
	}
	
	private Random priorityGenerator;
	private Node<E> root;
	
	/*
	 * Constructs a new Treap with a random priority and an empty root. 
	 */
	
	public Treap() {
		
		this.priorityGenerator = new Random();
		this.root = null;
		
	}
	
	/*
	 * Constructs a new Treap with a random priority to a certain point (seed), and an empty root. 
	 */
	
	public Treap(long seed) {
		
		this.priorityGenerator = new Random(seed);
		this.root = null;
		
	}
	
	/*
	 * Rotates stack heap given priority. 
	 */
	
	private void reheap(Stack<Node<E>> stack, Node<E> curr) {
		
		/*
		 * Node<E> temp2 = stack.peek();
		 * 
		 * do {
		 * 
		 * if (stack.peek().left == temp) {
		 * 
		 * if (stack.size() != 1) {
		 * 
		 * stack.pop();
		 * 
		 * if (stack.peek().right == temp2) {
		 * 
		 * stack.peek().right = temp2.rotateRight();
		 * 
		 * } else {
		 * 
		 * stack.peek().left = temp2.rotateRight();
		 * 
		 * }
		 * 
		 * } else {
		 * 
		 * this.root = temp2.rotateRight();
		 * 
		 * break;
		 * 
		 * }
		 * 
		 * } else {
		 * 
		 * if (stack.size() != 1) {
		 * 
		 * stack.pop();
		 * 
		 * if (stack.peek().left == temp2) {
		 * 
		 * stack.peek().left = temp2.rotateLeft();
		 * 
		 * } else {
		 * 
		 * stack.peek().right = temp2.rotateLeft();
		 * 
		 * }
		 * 
		 * } else {
		 * 
		 * this.root = temp2.rotateLeft();
		 * 
		 * break;
		 * 
		 * }
		 * 
		 * }
		 * 
		 * } while (stack.peek().priority < temp.priority);
		 */
		
		do {
			
			Node<E> temp = stack.pop();
			
			if (temp.priority < curr.priority) {
				
				if (curr.data.compareTo(temp.data) < 0) {
					
					curr = temp.rotateRight();
					
				} else {
					
					curr = temp.rotateLeft();
					
				}
				
				if (stack.isEmpty() == false) {
					
					if (stack.peek().left != temp) {
										
						stack.peek().right = curr;
						
					} else {
												
						stack.peek().left = curr;

					}
					
				} else {
					
					this.root = curr;
					
				}	
				
			} else {
				
				break;
				
			}
		} while (stack.isEmpty() == false);
	}
		
	/*
	 * Adds a new node to a Treap with a certain key and random priority. Returns false if the key is already in the Treap. 
	 */
		
	public boolean add(E key) {
		
		if (key == null) {
			
			return false;
			
		}
		
		return add(key, priorityGenerator.nextInt() /* ? */);
						
	}
		
	/*
	 * Adds a new node to a Treap with a certain key and priority. Returns false if the key is already in the Treap. 
	 */
	
	public boolean add(E key, int priority) {
		
		/*
		 * Stack<Node<E>> stack = new Stack<Node<E>>(); Node<E> temp = new
		 * Node<E>(key,priority); // ? Node<E> curr = this.root;
		 * 
		 * if (curr == null) {
		 * 
		 * this.root = temp;
		 * 
		 * return true;
		 * 
		 * } else if (key == null) {
		 * 
		 * // throw new NullPointerException("Item is empty.");
		 * 
		 * return false;
		 * 
		 * } else if (priority < 0) {
		 * 
		 * // throw new IllegalArgumentException();
		 * 
		 * return false;
		 * 
		 * } else if (find(key) == true) {
		 * 
		 * return false;
		 * 
		 * } else {
		 * 
		 * do {
		 * 
		 * if (curr == null) {
		 * 
		 * break;
		 * 
		 * } else if (key.compareTo(curr.data) < 0) {
		 * 
		 * stack.push(curr); curr = curr.left;
		 * 
		 * } else {
		 * 
		 * stack.push(curr); curr = curr.right;
		 * 
		 * }
		 * 
		 * } while (true);
		 * 
		 * }
		 * 
		 * if (key.compareTo(stack.peek().data) < 0) {
		 * 
		 * stack.peek().left = temp;
		 * 
		 * } else {
		 * 
		 * stack.peek().left = temp;
		 * 
		 * }
		 * 
		 * reheap(temp, stack); // ?
		 * 
		 * return true;
		 */
		 
		if (root == null) {
			
			root = new Node<E>(key, priority);
			
			return true;
			
		}
		
		if (key == null) {
			
			return false;
			
		}
		
		Stack<Node<E>> stack = new Stack<Node<E>>();
		Node<E> curr = root;
		
		do {
			
			stack.push(curr);
			
			if(find(key) == true) {
				
				return false;
				
			} else if (key.compareTo(curr.data) < 0) {
	        	
	        	if(curr.left == null) {
	        		
			           curr.left = new Node<E>(key, priority);
			           
			           reheap(stack, curr.left);
			           
			           return true;
			           
		        	}
		        	
		        	curr = curr.left;
	        	
	        } else { 
	        	
	        	if(curr.right == null) {
	        		
			           curr.right = new Node<E>(key, priority);
			           
			           reheap(stack, curr.right);
			           
			           return true;
			           
		        	}
		        	
		        	curr = curr.right;
	        	
	        }
			
		} while (curr != null);
		
		return false;
		
	}
	
	/*
	 * public boolean deleteRoot(E key) {
	 * 
	 * 		if (curr.data == key && (curr.left == null && curr.right == null)) {
	 *				
	 *				curr = parent; // ? 
	 *				
	 *				return true;
	 *				
	 *		} else if (curr.data == key && (curr.left != null && curr.right == null)) {
	 *				
 	 *				curr = curr.left;
	 *				curr.left = null;
	 *				
	 *				return true;
	 *				
	 *		} else if (curr.data == key && (curr.left == null && curr.right != null)) {
	 *				
	 *				curr = curr.right;
	 *				curr.right = null;
	 *				
	 *				return true;
	 *				
	 *		} else {
	 * 			
	 * 		}
	 * 
	 * }
	 */
	
	/*
	 * Deletes a node from a Treap with a certain key. Returns false if the node wasn't found within the Treap.  
	 */
	
	public boolean delete(E key) {
					
			/*
			Stack<Node<E>> stack = new Stack<Node<E>>();
			Node<E> curr = this.root;
			Node<E> parent = null;
			
			do {
				
				if (curr.data == key && (curr.left == null && curr.right == null)) {
					
					curr = parent; // ? 
					
					return true;
					
				} else if (curr.data == key && (curr.left != null && curr.right == null)) {
					
					curr = curr.left;
					curr.left = null;
					
					return true;
					
				} else if (curr.data == key && (curr.left == null && curr.right != null)) {
					
					curr = curr.right;
					curr.right = null;
					
					return true;
					
				} else {
					
					
					
				}
				
				
				
			} while (true); */
			
		Node<E> pz = null;
		Node<E> temp = root;
		
		if (find(key) == false) {
			
			return false;
			
		}
		
		do {
			
			if (key.compareTo(temp.data) > 0) {
				
				pz = temp;
				temp = temp.right;
				
			} else if (key.compareTo(temp.data) < 0 ) {
				
				pz = temp;
				temp = temp.left;
				
			} else {
				
				if (temp.right == null && temp.left == null) {
					
					if (temp.data.compareTo(pz.data) > 0) {
						
						pz.right = null;
						
						return true;
						
					} else {
						
						pz.left = null;
						
						return true;
						
					}
				}
				
				if (key.compareTo(this.root.data) == 0) {
					
					if (this.root.left == null) {
						
						this.root = this.root.right;
						
						return true;
						
					} else if (this.root.right == null) {
						
						this.root = this.root.left;
						
						return true;
						
					}
					
					if (this.root.right.priority < this.root.left.priority) {
						
						this.root = this.root.rotateRight();
						pz = root;
						
					} else {
						
						this.root = this.root.rotateLeft();
						pz = root;
						
					}
					
				} else if (temp.right != null && temp.left == null) {
					
					if (pz.left != temp) {
						
						pz.right = temp.rotateLeft();
						pz = pz.right;
						
					} else {
						
						pz.left = temp.rotateLeft();
						pz = pz.left;
						
					}
					
				} else if (temp.right == null && temp.left != null) {
					
					if(pz.left != temp) {
						
						pz.right = temp.rotateRight();
						pz = pz.right;
						
					} else {
						
						pz.left = temp.rotateRight();
						pz = pz.left;
						
					}
					
				} else if (temp.right != null && temp.left != null) {
					
					if (temp.left.priority > temp.right.priority) {
						
						if (pz.left != temp) {
							
							pz.right = temp.rotateRight();
							pz = pz.right;
							
						} else {
							
							pz.left = temp.rotateRight();
							pz = pz.left;
							
						}
						
					} else {
						
						if (pz.left != temp) {
							
							pz.right = temp.rotateLeft();
							pz = pz.right;
							
						} else {
							
							pz.left = temp.rotateLeft();
							pz = pz.left;
							
						}
					}
				}
			}
		} while (temp != null);
		
		return false;	
		
	}
	
	/*
	 * Finds a specific Node with a specific key within the Treap. Returns false if the node with the key is not found within the Treap. 
	 */
	
	private boolean find(Node<E> root, E key) {
		
		if (root == null) {
			
			// throw new NullPointerException("Item is empty.");
			
			return false;
		
		} else if (key == null) {
			
			// throw new NullPointerException("Item is empty.");
			
			return false;
		
		} else if (root.data == key) {
			
			return true;
			
		} else {
			
			return find(root.left, key) || find(root.right, key); // ? 
			
		}
		
	}
	
	/*
	 * Finds a node within the Treap with a specific key. Returns false if the node with the specific key is not found within the Treap. 
	 */
	
	public boolean find(E key) {
		
		return find(this.root, key);
		
	}
	
	/*
	 * Returns a visualization of the Treap in String format. 
	 */
	
	public String toString() {
		
		return toString(root, 0);
		
	}
	
	/*
	 * toString helper function that properly builds the string form of the Treap. 
	 */
	
	public String toString(Node<E> current, int level) {
		
		StringBuilder s = new StringBuilder();
		
		for (int i = 0; i < level; i++) {
			
			s.append("  ");
			
		}
		
		if (current==null) {
			
			s.append("null\n");
			
		} else {
			
			s.append("(key=" + current.data + ", priority=" + current.priority + ")\n");
			s.append(toString(current.left, level+1));
			s.append(toString(current.right,level+1));
			
		}
		
		return s.toString();
		
	}
	
}

