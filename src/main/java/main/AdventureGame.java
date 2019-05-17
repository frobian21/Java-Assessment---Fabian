package main;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AdventureGame {
	Player player;
	Coordinates dial;
	Scanner sc;

	public AdventureGame() {
		player = new Player();
		newMap();
	}

	public static void main(String[] args) {
		new AdventureGame();
	}

	public void getMove() {
		sc = new Scanner(System.in);
		boolean notAtObjective = true;
		List<String> acceptedInputs = Arrays.asList("north", "n", "south", "s", "west", "w", "east", "e");
		String input = "";
		player.compareCoordinates(dial);
		do {
			input = sc.nextLine();
			if (acceptedInputs.contains(input.toLowerCase())) {
				player.updateCoordinates(input.toLowerCase());
				if (!player.compareCoordinates(dial)) {
					getItem();
					notAtObjective = false;
				}
				;
			} else if (input.toLowerCase().equals("q")) {
				notAtObjective = false;
			} else
				System.out.println("Try \"north\",\"south\",\"east\",or \"west\"\r\n");
		} while (notAtObjective);
		quitOrContinue();
	}

	public void quitOrContinue() {
		sc = new Scanner(System.in);
		boolean badInput = true;
		String input = "";
		if (player.items == 2) {
			System.out.println("You win! The end.");
		} else {
			do {
				System.out.println("Do you want to give up? y/n n");
				input = "n";// sc.nextLine();
				if (Arrays.asList("y", "n").contains(input.toLowerCase()))
					badInput = false;
			} while (badInput);
			
			if (input.toLowerCase().equals("y"))
				System.out.println("You suddenly feel very tired. You lie down and go to sleep.");
			else {
				newMap();
				player.setCoordinates(0, 0);
				dial = new Coordinates(player);
				getMove();
			}
		}
	}

	public void newMap() {
		switch (player.items) {
		case 0:
			System.out.println("Grey foggy clouds float oppressively close to you, \r\n"
					+ "reflected in the murky grey water which reaches up your shins.\r\n"
					+ "Some black plants barely poke out of the shallow water.\r\n"
					+ "Try \"north\",\"south\",\"east\",or \"west\"\r\n"
					+ "You notice a small watch-like device in your left hand.\r\n"
					+ "It has hands like a watch, but the hands don't seem to tell time.");
			break;
		case 1:
			System.out.println("Inside the chest is a large toad sitting with it's mouth open.\r\n"
					+ "Your attention is drawn to a shiny object in it's mouth. It is a diamond ring.\r\n"
					+ "As you reach for the toad it leaps out of the box and hops away.\r\n"
					+ "You notice a small watch-like device in your left hand.\r\n"
					+ "Its hands swing as the frog hops away.\r\n"
					+ "Try \"north\",\"south\",\"east\", or \"west\"\r\n");
		}
		dial = new Coordinates(player);
		getMove();
	}

	public void getItem() {
		switch (player.items) {
		case 0:
			System.out.println("You see a box sitting on the plain. You go up to it and open it.");
			break;
		case 1:
			System.out.println("You see at your feet the fat toad sitting calmly on a lilypad.\r\n"
					+ "You reach towards it and pick its slimy body up.\r\n"
					+ "It looks at you and spits the ring out.");
			break;
		}
		player.items++;
	}
}