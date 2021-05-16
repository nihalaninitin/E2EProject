package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {

	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		
	}
	@Test(dataProvider = "getData")

	public void basePageTest(String username, String password,String text) throws IOException {
	
		driver.get("https://www.qaclickacademy.com/");
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		LoginPage lop = new LoginPage(driver);
		lop.getEmail().sendKeys(username);
		lop.getPassword().sendKeys(password);
		lop.getLogin().click();
		log.info(text);
	}

	@DataProvider
	public Object[][] getData() {
		// Row tells us how many different data sets should run
		// Column tells us how many values are sent across per test
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestricted@gmail.com";
		data[0][1] = "1234";
		data[0][2] = "non restricted user";

		  data[1][0] = "restricted@gmail.com"; 
		  data[1][1] = "1234"; 
		  data[1][2] = "restricted user";
		 
		return data;
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}