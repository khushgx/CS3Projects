package LinkedListQueueClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Maze {
	
	private Square[][] maze;
	
	private static Square start;
	
	private static Square end;
	
	
	
	
	public Maze() {
		
		
	}
	 public boolean loadMaze(String filename) {
		 
		 
		 
		 try {
			 
			 int row = 0;
			 int col = 0;
			 
			 Scanner sc = new Scanner(new File(filename));
			 maze = new Square[sc.nextInt()][sc.nextInt()];
			 
			 while(sc.hasNextInt()) {
				 
				 maze[row][col] = new Square(row, col, sc.nextInt());
				 
				 if(maze[row][col].getType() == 2) {
					 
					 start = maze[row][col];
				 }
				 
				 if(maze[row][col].getType() == 3) {
					 
					 end = maze[row][col];
				 }
				 
				 if(col == maze[row].length - 1) {
					 col = -1;
					row++;
				 }
				 col++;
			 }
			 sc.close();
			
		 }
		 catch(FileNotFoundException e) {
			 
			 System.out.println("Wrong File ");
			 return false;
			 
			 
			 
		 }
		 return true;
		 
		 
		
	 }
	 public List<Square> getNeighbors(Square s){
		 
		 ArrayList<Square> list = new ArrayList<>();
			
			if(s.getRow()-1 >= 0)
			{
				list.add(maze[s.getRow()-1][s.getCol()]);
				
			}
			
			if(s.getCol()+1 < maze[0].length)
			{
				list.add(maze[s.getRow()][s.getCol() +1]);
			}
			
			if(s.getRow()+1 < maze.length)
			{
				list.add(maze[s.getRow()+1][s.getCol()]);
			}
			
			if(s.getCol()-1 >= 0)
			{
				list.add(maze[s.getRow()][s.getCol()-1]);
			}
			return list;
	 }
	 
	 @Override
	 public String toString()
	    {
	        String myString = "";
	        for(int i = 0; i < maze.length; i ++){
	        	myString += "\n";
	            for(int j = 0; j <maze[i].length; j++)
	            {
	                myString += maze[i][j].toString() + " ";
	            }
	            
	        }
	        return myString;
	    }
	 
	  public void reset()
	    {
		  int row = 0;
		  int col = 0;
	        for(int x=0;x< maze.length;x++)
	        {
	            for(int z=0;z<maze[x].length;z++)
	            {
	            	if(maze[x][z].getType() == Square.EMPTY) {
	        			maze[x][z] = new Square(x,z, 0);
	        			
	        		}
	            	if(maze[x][z].getType() == Square.WALL) {
	        			maze[x][z] = new Square(x,z, 1);
	        			
	        		}
	        		
	            	if(maze[x][z].getType() == Square.START) {
	        			maze[x][z] = new Square(x,z, 2);
	        			
	        		}
	        		
	            	if(maze[x][z].getType() == Square.EXIT) {
	        			maze[x][z] = new Square(x,z, 3);
	        			
	        		}
	        		
	        		
	        		
	            }
	        }
	    }
	  
	 public Square getStart()
	    {
	        return start;
	    }
	 
	 public Square getExit()
	    {
		 for (int row = 0; row < maze.length; row++) {
				for (int col = 0; col < maze[row].length; col++) {
					if (maze[row][col].isFinish()) {
						return maze[row][col];
					}
				}
			}
			return null;
	    }

}
