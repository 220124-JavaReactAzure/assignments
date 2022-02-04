package com.revature.custom_collections;

import com.revature.custom_collections.collections.ArrayDeque;
import com.revature.custom_collections.collections.HashSet;

public class CollectionDriver {

    public static void main(String[] args) {
    	ArrayDeque<String> myDeque = new ArrayDeque<String>();
    	myDeque.add("Happy");
    	myDeque.add("Days");
    	myDeque.add("Are");
    	myDeque.add("Here");
    	System.out.println(myDeque.size());
    	
    	
    	
    	myDeque.remove("Days");
    	
    	System.out.println(myDeque.contains("Are"));
    	System.out.println(myDeque.contains("Days"));
    	
    	System.out.println(myDeque.size());
    	
    	//HashSet<Integer> myHashSet = new HashSet<Integer>();
    }
}
