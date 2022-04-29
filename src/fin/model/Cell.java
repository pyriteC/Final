package fin.model;

import java.awt.Color;

public class Cell
{
	private int number ;
	private Color color;

	
	public Cell()
	{
		number = 0;
		color = new Color(255,255,255);
	}
	
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
