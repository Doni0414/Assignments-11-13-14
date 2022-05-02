package com.company;

import java.util.*;

public class EX21_6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        Map<Integer,Integer> map = new TreeMap<>();
        int a = scan.nextInt();
        while(a != 0){
            list.add(a);
            a = scan.nextInt();
        }

        Set<Integer> set = new TreeSet<>(list);

        for(Integer number: set){
            int count = 0;
            map.put(number,0);
            for(Integer element: list){
                if(number == element){
                    map.remove(number);
                    map.put(number,++count);
                }
            }
        }

        int max = 0;
        int key = 0;
        Map<Integer,Integer> last = new TreeMap<>();
        for(Map.Entry<Integer,Integer> el: map.entrySet()){
            if(max < el.getValue()){
                max = el.getValue();
                key = el.getKey();
            }
        }
        last.put(key,max);
        for(Map.Entry<Integer,Integer> el: map.entrySet()){
            if(max == el.getValue()){
                last.put(el.getKey(),el.getValue());
            }
        }

        for (Map.Entry<Integer,Integer> b: last.entrySet()) {
            System.out.println(b.getKey()+" occurs "+b.getValue()+" times");
        }

    }
}
