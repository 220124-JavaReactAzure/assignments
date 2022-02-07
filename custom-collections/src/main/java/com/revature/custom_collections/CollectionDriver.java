package com.revature.custom_collections;

import com.revature.custom_collections.collections.HashMap;

public class CollectionDriver {

    public static void main(String[] args) {
    	HashMap<Integer,String > hashMap = new HashMap<>();
    	hashMap.put(0, "First Element");
    	System.out.println(hashMap);
    	System.out.println(hashMap.size());
    	hashMap.put(0, "Frst Element");
    	System.out.println(hashMap);
    	System.out.println(hashMap.size());
    	
    	hashMap.put(1, "Second Element");
    	System.out.println(hashMap);
    	System.out.println(hashMap.size());
    	

    }
}
