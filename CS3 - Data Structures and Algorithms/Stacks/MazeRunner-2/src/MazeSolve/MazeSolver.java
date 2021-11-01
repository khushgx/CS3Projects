package MazeSolve;

import java.util.ArrayList;

public abstract class MazeSolver 
{

	Maze maze;
	public boolean solved, solveable;
	Square currentSquare;
	
	public MazeSolver(Maze Maze)
	{
		maze = Maze;
		makeEmpty();
		add(maze.getStart());
	}
	
	abstract void makeEmpty();
	
	abstract boolean isEmpty();
	
	abstract void add(Square s);
	
	abstract Square next();
	
	public boolean isSolved()
	{
		if(solved)
			return true;
		return false;
	}
	
	public void step()
	{
		if(isEmpty()) {
			return;
		}
		
		if(currentSquare!= null)
		{
			if(!currentSquare.equals(maze.getStart()))
			currentSquare.setStatus(".");
		}
		
		currentSquare = next();
		if(!currentSquare.equals(maze.getStart()))
		currentSquare.setStatus("O");
		ArrayList <Square> list = (ArrayList<Square>) maze.getNeighbors(currentSquare);
		for(int i = 0; i < list.size(); i++)
		{
			if(!list.get(i).getStatus().equals(".") && !list.get(i).getStatus().equals("#") && !currentSquare.equals(maze.getStart()))
			{
				add(list.get(i));
				if(!list.get(i).equals(list.get(i)) && !list.get(i).equals(maze.getStart()))
				list.get(i).setStatus("O");
			}
			
			
		}

	}
	
	
	public String getPath()
	{
		if(solved)
		{
			return "Solved";
		}
		else if(!solveable)
		{
			return "not yet solved";
		}
		else
		{
			return "Unsolveable";
		}
	}
	
	public void solve()
	{
		
	}
}
