package br.com.laboratorio.automacao.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSteps extends Base{
	
	WebDriver driver = Base.getDriver();

		
	@Given("acesso a pagina do google")
	public void acesso_a_pagina_do_google() {
		driver.get("http://www.google.com");
	}

	@When("^realizao uma pesquisa \"([^\"]*)\"$")
	public void realizao_uma_pesquisa(String valorPesquisa) throws Throwable {
		WebElement barra_pesquisa = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
		barra_pesquisa.sendKeys(valorPesquisa);
		barra_pesquisa.sendKeys(Keys.ENTER);
		
	}

	@Then("^valido o resultado da pesquisa$")
	public void valido_o_resultado_da_pesquisa() {
		WebElement txtResultadoPesquisa = driver.findElement(By.xpath("//*[@id=\"result-stats\"]"));
		assertTrue(txtResultadoPesquisa.getText().contains("Aproximadamente"));
	}

}
