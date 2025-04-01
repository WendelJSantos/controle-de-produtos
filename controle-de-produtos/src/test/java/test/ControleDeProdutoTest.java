package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import builder.ProdutoBuilder;
import page.ControleDeProdutoPO;
import page.LoginPO;
import config.Constants;

/**
 * Classe responsável pelos testes da tela de consulta e cadastro de produtos
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends BaseTest {

    private static ControleDeProdutoPO controleDeProdutoPage;
    private static LoginPO loginPage;

    /*
     * Metodo que prepara os sistema para acessar a tela de consulta e cadastro de
     * produtos
     */
    @BeforeClass
    public static void prepararTestes() {
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar(Constants.EMAIL_VALIDO, Constants.SENHA_VALIDA);
        controleDeProdutoPage = new ControleDeProdutoPO(driver);
        String tituloDaPagina = loginPage.obterTituloDaPagina();
        assertEquals(Constants.TITULO_PAGINA_CONTROLE_DE_PRODUTOS, tituloDaPagina);
    }

    /*
     * Metodo de teste responsável por validar que o sistema não permite cadastrar
     * produto com o campo Código em branco
     */
    @Test
    public void TC001_naoDeveCadastrarProdutoComOCampoCodigoEmBranco() {
        controleDeProdutoPage.clicarNoBotaoCriar();
        // TODO: Remover esse clique duplo assim que o sistema for corrigido.
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
     * Caso de teste falhando. O link voltar não está retornando para a tela de login.
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
        .adicionarNome("2nome")
        .adicionarQuantidade("2qtde")
        .adicionarValor("2valor")
        .builder();

        produtoBuilder
        .adicionarCodigo("3")
        .adicionarNome("3nome")
        .adicionarQuantidade("3qtde")
        .adicionarValor("3valor")
        .builder();

        controleDeProdutoPage.clicarNoBotaoSair();

        Map<String, List<String>> produtosCadastrados = controleDeProdutoPage.extrairDadosTabela();
        
        assertTrue(produtosCadastrados.get("valores").contains("2valor"));

     
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
