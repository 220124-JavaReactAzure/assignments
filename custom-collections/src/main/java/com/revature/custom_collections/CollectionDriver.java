package com.revature.custom_collections;

import com.revature.custom_collections.collections.ArrayDeque;

public class CollectionDriver {

    public static void main(String[] args) {
    	
    	ArrayDeque adq = new ArrayDeque();
    	
    	System.out.println(adq.peekFirst());
    	
    	adq.add(27);
    	
    	System.out.println(adq.peekLast());
    	
    }
}
