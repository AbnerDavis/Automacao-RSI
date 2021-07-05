package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Metodos;

public class Steps {
	
	Metodos metodo = new Metodos();
	CreateAccount account = new CreateAccount();
	WebDriverWait wait;

	@Given("esteja na tela de cadastro de cliente")
	public void esteja_na_tela_de_cadastro_de_cliente() throws InterruptedException {
		metodo.abrirNavegador("http://advantageonlineshopping.com/", "CHROME", "acessando site da loja");
		
		
	}

	@When("informar todos os dados obrigatorios")
	public void informar_todos_os_dados_obrigatorios() throws InterruptedException{
		account.criarConta("emailTesteAutomacao@gmail.com", "luoLd7MNOB", "luoLd7MNOB", "Louise Camila", "Figueiredo",
				"98 98419-1583", "Brazil", "São Luís", "Rua General Tasso Fragoso", "MA", "65030630");
		
		
	}

	@Then("cadastro realizada com sucesso")
	public void cadastro_realizada_com_sucesso() throws InterruptedException  {
		metodo.esperarElemento(By.xpath("//a[@id='hrefUserIcon']\""), "");
		account.validarUser();
		
	}
	

}
