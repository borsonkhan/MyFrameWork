package base;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestBase extends Saucelabs{

	@BeforeSuite
	public void setUp() {
		
		
		if(Boolean.valueOf(getProperty("saucelabs"))){
			
			setSaucelabs();
		}else {
			
		}
		setDriver();
		
		
	}
	
	@Test
	
	public void test() {
		
	
	}
	
	@AfterSuite
	
	public void tearDown() {
		driver.quit();
		
	}
}
