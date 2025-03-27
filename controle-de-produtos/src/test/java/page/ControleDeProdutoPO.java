package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import builder.ProdutoBuilder;

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

    @FindBy(id = "mensagem")
    public WebElement spanMensagem;
    
    public String obterSpanMensagem(){
        return spanMensagem.getText();
    }

    public void cadastrarNovoProduto(ProdutoBuilder produtoBuilder){
        produtoBuilder.builder();
    }

    public ControleDeProdutoPO(WebDriver driver) {
        super(driver);
    }

}
