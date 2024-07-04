package io.github.lorensfs;

import java.util.Random;

public class Tortuga extends Thread{
    private int time;

    public Tortuga() {
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
            try {
                this.time++;
                Thread.sleep(100);
                this.time++;
                int number = random.nextInt(100) + 1;
                if (number <= 50) {
                    int temp = 3;
                    progress += temp;
                    System.out.println(String.format("T advanced: %s tiles, it's current progress is: %s tiles.", temp, progress));
                } else if (number <= 70) {
                    if (progress < 7) {
                        progress = 1;
                    } else {
                        int temp = 6;
                        progress -= temp;
                        System.out.println(String.format("T retraced: %s tiles, it's current progress is: %s tiles.", temp, progress));
                    }
                } else {
                    int temp = 1;
                    progress += temp;
                    System.out.println(String.format("T advanced: %s tiles, it's current progress is: %s tiles.", temp, progress));
                }
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
    }
}
