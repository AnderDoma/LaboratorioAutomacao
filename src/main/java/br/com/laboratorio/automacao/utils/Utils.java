package br.com.laboratorio.automacao.utils;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {
	
	static WebDriver driver = null;
	
	public Utils(WebDriver driver) {
		Utils.driver = driver;
	}
	
	public boolean elementoExiste(WebElement element) {
		if (element == null) {
			return false;
		}
		return true;
	}
	
	public void aguardarTempo(Integer tempo) throws InterruptedException {
		System.out.println("tempo: " + tempo);
		driver.manage().timeouts().implicitlyWait(tempo,TimeUnit.SECONDS) ;
	}

}
