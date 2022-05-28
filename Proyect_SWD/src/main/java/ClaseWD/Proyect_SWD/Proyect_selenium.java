package ClaseWD.Proyect_SWD;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//Proyecto sin asserts, asserts en wManager.java
public class Proyect_selenium {
	private WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void test() throws InterruptedException {
		// Goes to page
		Scanner text = new Scanner(System.in);
		System.out.println("Ingrese nombre de cancion: ");
		String nameSong = text.nextLine();
		driver.get("http://google.com");
		Thread.sleep(2000);
		WebElement inputText = driver.findElement(By.xpath("//input[@name = 'q']"));
		inputText.sendKeys("Youtube");
		inputText.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebElement firstResult = driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));
		firstResult.click();
		Thread.sleep(2000);
		WebElement inputTextYu = driver.findElement(By.xpath("//input[@id='search']"));
		inputTextYu.sendKeys(nameSong);
		inputTextYu.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebElement firstResultYu = driver.findElement(By.xpath("//*[@id=\"title-wrapper\"]/h3"));
		firstResultYu.click();
		Thread.sleep(5000);
		WebElement nameText = driver.findElement(By.xpath("//*[@id=\"container\"]/h1"));
		System.out.println("El titulo de la cancion es: " +nameText.getText());
	}
	
	@After
	public void teardown() {
		//System.out.println(driver);
		driver.quit();
	}

}
