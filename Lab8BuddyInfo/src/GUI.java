import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.MenuEvent;


public class GUI {
	
	private AddressBook book;
	private JMenuBar menuBar;
	private JMenu menu;
	private JFrame frame;
	
	private JMenuItem newEntry;
	private JMenuItem save;
	private JMenuItem remove;
	private JMenuItem edit;
	private JMenuItem Import;
	
	private JList<String> list;
	private DefaultListModel<String> lm;
	private JScrollPane listScroller;
	
	private ButtonListener bl;
	private String importString;
	
	
	public GUI(){
		book = new AddressBook();
		importString = "Name: Zedd Number: 1006543211 Address: FakeAddress\nName: Ronne Number: 1008844444 Address: Place";
		book.addBuddy("Robert","100887093","home", 21);
		book.addBuddy("Fred","100888999","House", 10);
		
		bl = new ButtonListener(this);
		
		frame = new JFrame("Address Book");
		frame.setSize(600,400);
		
		menuBar = new JMenuBar();
		
		menu = new JMenu("Address Book");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription("menu");
		menuBar.add(menu);
		
		newEntry = new JMenuItem("New Entry");
		newEntry.addActionListener(bl);
		menu.add(newEntry);
		
		save = new JMenuItem("Save");
		save.addActionListener(bl);
		menu.add(save);
		
		remove = new JMenuItem("Remove");
		remove.addActionListener(bl);
		menu.add(remove);
		
		edit = new JMenuItem("Edit");
		edit.addActionListener(bl);
		menu.add(edit);
		
		Import = new JMenuItem("Import");
		Import.addActionListener(bl);
		menu.add(Import);
		showBuddies();
		
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
	}

	public void showBuddies(){
		Container contentPane = new Container();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		lm = new DefaultListModel<String>(); 
		for(BuddyInfo b : book.getBuddies()){
			lm.addElement(b.getName());
		}
		list = new JList<String>(lm);
		
		listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(250, 80));
		contentPane.add(listScroller);
		frame.setContentPane(contentPane);
		frame.setVisible(true);
	}
	
	public void newBuddy(){
		JTextField name = new JTextField();
		JTextField number = new JTextField();
		JTextField address = new JTextField();
		JTextField age = new JTextField();
		
		JPanel newBuddy = new JPanel();
		newBuddy.setLayout(new BoxLayout(newBuddy, BoxLayout.Y_AXIS));
		newBuddy.add(new JLabel("Enter Name"));
		newBuddy.add(name);
		newBuddy.add(new JLabel("Enter Number"));
		newBuddy.add(number);
		newBuddy.add(new JLabel("Enter Address"));
		newBuddy.add(address);
		newBuddy.add(new JLabel("Enter Aage"));
		newBuddy.add(age);
		
		int result = JOptionPane.showConfirmDialog(null,
				newBuddy,"Please Enter Buddy Information",
				JOptionPane.OK_CANCEL_OPTION);
		if(result == JOptionPane.OK_OPTION){
			BuddyInfo buddy = new BuddyInfo(name.getText(),number.getText(),address.getText(),Integer.valueOf(age.getText()));
			book.addBuddy(buddy);
		}
	}
	
	public void removeBuddy(){
		int index = list.getSelectedIndex();
		if(index >= 0){
			String buddyName = lm.getElementAt(index);
			lm.remove(index);
			book.removeBuddy(buddyName);
			list.setSelectedIndex(-1);
		}
	}
	
	public void edit(){
		int index = list.getSelectedIndex();
		if(index >= 0){
			String buddyName = lm.getElementAt(index);
		
			JTextField name = new JTextField();
			name.setText(buddyName);
			
			JPanel newBuddy = new JPanel();
			newBuddy.setLayout(new BoxLayout(newBuddy, BoxLayout.Y_AXIS));
			newBuddy.add(new JLabel("Enter Name"));
			newBuddy.add(name);
		
			int result = JOptionPane.showConfirmDialog(null,
				newBuddy,"Please Enter Buddy Information",
				JOptionPane.OK_CANCEL_OPTION);
			if(result == JOptionPane.OK_OPTION){
				book.editBuddy(buddyName, name.getText());
			}
		}
	}
	
	public void save(){
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("addressBook.txt"));
			for(BuddyInfo b : book.getBuddies()){
				out.write(b.toString());
				out.newLine();
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Import(){
		book.Import(importString);
	}
	
	public static void main(String args[]){
		GUI g = new GUI();
	}
}
