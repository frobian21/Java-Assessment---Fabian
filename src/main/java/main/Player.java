package main;

public class Player extends Coordinates{
	int items=0;
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
		checkBounds();			
	}
	public void checkBounds() {
		Boolean outOfBounds = false;
		int limit = 10, refresh = 5;
		if(this.getCoordinates()[1]>limit) {
			outOfBounds=true;
			setCoordinates(this.getCoordinates()[0],-refresh);
		}
		if(this.getCoordinates()[1]<-limit) {
			outOfBounds=true;
			setCoordinates(this.getCoordinates()[0],refresh);
		}
		if(this.getCoordinates()[0]>limit) {
			outOfBounds=true;
			setCoordinates(-refresh,this.getCoordinates()[1]);
		}
		if(this.getCoordinates()[1]<-limit) {
			outOfBounds=true;
			setCoordinates(refresh,this.getCoordinates()[1]);
		}
		if(outOfBounds) {
			System.out.println("You feel a click in your left hand and the dial seems to have jumped suddenly.");
		}
	}
}
