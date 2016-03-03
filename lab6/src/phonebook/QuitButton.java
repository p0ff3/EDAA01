package phonebook;
import javax.swing.*;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class QuitButton extends JButton implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;

	public QuitButton(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Quit");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	 public void actionPerformed(ActionEvent e) {
		phoneBook.printToFile();
		System.exit(0);
	 }
}