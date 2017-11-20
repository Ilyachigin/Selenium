package main2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Authorization {

	public static void main(String[] args) throws InterruptedException  {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://cpa.kpilead.ru");
		WebElement login = driver.findElement(By.xpath("/html/body/header/nav/div/div/div[2]/div/a[8]"));
		login.click();
		WebElement email = driver.findElement(By.name("LoginForm[username]"));
		WebElement password = driver.findElement(By.name("LoginForm[password]"));
		email.sendKeys("XX");
		password.sendKeys("XX");
		password.submit();
		Thread.sleep(100);
		driver.quit();
	}

}
