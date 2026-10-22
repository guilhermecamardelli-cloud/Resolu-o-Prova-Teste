package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CadastroPage {

    private WebDriver driver;

    public CadastroPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement getEmailInput(){

        // o cartao de cadastro gira com animacao, entao espera o campo ficar clicavel
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@class='card__register']//input[@name='email']")));
    }

    public WebElement getNomeInput(){

        return driver.findElement(By.xpath("//div[@class='card__register']//input[@name='name']"));
    }

    public WebElement getSenhaInput(){

        return driver.findElement(By.xpath("//div[@class='card__register']//input[@name='password']"));
    }

    public WebElement getConfirmacaoSenhaInput(){

        return driver.findElement(By.xpath("//div[@class='card__register']//input[@name='passwordConfirmation']"));
    }

    public WebElement getCriarComSaldoToggle(){

        return driver.findElement(By.id("toggleAddBalance"));
    }

    public WebElement getCadastrarButton(){

        return driver.findElement(By.xpath("//div[@class='card__register']//button[text()='Cadastrar']"));
    }
}
