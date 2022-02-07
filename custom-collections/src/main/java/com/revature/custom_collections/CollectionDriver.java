package com.revature.custom_collections;

import com.revature.custom_collections.collections.ArrayDeque;

public class CollectionDriver {

    public static void main(String[] args) {
    	
    	ArrayDeque<Integer> adq = new ArrayDeque<Integer>();
    	
    	System.out.println(adq.peekLast());
    	
    	System.out.println("ArrayDeque is currently empty: " + adq.isEmpty());
    	
    	System.out.println("The size of the current ArrayDeque: " + adq.size());
    	
    	adq.add(27);
    	
    	System.out.println(adq.peekLast());
    	
    	System.out.println("ArrayDeque is currently empty: " + adq.isEmpty());
    	
    	System.out.println("The size of the current ArrayDeque: " + adq.size());
    	
    	System.out.println("The current ArrayDeque contains 27: " + adq.contains(27));
    	
    	System.out.println("27 was removed from the current ArrayDeque: " + adq.remove(27));
    	
    	System.out.println(adq.peekLast());
    	
    	System.out.println("The size of the current ArrayDeque: " + adq.size());
    	
    }
}
