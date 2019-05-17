package main;

public class Player extends Coordinates{
	public void updateCoordinates(String direction) {
		if(direction.toLowerCase().equals("north")||direction.equals("n")) {
			setCoordinates(this.getCoordinates()[0],this.getCoordinates()[1]+1);
		}
		else if(direction.toLowerCase().equals("south")||direction.equals("s")) {
			setCoordinates(this.getCoordinates()[0],this.getCoordinates()[1]-1);
		}
		else if(direction.toLowerCase().equals("east")||direction.equals("e")) {
			setCoordinates(this.getCoordinates()[0]+1,this.getCoordinates()[1]);
		}
		else if(direction.toLowerCase().equals("west")||direction.equals("w")) {
			setCoordinates(this.getCoordinates()[0]-1,this.getCoordinates()[1]);
		}
	}
}
