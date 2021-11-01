package GemMatchingClasses;

//Creating a linkedlist that stores the Gems in the game
public class GemList 
{
	Node head; //front gem
	int size = 0; 
	Node tail;//last gem
	//Constructor
	public GemList() {
		head = null;
		size = 0;
		tail = null;
	}
	
	public GemList(Gem data) {
		head = new Node(data);
		size = 1;
		head = tail;
	}
	public int size() {
		return size;
	}
	
	//Insert the Gem at the First position, used later
	private void insertFirst(Gem data) {
		Node temp = new Node(data);
		temp.next = head;
		size++;
		if(tail == null) {
			tail = head;
		}
		
		
		
	}
	
	//Insert gem at last postion
	private void insertLast(Gem data) {
		Node temp = new Node(data);
		
		if(tail == null) {
			head = temp;
			tail = temp;
		}else {
			tail.next = temp;
			tail = tail.next;
		}
		size++;
		
	}
	
	
	public void draw(double y) {
		Node temp = head;
		double i = 0;
		
		while(temp != null) {
			
			temp.gem.draw( i , y);
			temp = temp.next;
			i+= .06;
		}
		
	}
	
	//Insert the gems before the specified index, so if Index was 4, it would enter at 3
	public void insertBefore(Gem gem, int index) {
		if(index >= size) {
			if (head != null) {
				Node temp = head;
				while (temp.next != null) {
					temp = temp.next;
				}
				temp.next = new Node(gem);
			
			} else {

				
				head = new Node(gem);
			}
			
			size++;
		}
		else {
			if(index < 0) {
				throw new IndexOutOfBoundsException();
			} else {
				if(index == 0) {
					insertFirst(gem);
				

				} else if(index == size()){
					
					insertLast(gem);
					
				}
				else {
					
					Node current = head;
					for(int i = 0; i < index - 1; i++) {
						current = current.next;
					}
					Node temp2 = current.next;
					current.next = new Node(gem);
					current.next.next = temp2;
					size++;
					
				}
			}
			}	
		}
		
	
	
	@Override
	public String toString() {
		String s = "";
		Node temp = head;
		for(int i = 0; i < size(); i++) {
			s += temp.gem +  " ";	
			temp = temp.next;
		}
		
		return s;
		
	}

	//node for linkedlist
	private class Node{

		private Gem gem;
		private Node next;
		
		public Node(Gem val) {
			this.gem = val;
		}

		@Override
		public String toString() {
			return "" + this.gem;
		}
	}
	
	//Calculates the score with the multiplier. compares the types to add the multiplier
	public int score() {
		int score = 0;
		Node temp = head;
		if(head == null) {
			return 0;
		} else if(head.next == null) {
			return head.gem.getPoints();
		}
		
		while(temp!=null) {
			int multiplier = 1;
			int tempScore = temp.gem.getPoints();
			
			//Try catch used for debugging
			try { 
				while (temp.gem.getType() == temp.next.gem.getType()) {
					
					multiplier++;
					tempScore += temp.next.gem.getPoints();
					temp = temp.next;

				}
			
			}
			catch(Exception e) {}
			score += tempScore * multiplier;
		
		
			temp = temp.next;
			
		}
			
			
		
		return score;
	}	
	
	
	public static void main(String [] args)
	{
		GemList list = new GemList();
		System.out.println(list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.9);		
		
		list.insertBefore(new Gem(GemType.BLUE, 10), 0);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.8);
		
		list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.7);
		
		list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.6);
		
		list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.5);
		
		list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.4);
		
		list.insertBefore(new Gem(GemType.GREEN, 50), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.3);		
	}
	
}
