/**
 * Created by Dan on 12/18/2015.
 */
public class Slime implements Monster{
    int lvl=0;
    int hp=100;
    @Override
    public int getAttack() {
        return 0;
    }

    @Override
    public int getHitPoints() {
        return 0;
    }

    @Override
    public int getXP() {
        return 0;
    }

    @Override
    public int getMinDamage() {
        return 0;
    }

    @Override
    public int getMaxDamage() {
        return 0;
    }

    @Override
    public int getDefence() {
        return 0;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public String getAttackName() {
        return "Slime blast";
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public void setHitPoints(int hp) {

    }

    @Override
    public String getDescription() {
        return null;
    }
}
