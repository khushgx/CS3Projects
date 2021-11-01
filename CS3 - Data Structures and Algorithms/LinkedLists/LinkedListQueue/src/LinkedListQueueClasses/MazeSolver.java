package LinkedListQueueClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class MazeSolver {

	private Maze mymaze;

	public boolean solved;
	public boolean solveable;

	Square currentSquare;

	public MazeSolver(Maze Maze) {
		mymaze = Maze;
		makeEmpty();
		add(mymaze.getStart());
		
	}

	abstract void makeEmpty();

	abstract boolean isEmpty();

	abstract void add(Square s);

	abstract Square next();

	public boolean isSolved() {

		if (isEmpty() || solved) {

			return true;
		}

		if (isEmpty()) {
			solveable = false;
		}

		return false;

	}

	public void step() {

		if (isEmpty()) {
			return;
		}

		currentSquare = next();

		ArrayList<Square> check =   (ArrayList<Square>) mymaze.getNeighbors(currentSquare);
		

		for (Square s: check) {

			currentSquare.setStatus('.');

			if (s.getType() == Square.EXIT) {
				solved = true;
				s.setPrevious(currentSquare);
     			System.out.println(s);
     			System.out.println(s.getPrev());
				return;
			}

			 if (s.getStatus() == Square.UNKNOWN && s.getType() == Square.EMPTY) {
				
				
				s.setStatus('o');
				
				if(s.getPrev() == null) {
				s.setPrevious(currentSquare);
				add(s);
				}
				
			}

		}
	}

	public String getPath() {
		String s = "";
		Stack<Integer> row = new Stack();
		Stack<Integer> col = new Stack();
		if (solved) {
			Square current = this.mymaze.getExit();
			while (true) {
				
				row.push(current.getRow());
				col.push(current.getCol());
				current = current.getPrev();
				
				
				
				if (current.isStart()) {
					break;
				}
			}
			
			while(!row.isEmpty() && !col.isEmpty()) {
				
				s += "[" + row.pop() + " , " + col.pop() + "]";
			}
			return s;

			
		} else if (!solveable) {
			return "not solved yet";
		} else {
			return "Unsolveable";
		}
	}

	public void solve() {
		while (!(isSolved())) {
			step();
		}
	}
}
