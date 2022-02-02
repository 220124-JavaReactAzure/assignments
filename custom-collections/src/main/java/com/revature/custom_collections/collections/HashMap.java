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
    private Entry<K, V>[] entries = new Entry[DEFAULT_CAPACITY];

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key
     */
    @Override
    public V get(K key) {
    	Node node = getKeyEntry(key);
    	if(node == null) {return null;}
    	return (V)node.value;
    }
    
    private Node getKeyEntry(K key) {
    	int index = hash(key) % DEFAULT_CAPACITY;
    	if(index < 0) {index = index * -1;}
    	//System.out.println("This "+ key+ " has index "+index);
    	if(entries[index] != null) {
    		Node runner = (Node)entries[index];
    		while(runner != null) {
    			if(runner.getKey().equals(key)) {
					return runner;
				}
				runner = runner.next;
    		}
    	}
    	return null;
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
    	int index = hash(key) % DEFAULT_CAPACITY;
    	if(index < 0) {index = index * -1;}
    	if(entries[index] == null) {
    		Node newNode = new Node(hash(key), key, value, null);
    		entries[index] = newNode;
    		size ++;
    		return null;
    	}
    	Node oldNode = (Node) entries[index];
    	while(oldNode.next != null) {
    		if(oldNode.key.equals(key)) {
    			V answer = (V) oldNode.getValue();
    			oldNode.setValue(value);
    			return answer;
    		}
    		oldNode = oldNode.next;
    	}
    	if(oldNode.key.equals(key)) {
			V answer = (V) oldNode.getValue();
			oldNode.setValue(value);
			return answer;
		}
    	oldNode.next = new Node(hash(key), key, value, null);
    	size++;
    	return null;
    }
    
    public String printHashMap() {
    	String answer = "";
    	for(int i = 0; i < entries.length; i++) {
    		answer = answer + i + ") ";
    		if(entries[i] != null) {
    			Node runner = (Node) entries[i];
    			while(runner != null) {
    				answer = answer + runner.getValue() + " : ";
    				runner = runner.next;
    			}
    		}
    		answer = answer + "\n";
    	}
    	return answer;
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param key key whose mapping is to be removed from the map
     * @return the previous value associated with key, or null if there was no mapping for key.
     */
    @Override
    public V remove(K key) {
    	int index = hash(key) % DEFAULT_CAPACITY;
    	if(index < 0) {index = index * -1;}
    	if(entries[index] == null) {
    		return null;
    	}
    	Node previousNode = (Node) entries[index];
    	if(previousNode.getKey().equals(key)) {
    		V answer = (V) previousNode.getValue();
    		entries[index] = ((Node)entries[index]).next;
    		size--;
    		return answer;
    	}
    	Node runner = previousNode.next;
    	while(runner != null) {
    		if(runner.getKey().equals(key)) {
    			V answer = (V) runner.getValue();
    			previousNode.next = runner.next;
    			size--;
    			return answer;
    		}
    		runner = runner.next;
    		previousNode = previousNode.next;
    	}
    	return null;
    }

    /**
     * Returns true if this map contains a mapping for the specified key.
     *
     * @param key the key whose presence in this map is to be tested
     * @return true if this map contains a mapping for the specified key.
     */
    @Override
    public boolean containsKey(K key) {
    	Node node = getKeyEntry(key);
    	if(node != null) {return true;}
        return false;
    }

    /**
     * Returns true if this map maps one or more keys to the specified value.
     *
     * @param value value whose presence in this map is to be tested
     * @return true if this map maps one or more keys to the specified value
     */
    @Override
    public boolean containsValue(V value) {
    	for (int i = 0; i < entries.length; i++){
    		if(entries[i] != null) {
    			Node runner = (Node) entries[i];
    			while(runner != null) {
    				if(runner.getValue().equals(value)) {
    					return true;
    				}
    				runner = runner.next;
    			}
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
