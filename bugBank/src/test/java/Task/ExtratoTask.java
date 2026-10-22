package Task;

import PageObjects.GenericPage;
import PageObjects.HomePage;
import Validacao.ExtratoValidacao;
import org.openqa.selenium.WebDriver;

public class ExtratoTask {

    private WebDriver driver;
    private HomePage homePage;
    private GenericPage genericPage;
    private ExtratoValidacao extratoValidacao;

    public ExtratoTask(WebDriver driver){

        this.driver = driver;
        homePage = new HomePage(this.driver);
        genericPage = new GenericPage(this.driver);
        extratoValidacao = new ExtratoValidacao(this.driver);
    }

    public void validarExtrato(String saldo, String tipo, String descricao, String valor){

        homePage.getExtratoButton().click();
        extratoValidacao.validationSaldo(saldo);
        extratoValidacao.validationUltimaTransacao(tipo, descricao, valor);
        genericPage.getSairButton().click();
    }
}
