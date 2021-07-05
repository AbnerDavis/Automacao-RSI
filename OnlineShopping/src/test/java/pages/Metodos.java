package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;

public class Metodos {

	// private static final String RandomStringUtils = null;
	// Criamos um objeto do tipo WebDriver chamado driver
	public static WebDriver driver;

	/**
	 * Métodos responsável por abrir o navegador
	 * 
	 * @author AbnerDavis
	 * @param site
	 * @param navegador
	 * @param descricao
	 */
	public void abrirNavegador(String site, String navegador, String descricao) {

		try {
			if (navegador == "CHROME") {
				System.setProperty("webdriver.chrome.driver", ".//DriversChrome/chromedriver.exe");
				driver = new ChromeDriver();
				driver.get(site);
			} else if (navegador == "FIREFOX") {
				System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				driver.get(site);
			} else {
				System.out.println("Opção inválida digitar CHROME ou FIREFOX");
			}
		} catch (Exception e) {
			System.out.println("****** error ****** no passo " + descricao + " " + e);
		}

		driver.manage().window().maximize();
	}

	/**
	 * Clicar no elemento
	 * 
	 * @author AbnerDavis
	 * @param elemento
	 * @param descricao
	 */
	public void clicar(By elemento, String descricao) {

		try {
			driver.findElement(elemento).click();
		} catch (Exception e) {
			System.out.println("****** error ****** no passo " + descricao + " " + e);
		}

	}

	/**
	 * Escrever um texto
	 * 
	 * @author AbnerDavis
	 * @param elemento
	 * @param texto
	 * @param descricao
	 */
	public void escrever(By elemento, String texto, String descricao) {

		try {
			driver.findElement(elemento).sendKeys(texto);
		} catch (Exception e) {
			System.out.println("****** error ****** no passo " + descricao + " " + e);
		}
	}

	/**
	 * Pausa o teste
	 * 
	 * @author AbnerDavis
	 * @param tempo
	 * @param descricao
	 */
	public void pausa(int tempo, String descricao) {

		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			System.out.println("****** error ****** no passo " + descricao + " " + e);
		}

	}

	/**
	 * Método aguardar elemento ficar disponível
	 * 
	 * @author AbnerDavis
	 * @param elemento
	 * @param descricao
	 */
	public void esperarElemento(By elemento, String descricao) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			@SuppressWarnings("unused")
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
		} catch (Exception e) {
			System.out.println("****** error ****** no passo " + descricao + " " + e);
		}
	}

	/**
	 * Encerrando o teste
	 * 
	 * @author AbnerDavis
	 * @param descricao
	 */
	public void fechar(String descricao) {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("****** error ****** no passo " + descricao + " " + e);
		}
	}

	private static Random rand = new Random();
	private static char[] letras = "abcdefghijlmnopqrstuvxz".toCharArray();

	public String getNome() {

		StringBuffer generatedString = new StringBuffer();
		for (int i = 0; i < 5; i++) {
			int ch = rand.nextInt(letras.length);
			generatedString.append(letras[ch]);
		}
		return generatedString.toString();

	}

}
