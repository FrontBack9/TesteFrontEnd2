package eplayers.teste;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteEplayer {
	
	private ChromeDriver driver;
	@Before
	public void abrirNavegador() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.get("http://localhost:4200/login");
}
	
	@Test
	public void testeNavegador() {
		
		String[] listaSenhas = {"senha1", "xpto", "outrasenha", "12345678"};
		//roda o teeste 4 vezes
		for(int tentativa = 0; tentativa < listaSenhas.length; tentativa++) {
			
			try {
				//declarar os inputs
				
				WebElement inputNome 	= this.driver.findElement(By.id("nome")); 
				WebElement inputUsuario = this.driver.findElement(By.id("usuario")); 
				WebElement inputSenha 	= this.driver.findElement(By.id("senha")); 
				WebElement inputSignin 	= this.driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/button[1]")); 
				
				//limpar os campos
				
				inputNome.clear();
				inputUsuario.clear();
				inputSenha.clear();
				
				//preencher os campos
				
				inputNome.sendKeys("Teobaldo");
				inputUsuario.sendKeys("teobaldo@teobaldo.com");
				inputSenha.sendKeys( listaSenhas[tentativa] );
				
				//inputSenha.sendKeys(Keys.ENTER);
				
				inputSignin.click();
				
				//pausar por 3 segundos
				
				Thread.sleep(3000);
				
			} catch(InterruptedException e) {
				e.printStackTrace();
				
			}	
			
		}	
		
	}

		

}
	
	
	
	

