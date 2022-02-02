package com.revature.custom_collections;

// import com.revature.custom_collections.collections.ArrayDeque;
import com.revature.custom_collections.collections.HashMap;
// import com.revature.custom_collections.collections.HashSet;
// import com.revature.custom_collections.collections.LinkedList;

public class CollectionDriver {

    public static void main(String[] args) {
        // LinkedList<String> ll = new LinkedList<>();
        // ll.add("data");
        // System.out.println(ll.toString());

        // ArrayDeque<String> dq = new ArrayDeque<>();
        // dq.add("data");
        // System.out.println(dq.isEmpty());

        HashMap<String, String> hm = new HashMap<>();
        hm.put("0", "data0");
        hm.put("1", "data1");
        hm.put("2", "data2");
        // hm.get("1");
        System.out.println(hm.get("1"));

        // HashSet<String> hs = new HashSet<>();
        // hs.add("data");
        // System.out.println(hs.isEmpty());
    }
}
