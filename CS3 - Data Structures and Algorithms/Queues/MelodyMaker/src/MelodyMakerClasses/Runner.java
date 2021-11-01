package MelodyMakerClasses;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Runner {

	public static void main(String[] args) {
		
		QueueProbs call = new QueueProbs();
		
		//Problem 3
		Queue<Integer> prob1 = makeQueue( new int[] {3, 5, 4, 17, 6 , 83, 1, 84, 16, 37});
		System.out.println(call.evenFirst(prob1));
		
		//Problem 4
		Queue<Integer> prob2 = makeQueue( new int[] {3, 8, 17, 9, 17 , 8, 3});
		System.out.println(call.numPalindrome(prob2));
		
		//Problem 5
			//Today, Tomorrow, Yesterday
		
		//Problem 6
		System.out.println(call.checkPrimes(10));
		
		

	}
	
public static Queue<Integer> makeQueue(int[] nums) {
		
		Queue<Integer> stack = new LinkedList<>();
		for (int num : nums)
		stack.offer(num);
		return
		stack;
	}

}
