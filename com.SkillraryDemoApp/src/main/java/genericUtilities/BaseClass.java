package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import objectRepo.Courselistpage;
import objectRepo.Homepage;
import objectRepo.Loginpage;
import objectRepo.Userpage;
import objectRepo.categoryPage;

public class BaseClass {
	//@BeforeSuite
	//@BeforeTest
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected webDriverUtility web;
	protected JavaUtility jutil;
	
	protected WebDriver driver;
	
	protected Loginpage login;
	protected Homepage home;
	protected Courselistpage course;
	protected Userpage users;
	protected categoryPage category;

	@BeforeClass
	public void classconfi() {
	  property=new PropertiesUtility();
	  excel=new ExcelUtility();
	  web=new webDriverUtility();
	 jutil=new JavaUtility();
	 property. propertiesInit(IConstantPath.PROPERTIES_PATH);
	 driver=web.launchBrowser(property.getDataFromProperties("browser"));
	 web.maximizeBrowser();
	 long time=(Long)jutil.parseStringToAnyDatatype("long",property.getDataFromProperties("timeouts"));
	 web.waitTillElementFound(time);
	 
	
	}
	@BeforeMethod
	public void methodConfig() {
		login=new Loginpage(driver);
		home=new Homepage(driver);
		course=new Courselistpage(driver);
		users=new Userpage(driver);
		category=new categoryPage(driver);
		web.navigateToApp(property.getDataFromProperties("url"));
		
		Assert.assertTrue(driver.getTitle().contains("SkillRary"));
		
		login.setEmailTF(property.getDataFromProperties("email"));
		login.setPasswordTF(property.getDataFromProperties("password"));
		login.clicloginBTN();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("home"));
		
		
		excel.excelInit(IConstantPath.EXCEL_PATH,"Sheet1");
		
	}
	@AfterMethod
	public void methodTeardown() {
		home.signoutofskillrary();
		excel.saveExcel(IConstantPath.EXCEL_PATH);
	}
	
	@AfterClass
	public void classTeardown() {
		web.quitBrowser();
		excel.closeExcel();
	}
	//@AfterTest
	//@AfterSuite
}