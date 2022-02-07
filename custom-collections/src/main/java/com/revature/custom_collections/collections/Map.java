package com.revature.custom_collections.collections;

import com.revature.custom_collections.collections.HashMap.Node;

public interface Map<K,V> {

    V get(K key);
    V put(K key, V value);
    V remove(K key);
    boolean containsKey(K key);
    boolean containsValue(V value);
    boolean isEmpty();
    int size();

    interface Entry<K,V> {
        K getKey();
        V getValue();
        V setValue(V value);
        Node<K,V> getNext();
        boolean equals(Object var1);
        int hashCode();
		void setNext(Node<K,V> node);
    }

}
