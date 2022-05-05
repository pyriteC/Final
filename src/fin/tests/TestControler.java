package fin.tests;



import fin.controller.Controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestControler
{
	private Controller testedController;

	@BeforeEach
	void setUp() throws Exception
	{
		this.testedController = new Controller();
	}

	@AfterEach
	void tearDown() throws Exception
	{
		this.testedController  = null;
	}

	@Test
	void testCells()
	{
		assertTrue(testedController.getCells() != null, "Can't be null");
	}

	@Test
	void testFrame()
	{
		assertTrue(testedController.getFinalFrame() != null);
	}
}
