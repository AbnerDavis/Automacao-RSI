package tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Metodos;

public class Steps {

	Metodos metodo = new Metodos();
	CreateAccount account = new CreateAccount();

	@Given("esteja na tela de cadastro de cliente")
	public void esteja_na_tela_de_cadastro_de_cliente() {
		System.out.println();; // PARA ORGANIZAR O CONSOLE
		System.out.println("************************* INCIANDO O NAVEGADOR *************************");
		System.out.println(); // PARA ORGANIZAR O CONSOLE

		metodo.abrirNavegador("http://advantageonlineshopping.com/", "CHROME", "acessando site da loja");

		System.out.println();; // PARA ORGANIZAR O CONSOLE
		System.out.println("************************* NAVEGADOR INICIADO *************************");
		System.out.println();; // PARA ORGANIZAR O CONSOLE
	}

	@When("informar todos os dados obrigatorios")
	public void informar_todos_os_dados_obrigatorios() {
		System.out.println();; // PARA ORGANIZAR O CONSOLE
		System.out.println("************************* CRIANDO CONTA *************************");
		
		account.criarConta("emailTesteAutomacao@gmail.com", "luoLd7MNOB", "luoLd7MNOB", "Louise Camila", "Figueiredo",
				"98 98419-1583", "Brazil", "São Luís", "Rua General Tasso Fragoso", "MA", "65030630");

		System.out.println();; // PARA ORGANIZAR O CONSOLE
		System.out.println();; // PARA ORGANIZAR O CONSOLE
	}

	@Then("cadastro realizada com sucesso")
	public void cadastro_realizada_com_sucesso() {
		System.out.println("**********************************************************"); // PARA ORGANIZAR O CONSOLE
		
		metodo.pausa(3000, null);
		account.validarUser();
		metodo.pausa(3000, null);
		
		System.out.println("**********************************************************"); // PARA ORGANIZAR O CONSOLE
	}
	

}
