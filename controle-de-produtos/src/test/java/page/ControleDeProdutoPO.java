package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ControleDeProdutoPO extends BasePO {

    @FindBy(css = "ul>li>a.nav-link")
    public WebElement linkVoltar;

    public void clicarNoLinkVoltar() {
         linkVoltar.click();
    }

    @FindBy(css = "div>h4.modal-title")
    public WebElement modalTittleProduto;

    public String obterMensagemModalTittleProduto() {
       return modalTittleProduto.getText();
    }    
    
    @FindBy(id = "btn-adicionar")
    public WebElement buttonCriar;
    
    public void clicarNoBotaoCriar(){
        buttonCriar.click();
    }

    @FindBy(id = "codigo")
    public WebElement inputCodigo;
    
    @FindBy(id = "nome")
    public WebElement inputNome;
    
    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "data")
    public WebElement inputData;

    @FindBy(id = "btn-salvar")
    public WebElement buttonSalvar;

    public void clicarNoBotaoSalvar(){
        buttonSalvar.click();
    }
    
    @FindBy(id = "btn-sair")
    public WebElement buttonSair;

    public void clicarNoBotaoSair(){
        buttonSair.click();
    }

    public void cadastrarNovoProduto(String codigo, String nome, String quantidade, String valor, String data){
        escrever(inputCodigo, codigo);
        escrever(inputNome, nome);
        escrever(inputQuantidade, quantidade);
        escrever(inputValor, valor);
        escrever(inputData, data);
        clicarNoBotaoSalvar();
    }

    public ControleDeProdutoPO(WebDriver driver) {
        super(driver);
    }

}
