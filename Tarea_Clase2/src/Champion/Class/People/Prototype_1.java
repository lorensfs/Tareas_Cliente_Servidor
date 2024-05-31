package Champion.Class.People;

import Champion.Champion;
import Champion.Class.Rogue;

public class Prototype_1 extends Rogue {

    public Prototype_1() {
        super("ShadowStrike", false, 17, 90);
        classBuff();
        isSpecial();
        setRace("Elf");
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
        System.out.println("Champion "+ getName() +" has been applied a buff in attack by rogue class");
    }

    @Override
    public void attackOpponent(Champion opponent) {
        super.attackOpponent(opponent);
    }

    public void isSpecial(){
        if (getSpecialRogue()){
            System.out.println(getName()+" is special");
            setAttack(getAttack()*1.15);
            setHealth(getHealth()*1.15);
        }
    }

}
