package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Classe Page Object da tela de Login.
 */
public class LoginPO extends BasePO {

    // #region WebElements
    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spanMensagem;

    @FindBy(xpath = "//button[@class='close']")
    public WebElement botaoFecharMensagemDeExcecao;
    // #endregion WebElements

    // #region Metodos
    /* Metodo que executa a ação de entrar no sistema */
    public void clicarNoBotaoEntrar() {
        buttonEntrar.click();
    }

    /* Metodo que retorna a mensagem de exceção apresentada na tela de login */
    public String obterMensagemExcecao() {
        return spanMensagem.getText();
    }

    /**
     * Método responsável pela tentativa de login no sistema
     * 
     * @param email E-mail para tentativa de login
     * @param senha Senha para tentativa de login
     */
    public void executarAcaoDeLogar(String email, String senha) {
        escrever(inputEmail, email);
        escrever(inputSenha, senha);
        clicarNoBotaoEntrar();
    }
    // #endregion Metodos

    // #region Construtor
    /**
     * Construtor para criação da página do Controle de Produtos.
     * 
     * @param driver Driver da página do Controle de Produtos.
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }
    // #endregion Construtor
}
