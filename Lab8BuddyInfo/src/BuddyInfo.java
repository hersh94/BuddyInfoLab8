
public class BuddyInfo {
	
	private String name;
	private String number;
	private String address;
	private int age;
	private BuddyInfo copyBuddy;
	String greeting ="hi";
	
	public BuddyInfo(String name, String number, String address, int age){
		this.name = name;
		this.number = number;
		this.address = address;
		this.age = age;
	}
	//copy constructor
	public BuddyInfo(BuddyInfo copyBud){
	copyBuddy = copyBud;	
	}
	//greeting
	public String greeting(){
		return greeting;
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return age;
	}
	public Boolean isOver18(){
		if (this.age >= 18){
			return true;
		}
		return false;
	}
		
	public void setName(String name){
		this.name = name;
	}
	public void setNumber(String number){
		this.number = number;
	}
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getName(){
		return name;
	}
	public String getAddress(){
		return address;
	}
	public String getNumber(){
		return number;
	}
	
	public String toString(){
		return "Name: " + name + " Number: " + number + " Address: " + address;
	}
	
	public boolean equals(Object object){
		if(object instanceof BuddyInfo){
			BuddyInfo b = (BuddyInfo)object;
			if(b.getName().equals(this.getName()) &&
				b.getAddress().equals(this.getAddress()) &&
						b.getNumber().equals(this.getNumber())){
				return true;
			}
		} else {
		    return false;
		}
		return false;
	}
}
