package MyStackClasses;

import java.util.EmptyStackException;

public class MyStack {
    private Integer[] stack;
    private int size = 0;
    MyStack()
    {
        this(2);
    }
    MyStack(int initCap)
    {
        stack = new Integer[initCap];
    }
    public boolean isEmpty()
    {
        if(size == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public Integer peek()
    {
        
        if(isEmpty() == true)
        {
            throw new EmptyStackException();
        }
        else
        {
            return stack[size-1] ;
        }
            
    }
    public Integer pop()
    {
        int popVal = 0;
        if(isEmpty() == true)
        {
            throw new EmptyStackException();
        }
        else
        {
            popVal = stack[size-1];
            stack[size-1] = null;
            size--;
            return popVal;
        }
        
    }
    
   public void push(Integer item)
    {
        
        if (size==0 || size<=stack.length)
        {       
            doubleCapacity();
        }
         
        stack[size] = item;
        size++;

    }
    
    private void doubleCapacity()
    {
       int y = stack.length * 2;
       Integer[] x = new Integer[y];
       System.arraycopy(stack, 0, x, 0, stack.length);
       stack = x;
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
}