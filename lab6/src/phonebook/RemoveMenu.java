package phonebook;

import javax.swing.*;

import java.awt.event.*;

public class RemoveMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;

	public RemoveMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Remove");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String s = JOptionPane.showInputDialog("ENTER DE FACKING NÄJM");
		if (s == null || s.length() == 0) {
			JOptionPane.showMessageDialog(null, "FUCK");
		} else {
			phoneBook.remove(s);
			JOptionPane.showMessageDialog(null, "BORTAAAA");
		}

	}
}