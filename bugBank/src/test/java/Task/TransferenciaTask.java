package Task;

import PageObjects.GenericPage;
import PageObjects.HomePage;
import PageObjects.TransferenciaPage;
import Validacao.GenericValidacao;
import org.openqa.selenium.WebDriver;

public class TransferenciaTask {

    private WebDriver driver;
    private HomePage homePage;
    private TransferenciaPage transferenciaPage;
    private GenericPage genericPage;
    private GenericValidacao genericValidacao;

    public TransferenciaTask(WebDriver driver){

        this.driver = driver;
        homePage = new HomePage(this.driver);
        transferenciaPage = new TransferenciaPage(this.driver);
        genericPage = new GenericPage(this.driver);
        genericValidacao = new GenericValidacao(this.driver);
    }

    // contaDestino vem no formato "123-4"
    public void realizarTransferencia(String contaDestino, String valor, String descricao){

        String[] conta = contaDestino.split("-");

        homePage.getTransferenciaButton().click();
        transferenciaPage.getNumeroContaInput().sendKeys(conta[0]);
        transferenciaPage.getDigitoInput().sendKeys(conta[1]);
        transferenciaPage.getValorInput().sendKeys(valor);
        transferenciaPage.getDescricaoInput().sendKeys(descricao);
        transferenciaPage.getTransferirAgoraButton().click();

        genericValidacao.validationModal("Transferencia realizada com sucesso");
        genericPage.getFecharModalButton().click();
        genericPage.getVoltarButton().click();
    }
}
