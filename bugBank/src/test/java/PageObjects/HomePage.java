package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement getNomeText(){

        return driver.findElement(By.id("textName"));
    }

    public WebElement getSaldoText(){

        return driver.findElement(By.id("textBalance"));
    }

    public WebElement getTransferenciaButton(){

        return driver.findElement(By.id("btn-TRANSFERÊNCIA"));
    }

    public WebElement getExtratoButton(){

        return driver.findElement(By.id("btn-EXTRATO"));
    }
}
