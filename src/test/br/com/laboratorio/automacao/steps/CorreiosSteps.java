package br.com.laboratorio.automacao.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.laboratorio.automacao.pages.CorreiosPage;
import br.com.laboratorio.automacao.utils.Utils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CorreiosSteps extends Base {
	
	Logger logger = LoggerFactory.getLogger(CorreiosSteps.class);
	Utils utils = new Utils(Base.getDriver());
	CorreiosPage correiosPage = new CorreiosPage(Base.getDriver()); 

	WebDriver driver = Base.getDriver();
		
	@Given("^que acesso a pagina dos correios$")
	public void que_acesso_a_pagina_dos_correios() throws Throwable {
		utils.waitTimeOf(2000);
		logger.info("[acesso_a_pagina_dos_correios] acesso pagina dos correios");
		driver.get("https://www.correios.com.br");
		utils.waitPageLoad(2000);
		
		if(utils.elementoExiste(correiosPage.btnAceitoCookies())){
			correiosPage.clicarAceitarCookies();
		}
	}
	
	@Given("^acesso a pagina de autenticacao$")
	public void acesso_a_pagina_de_autenticacao() throws Throwable {
		logger.info("[acesso_a_pagina_de_autenticacao] Acesso a pagina de autenticação");
		assertTrue(utils.elementoExiste(correiosPage.menuMeusCorreios()));
		correiosPage.clicarMenuMeusCorreios();
		assertTrue(utils.elementoExiste(correiosPage.opcaoMeusCorreios()));
		correiosPage.clicarOpcaoMeusCorreios();
		utils.waitTimeOf(2000);
		assertTrue(utils.elementoExiste(correiosPage.btnEntrar()));
		correiosPage.clicarBtnEntrar();
		utils.waitTimeOf(2000);
	}
	
	@And("^autentico o usuario no site dos correios \"([^\"]*)\" \"([^\"]*)\"$")
	public void autentico_o_usuario_no_site_dos_correios(String usuario, String senha) throws Throwable {
		logger.info("[autentico_o_usuario_no_site_dos_correios] Autenticação usuário");

		assertTrue(utils.elementoExiste(correiosPage.inputUserName()));
		assertTrue(utils.elementoExiste(correiosPage.inputPassword()));
		
		correiosPage.inserirPassword(senha);
		correiosPage.inserirUserName(usuario);
		
		assertTrue(utils.elementoExiste(correiosPage.btnEntrarSenha()));
		correiosPage.clicarBtnEntrarSenha();
		
	}

	@When("^acompanho meu objeto \"([^\"]*)\"$")
	public void acompanho_meu_objeto(String objetoRastreamento) throws Throwable {
		logger.info("[acompanho_meu_objeto] Clico em acompanhar objetos");
		utils.waitTimeOf(2000);
		assertTrue(utils.elementoExiste(correiosPage.boxAcompanheSeuObjLogado()));
		correiosPage.clicarBoxAcompanheSeuObjLogado();	
	}
	
	@Then("^valido o resultado da pesquisa do objeto$")
	public void valido_o_resultado_da_pesquisa_do_objeto() throws Throwable {
		logger.info("[valido_o_resultado_da_pesquisa_do_objeto] Verifico os objetos rastreados");
		utils.waitTimeOf(2000);
		assertTrue(utils.elementoExiste(correiosPage.lstDeObjetosRastreados()));
	}
	

	@Then("^valido a mensagem de erro de autenticacao$")
	public void valido_a_mensagem_de_erro_de_autenticacao() throws Throwable {
		assertTrue(utils.elementoExiste(correiosPage.msgErroAutenticacao()));
		assertEquals("Usuário ou senha inválidos.\nOK", correiosPage.msgErroAutenticacao().getText());
	}

}
