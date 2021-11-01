package NumberListClasses;



public class NumberList {
	
	private Integer[] list; 
	private int size;
	
	
	
	public NumberList() {
		
		list = new Integer[2];
		size = 0;
		
	}
	
	public int size() {
		return this.size;
	}
	
	public int length() {
		return list.length;
	}
	
	public boolean isEmpty() {
		
		if (size != 0) {
		return false;
		}
		
		return true;
		
	}
	
	public String toString() {
		
		String s = "[ ";
		for (int i = 0; i < size; i++ ) {
			
			if(i < size - 1 && list[i] != null) {
			s = s + list[i] + " , ";
			}
			
			if(i == size - 1 && list[i] != null) {
				s = s + list[i];
			}
		}
		s = s + " ]";
		
		return s;
	}
	
	public void doubleCapacity() {
		
		Integer[] newArray = new Integer[size * 2];
		
		for(int i = 0; i < list.length; i++) {
			newArray[i] = list[i];
		}
		list = newArray;

		
	} 
	
	public void add(int index, Integer val) {

		
		
		if(index < 0 || index > size) {
			 throw new IndexOutOfBoundsException();
		}
		size++;
		if(size >= list.length ) {
			doubleCapacity();
			
		}
		
		for(int i = size - 1 ; i  > index ; i --) {
			
			 if(i-1>= 0) {
			
			list[i] = list[i-1];
			
			 }
			
		}
		
		list[index] = val;
		
			
	
        
        
    }
	
	
	
	public boolean add(Integer element) {
		
		add(size, element);
		return true;
	}
	
	
	
	public Integer get(int index) {
		
		if(index < 0 || index > size) {
			 throw new IndexOutOfBoundsException();
		}
		
		return list[index];
	}
	
	public Integer set(int index, Integer val) {
		
		Integer oldval = null;
		if(index < 0 || index > size) {
			 throw new IndexOutOfBoundsException();
		}
		
		for(int i = 0; i < size; i++) {
			if(i == index) {
				oldval = list[i];
				list[i] = val;
			}
		}
		
		return oldval;
		
	}
	
	public Integer remove(int index) {
		
		Integer oldval = null;
		
		
		if(index < 0 || index > size) {
			 throw new IndexOutOfBoundsException();
		}
		
		
		for(int i = index; i < size - 1; i++) {
			
			oldval = list[index];
			list[i] = list[i+1];
			list[index + 1] = null;
				
		}
		
		size--;
		
		
		return oldval;
	}
}
