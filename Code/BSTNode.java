
public class BSTNode<T> {
	
	private T info;
	private BSTNode<T> left;
	private BSTNode<T> right;
	
	private Customer customer;
	
	//Constructor
	public BSTNode(T info )
	{
		this.info = info;
		left = null;
		right = null;
	}
	//Constructor
	public BSTNode(Customer customer )
	{
		this.customer = customer;
		left = null;
		right = null;
	}	
	
	//Setter
	public void setInfo(T info)
	{
		this.info = info;
	}
	//Setter
	public void setInfo(Customer customer)
	{			
		this.customer = customer;
	}	
	
	//Getter
	public T getInfo()
	{
		return info;
	}
	//Getter
	public Customer getInfoo()
	{
		return customer;
	}
	
	//Setter Right Node
	public void setRight(BSTNode<T> right)
	{
		this.right = right;
	}
	//Getter Right Node
	public BSTNode<T> getRight()
	{
		return right;
	}
	
	//Setter Left Node
	public void setLeft(BSTNode<T> left)
	{
		this.left = left;
	}
	//Getter Left Node
	public BSTNode<T> getLeft()
	{
		return left;
	}

}
