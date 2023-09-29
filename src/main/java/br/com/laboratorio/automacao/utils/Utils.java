package br.com.laboratorio.automacao.utils;


import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	static WebDriver driver = null;

	
	public Utils(WebDriver driver) {
		Utils.driver = driver;
	}
	
	public WebDriver getDriver() {
		return Utils.driver;
	}
	
	public boolean elementoExiste(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}
	
	public boolean elementoExiste(WebElement element, int segundos) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, segundos);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}
	
	public void waitTimeOf(Integer tempo) throws InterruptedException {
		int tempoEspera = tempo * 1000;
		Thread.sleep(tempoEspera);
	}
	
    public void waitForElement(WebElement element, Long value){
        WebDriverWait wait = new WebDriverWait(getDriver(), value);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
	public void waitPageLoad(Integer tempo) throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(tempo, TimeUnit.SECONDS);
	}

}
