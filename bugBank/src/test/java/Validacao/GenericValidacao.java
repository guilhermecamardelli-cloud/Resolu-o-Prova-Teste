package Validacao;

import PageObjects.GenericPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GenericValidacao {

    WebDriver driver;
    private GenericPage genericPage;

    public GenericValidacao(WebDriver driver){
        this.driver = driver;
        genericPage = new GenericPage(this.driver);

    }

    public void validationModal(String texto){

        // o modal entra deslizando de cima da tela (animacao), enquanto isso o texto vem vazio
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.textToBePresentInElementLocated(By.id("modalText"), texto));
        } catch (TimeoutException e) {
            // segue para o assert, que mostra o texto esperado e o encontrado
        }
        String label = genericPage.getModalText().getText();
        Assertions.assertTrue(label.contains(texto), "Esperado: '" + texto + "' | Encontrado: '" + label + "'");
    }

    // o site formata dinheiro com um espaco especial ( ) entre "R$" e o valor,
    // aqui ele vira um espaco normal para poder comparar com o texto esperado
    public static String limparTexto(String texto){

        return texto.replace(' ', ' ').trim();
    }
}
