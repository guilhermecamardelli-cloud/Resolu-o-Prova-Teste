package Validacao;

import PageObjects.HomePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeValidacao {

    private WebDriver driver;
    private HomePage homePage;

    public HomeValidacao(WebDriver driver){

        this.driver = driver;
        homePage = new HomePage(this.driver);
    }

    public void validationLogin(String nome){

        // a home aparece primeiro vazia ("Olá ,") e so depois carrega o nome
        String esperado = "Olá " + nome + ",";
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.textToBe(By.id("textName"), esperado));
        } catch (TimeoutException e) {
            // segue para o assert, que mostra o texto esperado e o encontrado
        }
        Assertions.assertEquals(esperado, homePage.getNomeText().getText());
    }

    public void validationSaldo(String saldo){

        String label = GenericValidacao.limparTexto(homePage.getSaldoText().getText());
        Assertions.assertEquals("Saldo em conta " + saldo, label);
    }
}
