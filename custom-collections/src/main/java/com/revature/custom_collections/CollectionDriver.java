package com.revature.custom_collections;

import com.revature.custom_collections.collections.ArrayDeque;
import com.revature.custom_collections.collections.HashMap;
import com.revature.custom_collections.collections.HashSet;
import com.revature.custom_collections.collections.LinkedList;

public class CollectionDriver {

    public static void main(String[] args) {
        
        System.out.println("LinkedList: ---------------");
        LinkedList<String> ll = new LinkedList<>();
        ll.add("data1");
        ll.add("data2");
        System.out.println(ll.toString());

        System.out.println("ArrayDeque: ---------------");
        ArrayDeque<String> dq = new ArrayDeque<>();
        dq.add("data1");
        dq.add("data2");
        System.out.println(dq.isEmpty());
        // System.out.println(dq.contains());
        System.out.println(dq.toString());

        System.out.println("HashMap: ---------------");
        HashMap<String, String> hm = new HashMap<>();
        hm.put("0", "data0");
        hm.put("1", "data1");
        hm.put("2", "data2");
        // hm.get("1");
        System.out.println("containsKey: " + hm.containsKey("2"));
        System.out.println("containsValue: " + hm.containsValue("data2"));
        System.out.println(hm.get("1"));

        HashSet<String> hs = new HashSet<>();
        hs.add("data");
        System.out.println(hs.isEmpty());
    	
        System.out.println("ArrayDeque2: ---------------");
        ArrayDeque<String> int_deque = new ArrayDeque<>();
		  
        int_deque.add("Hello1"); int_deque.add("Hello2"); int_deque.add("Hello3");
        int_deque.addLast("Hello4"); int_deque.addLast("Hello5");
        
        System.out.println("added 5 hellos");
        
        System.out.println(int_deque.size()); 
        System.out.println(int_deque.peek());
        
        System.out.println("removing first"); 
        System.out.println(int_deque.poll());
        System.out.println(int_deque.size()); 
        System.out.println(int_deque.peek());
        
        System.out.println("removing first");
        System.out.println(int_deque.pollFirst());
        System.out.println(int_deque.size()); 
        System.out.println(int_deque.peek());
        
        System.out.println("removing last");
        System.out.println(int_deque.pollLast());
        System.out.println(int_deque.isEmpty());
        
        System.out.println(int_deque.peekLast()); 
        int_deque.addLast("Hello6");
        System.out.println(int_deque.peekLast());
        
        System.out.println(int_deque.pollFirst());
        System.out.println(int_deque.pollLast());
        System.out.println(int_deque.size());
        System.out.println(int_deque.isEmpty());


        HashMap<String, Integer> hashMap = new HashMap<>();
    	System.out.println( "Expecting true:" + hashMap.isEmpty() );
    	
    	hashMap.put("Phil", 5);
    	hashMap.put("Dan", 4);
    	hashMap.put("Matt", 3);
    	hashMap.put("Em", 2);
    	hashMap.put("Nic", 1);
    	System.out.println("Expecting 5:" +  hashMap.size() );
    	
    	System.out.println("Expecting null:" +  hashMap.remove("Bart") );
    	// System.out.println("Expecting 5:" +  hashMap.remove("Phil") );
    	// System.out.println("Expecting null:" +  hashMap.remove("Phil") );
    	// System.out.println("Expecting 2:" +  hashMap.remove("Em") );
    	// System.out.println("Expecting nul:" +  hashMap.remove("Em") );
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
    	// System.out.println("Expecting false:" +  arrayDeque.contains("Four") );
    	System.out.println("Expecting true:" + arrayDeque.remove("Two") );
    	System.out.println("Expecting 2:" +  arrayDeque.size() );
    	// System.out.println("Expecting false:" +  arrayDeque.contains("Two") );
    	arrayDeque.addFirst("Four");
    	arrayDeque.addFirst("Five");
    	arrayDeque.addFirst("Six");
    	arrayDeque.addFirst("Seven");
    	System.out.println("Expecting Seven:" + arrayDeque.pollFirst());
    	System.out.println("Expecting Six:" + arrayDeque.pollFirst());
    	System.out.println("Expecting 4:" +  arrayDeque.size() );
    	System.out.println("Expecting true:" + arrayDeque.remove("Four") );
    	// System.out.println("Expecting false:" + arrayDeque.remove("Four") );
    	
    }
}
