package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferenciaPage {

    private WebDriver driver;

    public TransferenciaPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement getNumeroContaInput(){

        return driver.findElement(By.name("accountNumber"));
    }

    public WebElement getDigitoInput(){

        return driver.findElement(By.name("digit"));
    }

    public WebElement getValorInput(){

        return driver.findElement(By.name("transferValue"));
    }

    public WebElement getDescricaoInput(){

        return driver.findElement(By.name("description"));
    }

    public WebElement getTransferirAgoraButton(){

        // o botao nao tem id no site, entao e encontrado pelo texto
        return driver.findElement(By.xpath("//button[text()='Transferir agora']"));
    }
}
