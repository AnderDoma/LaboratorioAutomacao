package br.com.laboratorio.automacao.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CorreiosPage {
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div/div[2]/div[1]")
	private WebElement boxAcompanheSeuObj;
	
	@FindBy(xpath = "/html/body/main/div[3]/div/a[1]")
	private WebElement boxAcompanheSeuObjLogado;
	
	@FindBy(xpath = "//*[@id=\\\"content\\\"]/div[3]/div/div[2]/div[1]/form/div[1]/label")
	private WebElement txtAcompanheSeuObj;
	
	@FindBy(xpath = "//*[@id=\\\"objetos\\\"]")
	private WebElement inputPesquiseSeuObj;
	
	@FindBy(xpath = "//*[@id=\"menu-content\"]/div/div/ul[2]/li/a")
	private WebElement menuMeusCorreios;
	
	@FindBy(xpath = "//*[@id=\"menu-content\"]/div/div/ul[2]/li/ul/li[1]")
	private WebElement opcaoMeusCorreios;
	
	@FindBy(xpath = "/html/body/main/div[1]/div/a[1]")
	private WebElement btnEntrar;
	
	@FindBy(xpath = "//*[@id=\"fm1\"]/div[2]/button")
	private WebElement btnEntrarSenha;
	
	@FindBy(xpath = "//*[@id=\"tab-enviadoParaVoce\"]/section/div/div/div/table/tbody")
	private WebElement lstDeObjetosRastreados;
	
	@FindBy(xpath = "//*[@id=\"carol-fecha\"]")
	private WebElement popUpInicial;
	
	@FindBy(xpath = "//*[@id=\"control-fechar\"]/img")
	private WebElement popUpInicialFechar;
	
	@FindBy(css = "#btnCookie")
	private WebElement btnAceitoCookies;
	
	@FindBy(xpath = "//*[@id=\"username\"]")
	private WebElement inputUserName;
	
	@FindBy(xpath = "//*[@id=\"password\"]")
	private WebElement inputPassword;
	
	
    protected WebDriver driver;

    public CorreiosPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
 
	
	public WebElement inputPassword() {
		return inputPassword;
	}
	
	public WebElement inputUserName() {
		return inputUserName;
	}
	
	public WebElement btnAceitoCookies() {
		return btnAceitoCookies;
	}
    
	public WebElement boxAcompanheSeuObj() {
		return boxAcompanheSeuObj;
	}
	
	public WebElement lstDeObjetosRastreados() {
		return lstDeObjetosRastreados;
	}
	
	public WebElement boxAcompanheSeuObjLogado() {
		return boxAcompanheSeuObjLogado;
	}
	
	public WebElement txtAcompanheSeuObj() {
		return txtAcompanheSeuObj;
	}
	
	public WebElement inputPesquiseSeuObj() {
		return inputPesquiseSeuObj;
	}
	
	public WebElement menuMeusCorreios() {
		return menuMeusCorreios;
	}
	
	public WebElement opcaoMeusCorreios() {
		return opcaoMeusCorreios;
	}
	
	public WebElement btnEntrar() {
		return btnEntrar;
	}
	
	public WebElement btnEntrarSenha() {
		return btnEntrarSenha;
	}
	
	public WebElement popUpInicial() {
		return popUpInicial;
	}
	
	public void clickPopUpInicial() {
		popUpInicial.click();
	}
	
	public String getLabelAcompanheSeuObjTxt() {
		return boxAcompanheSeuObj.getText();
	}
	
	public void realizarPesquiseSeuObj(String valor) {
		inputPesquiseSeuObj.sendKeys(valor);
		inputPesquiseSeuObj.sendKeys(Keys.ENTER);
	}
	
	public void clicarMenuMeusCorreios() {
		menuMeusCorreios.click();
	}
	
	public void clicarOpcaoMeusCorreios() {
		opcaoMeusCorreios.click();
	}
	
	public void clicarBtnEntrar() {
		btnEntrar.click();
	}
	
	public void clicarBtnEntrarSenha() {
		btnEntrarSenha.click();
	}
	
	public void clicarBoxAcompanheSeuObjLogado() {
		boxAcompanheSeuObjLogado.click();
	}
	
	public void clicarAceitarCookies() {
		btnAceitoCookies.click();
	}
	
	public void inserirUserName(String userName) {
		inputUserName.sendKeys(userName);
	}
	
	public void inserirPassword(String password) {
		inputPassword.sendKeys(password);
	}
	
	
}
