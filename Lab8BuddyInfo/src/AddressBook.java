import java.util.*;


public class AddressBook {
	
	private List<BuddyInfo> buddies;
	String importString;
	public AddressBook(){
		buddies = new ArrayList<>();
		
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
		String[] lines = buddyString.split("\n");
		System.out.println(lines[0]+"\n"+lines[1]);
		String[] temp;
		for(String l: lines){
			//split appropriate attributes
			temp = l.split("\\w{4,7}:\\s");
			System.out.println(temp[1]+temp[2]+temp[3]);
			this.addBuddy(temp[1], temp[2], temp[3], 18);
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
