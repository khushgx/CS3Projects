package MyLinkedListClasses;



public class MyLinkedList {
	ListNode head;
	private int size;
	ListNode tail;

	public MyLinkedList() {
		head = null;
		size = 0;
		tail = null;
	}

	public MyLinkedList(int val) {
		head = new ListNode(val);
		head.next = null;
		tail = head;
		size = 1;
	}
	
	private void addFirst(int data) {
		ListNode temp = new ListNode(data);
		temp.next = head;
		head = temp;
		size++;
		if(tail == null) {
			tail = head;
		}
		
	}
	
	private void addLast(int newVal) {
		ListNode temp = new ListNode(newVal);
		if(tail == null) {
			head = temp;
			tail = temp;
		}else {
			tail.next = temp;
			tail = tail.next;
		}
		size++;
		
	}
	
	private int removeFirst() {
		
	
			ListNode temp = head;
			
			head = head.next;
			size--;
			return temp.val;
		
	}
	
	private int removeLast() {
		
	 if (size == 1){
			ListNode temp = head;
			head = null;
			tail = null;
			size = 0 ;
			
			return temp.val;
		} else {
			ListNode current = head;
			
			for(int i = 0; i < size - 2; i++) {
				current = current.next;
			}
			
			ListNode temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.val;
			
		}
		
	}
	
	public void add(int val) {
		if (head == null) {
			head = new ListNode(val);
		
		} else {

			ListNode temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new ListNode(val);
		
		}
		
		size++;
	}

	public boolean contains(int target) {
		ListNode temp = head;
		while (temp != null) {
			if (temp.val == target) {
				return true;
			}
			temp = temp.next;
		}
		return false;

	}

	public int get(int index) {
		ListNode temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}

		return temp.val;
	}

	public int indexOf(int target) {
		ListNode temp = head;
		int i = 0;
		while (temp != null) {
			if (temp.val == target) {
				return i;
			}
			temp = temp.next;
			i++;
		}
		return -1;
	}

	public void set(int newVal, int index) {
		ListNode temp = head;

		for (int i = 0; i < index; i++) {
			if (temp != null) {
				temp = temp.next;
			}

		}
		temp.val = newVal;
	}

	public int size() {
		return size;
	}

	
	ListNode temp2 = head;
	int i = 0;
	public int sizeRecursive() {
		
		if(temp2 == null) {
			return i;
		}
		i++;
		return sizeRecursive();
		
	}

	public boolean isEmpty() {
		return head == null;
	}


		
	public int remove(int index) {
		if(index < 0 || index >= size() ) {
			return (Integer) null;
		}
		
		if(index == 0) {
			return removeFirst();
			
		}
		else if(index == size()) {
			return removeLast();
		}
		else {
			
			ListNode previous = head;
			for (int i = 0; i < index - 1; i++) {
				previous = previous.next;
			}
			
			ListNode current = previous.next;
			previous.next = current.next;
			size--;
			
			return current.val;
			
		}
	}

	

	public void add(int newVal, int index) {
		if(index < 0) {
			throw new IndexOutOfBoundsException();
		} else {
			if(index == 0) {
				addFirst(newVal);
			

			} else if(index == size()){
				
				addLast(newVal);
				
			}
			else {
				
				ListNode current = head;
				for(int i = 0; i < index - 1; i++) {
					current = current.next;
				}
				ListNode temp2 = current.next;
				current.next = new ListNode(newVal);
				current.next.next = temp2;
				size++;
				
			}
		}
	}

	

	public String toString() {
		if (head != null) {
			ListNode temp = head;
			String s = "[";
			s += "" + temp.val;
			while (temp.next != null) {
				s += ", " + temp.next.val;
				temp = temp.next;
			}
			s += "]";
			return s;
		} else {
			return "[]";
		}

	}

	private class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "" + this.val;
		}

	}
}
