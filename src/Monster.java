public interface Monster {
    int hp=100;
    int level=0;
//attack
int getAttack();

//HP
int getHitPoints();

//XP Drop
int getXP();

//Not very important right now but can be helpfull
int getMinDamage();
int getMaxDamage();

//defence-attack=hit to health
int getDefence();

//based off of player level (somehow)
int getLevel();

//used for fighting text
String getAttackName();

//Returns if HP is > 0
boolean isAlive();


//Sets health
void setHitPoints(int hp);

    String getDescription();
}
