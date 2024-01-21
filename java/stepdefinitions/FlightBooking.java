package stepdefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlightBooking
{
	
	public static WebDriver driver;
	

	@Given("^i open browser with url \"([^\"]*)\"$")
	public static void launchApp(String url)
	{
	    
		System.setProperty("webdriver.chrome.driver", "/Users/ramesh/Documents/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		
	}

	@Then("^i should see login page$")
	public void i_should_see_login_page() 
	{
	    //if(driver.findElement(By.id("btnLogin")).isDisplayed())
		if(driver.findElement(By.xpath("//*[@type='submit']")).isDisplayed())
	    {
	    	System.out.println("System Displayed Login Page");
	    }
	}

	@When("^i enter username as \"([^\"]*)\"$")
	public void i_enter_username_as(String uname)
	{
		driver.findElement(By.name("email")).sendKeys(uname);
	}

	@And("^i enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String pw) 
	{
		driver.findElement(By.name("password")).sendKeys(pw);
	}

	@And("^i click login$")
	public void i_click_login() 
	{
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	}

	@Then("^i should see Flight Reservation Page$")
	public void i_should_see_Flight_Reservation_Page()
	{
		if(driver.findElement(By.className("a_logo")).isDisplayed())
	    {
	    	System.out.println("Flight Reservation Page Displayed");
	    }
	}

	@When("^i click on Flight Bookings$")
	public void i_click_on_Flight_Bookings()
	{
		driver.findElement(By.partialLinkText("Bookings")).click();
	}

	@And("^i click on Delete$")
	public void i_click_on_Delete() 
	{
		driver.findElement(By.partialLinkText("Delete")).click();	
	}

	@Then("^i should see message$")
	public boolean i_should_see_message()
	{
		WebDriverWait x=new WebDriverWait(driver, 10);
		x.until(ExpectedConditions.alertIsPresent());
		String y=driver.switchTo().alert().getText();
		System.out.println(y);
		if(y.toLowerCase().contains("delete"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}


}
	
	
	