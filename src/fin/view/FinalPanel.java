package fin.view;

import java.awt.Color;

import javax.swing.JPanel;

import fin.controller.Controller;



public class FinalPanel extends JPanel
{
	private Controller app;
	
	public FinalPanel(Controller app)
	{
		super();
		this.app = app;
		
		setupPanel();
		setupListeners();
		setupLayout();
		
	}
	
	private void setupPanel()
	{
		this.setBackground(new Color(200, 150, 50 ));
	}
	
	private void setupListeners()
	{
		
	}
	
	private void setupLayout()
	{
	
	}
}
