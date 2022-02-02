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
        //search entries for key
        System.out.println("get key:" + key);
        int hash = hash(key);
        System.out.println("get hash: " + hash);

        int index = hash & (DEFAULT_CAPACITY - 1);
        System.out.println("get index:" + index);

        V value = null;
        // int index = index(key);
        Node<K, V> entry = entries[index];
        while (entry != null){
            
            System.out.println("get getKey(): " + entry.getKey() + " - get getValue(): " + entry.getValue());
            if(entry.getKey().equals(key)) {
                value = entry.getValue();
                break;
            }
            entry = entry.next;
        }
        return value;
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
    public V put(K key, V val) {

        System.out.println("put key:" + key + " val: " + val);
        int hash = hash(key);
        System.out.println("put hash:" + hash);

        int index = hash & (DEFAULT_CAPACITY - 1);
        System.out.println("put index:" + index);

        // int index = index(key);
        // Node<K, V> newEntry = Node<K, V>(hash, key, val, null);
        Node<K, V> newEntry = new Node<>(hash, key, val, null);
        if(entries[index] == null){
            entries[index] = newEntry;
        }else {
            Node<K, V> previousNode = null;
            Node<K, V> currentNode = entries[index];
            while(currentNode != null){
                if(currentNode.getKey().equals(key)){
                    currentNode.setValue(val);
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            if(previousNode != null)
                previousNode.next = newEntry;
            }

        // size++;
        return null;
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param key key whose mapping is to be removed from the map
     * @return the previous value associated with key, or null if there was no mapping for key.
     */
    @Override
    public V remove(K key) {

        System.out.println("put key:" + key);
        int hash = hash(key);
        System.out.println("put hash:" + hash);

        int index = hash & (DEFAULT_CAPACITY - 1);
        System.out.println("put index:" + index);

        Node<K, V> prevNode = null;
        Node<K, V> currentNode = entries[index];

        while (currentNode != null){
            if(currentNode.getKey().equals(key)){
                if(prevNode == null){
                    currentNode = currentNode.next;
                    entries[index] = currentNode;
                    // return;
                }else {
                    prevNode.next = currentNode.next;
                    // return;
                }
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
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
        System.out.println("containsKey key:" + key);
        int hash = hash(key);
        System.out.println("containsKey hash:" + hash);

        int index = hash & (DEFAULT_CAPACITY - 1);
        System.out.println("containsKey index:" + index);

        Node<K, V> currentNode = entries[index];

        while (currentNode != null){
            if(currentNode.getKey().equals(key)){
                return true;
            }
            currentNode = currentNode.next;
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
        System.out.println("containsValue value:" + value);

        for (int i = 0;i < DEFAULT_CAPACITY;i++){

            Node<K, V> currentNode = entries[i];

            while (currentNode != null){
                if(currentNode.getValue().equals(value)){
                    return true;
                }
                currentNode = currentNode.next;
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
        for (int i = 0;i < DEFAULT_CAPACITY;i++){
            Node<K, V> currentNode = entries[i];
            if (currentNode != null){
                return false;
            }
        }
        return true;
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
