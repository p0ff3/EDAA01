package phonebook;
import javax.swing.*;

import java.awt.event.*;

@SuppressWarnings("serial")
public class FindNumbersMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public FindNumbersMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Find Numbers");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	 public void actionPerformed(ActionEvent e) {
		 gui.messageArea.setText("dafuq");
		 String s = JOptionPane.showInputDialog("ENTER DE FACKING namn, JAo.");
			if(s == null || s.length() == 0){
				JOptionPane.showMessageDialog(null, "Dålig input");
			}
			else{
				StringBuilder out = new StringBuilder(s + "\n");
				for(String str: phoneBook.findNumber(s)){
					out.append(str);
					out.append("\n");
				}
				gui.messageArea.setText(out.toString());
			}
	 }
}
