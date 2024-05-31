package Champion.Class;

import Champion.Champion;

import java.util.Random;

public class Tank extends Champion {

    public Tank(String name, boolean isDead, double attack, double health) {
        super(name, isDead, attack, health);
        isSpecialTank();
    }

    boolean specialTank;


    public void setSpecialTank(boolean specialTank) {
        this.specialTank = specialTank;
    }

    public boolean getSpecialTank() {
        return specialTank;
    }

    protected void classBuff(){
        setAttack(getAttack()*1.15);
    }

    protected void isSpecialTank(){
        Random number=new Random();
        int roll=number.nextInt(4);
        if (roll == 3){
            this.specialTank=true;
        }
        else{
            this.specialTank=false;
        }
    }

}
