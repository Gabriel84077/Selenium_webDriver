package Poms;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class GoPage {
	private String inputTextGoogle = "//input[@name = 'q']";
	private String firstResultGoogle = "//h3[@class='LC20lb MBeuO DKV0Md']";
	private String inputTextYoutube = "//input[@id='search']";
	private String firstResultYoutube = "//*[@id=\"title-wrapper\"]/h3";
	private String nameSong = "//*[@id='container']/h1/yt-formatted-string";
	public WebDriver driver;

	public GoPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public boolean writeSearch(String searchValue) {
		boolean flag = false;
		try {
			WebElement inputText = driver.findElement(By.xpath(inputTextGoogle));
			inputText.sendKeys(searchValue);
			inputText.sendKeys(Keys.ENTER);
			flag = true;
		}
	    catch(Exception e) {
	    	System.out.println("Something went wrong: (");
	    	e.printStackTrace();
	    }
		return flag;
	}
	

	public boolean clickGoogle() {
		boolean flag = false;
		try {
			WebElement firstResult = driver.findElement(By.xpath(firstResultGoogle));
			firstResult.click();
			flag = true;
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public boolean writeSong(String searchValueY) {
		boolean flag = false;
		try {
			WebElement inputTextY = driver.findElement(By.xpath(inputTextYoutube));
			inputTextY.sendKeys(searchValueY);
			inputTextY.sendKeys(Keys.ENTER);
			flag = true;
		}
	    catch(Exception e) {
	    	System.out.println("Something went wrong: (");
	    	e.printStackTrace();
	    }
		return flag;
	}
	
	
	public boolean clickYoutube() {
		boolean flag = false;
		try {
			WebElement firstResultY = driver.findElement(By.xpath(firstResultYoutube));
			firstResultY.click();
			flag = true;
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean getNameSong() {
		boolean flag = false;
		try {
			WebElement nameText = driver.findElement(By.xpath(nameSong));
			System.out.println("El nombre de la cancion es: " + nameText.getText());
			flag = true;
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();			
		}

		return flag;

	}
}