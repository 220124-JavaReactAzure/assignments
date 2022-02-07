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
    	
    }
}
