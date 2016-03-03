package phonebook;
import javax.swing.*;

import java.awt.event.*;

@SuppressWarnings("serial")
public class FindNamesMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public FindNamesMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Find Names");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	 public void actionPerformed(ActionEvent e) {
		 gui.messageArea.setText("dafuq");
		 String s = JOptionPane.showInputDialog("ENTER DE FACKING Numm, JA.");
			if(s == null || s.length() == 0){
				JOptionPane.showMessageDialog(null, "Dålig input");
			}
			else{
				StringBuilder out = new StringBuilder();
				for(String str: phoneBook.findNames(s)){
					out.append(str);
					out.append("\n");
				}
				gui.messageArea.setText(out.toString());
			}
		
	 }
}
