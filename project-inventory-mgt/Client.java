package ServerPackage;

public class Client {
private int clientId;
private String lastName;
private String firstName;
private String clientType;
private String phoneNum;
private String address;
private String postalCode;


	public Client(int id, String last, String first, String type, String contact, String add, String postal)
	{
		this.clientId = id;
		this.lastName = last;
		this.firstName = first;
		this.clientType = type;
		this.phoneNum = contact;
		this.address = add;
		this.postalCode = postal;
		
	}
	
	public void setClientId(int id)
	{
		this.clientId = id;
	}
	
	public int getClientId() {
		return clientId;
		
	}
	
	public void setLastName(String last)
	{
		this.lastName = last;
	}
	
	public String getLastName() {
		return lastName;
		
	}
	
	public void setFirstName(String first)
	{
		this.firstName = first;
	}
	
	public String getFirstName() {
		return firstName;
		
	}
	
	public void setclientType(String type)
	{
		this.clientType = type;
	}
	
	public String getclientType() {
		return clientType;
		
	}
	
	public void setphoneNum(String phoneNum)
	{
		this.phoneNum = phoneNum;
	}
	
	public String getphoneNum() {
		return phoneNum;
		
	}
	
	public void setAddress(String add)
	{
		this.address = add;
	}
	
	public String getAddress() {
		return address;
		
	}
	
	public void setPostalCode(String postal)
	{
		this.postalCode = postal;
	}
	
	public String getPostalCode() {
		return postalCode;
		
	}
	
	public String toString() {
		return (clientId + " "+ lastName+" "+ firstName+" "+ clientType+" "+ phoneNum + address + postalCode);
	}
	
	
}
