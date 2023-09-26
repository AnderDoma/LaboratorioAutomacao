package br.com.laboratorio.automacao.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	public static WebDriver getDriver() {
		if (DriverFactory.driver != null) {
			return DriverFactory.driver;
		} else {
			new DriverFactory();
			return DriverFactory.driver;
		}	
	}

	static WebDriver driver = null;
	
	public DriverFactory() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		try {
			DriverFactory.driver = new ChromeDriver();
			System.out.println("Drive criado");
		} catch (Exception e) {
			throw e;
		}

	}

	public static void CloseDriver() {
		if (DriverFactory.driver != null) {
			DriverFactory.driver.close();
			DriverFactory.driver = null;
		}
		
	}
	
}

