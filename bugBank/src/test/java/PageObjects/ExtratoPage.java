package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ExtratoPage {

    private WebDriver driver;

    public ExtratoPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement getSaldoDisponivelText(){

        return driver.findElement(By.id("textBalanceAvailable"));
    }

    // o extrato tem uma linha por transacao, entao estes metodos devolvem listas
    public List<WebElement> getTiposTransacao(){

        return driver.findElements(By.id("textTypeTransaction"));
    }

    public List<WebElement> getDescricoesTransacao(){

        return driver.findElements(By.id("textDescription"));
    }

    public List<WebElement> getValoresTransacao(){

        return driver.findElements(By.id("textTransferValue"));
    }
}
