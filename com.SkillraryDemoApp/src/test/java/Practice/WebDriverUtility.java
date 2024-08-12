package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverUtility {
	public WebDriver launchBrowser(String browser) {
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver=new ChromeDriver(options);
		}
		return driver;
	}
	}
		

