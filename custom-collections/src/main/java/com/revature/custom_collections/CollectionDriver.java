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

		myDeque.addFirst("Days");

		System.out.println(myDeque.contains("Days"));

		System.out.println(myDeque.size());
		
		System.out.println(myDeque.peekFirst());
		System.out.println(myDeque.peekLast());
		
		
		System.out.println(myDeque.pollFirst());
		System.out.println(myDeque.size());

		System.out.println(myDeque.pollLast());
		System.out.println(myDeque.size());
		
		System.out.println(myDeque.contains("Days"));
		System.out.println(myDeque.contains("Here"));
		

		/*
		 * HashSet<Integer> myHashSet = new HashSet<Integer>();
		 * 
		 * System.out.println(myHashSet.isEmpty());
		 * 
		 * myHashSet.add(1); myHashSet.add(2); myHashSet.add(3);
		 * 
		 * System.out.println(myHashSet.size());
		 * 
		 * myHashSet.add(1);
		 * 
		 * System.out.println(myHashSet.size());
		 * System.out.println(myHashSet.contains(2));
		 * System.out.println(myHashSet.isEmpty());
		 * 
		 * myHashSet.remove(2); System.out.println(myHashSet.size());
		 * System.out.println(myHashSet.contains(2));
		 */
	}
}
