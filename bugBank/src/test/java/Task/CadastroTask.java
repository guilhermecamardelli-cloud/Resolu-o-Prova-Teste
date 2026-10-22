package Task;

import PageObjects.CadastroPage;
import PageObjects.GenericPage;
import PageObjects.LoginPage;
import Validacao.GenericValidacao;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastroTask {

    private WebDriver driver;
    private LoginPage loginPage;
    private CadastroPage cadastroPage;
    private GenericPage genericPage;
    private GenericValidacao genericValidacao;

    public CadastroTask(WebDriver driver){

        this.driver = driver;
        loginPage = new LoginPage(this.driver);
        cadastroPage = new CadastroPage(this.driver);
        genericPage = new GenericPage(this.driver);
        genericValidacao = new GenericValidacao(this.driver);
    }

    // cadastra uma conta com saldo e devolve o numero dela (ex: "123-4")
    public String cadastrarConta(String email, String nome, String senha){

        // o formulario de cadastro guarda os dados da conta anterior,
        // recarregar a pagina limpa tudo (as contas continuam salvas no navegador)
        driver.navigate().refresh();

        loginPage.getRegistrarButton().click();
        cadastroPage.getEmailInput().sendKeys(email);
        cadastroPage.getNomeInput().sendKeys(nome);
        cadastroPage.getSenhaInput().sendKeys(senha);
        cadastroPage.getConfirmacaoSenhaInput().sendKeys(senha);
        // o botao "Criar conta com saldo" e invisivel (opacity 0), entao o clique e feito via JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cadastroPage.getCriarComSaldoToggle());
        cadastroPage.getCadastrarButton().click();

        genericValidacao.validationModal("foi criada com sucesso");
        String numeroConta = pegarNumeroConta(genericPage.getModalText().getText());
        genericPage.getFecharModalButton().click();

        return numeroConta;
    }

    // a mensagem e "A conta 123-4 foi criada com sucesso", aqui pegamos so o "123-4"
    private String pegarNumeroConta(String mensagem){

        Matcher matcher = Pattern.compile("(\\d+-\\d+)").matcher(mensagem);
        if (!matcher.find()){
            throw new IllegalStateException("Numero da conta nao encontrado em: " + mensagem);
        }
        return matcher.group(1);
    }
}
