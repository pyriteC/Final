package fin.view;

import javax.swing.JFrame;

import fin.controller.Controller;
import fin.view.*;

public class FinalFrame extends JFrame
{

	private Controller app;
	private FinalPanel panel;
	
	public FinalFrame(Controller app)
	{
		super();
		this.app = app;
		this.panel = new FinalPanel(this.app);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(panel);
		this.setTitle("My third GUI project wow");
		this.setSize(800, 600);
		this.setResizable(false);
		this.setVisible(true);
	}
}

