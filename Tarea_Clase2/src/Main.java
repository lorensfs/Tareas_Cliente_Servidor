import Champion.Class.People.Prototype_1;
import Champion.Class.People.Prototype_2;
import Champion.Class.People.Prototype_3;
import Champion.Class.People.Prototype_4;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Prototype_1 hero1 = new Prototype_1();
        Prototype_2 hero2 = new Prototype_2();
        Prototype_3 hero3 = new Prototype_3();
        Prototype_4 hero4 = new Prototype_4();

        Random number=new Random();

        // LOOP FIGHT
        // Prototype_1 vs Prototype_3
        while (!hero1.getIsDead() && !hero3.getIsDead()){
            int roll=number.nextInt(2);
            if (roll == 1){
                hero2.attackOpponent(hero1);
            }else{
                hero1.attackOpponent(hero2);
            }
            if (hero1.getIsDead()){
                System.out.println(hero1.getName()+" is dead.");
            }
            if (hero2.getIsDead()){
                System.out.println(hero2.getName()+" is dead.");
            }
        }

        // Prototype_2 vs Prototype_4
        while (!hero3.getIsDead() && !hero4.getIsDead()){
            int roll=number.nextInt(2);
            if (roll == 1){
                hero3.attackOpponent(hero4);
            }else{
                hero4.attackOpponent(hero3);
            }
            if (hero3.getIsDead()){
                System.out.println(hero3.getName()+"is dead.");
            }
            if (hero4.getIsDead()){
                System.out.println(hero4.getName()+"is dead.");
            }
        }

    }
}