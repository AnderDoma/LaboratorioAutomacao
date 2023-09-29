package br.com.laboratorio.automacao.driver;

import java.util.concurrent.TimeUnit;

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

	protected static WebDriver driver = null;

	public DriverFactory() {
		try {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
			DriverFactory.driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("Erro ao abrir o driver");
		}
	}

	public static void closeDriver() throws Throwable {
		if (DriverFactory.driver != null) {
			driver.close();
			DriverFactory.driver.quit();
			Thread.sleep(5000);
			DriverFactory.driver = null;	
			System.out.println("driver fechado:" + driver);
		}	
	}
}

