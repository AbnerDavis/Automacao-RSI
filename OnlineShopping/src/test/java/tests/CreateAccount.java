package tests;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import pages.Metodos;

public class CreateAccount extends Metodos {

	Metodos metodo = new Metodos();

	By user = By.id("menuUser");

	By createAccount = By.xpath("//a[contains(text(),\"CREATE NEW ACCOUNT\")]");

	By userName = By.name("usernameRegisterPage");
	By email = By.name("emailRegisterPage");
	By password = By.name("passwordRegisterPage");
	By confPassword = By.name("confirm_passwordRegisterPage");
	By firstName = By.name("first_nameRegisterPage");
	By lastName = By.name("last_nameRegisterPage");
	By phone = By.name("phone_numberRegisterPage");
	By country = By.name("countryListboxRegisterPage");
	By city = By.name("cityRegisterPage");
	By address = By.name("addressRegisterPage");
	By province = By.name("state_/_province_/_regionRegisterPage");
	By postalCode = By.name("postal_codeRegisterPage");

	By promocoes = By.name("nanallowOffersPromotion");
	By concordo = By.name("i_agree");
	By register = By.id("register_btnundefined");

	String usuario;

	public void criarConta(String email, String password, String confirmPassword, String firstName, String lastName,
			String phoneNumber, String country, String city, String adress, String province, String postalCode) {

		this.usuario = metodo.getNome();

		// clicando no bot�o user
		metodo.pausa(5000, "esperando o bot�o user ficar acess�vel");
		metodo.clicar(user, "clicar em user para criar a nova conta");

		// clicando no menu para abrir conta
		metodo.pausa(2000, "");
		metodo.clicar(createAccount, "clicando no menu create a new account");
		metodo.pausa(2000, postalCode);
		
		// preencher o formulario de abertura de conta
		metodo.pausa(2000, "esperando o bot�o user ficar acess�vel"); 
		metodo.escrever(this.userName, this.usuario, "preencher o campo nome");
		metodo.escrever(this.email, email, "");
		metodo.escrever(this.password, password, "");
		metodo.escrever(this.confPassword, confirmPassword, "");
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

		System.out.println("O nome retornado �: " + loginName);

		assertEquals(this.usuario, loginName);
		metodo.fechar("******************* FINALIZANDO O CADASTRO*********************");
	}

}