package fin.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import fin.controller.Controller;



public class FinalPanel extends JPanel 
{
	/** the controller*/
	private Controller app;
	/** the layout*/
	private SpringLayout layout;
	/**the panel that stores the numbers*/
	private JPanel numberPanel;
	/** the instance of keyListener that gets the buttons and calls the methods when pressed*/
	private KeyListener listener;
	
	/**the constructor that initializes everything and calls the helper methods
	 * @param the controller
	 */
	public FinalPanel(Controller app)
	{
		super();
		this.app = app;
		listener = new MyKeyListener();
		layout = new SpringLayout();
		numberPanel = new JPanel(new GridLayout(4,4));
		setFocusable(true);

		
		addKeyListener(listener);
		updateNumberPanel();
		setupPanel();
		setupLayout();
		
	}
	/**
	 * sets up panel
	 */
	private void setupPanel()
	{
		this.setBackground(new Color(200, 150, 50 ));
		this.setLayout(layout);
		this.add(numberPanel);
	}
	
	/**
	 * sets up layout
	 */
	private void setupLayout()
	{
		layout.putConstraint(SpringLayout.NORTH, numberPanel, 50, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, numberPanel, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, numberPanel, -10, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, numberPanel, -200, SpringLayout.EAST, this);
	}
	
	/**
	 * updates the number panel to the current version
	 */
	private void updateNumberPanel()
	{
//		numberPanel = new JPanel(new GridLayout(4,4));
		numberPanel.removeAll();
		numberPanel.setLayout(new GridLayout(4,4));
		String[][] cellNumbs = app.getCells();
		JButton [][] cells = new JButton[4][4];
		for (int row = 0; row< cells.length; row++)
		{
			for(int col = 0; col < cells.length; col++)
			{
				JButton temp = new JButton(cellNumbs[row][col]);
				//cells[row][col] = temp;
				numberPanel.add(temp);
				
				
			}
		}
		numberPanel.revalidate();
		numberPanel.repaint();
	}

	/**
	 * 
	 * @author jcla2343
	 * its a class that implements keyListeners to use the keyboard inputs 
	 */
	public class MyKeyListener implements KeyListener
	{
		@Override
		/**
		 * calls the different methods based on what button is pressed 
		 * @param e is the key pressed 
		 */
		public void keyPressed(KeyEvent e)
		{
			int code = e.getKeyCode();

			switch (code)
			{
			case KeyEvent.VK_W:
			{
				System.out.println("up");
				app.up();
				updateNumberPanel();
				repaint();

				break;
			}
			case KeyEvent.VK_S:
			{
				app.down();
				updateNumberPanel();
				System.out.println("down");
				break;
			}
			case KeyEvent.VK_A:
			{
				app.left();
				updateNumberPanel();
				System.out.println("left");
				break;
			}
			case KeyEvent.VK_D:
			{
				app.right();
				updateNumberPanel();
				System.out.println("right");
				break;
			}
			case KeyEvent.VK_SPACE:
			{
				app.test();
			}
			}

		}

		@Override
		public void keyReleased(KeyEvent e)
		{
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent e)
		{
			// TODO Auto-generated method stub

		}

	}
}
