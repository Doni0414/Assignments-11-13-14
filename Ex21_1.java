package com.company;

import java.util.*;

/////////////////IT'S THE 21.1/////////////////////
/////////////////IN THESE 4 CLASSES THERE ARE EX21.1, EX21.6, EX30.4 and EX30.11///////////////////
public class Main {

    public static void main(String[] args) {
        Set<String> set1 = new HashSet();
        Set<String> set2 = new HashSet();

        set1.add("George");
        set1.add("Jim");
        set1.add("John");
        set1.add("BLake");
        set1.add("Kevin");
        set1.add("Michael");

        Set<String> s1 = new LinkedHashSet<>(set1);

        set2.add("George");
        set2.add("Katie");
        set2.add("Kevin");
        set2.add("Michelle");
        set2.add("Ryan");

        Set<String> s2 = new LinkedHashSet<>(set2);

        s1.addAll(s2);
        System.out.println("After union: "+s1);

        s1 = new LinkedHashSet<>(set1);
        s1.removeAll(s2);
        System.out.println("After difference: "+s1);

        s1 = new LinkedHashSet<>(set1);
        s1.retainAll(s2);
        System.out.println("After intersection: "+s1);

    }
}
