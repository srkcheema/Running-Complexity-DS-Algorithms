
public class LLNode<T> {
	
	protected T info;
	protected LLNode<T> link;
	
	protected Customer customer;
	
	//Constructor
	public LLNode(T info)
	{
		this.info = info;
		link = null;
	}
	//Constructor
	public LLNode(Customer customer)
	{
		this.customer = customer;
		link = null;
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
	//Setter
	public void setLink(LLNode<T> link)
	{
		this.link = link;
	}
	//Getter
	public LLNode<T> getLink()
	{
		return link;
	}
	
}
