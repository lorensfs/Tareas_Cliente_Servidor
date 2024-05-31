package Champion.Class;

import Champion.Champion;

import java.util.Random;

public class Rogue extends Champion {

    public Rogue(String name, boolean isDead, double attack, double health) {
        super(name, isDead, attack, health);
        isSpecialRogue();
    }

    boolean specialRogue;

    public boolean getSpecialRogue() {
        return specialRogue;
    }

    public void setSpecialRogue(boolean specialRogue) {
        this.specialRogue = specialRogue;
    }

    protected void isSpecialRogue(){
        Random number=new Random();
        int roll=number.nextInt(4);
        if (roll == 3){
            this.specialRogue=true;
        }
        else{
            this.specialRogue=false;
        }
    }

    protected void classBuff(){
        setHealth(getHealth()*1.15);
    }

}
