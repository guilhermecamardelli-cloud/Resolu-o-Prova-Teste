# Prova Teste e Qualidade de Software

Automação web do site [BugBank](https://bugbank.netlify.app/) com **Java + Selenium + JUnit 5**,
seguindo o mesmo padrão do projeto [AutomacaoWeb](https://github.com/guilhermecamardelli-cloud/AutomacaoWeb).

## O que o teste faz

Caso de teste: `bugBank/src/test/java/TestCases/RealizarTransferenciaComSucesso.java`

1. Cadastra a **Conta Origem** com saldo (R$ 1.000,00).
2. Cadastra a **Conta Destino** com saldo (R$ 1.000,00) e guarda o número da conta.
3. Entra na Conta Origem e transfere **R$ 150,00** para a Conta Destino.
4. Abre o **extrato da Conta Origem** e valida o saldo **R$ 850,00** e a linha "Transferência enviada / -R$ 150,00".
5. Entra na Conta Destino, abre o **extrato** e valida o saldo **R$ 1.150,00** e a linha "Transferência recebida / R$ 150,00".

## Estrutura

```
bugBank/
├── pom.xml                      dependências (Selenium, WebDriverManager, JUnit)
└── src
    ├── main/java/Framework
    │   ├── Browser/TypeBrowser   navegadores disponíveis
    │   ├── Browser/DriverManager abre e fecha o navegador
    │   └── TesteBase             abre o site antes do teste e fecha depois
    └── test/java
        ├── PageObjects           ONDE estão os elementos de cada tela (mapeamento)
        ├── Task                  O QUE fazer (passos: cadastrar, logar, transferir...)
        ├── Validacao             COMO conferir se deu certo (Assertions)
        └── TestCases             a história completa, juntando as Tasks
```

| Tela      | PageObject          | Task                | Validação          |
|-----------|---------------------|---------------------|--------------------|
| Login     | `LoginPage`         | `LoginTask`         | `HomeValidacao`    |
| Cadastro  | `CadastroPage`      | `CadastroTask`      | `GenericValidacao` |
| Home      | `HomePage`          | —                   | `HomeValidacao`    |
| Transferência | `TransferenciaPage` | `TransferenciaTask` | `GenericValidacao` |
| Extrato   | `ExtratoPage`       | `ExtratoTask`       | `ExtratoValidacao` |
| Modal / botões comuns | `GenericPage` | —            | `GenericValidacao` |

## Como rodar

Pelo IntelliJ: abrir a pasta `bugBank`, abrir `RealizarTransferenciaComSucesso` e clicar no ▶ verde.

Pelo terminal (dentro de `bugBank`):

```bash
mvn test                       # abre o Chrome na tela
mvn test -Dbrowser=HEADLESS    # roda sem abrir janela
```

O `pom.xml` usa Java 25 (igual ao AutomacaoWeb). Se o seu JDK for outro, troque
`maven.compiler.source` e `maven.compiler.target` no `pom.xml`.
