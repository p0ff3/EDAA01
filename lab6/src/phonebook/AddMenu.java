package phonebook;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class AddMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;

	public AddMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Add");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String s = JOptionPane.showInputDialog("ENTER DE FACKING NÄJM");
		String number = JOptionPane.showInputDialog("ENTER DE FACKING NAMBER");
		if(s.equals(null) || s.length() == 0 || number.equals(null) || number.length() == 0){
			JOptionPane.showMessageDialog(null, "FUCK");
		}
		else{
			phoneBook.put(s, number);
			//JOptionPane.showMessageDialog(null, "BRA JOBBAT");
		}
	}
}
