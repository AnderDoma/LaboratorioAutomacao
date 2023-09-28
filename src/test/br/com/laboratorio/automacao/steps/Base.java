package br.com.laboratorio.automacao.steps;

import org.openqa.selenium.WebDriver;

public class Base {
	
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		Base.driver = driver;
	}

}
