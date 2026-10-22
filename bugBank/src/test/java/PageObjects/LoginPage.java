package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;

    }

    // a tela tem dois formularios (login e cadastro) com campos de mesmo "name",
    // por isso o xpath comeca pelo cartao de login
    public WebElement getEmailInput() {

        return driver.findElement(By.xpath("//div[@class='card__login']//input[@name='email']"));
    }

    public WebElement getPasswordInput() {

        return driver.findElement(By.xpath("//div[@class='card__login']//input[@name='password']"));
    }

    public WebElement getAcessarButton() {

        return driver.findElement(By.xpath("//div[@class='card__login']//button[text()='Acessar']"));
    }

    public WebElement getRegistrarButton() {

        return driver.findElement(By.xpath("//div[@class='card__login']//button[text()='Registrar']"));
    }

}
