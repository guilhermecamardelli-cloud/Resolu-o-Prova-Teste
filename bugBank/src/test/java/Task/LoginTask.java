package Task;

import PageObjects.LoginPage;
import Validacao.HomeValidacao;
import org.openqa.selenium.WebDriver;

public class LoginTask {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomeValidacao homeValidacao;

    public LoginTask (WebDriver driver){

        this.driver = driver;
        loginPage = new LoginPage(this.driver);
        homeValidacao = new HomeValidacao(this.driver);

    }

    public void efetuarLogin(String email, String senha, String nome){

        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(senha);
        loginPage.getAcessarButton().click();
        homeValidacao.validationLogin(nome);
    }
}
