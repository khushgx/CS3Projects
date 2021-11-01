package Runner;




import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class WordLadderRunner {
	public static void main(String[] args) {
		try {

			Scanner dictionary = new Scanner(new File("dictionary.txt"));
			Scanner input = new Scanner(new File("input.txt"));
			Scanner output = new Scanner(new File("output.txt"));

			Set<String> dict = new HashSet<>();
			while (dictionary.hasNextLine()) {
				dict.add(dictionary.nextLine().toLowerCase());
			}

			while (input.hasNextLine()) {
				Scanner ln = new Scanner((input.nextLine()));
				String start = ln.next();
				String end = ln.next();
				
				
				System.out.println(findLadder(start, end, dict));

			}

		} catch (FileNotFoundException e) {

			System.out.println("File Not Found");

		}

	}

	public static String findLadder(String start, String end, Set<String> wordList) {

		Set<String> set = new HashSet<>(wordList);

		Queue<Stack<String>> q = new LinkedList<>();
		Stack<String> stack = new Stack<>();
		Set<String> old  = new HashSet<>();
		Stack<String> copiedStack = new Stack<>();
		stack.push(start);
		q.offer(stack);
		old.add(start);
		
		while (!q.isEmpty()) {
			int size = q.size();
			for(int i =0; i < size; i ++) {
				
				String current2 = q.poll().peek();
				 
				char[] current = current2.toCharArray();
						
				
				for(int j = 0; j < current.length; j++) {
					char tmp =  current[j];
					
					for(char ch = 'a'; ch <= 'z'; ch++) {
						
						
						current[j] = ch;
	                    String next = new String(current);
	                    if(start.equalsIgnoreCase(end)) {
	    					return "Found a ladder between [" + start + ", " +  end + "]";
	    				}
	    				
	    				if(!wordList.contains(start) || !wordList.contains(end)) {
	    	
	    					return " no ladder";
	    				}
						
						if(set.contains(next) && !old.contains(next) ) {
							
						if(oneLetterApart(current2, next)) {
							//Deep Copy
							copiedStack = new Stack<String>();
                            copiedStack.addAll(stack);
                            
                            copiedStack.push(next);
                            
                            old.add(next);
                            //Enqueue
                            q.offer(copiedStack);
						}
						
						
							
						
						if(next.equals(end)) {
							return "Found a ladder between " + copiedStack;
						}
							
					}
							
							
							
							
							 
							
							
							
						}
						
					 current[j] = tmp;
					}
				}
						
			}
			
		
		
		return "No word ladder between " + start + " and " + end;

				
	}
	
	
	//Sees if string difference is 1
	 public static boolean oneLetterApart(String w1, String w2) {
         
         if( w1.length() != w2.length() ){
                 return false;
         }
        
         int diffrenceCount = 0;
         for(int i=0; i< w1.length() ;i++){
                 if( w1.charAt(i) != w2.charAt(i) ){
                         diffrenceCount++;
                         if(diffrenceCount >1){
                                 return  false;
                         }
                 }
         }
         if(diffrenceCount >1){
                 return  false;
         }

         return true;
}
}
	


