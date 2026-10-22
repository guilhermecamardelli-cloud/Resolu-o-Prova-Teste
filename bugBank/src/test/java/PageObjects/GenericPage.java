package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GenericPage {

    private WebDriver driver;

    public GenericPage(WebDriver driver){

        this.driver = driver;
    }

    // a mesma janela (modal) aparece no cadastro e na transferencia
    public WebElement getModalText(){

        return driver.findElement(By.id("modalText"));
    }

    public WebElement getFecharModalButton(){

        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("btnCloseModal")));
    }

    public WebElement getSairButton(){

        return driver.findElement(By.id("btnExit"));
    }

    public WebElement getVoltarButton(){

        return driver.findElement(By.id("btnBack"));
    }
}
