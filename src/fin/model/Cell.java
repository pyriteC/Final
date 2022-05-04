package fin.model;

import java.awt.Color;

public class Cell
{
	private int number ;
	private Color color;

	/**
	 * basic constructor that sets number to 0 and color to white 
	 */
	public Cell()
	{
		number = 0;
		color = new Color(255,255,255);
		randNum();
	}
	/**
	 * constructor that with ability to set number
	 * @param number sets the number to whatever is passed
	 */
	public Cell( int number)
	{
		this.number = number;
		color = new Color(255,255,255);
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
		return color;
	}

	public void setColor(Color color)
	{
		this.color = color;
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
