
public class BinarySearchTree<T extends Comparable<T>> {
	
protected BSTNode<T> root;
	
	public BinarySearchTree()									//Constructor
	{
		root = null;
	}
	
	public boolean add(T element)								//Wrapper for recursive add
	{
		root = recAdd(root, element);
		return true;
	}
	
	private BSTNode<T> recAdd(BSTNode<T> root, T target)
	{
		if (root == null)										//if BST is Empty
		{
			BSTNode<T> newNode = new BSTNode<T>(target);		//add new node as root node
			root = newNode;
			return root;
		}
		
		if (target.compareTo(root.getInfo()) > 0 )				//if target is greater than root/parent node
			root.setRight( recAdd(root.getRight(), target) );	//add to the right subtree
		else													//if target is less than or equal to root/parent node
			root.setLeft( recAdd(root.getLeft(), target) );		//add to the left subtree
		
		return root;
	}
	
	public boolean search(T target)
	{
		return recSearch(root, target);
	}
	
	private boolean recSearch(BSTNode<T> search, T target)		//search target in BST
	{		
		if (search == null)										//if target not in BST
			return false;
		
		if (target.equals(search.getInfo()) )					//if target is found
			return true;
		
		else if (target.compareTo( search.getInfo()) > 0 )		//if target in right sub-tree
		{
			
			return recSearch(search.getRight(), target);		
		}
		else													//if target in left sub-tree
		{
			
			return recSearch(search.getLeft(), target);	
		}
	}
	
	public void inOrder()										//Wrapper for In-order Traversal
	{
		recInorder(root);
	}
	
	private void recInorder(BSTNode<T> root)
	{
		if (root != null)
		{
			recInorder(root.getLeft());							//get Left
			System.out.println(root.getInfo());					//get Root
			recInorder(root.getRight());						//get Right
		}
	}
	
//********************************************************************************************************************//
	
	public boolean add(Customer element)								//Wrapper for recursive add
	{
		root = recAdd(root, element);
		return true;
	}
	
	private BSTNode<T> recAdd(BSTNode<T> root, Customer target)
	{
		if (root == null)										//if BST is Empty
		{
			BSTNode<T> newNode = new BSTNode<T>(target);		//add new node as root node
			root = newNode;
			return root;
		}
		
		if (target.getID() > root.getInfoo().getID() )			//if target is greater than root/parent node
			root.setRight( recAdd(root.getRight(), target) );	//add to the right subtree
		else													//if target is less than or equal to root/parent node
			root.setLeft( recAdd(root.getLeft(), target) );		//add to the left subtree
		
		return root;
	}
	
	public boolean Search(int target)
	{
		return RecSearch(root, target);
	}
	
	private boolean RecSearch(BSTNode<T> search, int target)
	{		
		if (search == null)
			return false;
		
		if (target == search.getInfoo().getID())
			return true;
		
		else if (target > search.getInfoo().getID() )	
		{
			
			return RecSearch(search.getRight(), target);	
		}
		else	
		{
			
			return RecSearch(search.getLeft(), target);
		}
	}
	
	public BSTNode<T> Get(int target)
	{
		return RecGet(root, target);
	}
	
	private BSTNode<T> RecGet(BSTNode<T> search, int target)
	{		
		if (search == null)
			return null;
		
		if (target == search.getInfoo().getID())
			return search;
		
		else if (target > search.getInfoo().getID() )	
		{
			
			return RecGet(search.getRight(), target);	
		}
		else	
		{
			
			return RecGet(search.getLeft(), target);
		}
	}
	
	public void InOrder()								//Wrapper for In-order Traversal
	{
		recInOrder(root);
	}
	
	public void recInOrder(BSTNode<T> root)
	{
		if (root != null)
		{
			recInOrder(root.getLeft());					//get Left
			System.out.println(root.getInfoo().getID() + "\t\t" + root.getInfoo().getFirst() + "\t\t" + root.getInfoo().getSecond());			//get Root
			recInOrder(root.getRight());				//get Right
		}
	}
	
//********************************************************************************************************************//	
	public void PrintrecSize()							//Wrapper for recursive size
	{
		System.out.println(recSize(root) );
	}
	
	private int recSize(BSTNode<T> root)				//Recursive size of BST
	{
		if (root == null)
			return 0;
		else
			return 1 + recSize(root.getLeft()) + recSize(root.getRight());
	}
	
	public boolean isEmpty()
	{
		return (root == null);
	}
	
	public boolean isFull()
	{
		return false;
	}

}
