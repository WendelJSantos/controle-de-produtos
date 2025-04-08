package page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import config.Constants;

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

    @FindBy(css = "table.table-hover")
    public WebElement tabelaProduto;

    @FindBy(css = "table tr")
    public List<WebElement> linhasTabelaProduto;

    @FindBy(css = "button.close")
    public WebElement buttonX;
    
    @FindBy(css = "div.alert.alert-danger.text-center.alert-dismissible > button.close")
    public WebElement buttonXDivAlert;
    // #endregion WebElements

    // #region Metodos
    /** Metodo que retorna a mensagem da modal na tela de produto */
    public String obterTituloDaModalDeCadastroDeProduto() {
        return modalTittleProduto.getText();
    }

    /**
     * Metodo que retorna a mensagem de exceção na tela da modal do cadastro de
     * produto
     */
    public String obterSpanMensagem() {
        return spanMensagem.getText();
    }

    public List<WebElement> obterColunasDaLinha(WebElement linha) {
        return linha.findElements(By.cssSelector("table td"));
    }

    public List<WebElement> obterTitulosDasColunas(WebElement linha) {
        return linha.findElements(By.cssSelector("table th"));
    }

    /**
     * Metodo que retorna os dados da tabela de produto pela chave e valor
     */
    public Map<String, List<String>> extrairDadosTabela() {
        Map<String, List<String>> dadosTabela = Constants.CAMPOS_TABELA.stream()
                .collect(Collectors.toMap(Function.identity(), k -> new ArrayList<>()));

        try {
            IntStream.range(1, linhasTabelaProduto.size()) // Pula o cabeçalho
                    .mapToObj(linhasTabelaProduto::get)
                    .map(this::obterColunasDaLinha)
                    .filter(colunas -> colunas.size() == Constants.CAMPOS_TABELA.size())
                    .forEach(colunas -> IntStream.range(0, Constants.CAMPOS_TABELA.size())
                            .forEach(i -> dadosTabela.get(Constants.CAMPOS_TABELA.get(i))
                                    .add(colunas.get(i).getText())));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
        return dadosTabela;
    }

    /**
     * Metodo que retorna o nome das colunas da tabela de produtos cadastrados
     */
    public Map<String, String> extrairNomeDasColunasDaTabela() {
        // Inicializa um mapa para armazenar os nomes das colunas
        Map<String, String> nomesDasColunas = new HashMap<>();

        try {
            // Pega a primeira linha da tabela (cabeçalho) e extrai as colunas
            List<WebElement> colunasCabecalho = obterTitulosDasColunas(linhasTabelaProduto.get(0));

            // Para cada coluna no cabeçalho, mapeia o nome para um campo específico
            IntStream.range(0, Constants.CAMPOS_TABELA.size())
                    .forEach(i -> nomesDasColunas.put(Constants.CAMPOS_TABELA.get(i),
                            colunasCabecalho.get(i).getText()));

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Retorna o mapa com os nomes das colunas
        return nomesDasColunas;
    }
    // #endregion Metodos

    // #region Construtor
    public ControleDeProdutoPO(WebDriver driver) {
        super(driver);
    }
    // #endregion Construtor

}
