package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.asserts.SoftAssert;

import builder.ProdutoBuilder;
import config.Constants;
import utils.Utils;
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

        ProdutoBuilder.criar(controleDeProdutoPage).adicionarCodigo("").builder();

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

        ProdutoBuilder.criar(controleDeProdutoPage).adicionarNome("").builder();

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

        ProdutoBuilder.criar(controleDeProdutoPage).adicionarQuantidade("").builder();

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

        ProdutoBuilder.criar(controleDeProdutoPage).adicionarValor("").builder();

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

        ProdutoBuilder.criar(controleDeProdutoPage).adicionarData("").builder();

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

    // Teste falhando, correção pendente.
    @Test
    public void TC007_deveRetornarParaATelaDeLoginAoClicarNoLinkVoltar() {
        controleDeProdutoPage.clicarNoLinkVoltar();
        assertEquals(Constants.TITULO_PAGINA_LOGIN, loginPage.obterTituloDaPagina());
    }

    @Test
    public void TC008_deveRetornarOsUltimosProdutosCadastrados() {
        controleDeProdutoPage.clicarNoBotaoCriar();
        controleDeProdutoPage.clicarNoBotaoCriar();

        ProdutoBuilder.criar(controleDeProdutoPage).builder();

        ProdutoBuilder.criar(controleDeProdutoPage)
                .adicionarCodigo("2")
                .adicionarNome("nome 2")
                .adicionarQuantidade("2")
                .adicionarValor("2")
                .builder();

        ProdutoBuilder.criar(controleDeProdutoPage)
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

    // Teste falhando, correção pendente.
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

    // Teste falhando, correção pendente.
    @Test
    public void TC010_deveFecharATelaDeCadastroDeProdutoAoClicarNoX() {

        controleDeProdutoPage.clicarNoBotaoCriar();
        controleDeProdutoPage.clicarNoBotaoCriar();

        controleDeProdutoPage.clicarNoBotaoX();

        assertTrue(controleDeProdutoPage.buttonCriar.isDisplayed());
    }

    // Teste falhando, correção pendente.
    @Test
    public void TC011_deveSairDaTelaDeCadastroDeProdutoAoClicarNoBotaoSair() {

        controleDeProdutoPage.clicarNoBotaoCriar();
        controleDeProdutoPage.clicarNoBotaoCriar();

        controleDeProdutoPage.clicarNoBotaoSair();
        // O botão sair está funcionando apenas com 2 acionamentos.
        assertFalse(controleDeProdutoPage.modalTittleProduto.isDisplayed(),
                "A modal de produto permaneceu aberta. Verificar falha ao clicar no botão Sair");
    }

    // Teste falhando, correção pendente.
    @Test
    public void TC012_deveFecharADivAlertAoClicarNoX() {

        controleDeProdutoPage.clicarNoBotaoCriar();
        controleDeProdutoPage.clicarNoBotaoCriar();

        ProdutoBuilder.criar(controleDeProdutoPage)
                .adicionarCodigo("")
                .adicionarNome("")
                .builder();

        controleDeProdutoPage.clicarNoBotaoXDivAlert();

        // O botão X não está funcionando corretamente, não executa nenhuma ação ao ser
        // clicado.
        assertFalse(controleDeProdutoPage.buttonXDivAlert.isDisplayed(),
                "A Div Alert permaneceu aberta. Verificar falha ao clicar no X");
    }

    /*
     * Metodo de teste responsável por validar que o sistema permite cadastrar
     * produto com todos os campos preenchidos corretamente
     */
    @Test
    public void TC013_deveCadastrarNovoProdutoComSucesso() {
        controleDeProdutoPage.clicarNoBotaoCriar();
        // TODO: Remover esse clique duplo assim que o sistema for corrigido.
        controleDeProdutoPage.clicarNoBotaoCriar();

        String mensagemModalTittleProduto = controleDeProdutoPage.obterTituloDaModalDeCadastroDeProduto();
        assertEquals(Constants.DESCRICAO_MODAL_TITTLE_PRODUTO, mensagemModalTittleProduto);

        ProdutoBuilder.criar(controleDeProdutoPage).builder();

        Map<String, List<String>> produtosCadastrados = controleDeProdutoPage.extrairDadosTabela();

        // Melhorar asserção posteriormente para identificar exatamente qual asserção
        // falhou e por qual motivo
        softAssert.assertTrue(produtosCadastrados.get("codigo").contains(Constants.CODIGO_PRODUTO_PADRAO));
        softAssert.assertTrue(produtosCadastrados.get("nome").contains(Constants.NOME_PRODUTO_PADRAO));
        softAssert.assertTrue(produtosCadastrados.get("quantidade").contains(Constants.QUANTIDADE_PRODUTO_PADRAO));
        softAssert.assertTrue(produtosCadastrados.get("valor").contains(Constants.VALOR_PRODUTO_PADRAO));
        softAssert.assertTrue(
                produtosCadastrados.get("data").contains(Utils.converterParaFormatoIso(Constants.DATA_PRODUTO_PADRAO)));
        softAssert.assertAll();
    }

}
