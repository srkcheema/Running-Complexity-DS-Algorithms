
public class Customer {
	
	//instance variables
	private String first;
	private String second;
	private int ID;
	
	public Customer()
	{
		first = "";
		second = "";
		ID = 0;
	}
	//Setter
	public void setFirst(String _Name)
	{
		first = _Name;
	}
	//Getter
	public String getFirst() 
	{
		return first;
    }	
	
	//Setter
	public void setSecond(String _Second)
	{
		second = _Second;
	}
	//Getter
	public String getSecond() 
	{
		return second;
	}	
	
	//Setter
	public void setID(int _ID)
	{
		this.ID = _ID;
	}
	//Getter
	public int getID()
	{
		return ID;
    }	
	
}
