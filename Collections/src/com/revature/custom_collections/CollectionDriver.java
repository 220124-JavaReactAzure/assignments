package com.revature.custom_collections;


import com.revature.custom_collections.collections.HashMap;
import com.revature.custom_collections.collections.HashSet;
import com.revature.custom_collections.collections.ArrayDeque;

public class CollectionDriver {

    public static void main(String[] args) {
    	
    	ArrayDeque<Object> testAD = new ArrayDeque<>();
    	
    	testAD.add("test1");
    	testAD.add("test2");
    	testAD.add("test3");
    	testAD.add("test4");
    	testAD.add("test5");
    	    	
    	System.out.println(testAD.peekFirst());
    	System.out.println(testAD.peekLast());
    	
    	System.out.println("*************");
    	
    	testAD.printAD(); System.out.println(testAD.size());
   
       	System.out.println("+++++++++++++++");
       	System.out.println(testAD.pollLast());
       	System.out.println("+++++++++++++++");
       	
    	testAD.printAD(); System.out.println(testAD.size());
       	/*

    	testAD.remove("test3"); testAD.printAD(); System.out.println(testAD.size());
    	
    	testAD.addFirst("test0"); testAD.printAD(); System.out.println(testAD.size());
       	*/
       	

    	
    	/* HASHSET
    	HashSet<Object> testHS = new HashSet<>();
    	
    	System.out.println(testHS.isEmpty());
    	testHS.add("test1");
    	System.out.println(testHS.isEmpty());
    	testHS.add("test2");
    	
    	System.out.println("Contains the key: "+testHS.contains("test1"));

    	System.out.println("hashset is : "+testHS.size());

    	testHS.remove("test1");
    	
    	System.out.println("hashset is : "+testHS.size());
    	 */
    	
    	/* HASHMAP
    	HashMap<Object, Object> testHashMap = new HashMap<>();
    	
    	System.out.println("testHashMap is empty? "+testHashMap.isEmpty());
            	
    	testHashMap.put("key1", "value1");
    	testHashMap.put("key2", "value2");
    	testHashMap.put("key3", "value3");
    	
		testHashMap.printMap();
    	System.out.println("---------------");
    	
    	testHashMap.remove("key2");
    	testHashMap.printMap();
    	System.out.println("---------------");
    	
    	testHashMap.remove("key3");
    	testHashMap.printMap();
    	System.out.println("---------------");

		testHashMap.put("key2", "value2");
    	testHashMap.put("key3", "value3");

    	testHashMap.printMap();
    	System.out.println("---------------");

    	
		testHashMap.remove("key1");
    	testHashMap.printMap();
    	System.out.println("---------------");

    	System.out.println("testHashMap is empty? "+testHashMap.isEmpty());
    	*/

    	System.out.println("yay!");
        
    }
}
