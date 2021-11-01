package LinkedListQueueClasses;

import java.util.Objects;

public class Square {

	public final static int EMPTY = 0;
	public final static int WALL = 1;
	public final static int START = 2;
	public final static int EXIT = 3;

	public final static char WORKING = 'o';
	public final static char EXPLORED = '.';
	public final static char ON_EXIT_PATH = 'x';
	public final static char UNKNOWN = '_';
	

	private int row, col;
	private int type;
	private char status;
	private Square previous;

	public Square(int row, int col, int type) {
		this.row = row;
        this.col = col;
        this.type = type;
        this.previous = null;
        
        
        status = UNKNOWN;
		 
	}
	
	


	@Override
	public String toString() {
		String s = "";
		
		if(type == EMPTY) {
			s = status + ""; 
			
		}
		
		if(type == WALL) {
			
			s = "#";
			
		}
		if(type == START) {
			
			s = "S";
			
		}
		if(type == EXIT) {
			
			s = "E";
			
		}
		
		
		return s;
	
	}







	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Square other = (Square) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}



	public int getRow() {
		return this.row;
	}

	public int getCol() {
		return this.col;
	}

	public int getType() {
		return this.type;
	}

	public char getStatus() {
		return this.status;
	}

	public void setRow(int row) {
		this.row = row;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public void setStatus(Character status) {
		this.status = status;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Square getPrev() {
		return previous;
	}
	public void setPrevious(Square previous) {
		this.previous = previous;
	}
	public boolean isStart() {
		if (type == START) {
			return true;
		}
		return false;
	}




	public boolean isFinish() {
		if (toString().equals("E")) {
			return true;
		}
		return false;
	}




	
}
