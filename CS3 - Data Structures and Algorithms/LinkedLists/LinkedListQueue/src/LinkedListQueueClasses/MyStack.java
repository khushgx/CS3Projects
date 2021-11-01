package LinkedListQueueClasses;

public class MyStack
{
	Square[] stack;
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
       int y = stack.length * 2;
       Square[] x = new Square[y];
       System.arraycopy(stack, 0, x, 0, stack.length);
       stack = x;
    }
    
    public int size() {
    	return size;
    }
    
    @Override
    public String toString()
    {   String myString = "";
        for (int x = size-1; x>=0;x--)
        {
            myString += stack[x] +"\n";
        }
        return myString;
    }
	
	public void clear() {
		while(stack.length >= 0) {
			pop();
		}
		
	}
}