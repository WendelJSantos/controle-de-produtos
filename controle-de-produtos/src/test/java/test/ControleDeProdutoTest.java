package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.asserts.SoftAssert;
import builder.ProdutoBuilder;
import config.Constants;
import page.ControleDeProdutoPO;
import page.LoginPO;

/**
 * Classe responsável pelos testes da tela de consulta e cadastro de produtos
 */
public class ControleDeProdutoTest extends BaseTest {

    private ControleDeProdutoPO controleDeProdutoPage;
    private LoginPO loginPage;
    SoftAssert softAssert = new SoftAssert();

    /*
     * Metodo que prepara os sistema para acessar a tela de consulta e cadastro de
     * produtos
     */
    @BeforeEach
    public void setUp() {
        super.iniciar(); // Garante que o driver seja inicializado antes de usar
        loginPage = new LoginPO(driver); // Inicializa loginPage
        controleDeProdutoPage = new ControleDeProdutoPO(driver); // Inicializa controleDeProdutoPage
        loginPage.executarAcaoDeLogar(Constants.EMAIL_VALIDO, Constants.SENHA_VALIDA);
        // Valida que o sistema está na página do Controle de Produtos
        assertEquals(Constants.TITULO_PAGINA_CONTROLE_DE_PRODUTOS, loginPage.obterTituloDaPagina());
    }

    // Metodo de teste responsável por validar que o sistema não permite cadastrar
    // produto com o campo Código em branco
    @Test
    public void TC001_naoDeveCadastrarProdutoComOCampoCodigoEmBranco() {
        // TODO: Remover esse clique duplo assim que o sistema for corrigido.
        controleDeProdutoPage.clicarNoBotaoCriar();
        controleDeProdutoPage.clicarNoBotaoCriar();

        assertEquals(Constants.DESCRICAO_MODAL_TITTLE_PRODUTO,
                controleDeProdutoPage.obterTituloDaModalDeCadastroDeProduto());

        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleDeProdutoPage);

        produtoBuilder
                .adicionarCodigo("")
                .builder();

