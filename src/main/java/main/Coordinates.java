package main;

import java.text.DecimalFormat;
import java.util.Random;

public class Coordinates {
	private int x,y;
	
	public Coordinates() {
		setCoordinates(0,0);
	}
	public Coordinates(Coordinates ref) {
		setCoordinates(ref);
	}
	
	public void setCoordinates(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public void setCoordinates(Coordinates ref) {
		//sets a new location near to a reference
		Random r = new Random();
		if(r.nextBoolean()) 
			x=ref.getCoordinates()[0]+r.nextInt(5)+1;
		else
			x=ref.getCoordinates()[0]-r.nextInt(5)+1;
		if(r.nextBoolean()) 
			y=ref.getCoordinates()[1]+r.nextInt(5)+1;
		else
			y=ref.getCoordinates()[1]-r.nextInt(5)+1;
	}
	public int[] getCoordinates() {
		return new int[] {x,y};
	}
	public boolean compareCoordinates(Coordinates ref) {
		double distance = Math.sqrt(Math.pow(ref.getCoordinates()[0]-x,2) + Math.pow(ref.getCoordinates()[1]-y,2));
		if(distance==0) {
			return false;
		}else {
			System.out.print("The dial reads '");
//			float distf = (float) distance*100;
//			int dist = (int) distf;
//			System.out.print((float)dist/100); //Conversion to 2 d.p. This could be improved with printf but need to chck syntax
			System.out.print(new DecimalFormat("0.###").format(distance));
			System.out.print("m'\n>");
			return true;
		}
	}
}
