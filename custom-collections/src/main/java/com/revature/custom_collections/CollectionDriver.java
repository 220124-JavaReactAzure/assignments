package com.revature.custom_collections;

import com.revature.custom_collections.collections.ArrayDeque;

public class CollectionDriver {

    public static void main(String[] args) {
    	
    	ArrayDeque<Integer> adq = new ArrayDeque<Integer>(2);
    	
    	System.out.println("Element was added: " + adq.add(1));
    	
    	System.out.println("Size of ArrayDeque: " + adq.size());
    	
    	System.out.println("Element was added: " + adq.add(1));
    	
    	System.out.println("Size of ArrayDeque: " + adq.size());
    	
    	System.out.println("Element was added: " + adq.add(1));
    	
    	System.out.println("Size of ArrayDeque: " + adq.size());
    	
    }
}
