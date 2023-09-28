package br.com.laboratorio.automacao.utils;


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
		if (element == null) {
			return false;
		}
		return true;
	}
	
	public void waitTimeOf(Integer tempo) throws InterruptedException {
		Thread.sleep(tempo);
	}
	
    public WebElement waitForElement(WebElement element, Long value){
        WebDriverWait wait = new WebDriverWait(getDriver(), value);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    
	public void waitPageLoad(Integer tempo) throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(tempo, TimeUnit.SECONDS);
	}

}
