/**
 * A singly connected linked list
 * 
 * @author Christopher
 *
 */

public class SingleLinkedList {

	/**
	 * Entry point for the program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SingleLinkedList sl = new SingleLinkedList();

		sl.insert(1);
		sl.insert(2);

		sl.remove(1);
		sl.dump();
	}

	// Create a new starting point for the list
	Node head;
	// Keep track of items in the list
	private int counter;

	/**
	 * Constructor Set the start of the list to be null and counter to 0 as there is
	 * nothing yet in this list
	 */
	public SingleLinkedList() {
		this.head = new Node(null);
		this.counter = 0;
	}

	/**
	 * Adds a new value into the list
	 * 
	 * @param data Integer value to be added
	 */
	public void insert(int data) {
		// Create a new Node object
		Node current = new Node(data);

		// If there are no values in the list
		if (head == null) {
			head = new Node(data);
			counter++;
			return;
		}
		// Otherwise set the next pointer of the node to be inserted to null
		current.setNext(null);

		// Set a value to the start of the list
		Node placeholder = head;
		// While that value is not at the end of the list
		while (placeholder.getNext() != null) {
			// Get the last node
			placeholder = placeholder.getNext();
		}
		// Set the last nodes next value to the currently inserted node
		// So it has a place to reference
		placeholder.setNext(current);
		counter++;
		return;
	}

	/**
	 * Finds the location of a node in the list starting at 0
	 * 
	 * @param data The value stored in a node to check
	 * @return The integer of the location of that node, else -1 if not found
	 */
	public int findIndex(int data) {
		// The starting point of the search
		Node location = head;
		int count = 0;

		// While not at the end of the list
		while (location != null) {

			// If the value is found
			if (location.getData() == data) {
				return count;
			}
			// Otherwise keep searching
			count++;
			location = location.getNext();

		}
		// A value was not found
		return -1;
	}

	/**
	 * Removes a node from the list Based on finding the first occurance of the data
	 * passed in
	 * 
	 * @param data The value to find and remove
	 */
	public void remove(int data) {
		Node temp = head.getNext();
		Node prev = null;

		if (temp != null && temp.getData() == data) {
			head = temp.getNext();
			counter--;
			return;
		}

		while (temp != null && temp.getData() != data) {
			prev = temp;
			temp = temp.getNext();
		}

		if (temp == null) {
			counter--;
			return;

		}

		counter--;
		prev.setNext(temp.getNext());

	}

	/**
	 * Arranges each node in ascending order
	 */
	public void sort() {
		Node current = head.getNext();
		Node index = null;
		int temp;

		// Nothing in the list
		if (head == null) {
			return;
		} else {
			// If not at the end of the list
			// Get the next node
			while (current != null) {
				index = current.getNext();
				// If the next node is not the last node
				while (index != null) {
					// If the node that we are currently visting and that nodes data value is
					// greater
					// than the data value in the next node
					if (current.getData() > index.getData()) {
						// Swap the two nodes
						temp = current.getData();
						current.setData(index.getData());
						index.setData(temp);
					}
					// After the swap, move onto the next node
					index = index.getNext();
				}
				current = current.getNext();
			}
		}

	}

	/**
	 * Reverses the data in the linked list
	 * 
	 * @return Each node
	 */
	public Node reverse() {
		Node previous = null;
		Node current = head;
		Node next;
		// If the last node is reached
		while (current != null) {
			// Store the currents next pointer into the next Node
			next = current.getNext();
			// Set the current to the previous nodes value
			current.setNext(previous);
			// Move on to the next node
			previous = current;
			current = next;
		}
		this.head = previous;
		return previous;
	}

	/**
	 * Check if the list is empty
	 * 
	 * @return True if empty, false if one or more nodes
	 */
	public boolean isEmpty() {
		if (length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Check if the list contains a value
	 * 
	 * @param contains value to check against each node
	 * @return True if node is found, false if not found
	 */
	public boolean contains(int contains) {
		// Call the getNext method to get the first value in the list
		Node current = head.getNext();

		// Loop through the list
		while (current != null) {
			if (contains == current.getData()) {
				return true;
			}
			// Reassign current to the next value in the list
			current = current.getNext();
		}
		return false;
	}

	/**
	 * Print out all the values in the list
	 */
	public void dump() {
		if (head != null) {
			Node current = head;
			while (current.getNext() != null) {
				System.out.println(current.getNext().getData());
				current = current.getNext();
			}
			// System.out.println(current.getData());
		}
	}

	/**
	 * Clear the list
	 */
	public void clear() {
		head = null;
		counter = 0;
	}

	/**
	 * Get the length of the list
	 * 
	 * @return Integer value of the length
	 */
	public int length() {
		return this.counter;
	}

	/**
	 * A node class to store each data point for a linked list
	 * 
	 * @author Christopher
	 *
	 */
	private class Node {
		private Integer _data;
		private Node _next;

		/**
		 * Constructor
		 * 
		 * @param data The data of each node
		 */
		public Node(Integer data) {
			this._data = data;
			_next = null;
		}

		/**
		 * Get the data in the current node
		 * 
		 * @return Integer
		 */
		public Integer getData() {
			return this._data;
		}

		/**
		 * Get the next Node in the list
		 * 
		 * @return Node object, or null if nothing to get next
		 */
		public Node getNext() {
			return this._next;
		}

		/**
		 * Set the data in the current node
		 * 
		 * @param data Integer
		 */
		public void setData(Integer data) {
			this._data = data;
		}

		/**
		 * Set the next Node in the list
		 * 
		 * @param next Node object or null if nothing to set next
		 */
		public void setNext(Node next) {
			this._next = next;
		}
	}

}
