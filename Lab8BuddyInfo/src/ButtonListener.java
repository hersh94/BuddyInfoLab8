import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonListener implements ActionListener{

	private GUI gui;
	
	
	public ButtonListener(GUI gui){
		this.gui = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("New Entry")){
			gui.newBuddy();
		}
		if(e.getActionCommand().equals("Save")){
			gui.save();
		}
		if(e.getActionCommand().equals("Remove")){
			gui.removeBuddy();
		}
		if(e.getActionCommand().equals("Edit")){
			gui.edit();
		}
		gui.showBuddies();
	}

}
