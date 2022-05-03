package fin.controller;

import fin.model.Cell;
import fin.view.FinalFrame;

public class Controller
{

	private Cell [][] cells =  new Cell[4][4];
	private FinalFrame finalFrame;
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
		finalFrame = new FinalFrame(this);
	}
	
	public static void start()
	{
		
	}
	
	public void up() 
	{
		int top ;
		for(int col = 0; col < cells.length; col++)
		{
			top = 0;
			for ( int row = 0; row < cells[0].length; row++)
			{
				if ( cells[row][col].getNumber() !=0)
				{
					int currentNumber = cells[row][col].getNumber();
					cells[row][col].setNumber(0);
					if ( top > 0 && cells[top - 1][col].getNumber() == currentNumber)
					{
						cells[top-1][col].setNumber(currentNumber * 2);
					}
					else 
					{
						cells[top][col].setNumber(currentNumber);
					}
					top ++;
					cells[row][col].randNum();
				}
			}
		}
	}
	
	public void down()
	{
		int bottom;
		for (int col = 0; col < cells.length; col ++)
		{
			bottom = cells.length-1;
			for (int row = cells.length-1; row >=0; row--)
			{
				if ( cells[row][col].getNumber() !=0)
				{
					int currentNumber = cells[row][col].getNumber();
					cells[row][col].setNumber(0);
					if (bottom <cells.length-1 && cells[bottom + 1] [col].getNumber() == currentNumber)
					{
						cells[bottom +1][col].setNumber(currentNumber * 2);
					}
					else 
					{
						cells[bottom][col].setNumber(currentNumber);
					}
					bottom --;
					cells[row][col].randNum();
				}
			}
		}
	}
	
	public void left()
	{
		int LEdge ;
		for (int row = 0; row < cells.length; row++)
		{
			LEdge = 0;
			for (int col = 0; col < cells.length; col++)
			{
				if (cells[row][col].getNumber() != 0)
				{
					int currentNumber = cells[row][col].getNumber();
					cells[row][col].setNumber(0);
					if (LEdge > 0 && cells[row][LEdge -1].getNumber() == currentNumber)
					{
						cells[row][LEdge -1].setNumber(currentNumber * 2);
					}
					else
					{
						cells[row][LEdge].setNumber(currentNumber);
					}
					LEdge ++;
					cells[row][col].randNum();
				}
			}
		}
	}
	
	public void right()
	{
		int REdge ;
		for (int row = 0; row < cells.length; row++)
		{
			for (int col = cells.length-1; col >= 0; col--)
			{
				REdge = cells.length -1;
				if (cells[row][col].getNumber() != 0)
				{
					int currentNumber = cells[row][col].getNumber();
					cells[row][col].setNumber(0);
					if (REdge <cells.length-1 && cells[row][REdge + 1].getNumber() == currentNumber)
					{
						cells[row][REdge + 1].setNumber(currentNumber * 2);
					}
					else 
					{
						cells[row][REdge].setNumber(currentNumber);
					}
					REdge --;
					cells[row][col].randNum();
				}
			}
		}
		
	}
	
	public String[][] getCells()
	{
		String[][] numFromCells = new String[4][4];
		for (int row = 0; row< cells.length; row++)
		{
			for(int col = 0; col < cells.length; col++)
			{
				numFromCells[row][col] = cells[row][col].getNumbAsString();
			}
		}
		
		
		return numFromCells;
	}
	public void test()
	{
		for (int row = 0; row< cells.length; row++)
		{
			for(int col = 0; col < cells.length; col++)
			{
				System.out.print(cells[row][col].getNumber());
			}
			System.out.print("\n");
		}
	}
}
