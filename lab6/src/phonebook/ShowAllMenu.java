package phonebook;

import javax.swing.*;

import java.awt.event.*;
import java.util.LinkedList;
import java.util.Map.Entry;

@SuppressWarnings("serial")
public class ShowAllMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;

	public ShowAllMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Show All");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		StringBuilder out = new StringBuilder();
		for (String s : phoneBook.names()) {
			out.append(s + ": " + phoneBook.findNumber(s) + "\n");
		}
		gui.messageArea.setText(out.toString());
	}
}