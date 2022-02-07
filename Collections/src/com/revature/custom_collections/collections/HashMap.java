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

    private int size = 0;
    private final int DEFAULT_CAPACITY = 4;
    private int currentCapacity = DEFAULT_CAPACITY;
    
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
    	Node<K,V> node = (Node <K,V>) entries[size-1];
    	while(node != null) {
    		if(node.getKey() == key) {
    			return node.getValue();
    		}
    		node = node.next;
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
    	
    	if(this.isEmpty()) { // this is the first node
    		Node<K, V> node = new Node<>(hash(key), key, value, null);
    		this.entries[size] = node;
    		this.size++;
    		return value;
    	}
    	else if (this.size < (int) this.currentCapacity){ // room left
    		Node<K, V> node = new Node<>(hash(key), key, value, (Node<K,V>) this.entries[size-1]);
    		this.entries[size] = node;
    		this.size++;
    		return value;
    	}
    	else { // needs to grow 
    		currentCapacity *= 2;
    		Entry<K, V>[] tempEntries = new Entry[currentCapacity];
    		
    		for(int i =0;i<this.size;i++) {
    			tempEntries[i] = this.entries[i];
    		}
    		entries = tempEntries;
    		tempEntries = null;
    		
    		Node<K, V> node = new Node<>(hash(key), key, value, (Node<K,V>) this.entries[size-1]);
    		this.entries[size] = node;
    		this.size++;
    		return value;
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
    	Node<K,V> node = (Node <K,V>) entries[0];
    	Node<K,V> nextNode = null;
    	for(int i=0;i<this.size;i++) {
    		if(entries[i].getKey()==key) {
    			V returnValue = entries[i].getValue();
    			
    			if(i<size-1) {
    				node = (Node<K,V>) entries[i];
    				nextNode = (Node<K,V>) entries[i+1];
    			
    				nextNode.next = node.next;
    				
    				// remove node from entries array
    				while(i<this.size) {
    					entries[i] = entries[i+1];
    					i++;
    				}
    				size--;
    			}
    			else { // data will get over written when a new node is added
    				size--;
    			}
    			return returnValue;
    		}
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
    	Node<K,V> node = (Node <K,V>) entries[size-1];
    	while(node != null) {
    		if(node.getKey() == key) {
    			return true;
    		}
    		node = node.next;
    	}
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
    	Node<K,V> node = (Node <K,V>) entries[size-1];
    	while(node != null) {
    		if(node.getValue() == value) {
    			return true;
    		}
    		node = node.next;
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
    	if(this.size == 0) {
    		return true;
    	}
        return false;
    }

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the number of key-value mappings in this map
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Basic hash bin node structure. No need to change implementation for exercise.
     *
     * @param <K> the type of keys maintained by this map
     * @param <V> the type of mapped values
     */
    
    public void printMap() {
    	Node<K,V> node = (Node <K,V>) entries[size-1];
    	while(node != null) {
    		System.out.println("## "+node.getKey());
    		node = node.next;
        }
    }
    
    
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
