package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTest;

public class LoginTest extends BaseTest {
//to login sauce demo website
	@Test(priority =0)
	public void loginTest() {
		driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

	}
//check the price of product 
	@Test(priority = 2)
	public void checkPriceSaucelabsFleeceJacket() throws InterruptedException {
		Thread.sleep(2000);
		String bagPrice = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[4]/div[2]/div[2]/div"))
				.getText();
		System.out.println("Sauce labs Fleece Jacket price is " + bagPrice);

	}
	
	/*after add two products in the cart, check that those added products are right
	or not, then chekout and complete the action
	*/
	@Test(priority = 1)
	public void addproducts()
	{
		WebElement firstProduct =driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
		firstProduct.click();
		WebElement secondProduct= driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]"));
		secondProduct.click();
		
		WebElement cartIcon =driver.findElement(By.id("shopping_cart_container"));
		cartIcon.click();
		
		WebElement checkProd1=driver.findElement(By.xpath("//*[@id=\"item_0_title_link\"]/div"));
		String prod1 =checkProd1.getText();
		System.out.println(checkProd1.getText());
		WebElement checkProd2=driver.findElement(By.xpath("//*[@id=\"item_3_title_link\"]/div"));
		String prod2 =checkProd2.getText();
		
		if((firstProduct.getText()).equals(prod1) && secondProduct.getText().equals(prod2))
		{
			WebElement checkOut= driver.findElement(By.id("checkout"));
			checkOut.click();
			WebElement firstName = driver.findElement(By.id("first-name"));
			firstName.sendKeys("Rio");
			WebElement lastName = driver.findElement(By.id("last-name"));
			lastName.sendKeys("Cherish");
			WebElement postalCode = driver.findElement(By.id("postal-code"));
			postalCode.click();
			WebElement checkedContinue=driver.findElement(By.id("continue"));
			checkedContinue.click();
			WebElement finish = driver.findElement(By.id("finish"));
			finish.click();
		}
	}
}
