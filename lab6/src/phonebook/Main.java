package phonebook;

public class Main {
	public static void main(String[] args) {	
		PhoneBook pb = new PhoneBook();
		pb.readFromFile();
		new PhoneBookGUI(pb);
	}

}
