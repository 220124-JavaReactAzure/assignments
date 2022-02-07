package com.revature.custom_collections;

import com.revature.custom_collections.collections.ArrayDeque;
import com.revature.custom_collections.collections.HashMap;
import com.revature.custom_collections.collections.HashSet;

public class CollectionDriver {

    public static void main(String[] args) {
    	HashMap<String, Integer> hashMap = new HashMap<>();
    	System.out.println( "Expecting true:" + hashMap.isEmpty() );
    	
    	hashMap.put("Phil", 5);
    	hashMap.put("Dan", 4);
    	hashMap.put("Matt", 3);
    	hashMap.put("Em", 2);
    	hashMap.put("Nic", 1);
    	System.out.println("Expecting 5:" +  hashMap.size() );
    	
    	System.out.println("Expecting null:" +  hashMap.remove("Bart") );
    	System.out.println("Expecting 5:" +  hashMap.remove("Phil") );
    	System.out.println("Expecting null:" +  hashMap.remove("Phil") );
    	System.out.println("Expecting 2:" +  hashMap.remove("Em") );
    	System.out.println("Expecting nul:" +  hashMap.remove("Em") );
    	System.out.println("Expecting false:" +  hashMap.containsValue(10) );
    	System.out.println("Expecting true:" +  hashMap.containsValue(1) );
    	System.out.println("Expecting 3:" +  hashMap.size() );
    	System.out.println("Expecting false:" +  hashMap.isEmpty() );
    	System.out.println("Expecting 1:" +  hashMap.get("Nic") );
    	
    	HashSet<String> hashSet = new HashSet<>();
    	
    	System.out.println("Expecting true:" +  hashSet.isEmpty() );
    	System.out.println("Expecting 0:" +  hashSet.size() );
    	hashSet.add("Charles");
    	hashSet.add("Xavier");
    	System.out.println("Expecting false:" +  hashSet.add("Charles") );
    	System.out.println("Expecting true:" +  hashSet.contains("Charles") );
    	System.out.println("Expecting true:" +  hashSet.remove("Charles") );
    	System.out.println("Expecting false:" +  hashSet.remove("Ch4rles") );
    	System.out.println("Expecting false:" +  hashSet.remove("Charles") );
    	System.out.println("Expecting 1:" +  hashSet.size() );
    	
    	ArrayDeque<String> arrayDeque = new ArrayDeque<>();
    	System.out.println("Expecting true:" +  arrayDeque.isEmpty() );
    	System.out.println("Expecting 0:" +  arrayDeque.size() );
    	arrayDeque.add("One");
    	arrayDeque.add("Two");
    	arrayDeque.add("Three");
    	System.out.println("Expecting One:" +  arrayDeque.peekFirst() );
    	System.out.println("Expecting Three:" +  arrayDeque.peekLast() );
    	System.out.println("Expecting One:" + arrayDeque.pollFirst() );
    	System.out.println("Expecting Two:" + arrayDeque.pollFirst() );
    	arrayDeque.addFirst("Two");
    	arrayDeque.addFirst("One");
    	System.out.println("Expecting Three:" +  arrayDeque.pollLast() );
    	System.out.println("Expecting Two:" +  arrayDeque.pollLast() );
    	System.out.println("Expecting One:" +  arrayDeque.pollLast() );
    	arrayDeque.add("One");
    	arrayDeque.add("Two");
    	arrayDeque.add("Three");
    	System.out.println("Expecting true:" +  arrayDeque.contains("Two") );
    	System.out.println("Expecting false:" +  arrayDeque.contains("Four") );
    	System.out.println("Expecting true:" + arrayDeque.remove("Two") );
    	System.out.println("Expecting 2:" +  arrayDeque.size() );
    	System.out.println("Expecting false:" +  arrayDeque.contains("Two") );
    }
}
