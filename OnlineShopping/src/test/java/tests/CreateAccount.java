package tests;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import pages.Metodos;

public class CreateAccount extends Metodos {

	Metodos metodo = new Metodos();

	By user = By.xpath(".//*[@id='menuUser']");

	By createAccount = By.xpath("//a[@href='javascript:void(0)' and @class='create-new-account ng-scope']");

	By userName = By.xpath("//input[@name='usernameRegisterPage' and @type='text']");
	By email = By.xpath("//input[@name='emailRegisterPage' and @type='text']");
	By password = By.xpath("//input[@name='passwordRegisterPage' and @type='password']");
	By confirmPassword = By.xpath("//input[@name='confirm_passwordRegisterPage']");
	By firstName = By.xpath("//input[@name='first_nameRegisterPage']");
	By lastName = By.xpath("//input[@name='last_nameRegisterPage']");
	By phone = By.xpath("//input[@name='phone_numberRegisterPage']");
	By country = By.xpath("//select[@name='countryListboxRegisterPage']");
	By city = By.xpath("//input[@name='cityRegisterPage']");
	By address = By.xpath("//input[@name='addressRegisterPage']");
	By province = By.xpath("//input[@name='state_/_province_/_regionRegisterPage']");
	By postalCode = By.xpath("//input[@name='postal_codeRegisterPage']");

	By promocoes = By.xpath("//input[@name='allowOffersPromotion']");
	By concordo = By.xpath("//input[@name='i_agree']");
	By register = By.xpath("//button[@id='register_btnundefined']");

	String usuario;

	public void criarConta(String email, String password, String confirmPassword, String firstName, String lastName,
			String phoneNumber, String country, String city, String adress, String province, String postalCode) {

		this.usuario = metodo.getNome();

		// clicando no botão user
		metodo.pausa(5000, "esperando o botão user ficar acessível");
		metodo.clicar(user, "clicar em user para criar a nova conta");

		// clicando no menu para abrir conta
		metodo.pausa(2000, "");
		metodo.clicar(createAccount, "clicando no menu create a new account");
		metodo.pausa(2000, postalCode);
		
		// preencher o formulario de abertura de conta
		metodo.pausa(2000, "esperando o botão user ficar acessível"); 
		metodo.escrever(this.userName, this.usuario, "preencher o campo nome");
		metodo.escrever(this.email, email, "");
		metodo.escrever(this.password, password, "");
		metodo.escrever(this.confirmPassword, confirmPassword, "");
		metodo.escrever(this.firstName, firstName, "");
		metodo.escrever(this.lastName, lastName, "");
		metodo.escrever(this.country, country, "");
		metodo.escrever(this.city, city, "");
		metodo.escrever(this.address, adress, "");
		metodo.escrever(this.province, province, "");
		metodo.escrever(this.postalCode, postalCode, "");

		metodo.pausa(1000, "");

		metodo.clicar(concordo, "");

		metodo.pausa(1000, "");

		metodo.clicar(register, "");
		

	}

	public void validarUser() {
		
		String loginName = driver.findElement(By.cssSelector("#menuUserLink > span")).getText();

		metodo.pausa(3000, "");

		System.out.println("O nome retornado é: " + loginName);

		System.out.println("**********************************************************");
		
		assertEquals(this.usuario, loginName);
		
		metodo.fechar("******************* FINALIZANDO O CADASTRO*********************");
	}

}
