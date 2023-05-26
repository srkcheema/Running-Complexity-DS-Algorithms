
public class UnsortedArray<T> {							//Unsorted Linked list
	
	protected final int DEFCAP = 100;					//Default capacity of an Array
	protected T[] elements;								//Generic Array
	protected int topIndex = -1;						//Points towards the top index of the array
	
	protected int location;								//location variable by Search methods
	protected  boolean found;							//Boolean used by Search methods
	
	public UnsortedArray()								//Constructor default size
	{
		elements = (T[]) new Object[DEFCAP];	
	}
	
	public UnsortedArray(int maxsize)					//Constructor with input specified size
	{
		elements = (T[]) new Object[maxsize];
	}
	
	public void add(T info)								//Adds a Generic input into the Unsorted Array
	{
		if (isFull())
			throw new OverflowException("Array is Full !");
		else
		{
			topIndex++;									//increment topIndex
			elements[topIndex] = info;					//add element at the end of the array
		}
	}
	
	public boolean remove(T remove)						//find input T element & remove it, if it's in the Array
	{
		if (isEmpty())									//if Array list is Empty, throw Underflow Exception
			throw new UnderflowException("Array is Empty !");
		
		find(remove);									//call find Method
		if (found)										//if element is found in the list
		{
			elements[location] = elements[topIndex];	//replace with last element in the Array
			elements[topIndex] = null;					//remove last element
			topIndex--;									//decrease topIndex once element is removed
		}
		
		return found;									//return found boolean 
	}
	
	private void find(T target)							//find the target element in the Array
	{
		location = 0;
		found = false;
		
		for(int i=0; i<=topIndex; i++)					//loop until last element in the array
		{
			if (elements[i].equals(target))				//if target is found
			{
				found = true;							//found is equal to true
				location = i;							//update location variable
				return;									//exit method
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
	
	public boolean isEmpty()
	{
		if (topIndex == elements.length)
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
		return topIndex+1;
	}
	
	public void print()
	{
		for(int i=0; i<=topIndex; i++)
		{
			System.out.println(elements[i] + " ");
		}
		
		System.out.println();
	}
	
	public boolean Remove(int element)
	{
		if (isEmpty())
			throw new UnderflowException("Array is Empty !");
		
		Find(element);
		if (found)
		{
			elements[location] = elements[topIndex];
			elements[topIndex] = null;
			topIndex--;
		}
		
		return found;
	}
	
	private void Find(int target)
	{
		location = 0;
		found = false;
		
		for(int i=0; i<=topIndex; i++)
		{
			if (((Customer) elements[i]).getID() == target)
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
	
	public T Get(int target)
	{
		Find(target);
		if (found)
			return elements[location];
		else
			return null;
	}
	
	public void Print()
	{
		for(int i=0; i<=topIndex; i++)
		{
			System.out.println(((Customer) elements[i]).getID() + "\t\t" + ((Customer) elements[i]).getFirst() + "\t\t" + ((Customer) elements[i]).getSecond());
		}
		
		System.out.println();
	}
	
	protected T[] DeepCopy()
	{
		T[] copy = (T[]) new Comparable[elements.length];
	
		for (int i=0; i<elements.length; i++)
		{
			copy[i] = elements[i];
		}
		return copy;
	}
	
	protected Customer[] Deepcopy()
	{
		Customer[] copy = new Customer[elements.length];
		
		for (int i=0; i<elements.length; i++)
		{
			copy[i] = (Customer) elements[i];
		}
		return copy;
	}

}
