package com.revature.custom_collections.collections;

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
    private Node<K, V>[] entries = new Node[DEFAULT_CAPACITY];

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key
     */
    @Override
    public V get(K key) {
    	int hash = Math.abs( key.hashCode() % DEFAULT_CAPACITY);
    	if (entries[hash] == null) {
    		return null;
    	}
    	Node<K, V> cursor = entries[hash];
    	while ( ! cursor.getKey().equals(key) ) {
    		if (cursor.next == null) {
    			return null;
    		}
    		cursor = cursor.next;
    	}
    	return cursor.getValue();
    }

    /**
     * Associates the specified value with the specified key in this map. If the
     * map previously contained a mapping for the key, the old value is replaced.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with key, or null if there was no mapping for key.
     */
    @Override
    public V put(K key, V value) {
    	int hash = Math.abs( key.hashCode() % DEFAULT_CAPACITY );
    	if (entries[hash] == null) {
    		entries[hash] = new Node<K, V>(hash, key, value, null);
    		size++;
    		return null;
    	}
    	else {
    		Node<K, V> cursor = entries[hash];
    		while (!cursor.getKey().equals(key)) {
    			if (cursor.next == null) {
    				cursor.next = new Node<K, V>(hash, key, value, null);
    				size++;
    				return null;
    			}
    			cursor = cursor.next;
    		}
    		size++;
    		return cursor.setValue(value);
    	}
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param key key whose mapping is to be removed from the map
     * @return the previous value associated with key, or null if there was no mapping for key.
     */
    @Override
    public V remove(K key) {
    	int hash = Math.abs( key.hashCode() % DEFAULT_CAPACITY );
    	if (entries[hash] == null) {
    		return null;
    	}
    	Node<K, V> cursor = entries[hash];
    	Node<K, V> previous = entries[hash];
    	while ( ! cursor.getKey().equals(key) ) {
    		if (cursor.next == null) {
    			return null;
    		}
    		previous = cursor;
    		cursor = cursor.next;
    	}
    	V oldValue = cursor.getValue();
    	
    	if (cursor.equals(previous)) {
    		entries[hash] = entries[hash].next;
    		size--;
    		return oldValue;
    	}
    	
    	previous.next = cursor.next;
    	cursor = null;
    	size--;
    	return oldValue;
    }

    /**
     * Returns true if this map contains a mapping for the specified key.
     *
     * @param key the key whose presence in this map is to be tested
     * @return true if this map contains a mapping for the specified key.
     */
    @Override
    public boolean containsKey(K key) {
    	int hash = Math.abs( key.hashCode() % DEFAULT_CAPACITY );
    	if (entries[hash] == null) {
    		return false;
    	}
    	Node<K, V> cursor = entries[hash];
    	while (!cursor.getKey().equals(key)) {
    		if (cursor.next == null) {
    			return false;
    		}
    		cursor = cursor.next;
    	}
        return true;
    }

    /**
     * Returns true if this map maps one or more keys to the specified value.
     *
     * @param value value whose presence in this map is to be tested
     * @return true if this map maps one or more keys to the specified value
     */
    @Override
    public boolean containsValue(V value) {
    	for (int i=0; i<DEFAULT_CAPACITY; i++) {
    		Node<K, V> cursor = entries[i];
    		while (cursor != null) {
    			if ( cursor.getValue().equals(value) ) {
    				return true;
    			}
    			cursor = cursor.next;
    		}
    	}
        return false;
    }

    /**
     * Returns true if this map contains no key-value mappings.
     *
     * @return true if this map contains no key-value mappings
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
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
    static class Node<K,V> implements Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

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
                Entry<?,?> e = (Entry<?,?>)o;
                return Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue());
            }
            return false;
        }
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
