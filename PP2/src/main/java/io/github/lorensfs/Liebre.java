package io.github.lorensfs;

import java.util.Random;

public class Liebre extends Thread {
    private int time;


    public Liebre() {
        this.time = 0;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    @Override
    public void run() {
        Random random = new Random();
        int progress = 1;
        while (progress < 70) {
            this.time++;
            try {
                Thread.sleep(100);
                this.time++;
                int number = random.nextInt(100) + 1;
                if (number <= 20) {
                    System.out.println(String.format("L is sleeping"));
                } else if (number <= 40) {
                    int temp = 9;
                    progress += temp;
                    System.out.println(String.format("L advanced: %s tiles, it's current progress is: %s tiles.", temp, progress));
                } else if (number <= 50) {
                    if (progress < 13) {
                        progress = 1;
                    } else {
                        int temp = 12;
                        progress -= temp;
                        System.out.println(String.format("L retraced: %s tiles, it's current progress is: %s tiles.", temp, progress));
                    }
                } else if (number <= 80) {
                    int temp = 1;
                    progress += temp;
                    System.out.println(String.format("L advanced: %s tiles, it's current progress is: %s tiles.", temp, progress));
                } else {
                    if (progress < 3) {
                        progress = 1;
                    } else {
                        int temp = 2;
                        progress -= temp;
                        System.out.println(String.format("L retraced: %s tiles, it's current progress is: %s tiles.", temp, progress));
                    }
                }
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
    }
}
