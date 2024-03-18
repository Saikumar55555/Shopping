package Task5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Shopping {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://demowebshop.tricentis.com/";
		driver.get(url);
		
		//Clicking to the login Button
		driver.findElement(By.xpath("//a[@class=\"ico-login\"]")).click();
				
		//The Web Page has to Wait Certain Amount Of time (3000LongSec = 3Sec)
		Thread.sleep(3000);
				
		//Giving Valid Email and Valid Password
		driver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("saikuasicb@gmail.com");
		driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("@#$QWEasd");
		driver.findElement(By.xpath("//input[@id=\"RememberMe\"]")).submit();

				
		//Clicking On the Books
		driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Books')]")).click();
		driver.findElement(By.xpath("//img[@alt='Picture of Computing and Internet']")).click();
		WebElement add = driver.findElement(By.xpath("//input[@id=\"addtocart_13_EnteredQuantity\"]"));
		add.clear();
		add.sendKeys("2");
		driver.findElement(By.xpath("//input[@id='add-to-cart-button-13']")).click();
				
		Thread.sleep(3000);	
		//Clicking on the Computers	
		driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Computers')]")).click();
		driver.findElement(By.xpath("(//h2[@class='title'])[2]")).click();
		driver.findElement(By.xpath("//img[@alt=\"Picture of 14.1-inch Laptop\"]")).click();
		WebElement cle = driver.findElement(By.id("addtocart_31_EnteredQuantity"));
		cle.clear();
		cle.sendKeys("2");
		
		driver.findElement(By.xpath("//input[@id=\"add-to-cart-button-31\"]")).click();
		
		//Adding All those Products to the Cart
		
		driver.findElement(By.xpath("//a[@class=\"ico-cart\"]//span[@class=\"cart-qty\"]")).click();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll down by a specified number of pixels (e.g., 400 pixels)
		js.executeScript("window.scrollBy(0,400);");
		Thread.sleep(3000);
		driver.findElement(By.id("termsofservice")).click();
		driver.findElement(By.name("checkout")).click();
		WebElement FName = 	driver.findElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"));
		FName.clear();
		FName.sendKeys("SaiKumar");
		
		WebElement LName = 	driver.findElement(By.xpath("//input[@id=\"BillingNewAddress_LastName\"]"));
		LName.clear();
		LName.sendKeys("Uruvakili");
		
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_Company']")).sendKeys("RrootShell Technologies");
		
		WebElement ind =  driver.findElement(By.xpath("//select[@id=\"BillingNewAddress_CountryId\"]"));
		Select india = new Select(ind);
		india.selectByIndex(14);
		
		/*WebElement state = 	driver.findElement(By.xpath("//select[@id=\"BillingNewAddress_StateProvinceId\"]"));
		Select st = new Select(state);
		st.selectByIndex(0);*/
		
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("Ananthapur");
		
		driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Kanekal (Mandal)");
		
		driver.findElement(By.xpath("//input[@id=\"BillingNewAddress_Address2\"]")).sendKeys("Yerragunta (Village)");
		
		driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("515871");
		
		driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("9014730182");
		
		driver.findElement(By.xpath("//input[@id=\"BillingNewAddress_FaxNumber\"]")).sendKeys("638411");
		
		//An Alert Comes here that alert is Known as Authentication Alert , we Can Handle it With the help of Robot Class
		//We cannot inspect this popup and there is no library method given in Selenium to handle it.
		//So we should find a trick to avoid it  or we should use either Robot Class
		//We can’t inspect it,  We cannot move it , 
		Thread.sleep(3000);
		//Billing Address
		driver.findElement(By.xpath("//div[@id='billing-buttons-container']/input[@type=\"button\"]")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		//Shipping address
		driver.findElement(By.xpath("(//input[@type=\"button\"])[3]")).click();
		Thread.sleep(3000);
		//shipping method
		driver.findElement(By.xpath("//input[@id=\"shippingoption_1\"]")).click(); //To Identify the date & time
		driver.findElement(By.xpath("(//input[@value=\"Continue\"])[3]")).click();
		Thread.sleep(3000);
		//Payment Method
		driver.findElement(By.xpath("(//input[@value=\"Continue\"])[4]")).click();
		Thread.sleep(3000);
		//Payment Information
		driver.findElement(By.xpath("(//input[@value=\"Continue\"])[5]")).click();
		Thread.sleep(3000);
		//Conform Order
		driver.findElement(By.xpath("//input[@class=\"button-1 confirm-order-next-step-button\"]")).click();
		
		
		//this the order number 
		WebElement ordernum1 = driver.findElement(By.xpath("(//ul[@class=\"details\"]/li)[1]"));
		String order1 = ordernum1.getText();
		System.out.println(order1);

		//at the end Continue
		driver.findElement(By.xpath("//input[@class=\"button-2 order-completed-continue-button\"]")).click();
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		// Scroll down by a specified number of pixels
		js.executeScript("window.scrollBy(0,200);");
		
		//Clicking On the Main Gmail button 
		driver.findElement(By.xpath("(//a[@class=\"account\"])[1]")).click();
		Thread.sleep(3000);
		//then clicking the addresses button
		driver.findElement(By.xpath("(//a[contains(text(),'Orders')])[1]")).click();
		
		driver.get("https://demowebshop.tricentis.com/customer/orders");
		
		//this is the another one xpath of for order number 
		WebElement ordernum2 = driver.findElement(By.xpath("(//div[@class=\"title\"])[2]"));
		String order2 = ordernum2.getText();
		//String trim = order2.replace("Order Number :  ", "");
		//System.out.println(trim);
		System.out.println(order2);
		
		//Printing the Order Number
		
		try {
			if(order1.equalsIgnoreCase(order2)) {
				System.out.println("Your Order Number is Same as Main Order Section");
			}
			else {
				System.out.println("Once again Check Your Product Details");
			}
			
		}catch (NullPointerException e) {
			System.out.println("One of the strings is null.");
			
			
		}
	
		
		
		
	}

}
