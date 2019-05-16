package dataStructure;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
public class cardGames {

	public static void cardGame(LinkedList deck) {
		int random1=(int)(Math.random() * 53);
		int random2=(int)(Math.random() * 53);
		int random3=(int)(Math.random() * 53);
		int random4=(int)(Math.random() * 53);
			
			System.out.print("\nPlayer's Card: ");			
				drawCard(deck, random1);
				drawCard(deck, random2);
			System.out.print("\nComputer's Card: ");
				drawCard(deck, random3);	
				drawCard(deck, random4);
		
		String cardOne = (String)deck.get(random1);
		String cardTwo=(String)deck.get(random2);
		String cardThree = (String)deck.get(random3);
		String cardFour=(String)deck.get(random4);
		
			compareCards(convertToInt(cardOne),convertToInt(cardTwo), random1, random2);
			compareCards(convertToInt(cardThree),convertToInt(cardFour), random3, random4);
		
		deck.remove(random1);		
		deck.remove(random2);	
		deck.remove(random1);		
		deck.remove(random2);
	}
	
	
	public static int convertToInt(String s) {
		if(Character.toString(s.charAt(0)).equals("J")) {
			return 11;
		} else if(Character.toString(s.charAt(0)).equals("Q")) {
			return 12;
		} else if(Character.toString(s.charAt(0)).equals("K")) {
			return 13;
		} else if(Character.toString(s.charAt(0)).equals("A")) {
			return 1;
		} else if(s.equals("Joker")) {
			return 50;
		}else {
			return Integer.parseInt(Character.toString(s.charAt(0)));
		}
	}
	

	public static void drawCard(LinkedList<Object> list, int random) {
		System.out.print(list.get(random));
	}
	
	
	public static void compareCards(int cardOne, int cardTwo, int cardThree, int cardFour) {
		if(cardOne-cardTwo<=cardThree-cardFour) {
			System.out.println("\nPlayer Wins!");
		} else {
			System.out.println("\nComputer Wins!");
		}
	}
	
public static void main (String [] args) {

		LinkedList<Object> deck=new LinkedList<Object>();
		LinkedList<Object> rank=new LinkedList<Object>();
		LinkedList<Object> suits=new LinkedList<Object>();
		
		for(int  j=1;j<5;j++) {	
			rank.add('A');
			rank.add('K');
			rank.add('Q');
			rank.add('J');
			for(int i=1;i<=9;i++) {
				rank.add(i+1);
			}
		}

		suits.add("Clubs");
		suits.add("Hearts");
		suits.add("Diamond");
		suits.add("Spades");
		for(int i=0;i<suits.size();i++) {	
			for(int j=0;j<13;j++) {
				deck.add(rank.get(j)+" of "+suits.get(i));
			}
		}
		for(int i=0;i<4;i++) {
				deck.add("Joker of "+suits.get(i));
		}
		
		System.out.println("Deck of Cards: "+deck);		
		Collections.shuffle(deck);							
		System.out.println("Shuffled Deck: "+deck);			
	
		Scanner scanner = new Scanner(System.in);
		System.out.print("Press enter to begin game ");
		String string = scanner.nextLine();
		while(true) {
		if (string.equalsIgnoreCase("")) 
			cardGame(deck);
	
		System.out.print("Would you like to play again? (Yes or No)");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("No")) 
        	break;
		}
		
	}
}

