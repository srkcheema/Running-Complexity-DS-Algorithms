
public class UnsortedLinkedlist<T>{						//Unsorted Linked list
	
	protected LLNode<T> head;							//Points towards the start of Linked list
	protected LLNode<T> tail;							//Points towards the end of Linked list
	protected int numElements = 0;						//Keeps track of total elements in Linked list
	
	protected boolean found;							//Boolean used by Search methods
	protected LLNode<T> previous;						//LLNode used by Search methods
	protected LLNode<T> location;						//LLNode used by Search methods
	
	public UnsortedLinkedlist()							//Constructor 
	{
		head = null;
		tail = null;
	}
	
	public void add(T info)								//Adds a Generic input into the Linked List
	{
		LLNode<T> newNode = new LLNode<T>(info);		//Create a newNode to add
		
		if (isEmpty())									//if Linked List is Empty
		{
			head = newNode;								//head and tail points towards the newNode
			tail = newNode;
		}
		
		else											//if Linked list is not Empty
		{
			tail.setLink(newNode);						//Add newNode at the end of Linked list
			tail = newNode;								//tail points towards the newNode
		}
		
		numElements++;									//Update count
	}
	
	public boolean remove(T remove)						//find input T element & remove it, if it's in the Linked list
	{
		if (isEmpty())									//if Linked list is Empty, throw Underflow Exception
			throw new UnderflowException("Linked list is Empty !");
		
		find(remove);									//call find Method
		if (found)										//if element is found in the list
		{
			if (head == tail)							//if it's the only element in the list
			{
				head = null;							//remove the element, Linked list is Empty
				tail = null;
			}
			
			else if (location == head)					//if the element is the first element in the Linked list
				head = head.getLink();					//head points toward the 2nd element, 1st element is removed
			
			else if (location == tail)					//if the element is the last element in the list
			{
				tail = previous;						//tail points toward the 2nd last element
				previous.setLink(null);					//last element is removed
			}
			
			else										//if the element is in-between the list
				previous.setLink(location.getLink());	//element is removed
			
			numElements--;								//Update count
		}
		return found;									//return true if element is removed, false otherwise
	}
	
	private void find(T target)							//find the target element in the Linked list
	{
		location = head;
		found = false;
		
		while (location != null)						//loops until no next node in linked list
		{
			if (location.getInfo().equals(target))		//if location node equals target
			{
				found = true;							//Update found to true
				return;									//Exit method 
			}
			
			else										//if target not found
			{
				previous = location;					//previous node points to location node
				location = location.getLink();			//location Node moves to the next node
			}
		}
	}
	
	public boolean contains(T target)					
	{
		find(target);									//find target in the Linked list
		return found;									//returns true if element is found, false otherwise
	}
	
	public T get(T target)
	{
		find(target);									//find target in the Linked list
		if (found)										//if found
			return location.getInfo();					//return a copy of the element
		else
			return null;								//return null if element is not in the Linked list
	}
	
//********************************************************************************************************************//
	
	public void add(Customer customer)					//Add a Customer Object into the Linked List
	{
		LLNode<T> newNode = new LLNode<T>(customer);	//Create a newNode
		
		if (isEmpty())									//if Linked List is Empty
		{
			head = newNode;								//head and tail points towards the newNode
			tail = newNode;
		}
		
		else											//if Linked list is not Empty
		{
			tail.setLink(newNode);						//add newNode at the end of Linked list
			tail = newNode;
		}
		
		numElements++;									//Update count
	}
	
	public boolean Remove(int element)					//find input ID & remove the Object, if in the Linked list
	{
		if (isEmpty())									//if Linked list is Empty, throw Underflow Exception
			throw new UnderflowException("Linked list is Empty !");
		
		Find(element);									//call Find method
		if (found)										//if Object is found in the list
		{
			if (head == tail)							//if it's the only Object in the list
			{
				head = null;							//remove the Object, Linked list is Empty
				tail = null;
			}
			
			else if (location == head)					//if the Object is the first Object in the list
				head = head.getLink();					//head points toward the 2nd Object, 1st Object is removed
			
			else if (location == tail)					//if it's the last Object in the list
			{
				tail = previous;						//tail points toward the 2nd last Object
				previous.setLink(null);					//last Object is removed
			}
			else										//if the Object is in-between the list
				previous.setLink(location.getLink());	//Object is removed
			
			numElements--;								//Update count
		}
		return found;									//return true if Object is removed, false otherwise
	}
	
	private void Find(int target)						//find the target Customer ID in the Linked list
	{
		location = head;
		found = false;
		
		while (location != null)						//loops until no next node in linked list
		{
			if (location.getInfoo().getID() == target)	//if Customer ID in the location node, equals target
			{
				found = true;							//Update found to true
				return;									//Exit method
			}
			
			else										//if target not found
			{
				previous = location;					//previous node points to location node
				location = location.getLink();			//location Node moves to the next node
			}
		}
	}
	
	public boolean Contains(int target)
	{
		Find(target);									//find target Customer ID in the Linked list
		return found;									//return true if Customer ID is found, false otherwise
	}
	
	public Customer Get(int target)
	{
		Find(target);									//find target Customer ID in the Linked list
		if (found)										//if found
			return location.getInfoo();					//return a copy of the Object
		else
			return null;								//return null if Customer ID is not in the Linked list
	}
	
//********************************************************************************************************************//
	
	public boolean isEmpty()							//returns true is Linked list is Empty, false otherwise
	{
		if (numElements == 0)
			return true;
		else 
			return false;
	}
	
	public boolean isFull()								//returns false, as Linked list can never be full
	{
		return false;
	}
	
	public int size()									//returns the size of the Linked list
	{
		return numElements;
	}
	
	public void print()									//Prints the info in the node
	{
		location = head;
		
		while(location != null)
		{
			System.out.println(location.getInfo());
			location = location.getLink();
		}
		System.out.println();
	}
	
	public void Print()									//Prints Customer ID, First Name & Second Name
	{
		location = head;

		while(location != null)
		{
			System.out.println(location.getInfoo().getID() + "\t\t" + location.getInfoo().getFirst() + "\t\t"
																			+ location.getInfoo().getSecond());
			location = location.getLink();
		}
		System.out.println();
	}
	
	protected LLNode<T> getHead()						//returns the Head Node 
	{
		return head;
	}
}
