package TestExecutor;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Keyword.Engine.KeyWordEngine;

public class TestRunner {

	public KeyWordEngine keywordEngine;
	
	@BeforeClass
	public void initialize() {
		keywordEngine = new KeyWordEngine();
	}
	
	@Test
	public void FramerQuotaTest() {
		keywordEngine.startExecution("Farmer_Quota");
	}
	
}
