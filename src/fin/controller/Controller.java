package fin.controller;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import fin.model.Cell;
import fin.view.FinalFrame;



public class Controller
{
	/** 
	 * the file that is saved to 
	 */
	private static String dataFile;

	/** a 2D array of Cell objects used to store the information of where the numbers are */
	private Cell [][] cells =  new Cell[4][4];
	
	/** the frame */
	private FinalFrame finalFrame;
	
	/* keeps the score */
	private int score ;
	
	/**
	 * fills all the cells of cells and initializes the frame
	 */
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
		dataFile = new String("save.Cell");
		setFinalFrame(new FinalFrame(this));
		setScore(0);
	}
	

	/**
	 * is called when the up button is pressed. it moves all the numbers in the cells to the top and combines like numbers. it also randomly places numbers in the empty cells.
	 */
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
						setScore(getScore() + currentNumber *2);
					}
					else 
					{
						cells[top][col].setNumber(currentNumber);
					}
					top ++;
				}
				cells[row][col].randNum();
			}
		}
	}
	/**
	 * is called when the up down is pressed. it moves all the numbers in the cells to the bottom and combines like numbers. it also randomly places numbers in the empty cells.
	 */
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
						setScore(getScore() + currentNumber *2);
					}
					else 
					{
						cells[bottom][col].setNumber(currentNumber);
					}
					bottom --;
					
				}
				cells[row][col].randNum();
			}
		}
	}
	
	/**
	 * is called when the left button is pressed. it moves all the numbers in the cells to the left and combines like numbers. it also randomly places numbers in the empty cells.
	 */
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
						setScore(getScore() + currentNumber *2);
					}
					else
					{
						cells[row][LEdge].setNumber(currentNumber);
					}
					LEdge ++;
				}
				cells[row][col].randNum();
			}
		}
	}
	
	/**
	 * is called when the up right is pressed. it moves all the numbers in the cells to the right and combines like numbers. it also randomly places numbers in the empty cells.
	 */
	public void right()
	{
		int REdge ;
		for (int row = 0; row < cells.length; row++)
		{
			REdge = cells.length -1;
			for (int col = cells.length-1; col >= 0; col--)
			{
				if (cells[row][col].getNumber() != 0)
				{
					int currentNumber = cells[row][col].getNumber();
					cells[row][col].setNumber(0);
					if (REdge <cells.length-1 && cells[row][REdge + 1].getNumber() == currentNumber)
					{
						cells[row][REdge + 1].setNumber(currentNumber * 2);
						setScore(getScore() + currentNumber *2);
					}
					else 
					{
						cells[row][REdge].setNumber(currentNumber);
					}
					REdge --;
					
				}
				cells[row][col].randNum();
			}
		}
		
	}
	
	/**
	 * grabs the cells 2D array
	 * @return the 2D array of Cells cells
	 */
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
	
	/**
	 * grabs the colors of the cells array
	 * @return the 2D array of the colors 
	 */
	public Color[][] getColors()
	{
		Color[][] colorFromCells = new Color[4][4];
		for (int row = 0; row< cells.length; row++)
		{
			for(int col = 0; col < cells.length; col++)
			{
				colorFromCells[row][col] = cells[row][col].getColor();
			}
		}
		
		return colorFromCells;
	}
	
	/** 
	 * prints the array in the terminal to test when Panel isn't working 
	 */
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
	
	/**
	 * saves the data 
	 */
	public void saveData()
	{
		try(PrintWriter saveText = new PrintWriter(dataFile))	
		{
			saveText.println(score); 
			
		}
		catch (IOException fileError)
		{
			JOptionPane.showMessageDialog(finalFrame, fileError.getMessage(), "SavingError!!!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * loads the score 
	 */
	public  void loadData()
	{
		File source = new File(dataFile);
		try (Scanner fileScanner = new Scanner(source))
 		{
 			
 			JOptionPane.showMessageDialog(finalFrame, "the prevous saved score was " + fileScanner.nextLine());
 			
 		}
 		catch (IOException fileError)
 		{
 			JOptionPane.showMessageDialog(finalFrame, fileError.getMessage(), "Loading Error!!!", JOptionPane.ERROR_MESSAGE);
 		}
 		catch (Exception error)
 		{
 			JOptionPane.showMessageDialog(finalFrame, error.getMessage(), "SavingError!!!", JOptionPane.ERROR_MESSAGE);
 		}
 		
		

	}
	

	public FinalFrame getFinalFrame()
	{
		return finalFrame;
	}

	public void setFinalFrame(FinalFrame finalFrame)
	{
		this.finalFrame = finalFrame;
	}

	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}
}
