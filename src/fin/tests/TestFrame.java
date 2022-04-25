package fin.tests;

import javax.swing.JFrame;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import fin.controller.Controller;
import fin.view.FinalFrame;
import fin.view.FinalPanel;

public class TestFrame
{
	private Controller testedController; //Change!
	private FinalFrame testedFrame; //Change!

	@BeforeEach
	void setUp() throws Exception
	{
		this.testedController = new Controller();
		this.testedFrame = new FinalFrame(testedController);
	}

	@AfterEach
	void tearDown() throws Exception
	{
		this.testedController = null;
		this.testedFrame = null;
	}

	@Test
	void testChatFrame()
	{
		assertTrue(testedFrame instanceof JFrame, "... needs to extend JFrame");
		Method [] methods = testedFrame.getClass().getDeclaredMethods();
		assertTrue(methods.length == 1, "You need 1 method in the ChatFrame");
		assertTrue(testedFrame.getTitle().length() > 5, "Your title needs at least 6 letters");
		assertTrue(testedFrame.getContentPane() instanceof FinalPanel, "Your ChatFrame needs to have a ChatPanel inside");  //Change!
	}
}
