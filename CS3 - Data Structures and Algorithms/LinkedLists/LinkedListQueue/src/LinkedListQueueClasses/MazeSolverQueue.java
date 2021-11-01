package LinkedListQueueClasses;

public class MazeSolverQueue extends MazeSolver {

	MyQueue<Square> queue;

	public MazeSolverQueue(Maze maze) {
		super(maze);
		
	}

	@Override
	void makeEmpty() {
		queue = new MyQueue<>();
		
	}

	@Override
	boolean isEmpty() {
		
		if(queue.isEmpty())
			return true;
		return false;
	}

	@Override
	void add(Square s) {
		 queue.offer(s);
		
	}

	@Override
	Square next() {
		return queue.poll();
	}


}
