package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    @FindBy(id =  "email")
    public WebElement inputEmail;
        
    @FindBy(id =  "senha")
    public WebElement inputSenha;

    @FindBy(id =  "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spanMensagem;

    @FindBy(xpath = "//button[@class='close']")
    public WebElement botaoFecharMensagemDeExcecao;

    public void clicarNoBotaoEntrar(){
        buttonEntrar.click();
    }

    public String obterMensagemExcecao(){
       return spanMensagem.getText();
    }

    /**
     * Método responsável pela tentativa de login no sistema
     * @param email E-mail para tentativa de login
     * @param senha Senha para tentativa de login
     */
    public void executarAcaoDeLogar(String email, String senha){
        escrever(inputEmail, email);
        escrever(inputSenha, senha);
        clicarNoBotaoEntrar();
    }

    /**
     * Construtor para criação da página do Controle de Produtos.
     * @param driver Driver da página do Controle de Produtos.
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }

}
