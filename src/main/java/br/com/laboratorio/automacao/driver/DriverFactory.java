package br.com.laboratorio.automacao.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	public WebDriver getDriver() {
		return driver;
	}

	WebDriver driver = null;
	
	public DriverFactory() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		try {
			this.driver = new ChromeDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void CloseDriver() {
		if (this.driver != null) {
			this.driver.close();
			this.driver = null;
		}
		
	}
	
}

