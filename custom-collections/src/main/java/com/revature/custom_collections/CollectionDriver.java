package com.revature.custom_collections;

import com.revature.custom_collections.collections.HashMap;

public class CollectionDriver {

    public static void main(String[] args) {

    	HashMap hashMap = new HashMap<>();
    	test_HashMap(hashMap);
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }//end main
    	
    
    public static void test_HashMap(HashMap hashMap) {
    	if(hashMap.isEmpty() != true) {
			System.out.print("\n1isEmpty is not working!\n");
		}
    	if(hashMap.size() != 0) {
			System.out.print("\n1Size is not working!\n");
    	}
    	hashMap.put("apple", "A");
    	
    	if(hashMap.size() == 0) {
			System.out.print("\n2Size is not working!\n");
    	}
    	if(hashMap.isEmpty() == true) {
			System.out.print("\n2isEmpty is not working!\n");
		}
    	if(hashMap.containsKey("bananna") == true) {
			System.out.print("\n1containsKey is not working!\n");
		}
    	hashMap.put("bananna", "B");
    	
    	if(hashMap.containsKey("bananna") == false) {
			System.out.print("\n2containsKey is not working!\n");
		}
    	
    	if(hashMap.containsValue("C") == true) {
			System.out.print("\n1containsValue is not working!\n");
		}
    	hashMap.put("carrot", "C");
    	
    	if(hashMap.containsValue("C") == false) {
			System.out.print("\n2containsValue is not working!\n");
		}
    	hashMap.put("dice", "D");
    	
    	if(hashMap.get("dice") != "D") {
			System.out.print("\n1Get is not working!\n");
		}
    	if(hashMap.put("egg", "E") != null) {
    		System.out.print("\n1Put is not working!\n");
		}
    	if(hashMap.put("egg", "E1") != "E") {
    		System.out.print("\n2Put is not working!\n");
		}
    	hashMap.put("fig", "F");
    	hashMap.put("grape", "G");
    	hashMap.put("home", "H");
    	hashMap.put("igloo", "I");
    	hashMap.put("jam", "J");
    	hashMap.put("kite", "K");
    	hashMap.put("lettace", "L");
    	hashMap.put("mayonase", "M");
    	hashMap.put("nap", "N");
    	hashMap.put("octopus", "O");
    	hashMap.put("pipe", "P");
    	hashMap.put("question", "Q");
    	hashMap.put("rust", "R");
    	hashMap.put("sister", "S");
    	hashMap.put("tacle", "T");
    	hashMap.put("umbrella", "U");
    	hashMap.put("vikie", "V");
    	hashMap.put("water", "W");
    	hashMap.put("xavior", "X");
    	hashMap.put("yell", "Y");
    	hashMap.put("zap", "Z");
    	
    	System.out.print(hashMap.printHashMap());

    	hashMap.remove("apple");
    	hashMap.remove("bananna");
    	hashMap.remove("carrot");
		hashMap.remove("dice");
		if(hashMap.remove("egg") != "E1") {
			System.out.println("\nRemove is not working!\n");
		}
		if(hashMap.remove("egg") != null) {
			System.out.println("\n1Remove is not working!\n");
		}
		hashMap.remove("fig");
		hashMap.remove("grape");
		hashMap.remove("home");
		hashMap.remove("igloo");
		hashMap.remove("jam");
		hashMap.remove("kite");
		hashMap.remove("lettace");
		hashMap.remove("mayonase");
		hashMap.remove("nap");
		hashMap.remove("octopus");
		hashMap.remove("pipe");
		hashMap.remove("question");
		hashMap.remove("rust");
		hashMap.remove("sister");
		hashMap.remove("tacle");
		hashMap.remove("umbrella");
		hashMap.remove("vikie");
		if(hashMap.get("vikie") != null) {
			System.out.print("\n2Get is not working!\n");
		}
		hashMap.remove("water");
		if(hashMap.containsValue("X") == false) {
			System.out.print("\n3containsValue is not working!\n");
		}
		hashMap.remove("xavior");
		
		if(hashMap.containsValue("X") == true) {
			System.out.print("\n4containsValue is not working!\n");
		}
		if(hashMap.containsKey("yell") == false) {
			System.out.print("\n3containsKey is not working!\n");
		}
		hashMap.remove("yell");
		
		if(hashMap.containsKey("yell") == true) {
			System.out.print("\n4containsKey is not working!\n");
		}
		if(hashMap.isEmpty() == true) {
			System.out.print("\n3isEmpty is not working!\n");
		}
		if(hashMap.size() == 0) {
			System.out.print("\n3Size is not working!\n");
    	}
		hashMap.remove("zap");
		
		if(hashMap.size() != 0) {
			System.out.print("\n4Size is not working!\n");
    	}
		
		if(hashMap.isEmpty() != true) {
			System.out.print("\n4isEmpty is not working!\n");
		}
    }//end test_HashMap
}
