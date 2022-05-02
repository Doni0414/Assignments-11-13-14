package com.company;

public class EX30_11 {
    static Object a = new Object();
    static Object b = new Object();
    public static void main(String[] args) {
        Thread thread1 = new Thread(new A());
        Thread thread2 = new Thread(new B());

        thread1.start();
        thread2.start();
    }
    static class A implements Runnable{
        @Override
        public void run(){
            synchronized (a){
                System.out.println("a of A");
                synchronized (b){
                    System.out.println("b of A");
                }
            }
        }
    }
    static class B implements Runnable{
        @Override
        public void run(){
            synchronized (b){
                System.out.println("b of B");
                synchronized (a){
                    System.out.println("a of B");
                }
            }
        }
    }
}
