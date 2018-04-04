package base;


import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listener.EliteListener.class)
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
		String title = driver.getTitle();
		
		Assert.assertEquals(title,"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
	
	}
	
	@AfterSuite
	
	public void tearDown() {
		driver.quit();
		
	}
}
