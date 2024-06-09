package Champion.Class;

import Champion.Champion;

public abstract class Class extends Champion {

    public Class(String name, boolean isDead, double attack, double health) {
        super(name, isDead, attack, health);
    }

    public abstract void classBuff();
}
