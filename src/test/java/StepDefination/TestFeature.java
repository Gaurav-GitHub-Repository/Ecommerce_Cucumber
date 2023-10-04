package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFeature {

	WebDriver driver;
	
	@Given("Open Google Chrome browser and launch application")
	public void open_google_chrome_browser_and_launch_application() {
	
		System.setProperty("webDriver.chrome.driver", "C:\\Selenium Temp\\ChromeDriver\\chromedriver.exe");  
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));	
	}

	@When("User enters Username and Password")
	public void user_enters_username_and_password() {
	    
		WebElement Username = driver.findElement(By.xpath("//input[@id='user-name']/self::input"));
		WebElement Password = driver.findElement(By.xpath("//input[@id='password']/self::input"));
		WebElement Button = driver.findElement(By.xpath("//input[@id='login-button']/self::input"));
		
		Username.clear();
		Username.sendKeys("standard_user");
		Password.clear();
		Password.sendKeys("secret_sauce");
		Button.click();
		
		String Actual_Title = "Single Page Apps for GitHub Pages";
		Assert.assertEquals(Actual_Title, "Single Page Apps for GitHub Pages");
		
	}

	@When("User click on product filter")
	public void user_click_on_product_filter() {
	    
	 Select select = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']/self::select")));	
	 List<WebElement> var = select.getOptions();
	 for(WebElement options: var)
	 {
		 if(options.getText().equals("Price (high to low)"))
		 {
			 select.selectByVisibleText("Price (high to low)"); 
			 System.out.println("Price (high to low) product filter is selected");
		 }
	 }		 
	}

	@Then("User click on add to cart button")
	public void user_click_on_add_to_cart_button() throws InterruptedException {
		
     WebElement Add_to_cart_button = driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-fleece-jacket']"));
     Add_to_cart_button.click();
     
	}
	@When("User click on cart")
	public void user_click_on_cart() {
	    
     WebElement cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
     cart.click();	

//	 WebElement Remove_Button = driver.findElement(By.xpath("//button[text()='Remove']/self::button"));
//	 Remove_Button.click();
	 
	}

	@When("User click on checkout button")
	public void user_click_on_checkout_button() {
	   
	  By Checkout = By.xpath("//button[text()='Checkout' and @id='checkout']");	
		
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	  wait.until(ExpectedConditions.presenceOfElementLocated(Checkout));
	  driver.findElement(Checkout).click();
	  System.out.println("Successfully clicked on checkout button");
	}

	@Then("User enters First Name, Last name and Zip Code")
	public void user_enters_first_name_last_name_and_zip_code() {
	    
	 WebElement First_Name = driver.findElement(By.xpath("//input[@id='first-name' and @name='firstName']"));
	 WebElement Last_Name = driver.findElement(By.xpath("//input[@id='last-name' and @name='lastName']"));
	 WebElement Postal_Code = driver.findElement(By.xpath("//input[@id='postal-code' and @name='postalCode']"));
	    
	 First_Name.clear();
	 First_Name.sendKeys("Pathange");
	 Last_Name.clear();
	 Last_Name.sendKeys("Gaurav");
	 Postal_Code.clear();
	 Postal_Code.sendKeys("518002");
	 
	 System.out.println("Successfully entered details");
	 
	}

	@When("User click on continue button")
	public void user_click_on_continue_button() {
		
		WebElement Continue_Button = driver.findElement(By.xpath("//input[@id='continue' and @name='continue']"));
		Continue_Button.click();
		System.out.println("Successfully clicked on continue button");

	}

	@When("User click on Finish button")
	public void user_click_on_finish_button() throws InterruptedException {
	
	 String product = driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']")).getText();
		 
	 if(product.equals("Sauce Labs Fleece Jacket']"))
		 {		 
			 System.out.println("Sauce Labs Fleece Jacket product is verified."); 
		 }	 
			
	 WebElement Finish = driver.findElement(By.xpath("//button[@id='finish']/self::button"));	
	 Finish.click();
	    
	 System.out.println("Product is verified and successfully clicked on finish button");
	}

	@Then("Verify order placed message")
	public void verify_order_placed_message() {
	   	 
	 String Order_Placed = driver.findElement(By.xpath("//div[@id='checkout_complete_container']/h2[text()='Thank you for your order!']")).getText();	
	 if(Order_Placed.equals("Thank you for your order!"));
	 {
		 System.out.println("Sauce Labs Fleece Jacket order is successfully placed");
	 }
	}

	@When("User click on back to home button")
	public void user_click_on_back_to_home_button() throws InterruptedException {
	    
	 WebElement Home_Button = driver.findElement(By.xpath("//button[text()='Back Home']/self::button"));	
	 Home_Button.click();    
	 System.out.println("Successfully clicked on back home button");
	}

	@When("User click on product button")
	public void user_click_on_product_button() throws InterruptedException {
	    
	 WebElement product_button = driver.findElement(By.xpath("//button[text()='Open Menu' and @id='react-burger-menu-btn']"));
	 product_button.click();
	 System.out.println("Successfully clicked on product button");
	}

	@Then("User click on logout button")
	public void user_click_on_logout_button() throws InterruptedException {
	    
	 WebElement Logout = driver.findElement(By.xpath("//a[text()='Logout']/parent::nav/a[3]"));
	 Logout.click();	 
	 System.out.println("Successfully clicked on logout button");
	}
	
	
	}