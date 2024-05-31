package Champion;

import java.util.Random;

public class Champion {

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

    protected void attackOpponent(Champion opponent){
        Random rollNumber= new Random();
        double damage= rollNumber.nextDouble(this.attack);
        subtractHealth(damage);
        System.out.println(this.name + " took a hit of " + damage + ". Health remaining: " + this.health );
    }

    protected void subtractHealth(double damage){
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
