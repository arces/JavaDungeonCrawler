import java.util.*;

public class Player {

	private String name;
	private String description;
	private int maxHitPoints;
	//Health
	private int hitPoints;
	//Amount of Potions
	private int numPotions;
	//Unused
	private int minHit;
	//Damages
	private int minDamage;
	private int maxDamage;
	private Random random = new Random();
	public int level;
	private static  int xp;
	
	public Player(String namez, String descriptionz, int maxHitPointsz, int minDamagez, int maxDamagez,
			int numPotionsz, int levelz) {
		name = name;
		description = descriptionz;
		maxHitPoints = maxHitPointsz;
		minDamage = minDamagez;
		maxDamage = maxDamagez;
		numPotions = numPotionsz;
		hitPoints = maxHitPointsz;
		level = level;
		xp = 0;
	}
	
	public int getMinDamage(){
		return minDamage;
	}
	
	public int getMaxDamage(){
		return maxDamage;
	}
	
	//Attack points
	public int attack(){
	RandomNum r = new RandomNum();
		return r.random(minDamage, maxDamage);
	}
	
	
	public String getName(){
		return name;
	}
	
	public String getD(){
		return description;
	}
	
	public int gotPotions(){
		return numPotions;
	}
	
	public void addPotions(int num){
		numPotions = numPotions+num;
	}
	public void subPotions(int num){
		if(numPotions>0){
		numPotions = numPotions-num;}
		else{}
	}
	public void heal(){
		if(numPotions>0){
			hitPoints = hitPoints + 99999; //NEEDS TO BE DECIDED ON LATER!!!!!!!!!!!!!!!!!!!!!!!!!!
		}
	}
	
	public int getHP(){
		return hitPoints;
	}
	
	public boolean isAlive(){
		return hitPoints > 0;
	}
	
	//Adds xp then updates level
	public void XP(int tempXP){
		xp = xp +tempXP;
		lvlCheck();
		}
	//Checks xp and (if needed) calls method to update level and print a congrats
	public void lvlCheck(){
		int temp = 0;
		if (xp<=0){temp=0;}
		else if(xp<100){temp=1;}
		else if(xp<200){temp=2;}
		else if(xp<400){temp=3;}
		else if(xp<600){temp=4;}
		else if(xp<800){temp=5;}
		else if(xp<1000){temp=6;}
		else if(xp<1200){temp=7;}
		else if(xp<1400){temp=8;}
		else if(xp<1600){temp=9;}
		else if(xp<1800){temp=10;}
		else if(xp<2000){temp=11;}
		else if(xp<2200){temp=12;}
		else if(xp<2400){temp=13;}
		else if(xp<2600){temp=14;}
		else if(xp<3000){temp=15;}
		else if(xp<3400){temp=16;}
		else if(xp<3800){temp=17;}
		else if(xp<4200){temp=18;}
		else if(xp<4500){temp=19;}
		else if(xp<5000){temp=20;}
		else if(xp<6000){temp=21;}
		else if(xp<6500){temp=22;}
		else if(xp<6800){temp=23;}
		else if(xp<7000){temp=24;}
		else if(xp<7300){temp=25;}
		else if(xp<7600){temp=26;}
		else if(xp<8000){temp=27;}
		else if(xp<8500){temp=28;}
		else if(xp<9000){temp=29;}
		else if(xp<10000){temp=30;}
		else{temp=69;}
		
		//Checks if leveled up (and cheated (or broken))
		if(temp==69){System.out.println("Your a DIRTY H@ck0r");}
		if(temp != level){
			level = temp;
			//runs level up with new level
			Player.levelUp(level);
		}
		else{}
	}
		//prints out that you leveled up :D
	public static void levelUp(int lvl){
		System.out.println("Congrats you leveled up to "+lvl);
	}
	
	public static Player newInstance(){
		return new Player("TEST", "TESZT", 100, 5, 10, 2, 0);
	}
	}

