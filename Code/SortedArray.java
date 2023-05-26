
public class SortedArray<T extends Comparable<T>>{
	
	protected final int DEFCAP = 1000;
	protected T[] elements;
	protected Customer[] customer;
	protected int topIndex = -1;
	
	protected int location;
	protected  boolean found;
	
	
	public SortedArray(UnsortedArray<T> unsorted)					//Constructor
	
	{
		try															//if unsorted array is an array of Generic type
		{	
			
			elements = (T[]) new Comparable[unsorted.size()];		

			for (int i=0; i<elements.length; i++)
			{
				add( unsorted.DeepCopy()[i] );						//deep copy of unsorted array
			}

			QuickSort(elements, 0, topIndex);						//perform quick sort to sort array
		}

		catch(ArrayStoreException o)								//if unsorted array is an array of Customer objects
		{
			customer = new Customer[unsorted.size()];
			
			for (int i=0; i<customer.length; i++)
			{
				add( unsorted.Deepcopy()[i] );						//deep copy of unsorted array
			}
			
			QuickSort(customer, 0, topIndex);						//perform quick sort to sort array
		}
	}
	

	
	private void QuickSort(T[] elements, int first, int last)		//Quick Sort method
	{		
		if (first < last)
		{
			int SplitPoint;
			SplitPoint = Split(elements, first, last);
			
			QuickSort(elements, first, SplitPoint - 1);				//sort left half
			QuickSort(elements, SplitPoint + 1, last);				//sort right half
		}
	}
	
	private int Split(T[] elements, int first, int last)			//splits array into half
	{
		T splitpoint = elements[last];								//last element is the Split point
		
		int i = first-1;
		
		for(int j = first; j <= last - 1; j++)
	    {
			if ( elements[j].compareTo(splitpoint) <= 0 )
	        {
				i++; 
	            swap(elements, i, j);
	        }
	    }
		swap(elements, i + 1, last);
	    return (i + 1);
	}
	
	private void swap(T[] elements, int x, int y)					//swaps position element at input index
	{
	    T temp = elements[x];
	    
	    elements[x] = elements[y];
	    elements[y] = temp;
	}
	
	public void add(T info)											//add element at the end of the array
	{
		if (isFull())
			throw new OverflowException("List is Full !");
		else
		{
			topIndex++;
			elements[topIndex] = info;
		}
	}
	
	private void find(T target)										//finds target element in array
	{
		location = 0;
		found = false;
		
		for(int i=0; i<=topIndex; i++)
		{
			//System.out.println("here");
			if (elements[i].equals(target))
			{
				found = true;
				location = i;
				break;
			}
		}
	}
	
	public boolean contains(T target)
	{
		find(target);
		return found;
	}
	
	public T get(T target)
	{
		find(target);
		if (found)
			return elements[location];
		else
			return null;
	}
	
	private int BinarySearch(T[] array, T target, int first, int last)
	{
		int mid = (last+first)/2;									//defines a mid value
		
		if(first > last)											//if first > last then ID was not found
			return -1;

		if (array[mid].equals(target))								//target value found, returns index of target value
			return mid;
		
		else if (target.compareTo(array[mid]) < 0) 					//if target is in the 1st half
			return BinarySearch(array,target, first, mid -1);		//eliminates 2nd half and calls function recursively
		
		else														//if target is in the 2nd half
			return BinarySearch(array,target, mid +1, last);		//eliminates 1st half and calls function recursively

	}
	
	public boolean BinaryContain(T target)
	{
		int x = BinarySearch(elements, target, 0, topIndex);

		if (x == -1)
			return false;
		else
			return true;
	}
	
	public T BinaryGet(T target)
	{
		int x = BinarySearch(elements, target, 0, topIndex);
		if (x == -1)
			return null;
		else
			return elements[x];
	}
	
	public boolean isEmpty()
	{
		if (topIndex == -1)
			return true;
		else
			return false;
	}
	
	public boolean isFull()
	{
		if (topIndex == elements.length -1)
			return true;
		else
			return false;
	}
	
	public int size()
	{
		return elements.length;
	}
	
	public void print()
	{
		for(int i=0; i<=topIndex; i++)
		{
			System.out.println( elements[i]);
		}
		
		System.out.println();
	}
//********************************************************************************************************************//	
	
	private void QuickSort(Customer[] customer, int first, int last)
	{		
		if (first < last)
		{
			int SplitPoint;
			SplitPoint = Split(customer, first, last);
			
			QuickSort(customer, first, SplitPoint - 1);
			QuickSort(customer, SplitPoint + 1, last);
		}
	}
	
	private int Split(Customer[] customer, int first, int last)
	{
		int splitpoint = customer[last].getID();
		
		int i = first-1;
		
		for(int j = first; j <= last - 1; j++)
	    {
			if ( customer[j].getID() <= splitpoint)
	        {
				i++; 
	            swap(customer, i, j);
	        }
	    }
		swap(customer, i + 1, last);
	    return (i + 1);
	}
	
	private void swap(Customer[] customer, int x, int y)
	{
	    Customer temp = customer[x];
	    
	    customer[x] = customer[y];
	    customer[y] = temp;
	}
	
	public void add(Customer info)
	{
		if (IsFull())
			throw new OverflowException("List is Full !");
		else
		{
			topIndex++;
			customer[topIndex] = info;
		}
	}
	
	private void Find(int target)
	{
		location = 0;
		found = false;
		
		for(int i=0; i<=topIndex; i++)
		{
			if (customer[i].getID() == target)
			{
				found = true;
				location = i;
				return;
			}
		}
	}
	
	public boolean Contains(int target)
	{
		Find(target);
		return found;
	}
	
	public Customer Get(int target)
	{
		Find(target);
		if (found)
			return customer[location];
		else
			return null;
	}
	
	private int BinarySearch(Customer[] array, int target, int first, int last)
	{
		int mid = (last+first)/2;									//defines a mid value
		
		if(first > last)											//if first > last then ID was not found
			return -1;

		if (array[mid].getID() == target)							//target value found, returns index of target value
			return mid;
		
		else if (target < array[mid].getID()) 						//if target is in the 1st half
			return BinarySearch(array,target, first, mid -1);		//eliminates 2nd half and calls function recursively
		
		else														//if target is in the 2nd half
			return BinarySearch(array,target, mid +1, last);		//eliminates 1st half and calls function recursively

	}

	public boolean BinaryContains(int target)
	{
		int x = BinarySearch(customer, target, 0, topIndex);
		if (x == -1)
			return false;
		else
			return true;
	}
	
	public Customer BinaryGets(int target)
	{
		int x = BinarySearch(customer, target, 0, topIndex);
		if (x == -1)
			return null;
		else
			return customer[x];
	}
	
//********************************************************************************************************************//
	public boolean IsEmpty()
	{
		if (topIndex == -1)
			return true;
		else
			return false;
	}
	
	public boolean IsFull()
	{
		if (topIndex == customer.length -1)
			return true;
		else
			return false;
	}
	
	public int Size()
	{
		return customer.length;
	}
	
	public void Print()
	{
		for(int i=0; i<=topIndex; i++)
		{
			System.out.println(customer[i].getID() + "\t" + customer[i].getFirst() + "\t\t" + customer[i].getSecond());
		}
		
		System.out.println();
	}


}
