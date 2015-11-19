import java.util.*;


public class AddressBook {
	
	private List<BuddyInfo> buddies;
	String importString;
	public AddressBook(){
		buddies = new ArrayList<>();
		importString = "Name: Zedd Number: 1006543211 Address: FakeAddress";
	}
	
	public void addBuddy(String name, String number, String address, int age){
		buddies.add(new BuddyInfo(name, number, address, age));
	}
	
	public void addBuddy(BuddyInfo buddy){
		buddies.add(buddy);
	}
	
	public void removeBuddy(String name){
		BuddyInfo buddy = null;
		for(BuddyInfo b : buddies){
			if(b.getName().equals(name)){
				buddy = b;
				break;
			}
		}
		buddies.remove(buddy);
	}
	
	public void editBuddy(String name, String newName){
		for(BuddyInfo b : buddies){
			if(b.getName().equals(name)){
				b.setName(newName);
			}
		}
	}
	public BuddyInfo getBuddy(String name){
		for(BuddyInfo b : buddies){
			if(b.getName().equals(name)){
				return b;
			}
		}
			return null;
	}
	public Boolean contains(BuddyInfo bud){
		if (buddies.contains(bud)){
			return true;
		}
		return false;
	}
	public void Import(String buddyString){
		String[] lines = buddyString.split(System.getProperty("line.separator"));
		for(String l: lines){
		//	this.addBuddy(l., number, address, age);
			
		}
	} 
	
	public int size(){
		return buddies.size(); 
	}
	
	public void clear(){
		this.buddies.clear();
	}
	
	public List<BuddyInfo> getBuddies(){
		return buddies;
	}
}
