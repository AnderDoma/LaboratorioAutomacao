package br.com.laboratorio.automacao.google;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.laboratorio.automacao.driver.DriverFactory;

public class TesteGoogle {

	WebDriver driver = null;

	@Before
	public void setUp() {
		DriverFactory driverFact = new DriverFactory();
		driver = driverFact.getDriver();
	}
	@Test
	public void test() {
		driver.get("http://www.google.com");
		
	}

}
