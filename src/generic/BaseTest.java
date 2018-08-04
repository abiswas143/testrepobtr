package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant{
	public WebDriver driver ;
	static{
		System.setProperty(GECKO_KEY, GECKO_PATH);
		System.setProperty(CHROME_KEY, CHROME_PATH);
		System.setProperty(IE_KEY, IE_PATH);
	}
	@BeforeMethod
	public void launchApplication(){
		driver = new FirefoxDriver();
		driver.get(Lib.getPropertyValue("URL"));
		String implicitWait = Lib.getPropertyValue("ImplicitWait");
		long implicitTimePeriod = Long.parseLong(implicitWait);
		driver.manage().timeouts().implicitlyWait(implicitTimePeriod, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closeApplication(ITestResult res){
		if (ITestResult.FAILURE==res.getStatus()) {
			Lib.captureScreenshot(driver, res.getName());
		}
		driver.close();
	}
}
