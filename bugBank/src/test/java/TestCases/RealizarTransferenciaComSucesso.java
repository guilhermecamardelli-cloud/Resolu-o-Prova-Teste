package TestCases;

import Framework.TesteBase;
import Task.CadastroTask;
import Task.ExtratoTask;
import Task.LoginTask;
import Task.TransferenciaTask;
import Validacao.HomeValidacao;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class RealizarTransferenciaComSucesso extends TesteBase {

    private final WebDriver driver = getDriverManager();

    CadastroTask cadastroTask = new CadastroTask(driver);
    LoginTask loginTask = new LoginTask(driver);
    TransferenciaTask transferenciaTask = new TransferenciaTask(driver);
    ExtratoTask extratoTask = new ExtratoTask(driver);
    HomeValidacao homeValidacao = new HomeValidacao(driver);

    private static final String SENHA = "123456";
    private static final String EMAIL_ORIGEM = "origem@teste.com";
    private static final String NOME_ORIGEM = "Conta Origem";
    private static final String EMAIL_DESTINO = "destino@teste.com";
    private static final String NOME_DESTINO = "Conta Destino";
    private static final String VALOR = "150";
    private static final String DESCRICAO = "Prova Fundatec";

    @Test
    public void realizarTransferencia(){

        // 1 e 2 - cadastrar duas contas com saldo (R$ 1.000,00 cada)
        cadastroTask.cadastrarConta(EMAIL_ORIGEM, NOME_ORIGEM, SENHA);
        String contaDestino = cadastroTask.cadastrarConta(EMAIL_DESTINO, NOME_DESTINO, SENHA);

        // 3 - entrar na conta de origem e transferir para a conta de destino
        loginTask.efetuarLogin(EMAIL_ORIGEM, SENHA, NOME_ORIGEM);
        homeValidacao.validationSaldo("R$ 1.000,00");
        transferenciaTask.realizarTransferencia(contaDestino, VALOR, DESCRICAO);

        // 4 - extrato da conta que enviou: 1.000 - 150 = 850
        extratoTask.validarExtrato("R$ 850,00", "Transferência enviada", DESCRICAO, "-R$ 150,00");

        // 5 - extrato da conta que recebeu: 1.000 + 150 = 1.150
        loginTask.efetuarLogin(EMAIL_DESTINO, SENHA, NOME_DESTINO);
        extratoTask.validarExtrato("R$ 1.150,00", "Transferência recebida", DESCRICAO, "R$ 150,00");
    }

}
