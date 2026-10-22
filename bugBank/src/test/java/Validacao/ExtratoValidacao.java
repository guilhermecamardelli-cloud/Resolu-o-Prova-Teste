package Validacao;

import PageObjects.ExtratoPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ExtratoValidacao {

    private WebDriver driver;
    private ExtratoPage extratoPage;

    public ExtratoValidacao(WebDriver driver){

        this.driver = driver;
        extratoPage = new ExtratoPage(this.driver);
    }

    public void validationSaldo(String saldo){

        // o extrato abre mostrando R$ 0,00 e so depois carrega o saldo da conta
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(d -> GenericValidacao.limparTexto(extratoPage.getSaldoDisponivelText().getText()).equals(saldo));
        } catch (TimeoutException e) {
            // segue para o assert, que mostra o texto esperado e o encontrado
        }
        String label = GenericValidacao.limparTexto(extratoPage.getSaldoDisponivelText().getText());
        Assertions.assertEquals(saldo, label);
    }

    public void validationUltimaTransacao(String tipo, String descricao, String valor){

        // a transferencia e sempre a ultima linha do extrato
        Assertions.assertEquals(tipo, ultimo(extratoPage.getTiposTransacao()));
        Assertions.assertEquals(descricao, ultimo(extratoPage.getDescricoesTransacao()));
        Assertions.assertEquals(valor, ultimo(extratoPage.getValoresTransacao()));
    }

    private String ultimo(List<WebElement> elementos){

        Assertions.assertFalse(elementos.isEmpty(), "O extrato nao tem nenhuma transacao");
        return GenericValidacao.limparTexto(elementos.get(elementos.size() - 1).getText());
    }
}
