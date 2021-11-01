package LinkedListQueueClasses;



public class MyLinkedList<T> {
	
	ListNode head;
	private int size;
	ListNode tail;

	MyLinkedList() {
		head = null;
		size = 0;
		tail = null;
	}

	MyLinkedList(T val) {
		head = new ListNode(val);
		head.next = null;
		tail = head;
		size = 1;
	}
	
	public MyLinkedList(T... vals) {
		
		
		for(T val: vals) {
			add(val);
		}
		
		
		size = vals.length;
		tail = new ListNode(vals[size - 1]);
	}
	
	
	
	
	private void addFirst(T data) {
		ListNode temp = new ListNode(data);
		temp.next = head;
		head = temp;
		size++;
		if(tail.equals(null)) {
			tail = head;
		}
		
	}
	
	private void addLast(T newVal) {
		ListNode temp = new ListNode(newVal);
		if(tail.equals(null)) {
			head = temp;
			tail = temp;
		}else {
			tail.next = temp;
			tail = tail.next;
		}
		size++;
		
	}
	
	private T removeFirst() {
		
	
			ListNode temp = head;
			
			head = head.next;
			size--;
			return temp.val;
		
	}
	
	private T removeLast() {
		
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
	
	public void add(T val) {
		if (head != null) {
			ListNode temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new ListNode(val);
		
		} else {

			
			head = new ListNode(val);
		}
		
		size++;
	}

	public boolean contains(T target) {
		ListNode temp = head;
		while (temp != null) {
			if (temp.val.equals(target) ) {
				return true;
			}
			temp = temp.next;
		}
		return false;

	}

	public T get(int index) {
		ListNode temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}

		return temp.val;
	}

	public int indexOf(T target) {
		ListNode temp = head;
		int i = 0;
		while (temp != null) {
			if (temp.val.equals(target)) {
				return i;
			}
			temp = temp.next;
			i++;
		}
		return -1;
	}

	public void set(T newVal, int index) {
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
		
		if(temp2.equals(null)) {
			return i;
		}
		i++;
		return sizeRecursive();
		
	}

	public boolean isEmpty() {
		return head == null;
	}


		
	public T remove(int index) {
		if(index < 0 || index >= size() ) {
			return null;
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

	

	public void add(T newVal, int index) {
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
	    T val;
		ListNode next;

		public ListNode(T val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "" + this.val;
		}

	}
}
