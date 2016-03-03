package phonebook;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

public class PhoneBook implements Serializable {
	private HashMap<String, LinkedList<String>> phoneBook;

	public PhoneBook() {
		phoneBook = new HashMap<String, LinkedList<String>>();
	}

	/**
	 * Associates the specified number with the specified name in this phone
	 * book. post: If the specified name is not present in this phone book, the
	 * specified name is added and associated with the specified number.
	 * Otherwise the specified number is added to the set of number associated
	 * with name.
	 * 
	 * @param name
	 *            The name for which a phone number is to be added
	 * @param number
	 *            The number associated with the specified name
	 * @return true if the specified name and number was inserted
	 */
	public boolean put(String name, String number) {
		LinkedList<String> temp = new LinkedList<String>();
		if (phoneBook.containsKey(name)) {
			temp = phoneBook.get(name);
			temp.add(number);
			phoneBook.put(name, temp);
			return false;
		} else {
			temp.add(number);
			phoneBook.put(name, temp);
			return true;
		}
	}

	/**
	 * Removes the the specified name from this phone book. post: If the
	 * specified name is present in this phone book, it is removed. Otherwise
	 * this phone book is unchanged.
	 * 
	 * @param name
	 *            The name to be removed
	 * @return true if the specified name was present
	 */
	public boolean remove(String name) {
		if (phoneBook.containsKey(name)) {
			phoneBook.remove(name);
			return true;
		}
		return false;
	}

	/**
	 * Måse jag kommentera denna?
	 * 
	 * @param s
	 * @return
	 */
	public boolean contains(String s) {
		return phoneBook.containsKey(s);
	}

	/**
	 * Retrieves a list of phone numbers for the specified name. If the
	 * specified name is not present in this phone book an empty list is
	 * returned.
	 * 
	 * @param name
	 *            The name whose associated phone numbers are to be returned
	 * @return The phone numbers associated with the specified name
	 */
	public List<String> findNumber(String name) {
		LinkedList<String> temp = phoneBook.get(name);
		if (temp == null) {
			return new LinkedList<String>();
		}
		return temp;
	}

	/**
	 * Retrieves a list of names associated with the specified phone number. If
	 * the specified number is not present in this phone book an empty list is
	 * returned.
	 * 
	 * @param number
	 *            The number for which the set of associated names is to be
	 *            returned.
	 * @return The list of names associated with the specified number
	 */
	public List<String> findNames(String number) {
		LinkedList<String> names = new LinkedList<String>();
		for (Entry<String, LinkedList<String>> entry : phoneBook.entrySet()) {
			for (String s : entry.getValue()) {
				if (s.equals(number)) {
					names.add(entry.getKey());
				}
			}
		}
		return names;
	}

	/**
	 * Retrieves the set of all names present in this phone book. The set's
	 * iterator will return the names in ascending order
	 * 
	 * @return The set of all names present in this phone book
	 */
	public Set<String> names() {
		TreeSet<String> names = new TreeSet<String>();
		for (Entry<String, LinkedList<String>> entry : phoneBook.entrySet()) {
			names.add(entry.getKey());
		}
		return names;
	}

	/**
	 * Returns true if this phone book is empty
	 * 
	 * @return true if this phone book is empty
	 */
	public boolean isEmpty() {
		return phoneBook.isEmpty();
	}

	/**
	 * Returns the number of names in this phone book
	 * 
	 * @return The number of names in this phone book
	 */
	public int size() {
		return phoneBook.size();
	}

	public void printToFile() {
		String loc = JOptionPane.showInputDialog("HEJDÅ. VÄLJ PATH.");
		if(loc == null || loc.equals(""))
			System.exit(0);
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(loc));
			out.writeObject(phoneBook);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void readFromFile() {
		String loc = JOptionPane.showInputDialog("VÄLJ FAKING PATH");
		if(loc == null || loc.equals(""))
			return;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(loc));
			phoneBook = (HashMap) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}
