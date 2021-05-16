package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class validateNavBar extends base {

	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get("https://www.qaclickacademy.com/");
	}
	
	@Test

	public void basePageTest() throws IOException {
		
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.getnavbar().isDisplayed());
		System.out.println("navbar sop");
		log.info("navbar is displayed");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}