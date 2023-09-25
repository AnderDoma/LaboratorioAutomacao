package br.com.laboratorio.automacao.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.laboratorio.automacao.driver.DriverFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Google {
	
	static WebDriver driver = null;
	static DriverFactory driverFact = new DriverFactory();
	
	@BeforeAll
	public static void before_all() {
		try {
			driver = driverFact.getDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterAll
	public static void after_all() {
		driverFact.CloseDriver();
	}
		
	@Given("acesso a pagina do google")
	public void acesso_a_pagina_do_google() {
		driver.get("http://www.google.com");
	}

	@When("realizao uma pesquisa {string}")
	public void realizao_uma_pesquisa(String valorPesquisa) {
		WebElement barra_pesquisa = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
		barra_pesquisa.sendKeys(valorPesquisa);
		barra_pesquisa.sendKeys(Keys.ENTER);
		
	}

	@Then("valido o resultado da pesquisa")
	public void valido_o_resultado_da_pesquisa() {
		WebElement txtResultadoPesquisa = driver.findElement(By.xpath("//*[@id=\"result-stats\"]"));
		assertTrue(txtResultadoPesquisa.getText().contains("Aproximadamente"));
	}

}
