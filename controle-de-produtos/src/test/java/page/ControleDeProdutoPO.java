package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Classe Page Object do Controle de Produto.
 */
public class ControleDeProdutoPO extends BasePO {

    // #region WebElements
    @FindBy(css = "ul>li>a.nav-link")
    public WebElement linkVoltar;

    @FindBy(css = "div>h4.modal-title")
    public WebElement modalTittleProduto;

    @FindBy(id = "btn-adicionar")
    public WebElement buttonCriar;

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

    @FindBy(id = "btn-sair")
    public WebElement buttonSair;

    @FindBy(id = "mensagem")
    public WebElement spanMensagem;
    // #endregion WebElements

    // #region Metodos
    /** Metodo que executa a ação de voltar */
    public void clicarNoLinkVoltar() {
        linkVoltar.click();
    }

    /** Metodo que retorna a mensagem da modal na tela de produto */
    public String obterMensagemModalTittleProduto() {
        return modalTittleProduto.getText();
    }

    /** Metodo que executa a ação abrir a modal para cadastro de produto */
    public void clicarNoBotaoCriar() {
        buttonCriar.click();
    }

    /** Metodo que executa a ação sair da modal de cadastro do produto */
    public void clicarNoBotaoSair() {
        buttonSair.click();
    }

    /** Metodo que executa a ação de cadastrar um produto */
    public void clicarNoBotaoSalvar() {
        buttonSalvar.click();
    }

    /**
     * Metodo que retorna a mensagem de exceção na tela da modal do cadastro de
     * produto
     */
    public String obterSpanMensagem() {
        return spanMensagem.getText();
    }

    // #endregion Metodos

    // #region Construtor
    public ControleDeProdutoPO(WebDriver driver) {
        super(driver);
    }
    // #endregion Construtor

}
