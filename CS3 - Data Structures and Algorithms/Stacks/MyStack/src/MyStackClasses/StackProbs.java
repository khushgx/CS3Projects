package MyStackClasses;

import java.util.Stack;

public class StackProbs {

	public Stack<Integer> doubleUp(Stack<Integer> nums) {

		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();

		while (!(nums.isEmpty())) {
			int number = nums.pop();
			stack.push(number);
			stack.push(number);

		}

		while (!(stack.isEmpty())) {
			int number2 = stack.pop();
			stack2.push(number2);

		}

		return stack2;
	}

	public Stack<Integer> posAndNeg(Stack<Integer> nums) {

		Stack<Integer> pos = new Stack<Integer>();
		Stack<Integer> neg = new Stack<Integer>();

		while (!(nums.isEmpty())) {
			if (nums.peek() >= 0) {

				pos.push(nums.pop());

			} else if (nums.peek() < 0) {
				neg.push(nums.pop());
			}
		}

		while (!(pos.isEmpty())) {
			neg.push(pos.pop());
		}

		return neg;

	}

	public Stack<Integer> shiftByN(Stack<Integer> nums, int n) {

		int count = 0;
		Stack<Integer> temp = new Stack<Integer>();
		Stack<Integer> temp2 = new Stack<Integer>();

		for (int i = nums.size(); i > n; i--) {
			temp.push(nums.pop());
		}

		while (!(temp.isEmpty())) {
			int number2 = temp.pop();
			temp2.push(number2);

		}

		while (!(nums.isEmpty())) {

			temp.push(nums.pop());
		}

		while (!(temp.isEmpty())) {
			temp2.push(temp.pop());
		}

		return temp2;

	}

	private static boolean isVowel(char c) {
		return (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u'
				|| c == 'U');
	}

	public String reverseVowels(String str) {

		Stack<Character> vowel = new Stack<Character>();
		Stack<Character> tempmessage = new Stack<Character>();
		Stack<Character> finalmessage = new Stack<Character>();
		String fin = "";

		for (int i = 0; i < str.length(); i++) {
			if (isVowel(str.charAt(i))) {
				vowel.push(str.charAt(i));

			}

		}

		for (int i = 0; i < str.length(); i++) {

			if (isVowel(str.charAt(i))) {

				tempmessage.push(vowel.pop());

			} else {
				tempmessage.push(str.charAt(i));
			}

		}

		while (!tempmessage.isEmpty()) {
			finalmessage.push(tempmessage.pop());
		}
		while (!finalmessage.isEmpty()) {
			fin += finalmessage.pop();
		}

		return fin;

	}

	
	public boolean bracketBalance(String s ) {
		
		String prev = ""; 
		
		Stack<String>  brackets = new Stack<String>();
		
		for(int i = 0; i < s.length(); i ++) {
			
			if(match(prev, s.substring(i, i+1))){
				
				brackets.pop();
				
				if(brackets.size() > 0) {
					prev = brackets.peek();
				}else {
					prev = "";
				}
					
			}else if("()[]".contains(s.substring(i , i+ 1)) ) {
				
				brackets.push(s.substring(i, i+1));
				prev = brackets.peek()	;		}
		
		}
		
		if(brackets.size() == 0) {
			return true;
			
		}else {
			return false;
		}
	}
		
	
	private boolean match(String one, String two) {
		
		if((one.equals("(") && two.equals(")") ) || one.equals("[") && two.equals("]") ) {
			return true;
		}
		else {
		return false;
		}
		
	}
}
