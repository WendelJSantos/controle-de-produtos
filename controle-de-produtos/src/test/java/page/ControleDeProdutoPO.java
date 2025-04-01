package page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "//a[text()='Controle de produtos']")
    public WebElement linkControleDeProdutos;

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

    /** Metodo que executa a ação de voltar */
    public void clicarNoLinkControleDeProdutos() {
        linkControleDeProdutos.click();
    }

    /** Metodo que retorna a mensagem da modal na tela de produto */
    public String obterTituloDaModalDeCadastroDeProduto() {
        return modalTittleProduto.getText();
    }

    /** Metodo que executa a ação abrir a modal para cadastro de produto */
    public void clicarNoBotaoCriar() {
        buttonCriar.click();
    }

    /** Metodo que executa a ação sair da modal de cadastro do produto */
    public void clicarNoBotaoSair() {
        buttonSair.click();
        System.out.println("Passei aqui no botão sair");
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

    public Map<String, List<String>> extrairDadosTabela() {

        Map<String, List<String>> dadosTabela = new HashMap<>();
        dadosTabela.put("codigos", new ArrayList<>());
        dadosTabela.put("nomes", new ArrayList<>());
        dadosTabela.put("quantidades", new ArrayList<>());
        dadosTabela.put("valores", new ArrayList<>());
        dadosTabela.put("datas", new ArrayList<>());
        dadosTabela.put("acoes", new ArrayList<>());

        try {
            WebElement tabela = driver.findElement(By.cssSelector("table.table-hover"));
            List<WebElement> linhas = tabela.findElements(By.tagName("tr"));

            for (int i = 1; i < linhas.size(); i++) { // Pular o cabeçalho
                List<WebElement> colunas = linhas.get(i).findElements(By.tagName("td"));
                if (colunas.size() == 6) {
                    dadosTabela.get("codigos").add(colunas.get(0).getText());
                    dadosTabela.get("nomes").add(colunas.get(1).getText());
                    dadosTabela.get("quantidades").add(colunas.get(2).getText());
                    dadosTabela.get("valores").add(colunas.get(3).getText());
                    dadosTabela.get("datas").add(colunas.get(4).getText());
                    dadosTabela.get("acoes").add(colunas.get(5).getText());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
        System.out.println(dadosTabela);
        return dadosTabela;
    }

    // #endregion Metodos

    // #region Construtor
    public ControleDeProdutoPO(WebDriver driver) {
        super(driver);
    }
    // #endregion Construtor

}
