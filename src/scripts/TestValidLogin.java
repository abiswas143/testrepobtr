package scripts;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;
public class TestValidLogin extends BaseTest{
	@Test
	public void testValidLogin() throws InterruptedException{
		LoginPage lp = new LoginPage(driver);
		String username = Lib.getCellValue("ValidLogin", 1, 0);
		String password = Lib.getCellValue("ValidLogin", 1, 1);
		//enter username
		lp.setUsername(username);
		//enter password
		lp.setPassword(password);
		//click on login button
		lp.clickLogin();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track"));
		
		SoftAssert sa = new SoftAssert();
		
		sa.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
		
		sa.assertAll();
		
		
	}
}
