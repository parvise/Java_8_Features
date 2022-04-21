package com.collections;

import java.util.HashMap;

public class CustomHashMap {

	public static void main(String[] args) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(5);
		map.put(1, 1000);
		map.put(2, 2000);
		map.put(3, 3000);
		map.put(4, 4000);
		map.put(5, 5000);
		map.put(6, 6000);
		map.put(7, 7000);

		map.put(null, 0);

		System.out.println(map);
		System.out.println(map.get(7));
		System.out.println(map.remove(13));
		System.out.println(map.size());

		System.out.println(1 << 4);
		System.out.println(1 << 30);

		PervezMap<String, String> pMap = new PervezMap<String, String>();
		pMap.put(null, "Salma");
		pMap.put("A", "Pervez0");
		pMap.put("B", "Pervez1");
		pMap.put("C", "Pervez2");
		pMap.put("D", "Pervez3");

		System.out.println(pMap.get("D"));

		pMap.put("D", "Pervez4");

		System.out.println(pMap.get("D"));

		pMap.displayMap();

		System.out.println(pMap.size());

		System.out.println(pMap.remove("A"));

		pMap.displayMap();

		System.out.println(pMap.size());

	}

}

class Bucket<K, V> {
	private K key;
	private V value;
	private Bucket<K, V> next;

	public Bucket(K key, V value, Bucket<K, V> next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}

	public K getKey() {
		return key;
	}

	public void setK(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Bucket<K, V> getNext() {
		return next;
	}

	public void setNext(Bucket<K, V> next) {
		this.next = next;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bucket<K,V> other = (Bucket<K,V>) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

}

class PervezMap<K, V> {
	private int capacity = 16;
	private Bucket<K, V> table[];

	transient int size = 0;

	public PervezMap() {
		table = new Bucket[capacity];
	}

	public PervezMap(int capacity) {
		this.capacity = capacity;
		table = new Bucket[capacity];
	}

	public V remove(K key) {
		int index = index(key);
		Bucket<K, V> previous = null;
		Bucket<K, V> entry = table[index];
		Bucket<K, V> current = null;
		while (entry != null) {
			if (entry.getKey().equals(key)) {
				current = entry;
				--size;
				if (previous == null) {
					entry = entry.getNext();
					table[index] = entry;
					// break;
				}

				if (previous != null) {
					previous.setNext(entry);
					// break;
				}
			}
			previous = entry;
			if (entry != null)
				entry = entry.getNext();
		}
		if (current != null)
			return current.getValue();
		return null;
	}

	public V put(K key, V value) {
		int index = index(key);
		Bucket<K,V> newEntry = new Bucket<K,V>(key, value, null);

		if (table[index] == null) {
			table[index] = newEntry;
			++size;
		} else {
			Bucket<K,V> preEntry = null;
			Bucket<K,V> currEntry = table[index];

			while (currEntry != null) {
				if (currEntry.getKey().equals(key)) {
					currEntry.setValue(value);
					break;
				}
				preEntry = currEntry;
				currEntry = currEntry.getNext();
			}
			if (preEntry != null) {
				preEntry.setNext(newEntry);
				++size;
			}
		}
		return value;
	}

	public V get(K key) {
		int index = index(key);
		V value = null;

		Bucket<K, V> entry = table[index];
		while (entry != null) {
			if (entry.getKey().equals(key)) {
				value = entry.getValue();
				break;
			}
			entry = entry.getNext();
		}
		return value;

	}

	public void displayMap() {
		StringBuilder builder = new StringBuilder("PervezMap{");
		for (int i = 0; i < capacity; i++) {
			Bucket<K, V> entry = table[i];
			if (entry != null) {
				builder.append(entry.getKey() + "=" + entry.getValue() + ", ");
				entry = table[i].getNext();
			}
		}
		String text = builder.toString();
		int index = text.lastIndexOf(", ");
		if (index > 0) {
			text = text.substring(0, text.length() - 2);
		}
		builder.delete(0, builder.toString().length());
		builder.append(text);
		builder.append("}");

		System.out.println(builder.toString());
	}

	public int index(K key) {
		if (key == null)
			return 0;
		return Math.abs(key.hashCode() % capacity);
	}

	public int size() {
		return size;
	}

}