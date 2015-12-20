import java.io.BufferedReader;
import java.util.Scanner;

public final class Battle {

	public Battle(Player player, Monster monster){
		System.out.println("oh no a battle with "+monster);
		Scanner scan = new Scanner(System.in);
		while (player.isAlive() && monster.isAlive()) {
			
			System.out.println("Attack (a) or heal (h)?");
			String action = scan.nextLine();
			
			if (action.equals("h")){
			
				if(player.getPotions()>0){
				player.heal();}
				
				else {
					System.out.println("Sorry you don't have a potion, now attacking");
					}
			}
			else{
				//NEEDS TO ATTACK
			}
		}
	}

}
