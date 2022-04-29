package fin.controller;

import fin.model.Cell;

public class Controller
{
	Cell [][] cells =  new Cell[4][4];
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
	
	public void up() 
	{
		int top = 0;
		for(int col = 0; col < cells.length; col++)
		{
			for ( int row = 0; row < cells[0].length; row++)
			{
				if (!(cells[row][col].getNumber() == 0))
				{
					int currentNumber = cells[row][col].getNumber();
					cells[row][col].setNumber(0);
					if(row ==0)
					{
					cells[top][col].setNumber(currentNumber);
					top ++;
					}
					if(row != 0)
					{
						if(cells[top-1][col].getNumber() == currentNumber)
						{
							cells[top - 1][col].setNumber(currentNumber*2);
							top ++;
						}
						else
						{
							cells[top][col].setNumber(currentNumber);
							top ++;
						}
					}
					
				}
			}
		}
	}
}
