package fin.model;

import java.awt.Color;

public class Cell
{
	private String number ;
	private Color color;

	
	public Cell()
	{
		setNumber("");
		setColor(new Color(255,255,255));
	}
	
	public Cell( String number)
	{
		this.setNumber(number);
	}

	public String getNumber()
	{
		return number;
	}

	public void setNumber(String number)
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
	
	
}
