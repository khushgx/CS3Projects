package MiniHeapClasses;

public class MinHeap {
	
	Integer[] heap;
	
	int size;
	
	static final int DEFAULT_CAPACITY = 8;
	
	
	public MinHeap() {
		this(DEFAULT_CAPACITY);
		
	}
	
	public MinHeap(int userSize) {
		
		heap = new Integer[userSize];
		size = 0;
		
	}
	
	public MinHeap(Integer... nums) {
		
		for(Integer val: nums) {
			buildHeap(val);
		}
		
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		
		return size == 0;
		
	}
	
	public int peekMinimum() {
		return heap[1];
	}
	
	public int getLeftChildIndex(int index) {
		
		return 2 * index;
	}
	
	public int getRightChildIndex(int index) {
		
		return 2 * index + 1;
	}
	
	public int getParentIndex(int index) {
		return index/2;
	}

	private void doubleCapacity() {
		
		 int y = heap.length * 2;
	       Integer[] x = new Integer[y];
	       System.arraycopy(heap, 0, x, 0, heap.length);
	       heap = x;
		
		
	}
	
	public void insert(int value) {
		
		if(size >= heap.length - 1) {
			doubleCapacity();
		}
		
		size++;
		heap[size] = value; 
		bubbleUp(size);
		
		
		
		
		
	}

	private void bubbleUp(int index) {
		
		int parentIndex = getParentIndex(index);
		
		if(index < 0 || parentIndex <= 0) {
			return;
		}
		int parentVal = heap[parentIndex];
		int val = heap[index];
		if(heap[parentIndex] > heap[index]) {
			heap[parentIndex] = val;
			heap[index] = parentVal;
			index = getParentIndex(index);
			bubbleUp(index);
		}
	}
	
		
	public int popMin() {
		
		int x = heap[1];
		
		if(size == 0) {
			throw new Error("Heap is empty");
			
		}
		
		else {
			
			
			heap[1] = heap[size];
			size --;
			
			if(size > 0) {
				siftDown(1);
			}
		}
		
		return x;
	}
		
		
		
	
	
	private void siftDown(int i) {
		int minIndex, rightChildIndex, leftChildIndex, tmp;
		
		rightChildIndex = getRightChildIndex(i);
		leftChildIndex = getLeftChildIndex(i);
		
		if(rightChildIndex > size) {
			if(leftChildIndex > size) {
				return;
			}else {
				minIndex = leftChildIndex;
			}
		} else {
			if(heap[leftChildIndex] <= heap[rightChildIndex]) {
				minIndex = leftChildIndex;
			} else {
				minIndex = rightChildIndex;
			}
		}
		
		if(heap[i] > heap[minIndex]) {
			
			tmp = heap[minIndex];
			heap[minIndex] = heap[i];
			heap[i]= tmp;
			siftDown(minIndex);
		}
		
	}
	
	public void buildHeap(int i) {
		
		int startIndex = size/2;
		
		
		for( int index  = startIndex; index > 0; index--) {
			siftDown(index);
			
		}
		
	}

	@Override
	public String toString()
	{
		String output = "";
		
		for (int i = 1; i <= getSize(); i++) 
			output += heap[i] + ", ";

		return output.substring(0, output.lastIndexOf(",")); //lazily truncate last comma
	}

	/** method borrowed with minor modifications from the internet somewhere, for printing */
	public void display() {
		int nBlanks = 32, itemsPerRow = 1, column = 0, j = 1;
		String dots = "...............................";
		System.out.println(dots + dots);      
		while (j <= this.getSize())
		{
			if (column == 0)                 
				for (int k = 0; k < nBlanks; k++)
					System.out.print(' ');

			System.out.print((heap[j] == null)? "" : heap[j]);
			
			if (++column == itemsPerRow) {
				nBlanks /= 2;                 
				itemsPerRow *= 2;             
				column = 0;                   
				System.out.println();         
			}
			else                             
				for (int k = 0; k < nBlanks * 2 - 2; k++)
					System.out.print(' ');
			
			j++;
		}
		System.out.println("\n" + dots + dots); 
	}


	
	
}
