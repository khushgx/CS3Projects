package MyStackClasses;

import java.util.Stack;

public class Runner {

	public static void main(String[] args) {
		
		StackProbs call = new StackProbs();
		
		
		//Problem one
		Stack<Integer> test = makeStack( new int [] {1,3,5, 0, -1});
	
		System.out.println(call.doubleUp(test));
		
		//Problem 2
		Stack<Integer> test2 = makeStack( new int [] {2,9,-4, 3, -1, 0, -6});
		System.out.println(call.posAndNeg(test2));
		
		//Problem 3
		Stack<Integer> test3 = makeStack( new int [] {7,23,-7, 0, 22, -8, 4, 5});
		System.out.println(call.shiftByN(test3, 3));
		
		//Problem 4
		System.out.println(call.reverseVowels("hello how are you"));
		
		//Problem 5
		System.out.println(call.bracketBalance("[(())]"));
		

	}
	public static Stack<Integer> makeStack(int[] nums) {
		
		Stack<Integer> stack = new Stack<>();
		for (int num : nums)
		stack.push(num);
		return
		stack;
	}


}
