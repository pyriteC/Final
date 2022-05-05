package fin.model;

import java.awt.Color;
import java.util.HashMap;

public class Cell
{
	/** the number for the cell*/
	private int number ;
	/** the color for the cell that is gotten from the number*/
	private HashMap <Integer,Color> color;

	/**
	 * basic constructor that sets number to 0 and color to white 
	 */
	public Cell()
	{
		number = 0;
		color = new HashMap<Integer,Color>();
		color.put(0,Color.white);
		color.put(2,Color.white);
		color.put(4,Color.yellow);
		color.put(8,Color.orange);
		color.put(16,Color.red);
		color.put(32,Color.magenta);
		color.put(64,Color.pink);
		color.put(128,Color.blue);
		color.put(256,Color.cyan);
		color.put(512,Color.green);
		color.put(1024,Color.yellow);
		color.put(2048,Color.white);
		randNum();
	}
	/**
	 * constructor that with ability to set number
	 * @param number sets the number to whatever is passed
	 */
	public Cell( int number)
	{
		this.number = number;
		color = new HashMap<Integer,Color>();
		color.put(0,Color.white);
		color.put(2,Color.white);
		color.put(4,Color.yellow);
		color.put(8,Color.orange);
		color.put(16,Color.red);
		color.put(32,Color.magenta);
		color.put(64,Color.pink);
		color.put(128,Color.blue);
		color.put(256,Color.cyan);
		color.put(512,Color.green);
		color.put(1024,Color.yellow);
		color.put(2048,Color.white);
	}

	
	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public Color getColor()
	{
		return color.get(number);
	}

	/**
	 * gets the numbers as a string and returns 0 as empty String  
	 * @return the numbers as a string and returns 0 as empty String  
	 */
	public String getNumbAsString()
	{
		if (number == 0)
		{
			return "";
		}
		else
		{
			 
			return Integer.toString(number);
		}
	}
	/** 
	 * 1 in 8 chance of setting the number to 2 if it is currently 0
	 */
	public void randNum()
	{
		if (number == 0)
		{
			int condition = (int) (Math.random() * 7);
			if (condition == 0)
			{
				number = 2;
			}
		}
	}
	
	
}
