package Champion.Class;

import java.util.Random;

public class Tank extends Class {

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

    public void classBuff(){
        setAttack(getAttack()*1.15);
    }

    protected void isSpecialTank(){
        Random number=new Random();
        int roll=number.nextInt(4);
        this.specialTank= roll == 3;
    }

}
