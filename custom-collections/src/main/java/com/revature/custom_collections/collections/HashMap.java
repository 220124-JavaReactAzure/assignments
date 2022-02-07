package com.revature.custom_collections.collections;

import java.util.Arrays;
import java.util.Objects;

/**
 * Hash table based implementation of the Map interface. This implementation
 * permits null values and the null key. This class makes no guarantees as to
 * the order of the map; in particular, it does not guarantee that the order
 * will remain constant over time.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class HashMap<K, V> implements Map<K, V> {

	private int size;
	private final int DEFAULT_CAPACITY = 16;

	@SuppressWarnings("unchecked")
	private Entry<K, V>[] entries = new Entry[DEFAULT_CAPACITY];

	/**
	 * Returns the value to which the specified key is mapped, or null if this map
	 * contains no mapping for the key.
	 *
	 * @param key the key whose associated value is to be returned
	 * @return the value to which the specified key is mapped, or null if this map
	 *         contains no mapping for the key
	 */
	@Override
	public V get(K key) {
		V value = null;
		int i;
		if (key == null) {
			i = 0;
		} else {
			i = Math.abs(key.hashCode() % DEFAULT_CAPACITY);
		}
		Entry<K, V> entry = entries[i];
		while (entry != null) {
			if (entry.getKey().equals(key)) {
				value = entry.getValue();
				break;
			}
			entry = entry.getNext();

		}
		return value;
	}

	/**
	 * Associates the specified value with the specified key in this map. If the map
	 * previously contained a mapping for the key, the old value is replaced.
	 *
	 * @param key   key with which the specified value is to be associated
	 * @param value value to be associated with the specified key
	 * @return the previous value associated with key, or null if there was no
	 *         mapping for key.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public V put(K key, V value) {
		int i;
		if (key == null) {
			i = 0;
		} else {
			i = Math.abs(key.hashCode() % DEFAULT_CAPACITY);
		}
		if (entries[i] == null) {
			entries[i] = new Node(i, key, value, null);
		} else {
			Entry<K, V> currentEntry = entries[i];
			Entry<K, V> prevEntry = null;
			while (currentEntry != null) {
				if (currentEntry.getKey().equals(key)) {
					currentEntry.setValue(value);
					break;
				}
				prevEntry = currentEntry;
				currentEntry = currentEntry.getNext();
			}
			if (prevEntry != null) {
				prevEntry.setNext(new Node(i, key, value, null));
			}

		}
		return value;

	}

	/**
	 * Removes the mapping for the specified key from this map if present.
	 *
	 * @param key key whose mapping is to be removed from the map
	 * @return the previous value associated with key, or null if there was no
	 *         mapping for key.
	 */
	@Override
	public V remove(K key) {
		V value = null;
		int index;
		if (key == null) {
			index = 0;
		} else {
			index = Math.abs(key.hashCode() % DEFAULT_CAPACITY);
		}
		Entry<K, V> previous = null;
		Entry<K, V> entry = entries[index];
		while (entry != null) {
			value = entry.getValue();
			if (entry.getKey().equals(key)) {
				if (previous == null) {
					entry = entry.getNext();
					entries[index] = entry;
				} else {
					previous.setNext(entry.getNext());
					
				}
				return value;
			}
			previous = entry;
			entry = entry.getNext();
		}
		return value;
	}

	/**
	 * Returns true if this map contains a mapping for the specified key.
	 *
	 * @param key the key whose presence in this map is to be tested
	 * @return true if this map contains a mapping for the specified key.
	 */
	@Override
	public boolean containsKey(K key) {
		int index;
		if (key == null) {
			index = 0;
		} else {
			index = Math.abs(key.hashCode() % DEFAULT_CAPACITY);
		}
		Entry<K, V> entry = entries[index];
		return entry != null;
	}

	/**
	 * Returns true if this map maps one or more keys to the specified value.
	 *
	 * @param value value whose presence in this map is to be tested
	 * @return true if this map maps one or more keys to the specified value
	 */
	@Override
	public boolean containsValue(V value) {
		return false;
	}

	/**
	 * Returns true if this map contains no key-value mappings.
	 *
	 * @return true if this map contains no key-value mappings
	 */
	@Override
	public boolean isEmpty() {
		return entries[0] == null;
	}

	/**
	 * Returns the number of key-value mappings in this map.
	 *
	 * @return the number of key-value mappings in this map
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Basic hash bin node structure. No need to change implementation for exercise.
	 *
	 * @param <K> the type of keys maintained by this map
	 * @param <V> the type of mapped values
	 */
	static class Node<K, V> implements Entry<K, V> {
		final int hash;
		final K key;
		V value;
		Node<K, V> next;

		Node(int hash, K key, V value, Node<K, V> next) {
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public final K getKey() {
			return key;
		}

		public final V getValue() {
			return value;
		}

		public Node<K, V> getNext() {
			return next;
		}

		public void setNext(Node<K, V> next) {
			this.next = next;
		}

		public final String toString() {
			return key + "=" + value;
		}

		public final int hashCode() {
			return Objects.hashCode(key) ^ Objects.hashCode(value);
		}

		public final V setValue(V newValue) {
			V oldValue = value;
			value = newValue;
			return oldValue;
		}

		public final boolean equals(Object o) {
			if (o == this)
				return true;
			if (o instanceof Map.Entry) {
				Entry<?, ?> e = (Entry<?, ?>) o;
				return Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue());
			}
			return false;
		}

	}

	static final int hash(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}

	@Override
	public String toString() {
		return "HashMap [entries=" + Arrays.toString(entries) + "]";
	}

}
