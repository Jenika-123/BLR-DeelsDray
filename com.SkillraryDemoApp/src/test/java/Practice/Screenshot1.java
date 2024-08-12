package Practice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Screenshot1 {
	 WebDriver driver;
	    WebDriverUtility webDriverUtility = new WebDriverUtility();

	    // Method to get the current date and time for unique screenshot names
	    public String dateTime() {
	        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	    }

	    @Test
	    public void first() throws IOException {
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
	        driver = new ChromeDriver(options);
	        driver.manage().window().maximize();
	        driver.get("https://www.getcalley.com/");

	        takeScreenshot("first");
	        driver.quit();
	    }

	    @Parameters("browser")
	    @Test
	    public void second(@Optional("chrome") String browser) throws IOException {
	        driver = webDriverUtility.launchBrowser(browser);
	        if(driver==null) {
	        	throw new RuntimeException("Browser not supported:"+browser);
	        }
	        
	        driver.manage().window().maximize();
	        driver.get("https://www.getcalley.com/calley-lifetime-offer/");

	        takeScreenshot("second");
	        driver.quit();
	    }

	    @Test
	    public void third() throws IOException {
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
	        driver = new ChromeDriver(options);
	        driver.manage().window().maximize();
	        driver.get("https://www.getcalley.com/see-a-demo/");

	        takeScreenshot("third");
	        driver.quit();
	    }

	    @Test
	    public void fourth() throws IOException {
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
	        driver = new ChromeDriver(options);
	        driver.manage().window().maximize();
	        driver.get("https://www.getcalley.com/calley-teams-features/");

	        takeScreenshot("fourth");
	        driver.quit();
	    }

	    @Test
	    public void fifth() throws IOException {
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
	        driver = new ChromeDriver(options);
	        driver.manage().window().maximize();
	        driver.get("https://www.getcalley.com/calley-pro-features/");

	        takeScreenshot("fifth");
	        driver.quit();
	    }

	    // Method to take screenshots
	    public void takeScreenshot(String testName) throws IOException {
	        TakesScreenshot ts = (TakesScreenshot)driver;
	        File temp = ts.getScreenshotAs(OutputType.FILE);
	        File perm = new File("./Photo/img" + testName+"_" + dateTime() + ".png");
	        FileHandler.copy(temp, perm);
	    }
	}

