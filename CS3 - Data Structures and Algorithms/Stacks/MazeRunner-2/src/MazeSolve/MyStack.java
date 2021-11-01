package MazeSolve;

public class MyStack
{
	Square[] stak
	int size;
	
	public MyStack()
	{
		this(2);
	}
	
	public MyStack(int InitialCapacity)
	{
		stack = new Square[InitialCapacity];
	}
	
	public boolean isEmpty()
	{
		if(size==0)
			return true;
		return false;
	}
	
	public Square peek()
	{
		return stack[size];
	}
	
	public Square pop()
	{
		Square s = stack[size];
		stack[size] = null;
		size--;
		return s;
	}
	
	public void push(Square item)
	{
		size++;
		if(size +1 > stack.length)
		{
			doubleCapacity();
		}
		stack[size] = item;
	}
	
	private void doubleCapacity()
	{
		Square[] list2 = new Square[stack.length*2];
		
		for(int i = 0; i < stack.length; i++)
		{
			list2[i] = stack[i];
		}
		stack = list2;
	}
	
	@Override
	public String toString()
	{
		String s = "";
		for(int i = size; i > 0; i--)
		{
			if(i == size)
				s+= stack[i] + "        <------ TOP";
			else
			s+="\n" + stack[i];
		}
		s+="\n--------";
		return s;
	}
}
