package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EX30_4 {
    static Integer balance = 0;
    public static void main(String[] args) throws Exception{
        ExecutorService executor = Executors.newFixedThreadPool(1000);

        for(int i = 0; i < 1000; i++){
            executor.execute(new AddTask());
        }
        executor.shutdown();
        while(!executor.isTerminated()){}
        System.out.println(balance);
    }
    static class AddTask implements Runnable{
        @Override
        public void run(){
            add();
        }
    }
    public static void add(){
        balance+=1;
    }
}
