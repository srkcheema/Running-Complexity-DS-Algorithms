
public class SortedLinkedlist<T extends Comparable<T>> {
	
	protected LLNode<T> head;							//Points towards the start of Linked list
	protected LLNode<T> tail;							//Points towards the end of Linked list
	protected int numElements = 0;						//Keeps track of total elements in Linked list
	
	protected boolean found;							//Boolean used by Search methods
	protected LLNode<T> previous;						//LLNode used by Search methods
	protected LLNode<T> location;						//LLNode used by Search methods
	
	public SortedLinkedlist(UnsortedLinkedlist<T> ULL)	//Constructor
	{
		LLNode<T> loc;									//create LLNode loc
		loc = ULL.getHead();							//loc points towards unsorted Linked list
		
		while (loc != null)								//loops until location node is null
		{
			if(loc.getInfoo() != null) 					//if Unsorted Linked list contains Customer Objects
			{
				add(loc.getInfoo());					//add Objects in order(by Customer ID) to Sorted Linked list
				loc = loc.getLink();					//loc moves to the next node
			}
			else										//if Unsorted Linked list contains Generic type
			{
				add(loc.getInfo());						//add elements in ascending order to Sorted Linked list
				loc = loc.getLink();					//loc moves to the next node
			}
		}
	}
	
	public void add(T info)
	{
		LLNode<T> newNode = new LLNode<T>(info);		//create newNode to add
		
		toAdd(info);									//call toAdd Method
		
		if (isEmpty())									//if Linked List is Empty
		{
			head = newNode;								//head and tail points towards the newNode
			tail = newNode;
		}
		
		else if (location == head)						//if element is to be added at the beginning of the Linked list
		{												
			newNode.setLink(head);						//newNode is added at the start of the Linked list
			head = newNode;								//head points towards the newNode
		}
		
		else if (found)									//if a suitable location is found in between nodes
		{
			newNode.setLink(location);					//newNode is added between previous and location
			previous.setLink(newNode);
			
		}
		
		else											//if no suitable location in between nodes is found
		{												//element to be added at the end of linked list
			previous.setLink(newNode);					//add newNode at the end of Linked list
			tail = newNode;								//tail points towards the newNode
		}
		
		numElements++;									//Update count
	}
	
	protected void toAdd(T target)						//find the location to add the target element
	{													//target is suitable to be added after previous
		location = head;								//and before location
		found = false;
		
		while (location != null)						//loop until no next node is linked list
		{
			if (location.getInfo().compareTo(target) > 0 )
			{
				found = true;							//if a suitable input location is found
				return;									//return found as true
			}
			
			else
			{
				previous = location;					//previous moves to next node
				location = location.getLink();			//location node moves to the next node
			}	
		}
	}
	
	public boolean remove(T remove)						//find input T element & remove it if it's in the Linked list
	{
		if (isEmpty())									//if Linked list is Empty, throws Underflow exception
			throw new UnderflowException("Linked list is Empty !");
		
		find(remove);									//call find Method
		if (found)										//if element is found in the list
		{
			if (head == tail)							//if it's the only element in the list
			{
				head = null;							//remove the element, Linked list is Empty
				tail = null;
			}
			
			else if (location == head)					//if the element is the first element in the list
				head = head.getLink();					//head points toward the 2nd element, 1st element is removed
			
			else if (location == tail)					//if the element is the first element in the list
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
		
		while (location != null)						//loops until location node is null
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
		return found;									//return true if element is found, false otherwise
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
	
	public void add(Customer info)
	{
		LLNode<T> newNode = new LLNode<T>(info);		//create newNode to add
		
		toAdd(info);									//call toAdd Method
		
		if (isEmpty())									//if Linked List is Empty
		{
			head = newNode;								//head and tail points towards the newNode
			tail = newNode;
		}
		
		else if (location == head)						//if Object is to be added at the beginning of Linked list
		{												
			newNode.setLink(head);						//newNode is added at the start of the Linked list
			head = newNode;								//head points towards the newNode
		}
		
		else if (found)									//if a suitable location is found in between nodes
		{
			newNode.setLink(location);					//newNode is added between previous and location
			previous.setLink(newNode);
			
		}
		
		else											//if no suitable location in between nodes is found
		{												// Customer Object to be added at the end of linked list
			previous.setLink(newNode);					//add newNode at the end of Linked list
			tail = newNode;								//tail points towards the newNode
		}
		
		numElements++;									//Update count
	}
	
	protected void toAdd(Customer target)				//finds the location to add the target element
	{													//target is suitable to be added after previous
		location = head;								//and before location
		found = false;
		
		while (location != null)						//loops until no next node in linked list
		{
			if (location.getInfoo().getID() > target.getID())
			{
				found = true;							//if a suitable input location is found in order of Customer ID
				return;									//return found as true
			}
			
			else
			{
				previous = location;					//previous moves to next node
				location = location.getLink();			//move to next node is target is not found
			}	
		}
	}
	
	public boolean Remove(int remove)					//finds input ID & removes the Object, if in the Linked list
	{
		if (isEmpty())									//if Linked list is Empty, throws Underflow exception
			throw new UnderflowException("Linked list is Empty !");
		
		Find(remove);									//calls Find method
		if (found)										//if Object is found in the list
		{
			if (head == tail)							//if it's the only Object in the list
			{
				head = null;							//removes the Object, Linked list is Empty
				tail = null;
			}
			
			else if (location == head)					//if the Object is the first Object in the list
				head = head.getLink();					//head points toward the 2nd Object, 1st Object is removed
			
			else if (location == tail)					//if the Object is the first Object in the list
			{
				tail = previous;						//tail points toward the 2nd last Object
				previous.setLink(null);					//last Object is removed
			}
			else										//if the Object is in-between the list
				previous.setLink(location.getLink());	//Object is removed
			
			numElements--;								//Update count
		}
		return found;									//returns true if Object is removed, false otherwise
	}
	
	private void Find(int target)						//finds the target Customer ID in the Linked list
	{
		location = head;
		found = false;
		
		while (location != null)						//loops until location node is null
		{
			if (location.getInfoo().getID() == target)	//if Customer ID in the location node, equals target
			{
				found = true;							//update found to true
				return;									//exits method
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
		Find(target);									//finds target Customer ID in the Linked list
		return found;									//returns true if Customer ID is found, false otherwise
	}
	
	public Customer Get(int target)
	{
		Find(target);									//finds target Customer ID in the Linked list
		if (found)										//if found
			return location.getInfoo();					//returns a copy of the Object
		else
			return null;								//returns null if Customer ID is not in the Linked list
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
}
