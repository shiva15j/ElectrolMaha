package com.data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Latur {

	public void city_data() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://ceoelection.maharashtra.gov.in/SearchInfo/ListPSs.aspx");

		driver.manage().window().maximize();
		Thread.sleep(5000);

		driver.findElement(By.id("ctl00_content_LangList_1")).click();
		Thread.sleep(3000);

		WebElement dist = driver.findElement(By.id("ctl00_content_DistrictList"));

		Select city = new Select(dist);

		city.selectByValue("28");

		Thread.sleep(3000);

		WebElement assmb = driver.findElement(By.id("ctl00_content_AssemblyList"));

		Select assmblist = new Select(assmb);

		assmblist.selectByValue("234");

		Thread.sleep(4000);

		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.id("ctl00_content_ReportViewer1_ctl05_ctl04_ctl00_ButtonLink"));

		// Double click
		action.click(element).perform();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Excel")).click();

		Thread.sleep(4000);
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		Latur ll = new Latur();
		ll.city_data();
	}

}
