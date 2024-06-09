package Champion.Class.People;

import Champion.Champion;
import Champion.Class.Tank;

public class Prototype_4 extends Tank {

    public Prototype_4() {
        super("StoneGuard",false, 10, 132);
        classBuff();
        isSpecial();
        setRace("Dwarf");
        blessedByDev();
    }

    String race;

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public void classBuff() {
        super.classBuff();
        System.out.println("Champion "+ getName() +" has been applied a buff in health by tank class");
    }

    @Override
    public void attackOpponent(Champion opponent) {
        super.attackOpponent(opponent);
    }

    public void isSpecial(){
        if (getSpecialTank()){
            System.out.println(getName()+" is special");
            setAttack(getAttack()*1.15);
            setHealth(getHealth()*1.15);
        }
    }

}
