package com.revature.custom_collections;

import com.revature.custom_collections.collections.ArrayDeque;

public class CollectionDriver {

    public static void main(String[] args) {
    	
    	ArrayDeque adq = new ArrayDeque();
    	
    	ArrayDeque adq2 = new ArrayDeque(0);
    	
    	ArrayDeque adq3 = new ArrayDeque(64);
    	
    	System.out.println("Size of Array Deque: " + adq.size());
    	
    	System.out.println("Size of Array Deque 2: " + adq2.size());
    	
    	System.out.println("Size of Array Deque 3: " + adq3.size());
    	
    	System.out.println("Is the Array Deque empty? " + adq.isEmpty());
    	
    	System.out.println("Is Array Deque 2 empty? " + adq2.isEmpty());
    	
    	System.out.println("Is Array Deque 3 empty? " + adq3.isEmpty());
    }
}
