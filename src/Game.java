import javax.xml.bind.annotation.XmlElementDecl;
import java.util.*;
import java.io.*;

public class Game {
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_RESET = "\u001B[0m";
public  Player playerz = new Player("TEST", "TESZT", 100, 5, 10, 2, 0);


public void play(){
	
	
}


//Starts a new 
public static void main (String[] args){
	int go=0;
	while(go ==0){
	System.out.println("╔════════════════════════════════╗");
	System.out.println("║  Hello and welcome to TextRPG  ║");
	System.out.println("║ 1) Play game                   ║");
	System.out.println("║ 2) About                       ║");
	System.out.println("║ 3) Settings                    ║");
	System.out.println("║ 4) Quit                        ║");
	System.out.println("╚════════════════════════════════╝");
	Scanner scan = new Scanner(System.in);
	int option =scan.nextInt();
	
	if(option == 1)         {
		Game game = new Game();
		game.play();
		go=1;}
	else if (option ==2){
		System.out.println("Made by Dan Janes");
		System.out.println("Started on 12/17/14 and finished on XXX");
		System.out.println("Press any letter and hit enter to get back to the main menu");
		scan.next();
	}
	else if (option==3){
		System.out.println("JK no settings right now");	
		System.out.println("Press any letter and hit enter to get back to the main menu");
		scan.next();
	}
	else if (option==4){
		System.out.println("Good bye");
		System.exit(0);
	}
					}
	
	
	
}

}









