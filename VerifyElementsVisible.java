package Sep18;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyElementsVisible {
	WebDriver driver;

	private void getScreenShot() throws Throwable {
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
		TakesScreenshot sc = (TakesScreenshot) driver;
		File source = sc.getScreenshotAs(OutputType.FILE);
		File des = new File("./Screenshots/screenshot" + timeStamp + ".png");
		FileUtils.copyFile(source, des);
		System.out.println("Screenshot Name : " + des);
	}

	@BeforeMethod
	private void launch() {
		WebDriverManager.chromedriver().setup();
		// driver.manage().deleteAllCookies();
		driver = new ChromeDriver();
		System.out.println("Browser is launched.");
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
	}

	@Test
	public void VerifyElementVisible() throws Throwable {
		String userName = "//input[@name='username']";
		String password = "//input[@id='password']";
		String logIn = "//input[@name='Login']";

		// Launch URL
		driver.navigate().to("https://mapping.nds.at.t.digital/");
		Thread.sleep(3000);

		// Enter Username & Password
		driver.findElement(By.xpath(userName)).sendKeys("shawnee@t.digital.agent.dealerixlmaster");
		driver.findElement(By.xpath(password)).sendKeys("Iloveicecream1");
		Thread.sleep(2000);
		getScreenShot();
		
		// Click on Login button
		driver.findElement(By.xpath(logIn)).click();
		Thread.sleep(10000);
		getScreenShot();
		
		WebElement element;
		
		String logo = "//pf-image[@alt='At&t Logo']";
		element = driver.findElement(By.xpath(logo));
		if (element.isDisplayed()) {
			System.out.println("Logo is Visible.");
		} else {
			System.err.println("Logo is not Visible.");
		}
		
		String home = "//span[text()='Home']/parent::a";
		element = driver.findElement(By.xpath(home));
		// For Show
		element.click();
		Thread.sleep(2000);
		getScreenShot();
		if (element.isDisplayed()) {
			System.out.println("Home link is Visible.");
		} else {
			System.err.println("Home link is not Visible.");
		}
		
		String assignments = "//span[text()='Assignments']/parent::a";
		element = driver.findElement(By.xpath(assignments));
		// For Assignments's sub-menus 
		element.click();
		Thread.sleep(2000);
		getScreenShot();
		if (element.isDisplayed()) {
			System.out.println("Assignments lnik is Visible.");
		} else {
			System.err.println("Assignments lnik is not Visible.");
		}
		
		String accountSettings = "//button[@aria-label='Account settings']";
		element = driver.findElement(By.xpath(accountSettings));
		if (element.isDisplayed()) {
			System.out.println("Account settings button is Visible.");
		} else {
			System.err.println("Account settings button is not Visible.");
		}

		// For Show Account settings's sub-menus 
		element.click();
		Thread.sleep(3000);
		getScreenShot();
		
		String signOut = "//button[text()='Sign Out']";
		element = driver.findElement(By.xpath(signOut));
		if (element.isDisplayed()) {
			System.out.println("Sign Out button is Visible.");
		} else {
			System.err.println("Sign Out button is not Visible.");
		}
		
//		String resetPassword = "//button[text()='Reset Password']";
//		element = driver.findElement(By.xpath(resetPassword));
//		if (element.isDisplayed()) {
//			System.out.println("Reset Password button is Visible.");
//		} else {
//			System.err.println("Reset Password button is not Visible.");
//		}
		
		String totalLeadCounts = "//p[text()='Total Lead Counts']";
		element = driver.findElement(By.xpath(totalLeadCounts));
		if (element.isDisplayed()) {
			System.out.println("Total Lead Counts is Visible.");
		} else {
			System.err.println("Total Lead Counts is not Visible.");
		}
		
		String salesConversion = "//p[text()='Sales Conversion']";
		element = driver.findElement(By.xpath(salesConversion));
		if (element.isDisplayed()) {
			System.out.println("Sales Conversion is Visible.");
		} else {
			System.err.println("Sales Conversion is not Visible.");
		}
		
		String comeback = "//p[text()='Comeback']";
		element = driver.findElement(By.xpath(comeback));
		if (element.isDisplayed()) {
			System.out.println("Comeback is Visible.");
		} else {
			System.err.println("Comeback is not Visible.");
		}
		
		String toBeVisited  = "//p[text()='To Be Visited']";
		element = driver.findElement(By.xpath(toBeVisited));
		if (element.isDisplayed()) {
			System.out.println("To Be Visited is Visible.");
		} else {
			System.err.println("To Be Visited is not Visible.");
		}
		
		String noOpportunity  = "//p[text()='No Opportunity']";
		element = driver.findElement(By.xpath(noOpportunity));
		if (element.isDisplayed()) {
			System.out.println("No Opportunity is Visible.");
		} else {
			System.err.println("No Opportunity is not Visible.");
		}
		
	}

	@AfterMethod
	private void close() {
		driver.quit();
		System.out.println("Browser is closed.");
	}
}
