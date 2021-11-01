package MelodyMakerClasses;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueProbs {
	
	public Queue<Integer> evenFirst(Queue<Integer> nums){
		
		Queue<Integer> odds = new LinkedList<>();
		Queue<Integer> evens = new LinkedList<>();
		
		while(!nums.isEmpty()) {
			if(nums.peek() % 2 != 0) {
			odds.offer(nums.poll());
			}
				else {
				evens.offer(nums.poll());
			}
			
		}
		
		while(!odds.isEmpty()) {
			evens.offer(odds.poll());
		}
		
		return evens;
	
	}
	
	public  boolean numPalindrome(Queue<Integer> nums) {
		
		Stack<Integer> stack = new Stack<Integer>();
		Queue<Integer> temp = new LinkedList<>(nums);
		
		
		
		while(!temp.isEmpty()) {
			stack.push(temp.poll());
		}
		
		
		while(!nums.isEmpty()) {
			
			if(nums.poll() != stack.pop() ){
				return false;
			}
		}
		
		return true;
	
		
		
	}
	
	public Stack<Integer> checkPrimes(int n){
		
		Queue<Integer> values = new LinkedList<>(); 
		Stack<Integer> primes = new Stack<>();
				
			for(int i = 2; i <= n; i++) {
				values.offer(i);
			}
			
			
			
			while(!values.isEmpty()) {
				
				System.out.println(values);
				
				int primeNumb = values.poll();
				primes.push(primeNumb);
			    values = clear(values, primeNumb);
			    
				
				
				
			}
			
			
			
		return primes;
		
	}

	private Queue<Integer> clear(Queue<Integer> values, int prime) {
		
		Queue<Integer> factors = new LinkedList<>();
		
		while(values.size()>0) {
			int tempFactor = values.poll();
			
			if(tempFactor % prime != 0) {
				
				
				factors.offer(tempFactor);
				
			}
			
		
			
			
		}
		
		
		
		
		
		
		
		return factors;
		
	}
	
	
	
	
}
