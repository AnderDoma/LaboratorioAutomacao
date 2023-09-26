package br.com.laboratorio.automacao.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.laboratorio.automacao.driver.DriverFactory;
import br.com.laboratorio.automacao.pages.CorreiosPage;
import br.com.laboratorio.automacao.utils.Utils;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CorreiosSteps {
	
	Logger logger = LoggerFactory.getLogger(CorreiosSteps.class);
	
	static WebDriver driver = DriverFactory.getDriver();
	
	Utils utils = new Utils(driver);
	
	CorreiosPage correiosPage = new CorreiosPage(driver);

	@AfterAll
	public static void after_all() {
		DriverFactory.CloseDriver();
	}
		
	@Given("acesso a pagina dos correios")
	public void acesso_a_pagina_dos_correios() throws InterruptedException {
		utils.aguardarTempo(2);
		logger.info("[acesso_a_pagina_dos_correios] acesso pagina dos correios");
		driver.get("https://www.correios.com.br");
		utils.aguardarTempo(2);
	}
	
	@And("autentico o usuario no site dos correios {string} {string}")
	public void autentico_o_usuario_no_site_dos_correios(String usuario, String senha) throws InterruptedException {
		logger.info("[autentico_o_usuario_no_site_dos_correios] Autenticação usuário");

		if(utils.elementoExiste(correiosPage.btnAceitoCookies())){
			correiosPage.clicarAceitarCookies();
		}
		assertTrue(utils.elementoExiste(correiosPage.boxAcompanheSeuObj()));
		assertTrue(utils.elementoExiste(correiosPage.menuMeusCorreios()));
		correiosPage.clicarMenuMeusCorreios();
		assertTrue(utils.elementoExiste(correiosPage.opcaoMeusCorreios()));
		correiosPage.clicarOpcaoMeusCorreios();
		utils.aguardarTempo(2);
		assertTrue(utils.elementoExiste(correiosPage.btnEntrar()));
		correiosPage.clicarBtnEntrar();
		utils.aguardarTempo(2);
		
		assertTrue(utils.elementoExiste(correiosPage.inputUserName()));
		assertTrue(utils.elementoExiste(correiosPage.inputPassword()));
		
		correiosPage.inserirPassword(senha);
		correiosPage.inserirUserName(usuario);
		
		assertTrue(utils.elementoExiste(correiosPage.btnEntrarSenha()));
		correiosPage.clicarBtnEntrarSenha();
		
	}

	@When("acompanho meu objeto {string}")
	public void acompanho_meu_objeto(String objetoRastreamento) throws InterruptedException {
		logger.info("[acompanho_meu_objeto] Clico em acompanhar objetos");
		utils.aguardarTempo(5);
		assertTrue(utils.elementoExiste(correiosPage.boxAcompanheSeuObjLogado()));
		correiosPage.clicarBoxAcompanheSeuObjLogado();	
	}
	
	@Then("valido o resultado da pesquisa do objeto {string}")
	public void valido_o_resultado_da_pesquisa_do_objeto(String string) throws InterruptedException {
		logger.info("[valido_o_resultado_da_pesquisa_do_objeto] Verifico os objetos rastreados");
		utils.aguardarTempo(5);
		assertTrue(utils.elementoExiste(correiosPage.lstDeObjetosRastreados()));
	}

}
