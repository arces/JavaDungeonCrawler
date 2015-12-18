import java.util.Random;
/**
public class AATemp implements Monster {

	public AATemp() {}
		private int hitPoints;
		private int minDamage;
		private int maxDamage;
		private int XP;
		private int level;
		private int location;
		private int Defence;
		private String attackName;
		private final Random random = new Random();

		public AATemp(int getHitPoints, int getMinDamage, int getMaxDamage, int getXP, int getLevel, int getLocation, int Defence, String Attackname){
			this.hitPoints = getHitPoints;
			this.minDamage = getMinDamage;
			this.maxDamage = getMaxDamage;
			this.XP = getXP;
			this.level = getLevel;
			this.location = getLocation;
			this.Defence = Defence;
			this.attackName=Attackname;
		}

		public int getAttack(){
			return RandomNum.random(minDamage, maxDamage);
		}
		
		public  int getHitPoints()
		{return hitPoints;
			//get the location
			//if location == dungeon, get dungeon level, give monster hit points based on dungeon level
			//if location == wild, hit points = random num
		}

		public  int getMinDamage()
		{return minDamage;
			//given based on hit points
		}

		public  int getMaxDamage()
		{return maxDamage;
			//equals Min Attack plus 20
		}

		public int getDefence(){
			return Defence;
			//Unused 12/27/14
		}
		
		public String getAttackName(){
			return attackName;
		}
		
		public  int getXP()
		{return XP;
			//rewarded based on player level
		}

		public  int getLevel()
		{return level;
			//determined by hit points
		}

		public  int getLocation()
		{return location;
			//equal to players current location
		}

		public void setHitPoints(int hp){
			hitPoints=hp;
		}
	public boolean isAlive(){
		return hitPoints > 0;
	}

}
*/