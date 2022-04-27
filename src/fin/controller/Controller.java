package fin.controller;

import fin.model.Cell;

public class Controller
{
	Cell [][] cells =  new Cell[3][3];
	public Controller()
	{
		for (int index = 0; index < cells.length; index++)
		{
			for (int inIndex = 0; inIndex < cells[0].length; inIndex++)
			{
				Cell temp = new Cell();
				cells[index][inIndex] = temp;
			}
		}
	}
	
	public static void start()
	{
		
	}
}
