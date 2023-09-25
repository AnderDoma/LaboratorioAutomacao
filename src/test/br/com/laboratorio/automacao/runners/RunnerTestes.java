package br.com.laboratorio.automacao.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (
		
		plugin = { "pretty", "html:target/cucumber-report",
				"junit:target/cucumber-report/junitResulta.xml",
				"json:target/cucumber-report/jsonResult.json"},
		features = {
				"src/test/java/validar_pesquisa.feature"},
		glue = { "br.com.laboratorio.automacao.steps" },
		tags = {}	
		)
	
public class RunnerTestes {

}
