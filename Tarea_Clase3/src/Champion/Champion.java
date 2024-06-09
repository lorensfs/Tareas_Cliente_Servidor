package Champion;

import java.util.Random;

public class Champion extends Being{


    public Champion(String name, boolean isDead, double attack, double health) {
        this.name = name;
        this.isDead = isDead;
        this.attack = attack;
        this.health = health;
    }

    String name;
    double attack;
    double health;
    boolean isDead;

    public void blessedByDev() {
        Random number=new Random();
        int roll=number.nextInt(99);
        if (roll == 98){
            this.health=this.health*10;
            System.out.println(getName()+ " is immortal by Dev protection");
        }
    }

    public void attackOpponent(Champion opponent){
        Random rollNumber= new Random();
        double damage= rollNumber.nextDouble(this.attack);
        opponent.subtractHealth(damage);
        System.out.println(opponent.getName() + " took a hit of " + damage + ". Health remaining: " + opponent.health );
    }

    public void subtractHealth(double damage){
        if ((this.health-damage)<=0){
            setDead(true);
        }
        else {
            setHealth(this.health-damage);
        }
    }

    public double getAttack() {
        return attack;
    }

    public double getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public boolean getIsDead() {
        return isDead;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDead(boolean dead) {
        this.isDead = dead;
    }

}
