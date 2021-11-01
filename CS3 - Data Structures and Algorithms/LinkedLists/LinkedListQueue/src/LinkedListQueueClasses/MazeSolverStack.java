package LinkedListQueueClasses;

public class MazeSolverStack extends MazeSolver {
	
	MyStack stack;

	public MazeSolverStack(Maze maze) {
		super(maze);
		
	}

	@Override
	void makeEmpty() {
		stack = new MyStack();
		
	}

	@Override
	boolean isEmpty() {
		
		if(stack.isEmpty())
			return true;
		return false;
	}

	@Override
	void add(Square s) {
		 stack.push(s);
		
	}

	@Override
	Square next() {
		return stack.pop();
	}

}
