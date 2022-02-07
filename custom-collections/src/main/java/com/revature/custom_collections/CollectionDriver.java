package com.revature.custom_collections;

import com.revature.custom_collections.collections.ArrayDeque;
import com.revature.custom_collections.collections.HashMap;
// import com.revature.custom_collections.collections.HashSet;
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
        // HashSet<String> hs = new HashSet<>();
        // hs.add("data");
        // System.out.println(hs.isEmpty());
        // ArrayDeque adq = new ArrayDeque();
        // System.out.println(adq.peekFirst());
        // adq.add(27);
        // System.out.println(adq.peekLast());
    }
}
