package com.abhi;

public class Main {
    public static void main(String[] args) {
        //System.out.println(1<<4);

        int temp = 100 ;
        int i = 1;
        while(i < 32){
            System.out.println(1<<i);
            if(1<<i == temp){
                System.out.println("hello");
                break ;
            }
            i++ ;
        }
    }
}