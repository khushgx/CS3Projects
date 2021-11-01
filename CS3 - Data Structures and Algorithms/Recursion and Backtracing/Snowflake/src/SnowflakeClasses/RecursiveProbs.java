package SnowflakeClasses;

import java.util.Stack;

public class RecursiveProbs {

	//Problem 2
	public double sumReciprocals(int n) {
		
		if(n == 1) {
			return 1;
		} else {
			return 1.0/n + sumReciprocals(n - 1);
		}
	}
	
	//Problem 3
	public int productOfEvens(int n) {
		
		
		if(n == 1) {
			return 2;
		}
		else {
			
			
			return n * 2 * productOfEvens(n - 1);
			
		}
	}

	
	//Problem 4
		//The answer is the future
	
	//Problem 5
	public void doubleUp(Stack<Integer> nums) {
		
		if(nums.size() == 0) {
			return;
		}
		
		int x = nums.pop();
		doubleUp(nums);
		nums.push(x);
		nums.push(x);
		
		
	}
	
	
	public void countBy(int n, int m) {
		
		if(n - m < 0) {
			System.out.print(n );
			return;
		} else {
			countBy( n- m , m);
			System.out.print(", ");
		}
		System.out.print(n);
		
	}
	
	
	
	public static void main(String[] args) {
		RecursiveProbs prob = new RecursiveProbs();
		
		System.out.println(prob.sumReciprocals(10));
		System.out.println(prob.productOfEvens(4));
		Stack<Integer> x = new Stack<Integer>();
		x.push(3);x.push(4);x.push(5);
		prob.doubleUp(x);
		System.out.println(x);
		int i = 4;
		int z = 35;
		prob.countBy(z, i);
		
		
	}
}
