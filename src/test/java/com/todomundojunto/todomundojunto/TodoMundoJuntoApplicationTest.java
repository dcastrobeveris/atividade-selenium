package com.todomundojunto.todomundojunto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileReader;

@SpringBootTest
class TodoMundoJuntoApplicationTest {

	protected WebDriver driver;
	PageObject espera = new PageObject();

	@BeforeEach
	public void inicializador(){
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		this.driver = new ChromeDriver();
		//this.driver = driver;
		driver.get("http://automationpractice.com/index.php");
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/dados.csv", numLinesToSkip = 1)
	public void deve_CadastrarUsuario(String email, String sexo, String primeiroNome, String ultimoNome, String senha, int dia,
									  String mes, int ano, String rua, String cidade, String estado, String cep, String pais,
									  String tel) {
		espera.esperar(driver, "");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a")).click();
		espera.esperar(driver, "");
		driver.findElement(By.cssSelector("#email_create")).sendKeys(email);
		espera.esperar(driver, "");
		driver.findElement(By.cssSelector("#SubmitCreate")).click();
		espera.esperar(driver, "#customer_firstname");

		if (sexo.equals("M")){
			sexo = "#id_gender1";
		} else {
			sexo = "#id_gender2";
		}
		this.driver.findElement(By.cssSelector(sexo)).click();


		int casaEstado = 0;
		int casaPais = 0;

		switch (estado){

			case "Alabama":
				casaEstado = 1;
				break;

			case "Alaska":
				casaEstado = 2;
				break;

			case "Arizona":
				casaEstado = 3;
				break;

			case "Arkansas":
				casaEstado = 4;
				break;

			case "California":
				casaEstado = 5;
				break;

			case "Colorado":
				casaEstado = 6;
				break;

			case "Connecticut":
				casaEstado = 7;
				break;

			case "Delaware":
				casaEstado = 8;
				break;

			case "District of Columbia":
				casaEstado = 53;
				break;

			case "Florida":
				casaEstado = 9;
				break;

			case "Georgia":
				casaEstado = 10;
				break;

			case "Hawaii":
				casaEstado = 11;
				break;

			case "Idaho":
				casaEstado = 12;
				break;

			case "Illinois":
				casaEstado = 13;
				break;

			case "Indiana":
				casaEstado = 14;
				break;

			case "Iowa":
				casaEstado = 15;
				break;

			case "Kansas":
				casaEstado = 16;
				break;

			case "Kentucky":
				casaEstado = 17;
				break;

			case "Louisiana":
				casaEstado = 18;
				break;

			case "Maine":
				casaEstado = 19;
				break;

			case "Maryland":
				casaEstado = 20;
				break;

			case "Massachusetts":
				casaEstado = 21;
				break;

			case "Michigan":
				casaEstado = 22;
				break;

			case "Minnesota":
				casaEstado = 23;
				break;

			case "Mississipi":
				casaEstado = 24;
				break;

			case "Missouri":
				casaEstado = 25;
				break;

			case "Montana":
				casaEstado = 26;
				break;

			case "Nebraska":
				casaEstado = 27;
				break;

			case "Nevada":
				casaEstado = 28;
				break;

			case "New Hampshire":
				casaEstado = 29;
				break;

			case "New Jersey":
				casaEstado = 30;
				break;

			case "New Mexico":
				casaEstado = 31;
				break;

			case "New York":
				casaEstado = 32;
				break;

			case "North Carolina":
				casaEstado = 33;
				break;

			case "North Dakota":
				casaEstado = 34;
				break;

			case "Ohio":
				casaEstado = 35;
				break;

			case "Oklahoma":
				casaEstado = 36;
				break;

			case "Oregon":
				casaEstado = 37;
				break;

			case "Pennsylvania":
				casaEstado = 38;
				break;

			case "Puerto Rico":
				casaEstado = 51;
				break;

			case "Rhode Island":
				casaEstado = 39;
				break;

			case "South Carolina":
				casaEstado = 40;
				break;

			case "South Dakota":
				casaEstado = 41;
				break;

			case "Tenesse":
				casaEstado = 42;
				break;

			case "Texas":
				casaEstado = 43;
				break;

			case "US Virgin Islands":
				casaEstado = 52;
				break;

			case "Utah":
				casaEstado = 44;
				break;

			case "Vermont":
				casaEstado = 45;
				break;

			case "Virginia":
				casaEstado = 46;
				break;

			case "Washington":
				casaEstado = 47;
				break;

			case "West Virginia":
				casaEstado = 48;
				break;

			case "Wisconsin":
				casaEstado = 49;
				break;

			case "Wyoming":
				casaEstado = 50;
				break;

		}

		switch (pais){
			case "United States":
				casaPais = 2;
				break;
			case "-":
				casaPais = 1;
				break;
		}


		// Formulário
		driver.findElement(By.id("customer_firstname")).sendKeys(primeiroNome);
		driver.findElement(By.id("customer_lastname")).sendKeys(ultimoNome);
		driver.findElement(By.id("passwd")).sendKeys(senha);
		driver.findElement(By.cssSelector("#days")).sendKeys("" + dia + "");
		driver.findElement(By.cssSelector("#months")).sendKeys("" + mes + "");
		driver.findElement(By.cssSelector("#years")).sendKeys("" + ano + "");
		driver.findElement(By.id("address1")).sendKeys(rua);
		driver.findElement(By.id("city")).sendKeys(cidade);
		driver.findElement(By.id("id_state")).sendKeys("" + estado + "");
		driver.findElement(By.id("postcode")).sendKeys(cep);
		driver.findElement(By.id("id_country")).sendKeys("" + pais + "");
		driver.findElement(By.id("phone_mobile")).sendKeys("" + tel + "");
		driver.findElement(By.id("alias")).clear();
		driver.findElement(By.id("alias")).sendKeys("My House");

		// Botão registrar
		driver.findElement(By.cssSelector("#submitAccount")).click();

		/*
		//PageObject browser = new PageObject();
		CSVReader reader = new CSVReader(
				new FileReader("C:\\Users\\dcastrob\\intellij-workspace\\todomundojunto\\src\\test\\resource\\dados.csv"), ';');
		String[] tableline = null;*/
	}


}
