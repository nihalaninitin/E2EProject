package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"E:\\SeleniumWorkspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\Setups\\chromedriver_win32Chrome90\\chromedriver.exe");

	        ChromeOptions options = new ChromeOptions();
			options.addArguments("--ignore-ssl-errors=yes");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
		}

		if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	
	  public void getScreenshotPath(String testCaseName,WebDriver driver) throws IOException 
	  { 
		  TakesScreenshot ts = (TakesScreenshot) driver; 
	  File source = ts.getScreenshotAs(OutputType.FILE); 
	  String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	  FileUtils.copyFile(source, new File(destinationFile)); }
	 
}
