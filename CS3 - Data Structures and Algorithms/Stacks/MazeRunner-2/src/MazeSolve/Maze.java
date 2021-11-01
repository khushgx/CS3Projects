package MazeSolve;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Maze 
{
	Square[][] array;
	private static Square Start;
	private static Square Exit;
	
	public Maze()
	{
		array = new Square[0][0];
		loadMaze("maze-2");
	}
	
	public boolean loadMaze(String filename)
	{
		try {
		      File myObj = new File(filename);
		      Scanner myReader = new Scanner(myObj);
		      array = new Square[myReader.nextInt()][myReader.nextInt()];
		      int Row = 0;
		      int Column = 0;
		      while (myReader.hasNextInt()) 
		      {
		    	  
		        array[Row][Column] = new Square(Row, Column, myReader.nextInt());
		        if(array[Row][Column].getType() == 2)
		        {
		        	Start = array[Row][Column];
		        }
		        if(array[Row][Column].getType() == 3)
		        {
		        	Exit = array[Row][Column];
		        }
		    	  
		    	  if(Column == array[Row].length-1)
		    	  {
		    		Column = -1;
		    		Row++;
		    	  }
		    	  Column++;
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		      return false;
		    }
		return true;
	}
	
	public List<Square> getNeighbors(Square s)
	{
		ArrayList<Square> list = new ArrayList<Square>(0);
		System.out.println(array.length + " " + array[0].length);
		if(s.getRow()-1 >= 0)
		{
			list.add(array[s.getRow()-1][s.getCol()]);
		}
		
		if(s.getCol()+1 <= array[0].length-1)
		{
			list.add(array[s.getRow()][s.getCol() +1]);
		}
		
		if(s.getRow()+1 <= array.length-1)
		{
			list.add(array[s.getRow()+1][s.getCol()]);
		}
		
		if(s.getCol()-1 >= 0)
		{
			list.add(array[s.getRow()][s.getCol()-1]);
		}
		return list;
	}
	

	public Square getStart() {
		return Start;
	}

	public Square getExit() {
		return Exit;
	}

	@Override
	public String toString() {
		String s = "";
		for(int row = 0; row < array.length; row++)
		{
			s += "\n";
			for(int col = 0; col < array[row].length; col++)
			{
				s+= array[row][col].getStatus() + " ";
			}
		}
		return s;
	}

	public void reset() {
//		for(int x = 0; x < array.length; x++)
//		{
//			for(int y = 0; y < array.length; y++)
//			{
//				array[x][y].reset();
//			}
//		}
		
	}

}
