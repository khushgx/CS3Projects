package GemMatchingClasses;

import java.awt.Font;
import java.util.Random;

enum GemType {
    GREEN, BLUE, ORANGE;//define the different types of Gems, comma delimited
}

public class Gem 
{	
	private GemType type;
	private int pointVal;
	int[] acceptablePoints = new int[]{0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
	
	public Gem() {
		
		Random rand = new Random();
		type = GemType.values()[new Random().nextInt(GemType.values().length)];
		pointVal = acceptablePoints[new Random().nextInt(acceptablePoints.length - 1)];
		
	}
	
	public Gem(GemType type, int points) {
		
		this.type = type;
		this.pointVal = points;
		
	}
	@Override
	public String toString() {
		
		return type + " " + pointVal + " ";
		
		
	}
	public GemType getType() {
		return type;
		
	}
	
	public int getPoints() {
		
		return pointVal;
		
	}
	public void draw(double x, double y) {
		String s = "gem_" + type + ".png";
		StdDraw.setFont(new Font("SansSerif", Font.BOLD, 14));
		StdDraw.picture(x, y, s);
		StdDraw.text(x, y, getPoints() +"");
		
	}
	
	
	/** Tester main method */
	public static void main(String [] args)
	{
		final int maxGems = 16;
		
		// Create a gem of each type
		Gem green  = new Gem(GemType.GREEN, 10);
		Gem blue   = new Gem(GemType.BLUE, 20);
		Gem orange = new Gem(GemType.ORANGE, 30);
		System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());		
		System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
		System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
		green.draw(0.3, 0.7);
		blue.draw(0.5, 0.7);
		orange.draw(0.7, 0.7);
		
		// A row of random gems
		for (int i = 0; i < maxGems; i++)
		{
			Gem g = new Gem();
			g.draw(1.0 / maxGems * (i + 0.5), 0.5);
		}
	}
}
