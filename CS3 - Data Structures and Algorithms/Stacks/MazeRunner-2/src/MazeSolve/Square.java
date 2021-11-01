package MazeSolve;

public class Square 
{
	
	private int row, col;
	private int type;
	private String status;
	
	public Square(int Row, int Col, int Type)
	{
		row = Row;
		col = Col;
		type = Type;
		switch(type)
		{
		case 0:
			status = "_";
			break;
		case 1:
			status = "#";
			break;
		case 2:
			status = "S";
			break;
		case 3:
			status = "E";
			break;
		}
	}
	
	public void reset()
	{
		//status = " ";
	}

	@Override
	public String toString() {
		return "Square [row=" + row + ", col=" + col + ", type=" + type + ", status=" + status + "]";
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
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
	
	
	
	

}
