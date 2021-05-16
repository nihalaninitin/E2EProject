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

public class validateTitle extends base {

	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get("https://www.qaclickacademy.com/");
		log.info("navigate to homepage");
	}
	@Test

	public void basePageTest() throws IOException {
		LandingPage lp = new LandingPage(driver);
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");		
	}

	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}