        assertEquals(Constants.MENSAGEM_VAZIA, controleDeProdutoPage.inputCodigo.getText());
        assertEquals(Constants.MENSAGEM_CAMPOS_OBRIGATORIOS, controleDeProdutoPage.obterSpanMensagem());
    }

    /*
     * Metodo de teste responsável por validar que o sistema não permite cadastrar
     * produto com o campo Nome em branco
     */
    @Test
    public void TC002_naoDeveCadastrarProdutoComOCampoNomeEmBranco() {
        controleDeProdutoPage.clicarNoBotaoCriar();
        // TODO: Remover esse clique duplo assim que o sistema for corrigido.
        controleDeProdutoPage.clicarNoBotaoCriar();

        assertEquals(Constants.DESCRICAO_MODAL_TITTLE_PRODUTO,
                controleDeProdutoPage.obterTituloDaModalDeCadastroDeProduto());

        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleDeProdutoPage);

        produtoBuilder
                .adicionarNome("")
                .builder();

        assertEquals(Constants.MENSAGEM_VAZIA, controleDeProdutoPage.inputNome.getText());
        assertEquals(Constants.MENSAGEM_CAMPOS_OBRIGATORIOS, controleDeProdutoPage.obterSpanMensagem());
    }

    /*
     * Metodo de teste responsável por validar que o sistema não permite cadastrar
     * produto com o campo Quantidade em branco
     */
    @Test
    public void TC003_naoDeveCadastrarProdutoComOCampoQuantidadeEmBranco() {
        controleDeProdutoPage.clicarNoBotaoCriar();
        // TODO: Remover esse clique duplo assim que o sistema for corrigido.
        controleDeProdutoPage.clicarNoBotaoCriar();

        assertEquals(Constants.DESCRICAO_MODAL_TITTLE_PRODUTO,
                controleDeProdutoPage.obterTituloDaModalDeCadastroDeProduto());

        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleDeProdutoPage);

        produtoBuilder
                .adicionarQuantidade("")
                .builder();

        assertEquals(Constants.MENSAGEM_VAZIA, controleDeProdutoPage.inputQuantidade.getText());
        assertEquals(Constants.MENSAGEM_CAMPOS_OBRIGATORIOS, controleDeProdutoPage.obterSpanMensagem());
    }

    /*
     * Metodo de teste responsável por validar que o sistema não permite cadastrar
     * produto com o campo Valor em branco
     */
    @Test
    public void TC004_naoDeveCadastrarProdutoComOCampoValorEmBranco() {
        controleDeProdutoPage.clicarNoBotaoCriar();
        // TODO: Remover esse clique duplo assim que o sistema for corrigido.
        controleDeProdutoPage.clicarNoBotaoCriar();

        assertEquals(Constants.DESCRICAO_MODAL_TITTLE_PRODUTO,
                controleDeProdutoPage.obterTituloDaModalDeCadastroDeProduto());

        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleDeProdutoPage);

        produtoBuilder
                .adicionarValor("")
                .builder();

        assertEquals(Constants.MENSAGEM_VAZIA, controleDeProdutoPage.inputValor.getText());
        assertEquals(Constants.MENSAGEM_CAMPOS_OBRIGATORIOS, controleDeProdutoPage.obterSpanMensagem());
    }

    /*
     * Metodo de teste responsável por validar que o sistema não permite cadastrar
     * produto com o campo Data em branco
     */
    @Test
    public void TC005_naoDeveCadastrarProdutoComOCampoDataEmBranco() {
        controleDeProdutoPage.clicarNoBotaoCriar();
        // TODO: Remover esse clique duplo assim que o sistema for corrigido.
        controleDeProdutoPage.clicarNoBotaoCriar();

        assertEquals(Constants.DESCRICAO_MODAL_TITTLE_PRODUTO,
                controleDeProdutoPage.obterTituloDaModalDeCadastroDeProduto());

        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleDeProdutoPage);

        produtoBuilder
                .adicionarData("")
                .builder();

        assertEquals(Constants.MENSAGEM_VAZIA, controleDeProdutoPage.inputData.getText());
        assertEquals(Constants.MENSAGEM_CAMPOS_OBRIGATORIOS, controleDeProdutoPage.obterSpanMensagem());
    }

    /*
     * Metodo de teste responsável por validar que o sistema permanece na mesma tela
     * ao clicar no link Controle de produtos
     */
    @Test
    public void TC006_devePermanecerNaMesmaPaginaAoClicarNoLinkControleDeProdutos() {
        controleDeProdutoPage.clicarNoLinkControleDeProdutos();
        /*
         * Validando que sistema permaneceu na tela Controle de produtos através da
         * exibição do botão Criar presente na tela
         */
        assertTrue(controleDeProdutoPage.buttonCriar.isDisplayed());
    }

    /*
     * Caso de teste falhando. O link voltar não está retornando para a tela de
     * login.
     */
    @Test
    public void TC007_deveRetornarParaATelaDeLoginAoClicarNoLinkVoltar() {
        controleDeProdutoPage.clicarNoLinkVoltar();
        assertEquals(Constants.TITULO_PAGINA_LOGIN, loginPage.obterTituloDaPagina());
    }

    @Test
    public void TC008_deveRetornarOsUltimosProdutosCadastrados() {
        controleDeProdutoPage.clicarNoBotaoCriar();
        controleDeProdutoPage.clicarNoBotaoCriar();
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleDeProdutoPage);
        produtoBuilder.builder();

        produtoBuilder
                .adicionarCodigo("2")
                .adicionarNome("nome 2")
                .adicionarQuantidade("2")
                .adicionarValor("2")
                .builder();

        produtoBuilder
                .adicionarCodigo("3")
                .adicionarNome("nome 3")
                .adicionarQuantidade("3")
                .adicionarValor("3")
                .builder();

        controleDeProdutoPage.clicarNoBotaoSair();

        Map<String, List<String>> produtosCadastrados = controleDeProdutoPage.extrairDadosTabela();

        // Melhorar asserção posteriormente para identificar exatamente qual asserção
        // falhou e por qual motivo
        softAssert.assertTrue(produtosCadastrados.get("valor").contains("50.0"));
        softAssert.assertTrue(produtosCadastrados.get("valor").contains("2"));
        softAssert.assertTrue(produtosCadastrados.get("valor").contains("3"));
        softAssert.assertAll();

    }

    @Test
    public void TC009_deveRetornarOsNomesDasColunasDaTabelaPadronizadosEEmPortugues() {

        Map<String, String> nomeColuna = controleDeProdutoPage.extrairNomeDasColunasDaTabela();

        softAssert.assertEquals(nomeColuna.get("codigo"), Constants.NOME_COLUNA_CODIGO);
        softAssert.assertEquals(nomeColuna.get("nome"), Constants.NOME_COLUNA_NOME);
        softAssert.assertEquals(nomeColuna.get("quantidade"), Constants.NOME_COLUNA_QUANTIDADE);
        softAssert.assertEquals(nomeColuna.get("valor"), Constants.NOME_COLUNA_VALOR);
        softAssert.assertEquals(nomeColuna.get("data"), Constants.NOME_COLUNA_DATA_DE_CRIACAO);
        softAssert.assertEquals(nomeColuna.get("acao"), Constants.NOME_COLUNA_ACAO);

        softAssert.assertAll();

    }

    /*
     * Metodo de teste responsável por validar que o sistema permite cadastrar
     * produto com todos os campos preenchidos corretamente
     */
    @Test
    public void TC020_deveCadastrarNovoProdutoComSucesso() {
        controleDeProdutoPage.clicarNoBotaoCriar();
        // TODO: Remover esse clique duplo assim que o sistema for corrigido.
        controleDeProdutoPage.clicarNoBotaoCriar();

        String mensagemModalTittleProduto = controleDeProdutoPage.obterTituloDaModalDeCadastroDeProduto();
        assertEquals(Constants.DESCRICAO_MODAL_TITTLE_PRODUTO, mensagemModalTittleProduto);

        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleDeProdutoPage);

        produtoBuilder.builder();
        controleDeProdutoPage.clicarNoBotaoSair();
    }

}
