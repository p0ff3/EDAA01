package map;

import map.Map.Entry;

public class SimpleHashMap<K, V> implements Map<K, V> {
	private Entry<K, V>[] table;
	private final double LOAD_THRESHOLD = 0.75;
	private int size = 0;

	public SimpleHashMap() {
		table = (Entry<K, V>[]) new Entry[16];
	}

	public SimpleHashMap(int capacity) {
		table = (Entry<K, V>[]) new Entry[capacity];
	}

	public String show() {
		StringBuilder temp = new StringBuilder();
		for (Entry<K, V> e : table) {
			do {
				temp.append(e.toString());
				e = e.next;
			} while ((e.hasNext()));
		}
		return temp.toString();

	}

	private int index(K key) {
		int index = key.hashCode() % table.length;
		if (index < 0) {
			index *= -1;
		}
		return index;
	}

	private Entry<K, V> find(int index, K key) {
		Entry<K, V> temp = table[index];
		if (temp == null) {
			return null;
		}
		while (!(temp.key.equals(key)) && temp != null) {
			temp = temp.next;
		}
		if (temp == null) {
			return null;
		} else {
			return temp;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public V get(Object object) {
		K key = (K) object;
		int index = index(key);
		Entry<K, V> temp = find(index, key);
		if (temp == null) {
			return null;
		} else {
			return temp.value;
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public V put(K k, V v) {
		int index = index(k);

		if (table[index] == null) {
			table[index] = new Entry<K, V>(k, v);
			size++;
			rehash();
			return null;
		}
		Entry<K, V> temp = table[index];
		while (!(temp.key.equals(k)) && temp.next != null) {
			temp = temp.next;
		}
		if (temp.key.equals(k)) {
			V tempV = temp.value;
			temp.value = v;
			return tempV;
		}
		temp.next = new Entry<K, V>(k, v);

		size++;
		rehash();
		return null;

		// TODO Auto-generated method stub
	}

	@SuppressWarnings("unchecked")
	private void rehash() {
		// BEWARE DRAGONS AHEAD

		if (size > table.length * 0.75) {
			size = 0;
			Entry<K, V>[] tempTable = table;
			table = (Entry<K, V>[]) new Entry[tempTable.length * 2];
			for (int i = 0; i < tempTable.length; i++) {
				Entry<K, V> temp = tempTable[i];
				while (temp != null) {
					put(temp.key, temp.value);
					temp = temp.next;
				}

			}
		}
	}

	@Override
	public V remove(Object key) {

		int index = index((K) key);
		Entry<K, V> temp = table[index];
		if (temp == null) {
			return null;
		}
		if (temp.key.equals((K) key)) {
			table[index] = temp.next;
			size--;
			return temp.value;
		}
		while (temp != null) {
			if (temp.next != null) {
				if (temp.next.key.equals((K) key)) {
					size--;
					V value = temp.next.value;
					temp.next = temp.next.next;
					return value;
				}
			}
			temp = temp.next;
		}
		return null;
	}

	private static class Entry<K, V> implements Map.Entry<K, V> {
		private K key;
		private V value;
		protected Entry<K, V> next;

		public Entry(K k, V v) {
			key = k;
			value = v;
		}

		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return key;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return value;
		}

		@Override
		public V setValue(V value) {
			this.value = value;
			return value;
		}

		@Override
		public String toString() {
			return key + "=" + value;
		}

		protected boolean hasNext() {
			if (next != null)
				return true;
			return false;
		}

	}

}
