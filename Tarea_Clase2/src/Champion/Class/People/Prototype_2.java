package Champion.Class.People;

import Champion.Champion;
import Champion.Class.Rogue;

public class Prototype_2 extends Rogue {

    public Prototype_2() {
        super("WhiterSpace", false, 16, 95);
        classBuff();
        isSpecial();
        setRace("Orc");
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
