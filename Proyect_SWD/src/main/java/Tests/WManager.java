package Tests;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Poms.GoPage;

public class WManager {
	private WebDriver driver;
	private GoPage google;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/chromedriver.exe");
		driver = new ChromeDriver();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		
		//driver = new ChromeDriver(options);
	}

	@Test
	public void test() throws InterruptedException{
		// Goes to page
		Scanner text = new Scanner(System.in);
		System.out.println("Ingrese nombre de cancion: ");
		String inputSong = text.nextLine();
		
		google = new GoPage(driver);
		driver.get("http://google.com");
		google.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Searchs for desire item
		assertTrue(google.writeSearch("Youtube"));
		Thread.sleep(2000);
		//Clicks first result
		assertTrue(google.clickGoogle());
		Thread.sleep(2000);
		//Searchs for desire item
		assertTrue(google.writeSong(inputSong));
		Thread.sleep(2000);
		//Clicks first result
		assertTrue(google.clickYoutube());
		Thread.sleep(2000);
		assertTrue(google.getNameSong());
		Thread.sleep(10000);
		}

	@After
	public void teardown() {		
		driver.quit();
	}

}