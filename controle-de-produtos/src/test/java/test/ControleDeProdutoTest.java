package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.testng.asserts.SoftAssert;

import builder.ProdutoBuilder;
import config.Constants;
import page.ControleDeProdutoPO;
import page.LoginPO;
import utils.ScreenshotUtils;
import utils.Utils;

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
    public void setUp(TestInfo testInfo) {
        String nomeTest = testInfo.getTestMethod().get().getName();
        super.iniciar(); // Garante que o driver seja inicializado antes de usar
        
        loginPage = new LoginPO(driver); // Inicializa loginPage
        controleDeProdutoPage = new ControleDeProdutoPO(driver); // Inicializa controleDeProdutoPage
        loginPage.executarAcaoDeLogar(Constants.EMAIL_VALIDO, Constants.SENHA_VALIDA, nomeTest);
        // Valida que o sistema está na página do Controle de Produtos
        assertEquals(Constants.TITULO_PAGINA_CONTROLE_DE_PRODUTOS, loginPage.obterTituloDaPagina());
    }

    // Metodo de teste responsável por validar que o sistema não permite cadastrar
    // produto com o campo Código em branco
    @Test
    public void TC001_naoDeveCadastrarProdutoComOCampoCodigoEmBranco() {
        // TODO: Remover esse clique duplo assim que o sistema for corrigido.
        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonCriar);
        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonCriar);

        softAssert.assertEquals(controleDeProdutoPage.obterTituloDaModalDeCadastroDeProduto(), Constants.DESCRICAO_MODAL_TITTLE_PRODUTO);

        ProdutoBuilder.criar(controleDeProdutoPage).adicionarCodigo("").builder();
        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));

        softAssert.assertEquals(controleDeProdutoPage.inputCodigo.getText(), Constants.MENSAGEM_VAZIA);
        softAssert.assertEquals(controleDeProdutoPage.obterSpanMensagem(), Constants.MENSAGEM_CAMPOS_OBRIGATORIOS);
        softAssert.assertAll();
    }

    /*
     * Metodo de teste responsável por validar que o sistema não permite cadastrar
     * produto com o campo Nome em branco
     */
    @Test
    public void TC002_naoDeveCadastrarProdutoComOCampoNomeEmBranco() {
        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonCriar);
        // TODO: Remover esse clique duplo assim que o sistema for corrigido.
        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonCriar);

        softAssert.assertEquals(controleDeProdutoPage.obterTituloDaModalDeCadastroDeProduto(), Constants.DESCRICAO_MODAL_TITTLE_PRODUTO);

        ProdutoBuilder.criar(controleDeProdutoPage).adicionarNome("").builder();
        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));

        softAssert.assertEquals(controleDeProdutoPage.inputNome.getText(), Constants.MENSAGEM_VAZIA);
        softAssert.assertEquals(controleDeProdutoPage.obterSpanMensagem(), Constants.MENSAGEM_CAMPOS_OBRIGATORIOS);
        softAssert.assertAll();
    }

    /*
     * Metodo de teste responsável por validar que o sistema não permite cadastrar
     * produto com o campo Quantidade em branco
     */
    @Test
    public void TC003_naoDeveCadastrarProdutoComOCampoQuantidadeEmBranco() {
        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonCriar);
        // TODO: Remover esse clique duplo assim que o sistema for corrigido.
        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonCriar);

        softAssert.assertEquals(controleDeProdutoPage.obterTituloDaModalDeCadastroDeProduto(), Constants.DESCRICAO_MODAL_TITTLE_PRODUTO);

        ProdutoBuilder.criar(controleDeProdutoPage).adicionarQuantidade("").builder();

        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));

        softAssert.assertEquals(controleDeProdutoPage.inputQuantidade.getText(), Constants.MENSAGEM_VAZIA);
        softAssert.assertEquals(controleDeProdutoPage.obterSpanMensagem(), Constants.MENSAGEM_CAMPOS_OBRIGATORIOS);
        softAssert.assertAll();
    }

    /*
     * Metodo de teste responsável por validar que o sistema não permite cadastrar
     * produto com o campo Valor em branco
     */
    @Test
    public void TC004_naoDeveCadastrarProdutoComOCampoValorEmBranco() {
        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonCriar);
        // TODO: Remover esse clique duplo assim que o sistema for corrigido.
        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonCriar);

        softAssert.assertEquals(controleDeProdutoPage.obterTituloDaModalDeCadastroDeProduto(), Constants.DESCRICAO_MODAL_TITTLE_PRODUTO);

        ProdutoBuilder.criar(controleDeProdutoPage).adicionarValor("").builder();

        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));

        softAssert.assertEquals(controleDeProdutoPage.inputValor.getText(), Constants.MENSAGEM_VAZIA);
        softAssert.assertEquals(controleDeProdutoPage.obterSpanMensagem(), Constants.MENSAGEM_CAMPOS_OBRIGATORIOS);
        softAssert.assertAll();
    }

    /*
     * Metodo de teste responsável por validar que o sistema não permite cadastrar
     * produto com o campo Data em branco
     */
    @Test
    public void TC005_naoDeveCadastrarProdutoComOCampoDataEmBranco() {
        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonCriar);
        // TODO: Remover esse clique duplo assim que o sistema for corrigido.
        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonCriar);

        softAssert.assertEquals(controleDeProdutoPage.obterTituloDaModalDeCadastroDeProduto(), Constants.DESCRICAO_MODAL_TITTLE_PRODUTO);

        ProdutoBuilder.criar(controleDeProdutoPage).adicionarData("").builder();

        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));

        softAssert.assertEquals(controleDeProdutoPage.inputData.getText(), Constants.MENSAGEM_VAZIA);
        softAssert.assertEquals(controleDeProdutoPage.obterSpanMensagem(), Constants.MENSAGEM_CAMPOS_OBRIGATORIOS);
        softAssert.assertAll();
    }

    /*
     * Metodo de teste responsável por validar que o sistema permanece na mesma tela
     * ao clicar no link Controle de produtos
     */
    @Test
    public void TC006_devePermanecerNaMesmaPaginaAoClicarNoLinkControleDeProdutos() {
        controleDeProdutoPage.clicar(controleDeProdutoPage.linkControleDeProdutos);

        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));

        /*
         * Validando que sistema permaneceu na tela Controle de produtos através da
         * exibição do botão Criar presente na tela
         */
        assertTrue(controleDeProdutoPage.buttonCriar.isDisplayed());
    }

    // Teste falhando, correção pendente.
    @Test
    public void TC007_deveRetornarParaATelaDeLoginAoClicarNoLinkVoltar() {
        controleDeProdutoPage.clicar(controleDeProdutoPage.linkVoltar);
        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));
        assertEquals(Constants.TITULO_PAGINA_LOGIN, loginPage.obterTituloDaPagina());
    }

    @Test
    public void TC008_deveRetornarOsUltimosProdutosCadastrados() {
        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonCriar);
        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonCriar);

        ProdutoBuilder.criar(controleDeProdutoPage).builder();
        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));

        ProdutoBuilder.criar(controleDeProdutoPage)
                .adicionarCodigo("2")
                .adicionarNome("nome 2")
                .adicionarQuantidade("2")
                .adicionarValor("2")
                .builder();
        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));

        ProdutoBuilder.criar(controleDeProdutoPage)
                .adicionarCodigo("3")
                .adicionarNome("nome 3")
                .adicionarQuantidade("3")
                .adicionarValor("3")
                .builder();
        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));        

        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonSair);
        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));

        Map<String, List<String>> produtosCadastrados = controleDeProdutoPage.extrairDadosTabela();

        // Melhorar asserção posteriormente para identificar exatamente qual asserção
        // falhou e por qual motivo
        softAssert.assertTrue(produtosCadastrados.get("valor").contains("50.0"));
        softAssert.assertTrue(produtosCadastrados.get("valor").contains("2"));
        softAssert.assertTrue(produtosCadastrados.get("valor").contains("3"));
        softAssert.assertAll();

    }

    // Teste falhando, correção pendente.
    @Test
    public void TC009_deveRetornarOsNomesDasColunasDaTabelaPadronizadosEEmPortugues() {

        Map<String, String> nomeColuna = controleDeProdutoPage.extrairNomeDasColunasDaTabela();

        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));

        softAssert.assertEquals(nomeColuna.get("codigo"), Constants.NOME_COLUNA_CODIGO);
        softAssert.assertEquals(nomeColuna.get("nome"), Constants.NOME_COLUNA_NOME);
        softAssert.assertEquals(nomeColuna.get("quantidade"), Constants.NOME_COLUNA_QUANTIDADE);
        softAssert.assertEquals(nomeColuna.get("valor"), Constants.NOME_COLUNA_VALOR);
        softAssert.assertEquals(nomeColuna.get("data"), Constants.NOME_COLUNA_DATA_DE_CRIACAO);
        softAssert.assertEquals(nomeColuna.get("acao"), Constants.NOME_COLUNA_ACAO);

        softAssert.assertAll();

    }

    // Teste falhando, correção pendente.
    @Test
    public void TC010_deveFecharATelaDeCadastroDeProdutoAoClicarNoX() {

        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonCriar);
        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonCriar);        
        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));

        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonX);
        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));

        assertTrue(controleDeProdutoPage.buttonCriar.isDisplayed());
    }

    // Teste falhando, correção pendente.
    @Test
    public void TC011_deveSairDaTelaDeCadastroDeProdutoAoClicarNoBotaoSair() {

        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonCriar);
        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonCriar);
        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));

        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonSair);
        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));

        // O botão sair está funcionando apenas com 2 acionamentos.
        assertFalse(controleDeProdutoPage.modalTittleProduto.isDisplayed(), "A modal de produto permaneceu aberta. Verificar falha ao clicar no botão Sair");
    }

    // Teste falhando, correção pendente.
    @Test
    public void TC012_deveFecharADivAlertAoClicarNoX() {

        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonCriar);
        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonCriar);

        ProdutoBuilder.criar(controleDeProdutoPage)
                .adicionarCodigo("")
                .adicionarNome("")
                .builder();
        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));

        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonXDivAlert);
        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));

        // O botão X não está funcionando corretamente, não executa nenhuma ação ao ser
        // clicado.
        assertFalse(controleDeProdutoPage.buttonXDivAlert.isDisplayed(), "A Div Alert permaneceu aberta. Verificar falha ao clicar no X");
    }

    /*
     * Metodo de teste responsável por validar que o sistema permite cadastrar
     * produto com todos os campos preenchidos corretamente
     */
    @Test
    public void TC013_deveCadastrarNovoProdutoComSucesso() {
        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonCriar);
        // TODO: Remover esse clique duplo assim que o sistema for corrigido.
        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonCriar);

        softAssert.assertEquals(controleDeProdutoPage.obterTituloDaModalDeCadastroDeProduto(), Constants.DESCRICAO_MODAL_TITTLE_PRODUTO);

        ProdutoBuilder.criar(controleDeProdutoPage).builder();

        controleDeProdutoPage.clicar(controleDeProdutoPage.buttonSair);
        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));

        Map<String, List<String>> produtosCadastrados = controleDeProdutoPage.extrairDadosTabela();

        // Melhorar asserção posteriormente para identificar exatamente qual asserção
        // falhou e por qual motivo
        softAssert.assertTrue(produtosCadastrados.get("codigo").contains(Constants.CODIGO_PRODUTO_PADRAO));
        softAssert.assertTrue(produtosCadastrados.get("nome").contains(Constants.NOME_PRODUTO_PADRAO));
        softAssert.assertTrue(produtosCadastrados.get("quantidade").contains(Constants.QUANTIDADE_PRODUTO_PADRAO));
        softAssert.assertTrue(produtosCadastrados.get("valor").contains(Constants.VALOR_PRODUTO_PADRAO));
        softAssert.assertTrue(produtosCadastrados.get("data").contains(Utils.converterParaFormatoIso(Constants.DATA_PRODUTO_PADRAO)));
        softAssert.assertAll();
    }

}
