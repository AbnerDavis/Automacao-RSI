package tests;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.Metodos;

public class CreateAccount extends Metodos {
	WebDriverWait wait;
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
			String phoneNumber, String country, String city, String adress, String province, String postalCode)
			throws InterruptedException {

		this.usuario = metodo.getNome();

		// clicando no botão user
		metodo.esperarElemento(user, "");
		metodo.clicar(user, "clicar em user para criar a nova conta");

		// clicando no menu para abrir conta
		metodo.esperarElemento(createAccount, "");
		metodo.clicar(createAccount, "clicando no menu create a new account");
		metodo.esperarElemento(createAccount, "");

		// preencher o formulario de abertura de conta
		
		metodo.esperarElemento(userName, "");

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

		metodo.esperarElemento(concordo, "");

		metodo.clicar(concordo, "");

		metodo.esperarElemento(register, "");

		metodo.clicar(register, "");

	}

	public void validarUser() throws InterruptedException {

		String loginName = driver.findElement(By.xpath("//a[@id='hrefUserIcon']")).getText();


		System.out.println("O nome retornado é: " + loginName);

		System.out.println("**********************************************************");

		assertEquals(this.usuario, loginName);

		metodo.fechar("******************* FINALIZANDO O CADASTRO*********************");
	}

}
