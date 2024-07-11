package io.github.lorensfs;


public class Main {
    public static void main(String[] args) {
        Liebre liebre=new Liebre();
        Tortuga tortuga=new Tortuga();
        tortuga.start();
        liebre.start();
        try {
            liebre.join();
            tortuga.join();
        }catch (InterruptedException e){
            e.getStackTrace();
        }
        if(tortuga.getTime()> liebre.getTime()){
            System.out.println("L has reached the goal first");
        }else{
            System.out.println("T has reached the goal first");
        }


    }

}