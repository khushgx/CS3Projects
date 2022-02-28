package HuffmanCodingClasses;


 class Node implements Comparable<Node>{
		
		Character c;
		Node left;
		Node right;
		int asciiCharacter;
		int countFrequency;
		
		
		
		Node(int ascii, int count){
			this('\0', ascii, count, null, null );
		}
		
		Node (Character s, int ascii, int count, Node l, Node r){
			c = s;
			left = l;
			right = r;
			asciiCharacter = ascii;
			countFrequency = count;
			
		}
		@Override
		public int compareTo(Node current) {
			
			return countFrequency - current.countFrequency;
		}
		
	
		@Override
		public String toString() {
			
			if(left == null && right == null) {
				
				return asciiCharacter + "";
				
				
			} else {
				
				return countFrequency + "";
			}
			
			
			
		}
		
	}


