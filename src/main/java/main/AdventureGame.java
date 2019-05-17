package main;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AdventureGame {
	Player player;
	Coordinates dial;

	public AdventureGame() {
		System.out.println("Grey foggy clouds float oppressively close to you, \r\n"
				+ "reflected in the murky grey water which reaches up your shins.\r\n"
				+ "Some black plants barely poke out of the shallow water.\r\n"
				+ "Try \"north\",\"south\",\"east\",or \"west\"\r\n"
				+ "You notice a small watch-like device in your left hand.  \r\n"
				+ "It has hands like a watch, but the hands don't seem to tell time. ");
		player = new Player();
		dial = new Coordinates(player);
		getMove();
	}

	public static void main(String[] args) {
		new AdventureGame();
	}

	public void getMove() {
		Scanner sc = new Scanner(System.in);
		boolean notAtObjective = true;
		List<String> acceptedInputs = Arrays.asList("north", "n", "south", "s", "west", "w", "east", "e");
		String input = "";
		player.compareCoordinates(dial);
		do {
			input = sc.nextLine();
			if (acceptedInputs.contains(input.toLowerCase())) {
				player.updateCoordinates(input.toLowerCase());
				notAtObjective = player.compareCoordinates(dial);
			}
			else System.out.println("Try \"north\",\"south\",\"east\",or \"west\"\r\n");
		} while (notAtObjective);
		sc.close();
	}

}