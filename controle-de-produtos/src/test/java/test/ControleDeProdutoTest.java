package test;

import static org.junit.Assert.assertEquals;
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

        String mensagemModalTittleProduto = controleDeProdutoPage.obterMensagemModalTittleProduto();
        assertEquals(Constants.DESCRICAO_MODAL_TITTLE_PRODUTO, mensagemModalTittleProduto);

        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleDeProdutoPage);
        produtoBuilder
                .adicionarCodigo("")
                .builder();

        assertEquals(Constants.MENSAGEM_CAMPOS_OBRIGATORIOS, controleDeProdutoPage.obterSpanMensagem());
        controleDeProdutoPage.clicarNoBotaoSair();

    }

    /*
     * Metodo de teste responsável por validar que o sistema permite cadastrar
     * produto com todos os campos preenchidos corretamente
     */
    @Test
    public void TC002_deveCadastrarNovoProdutoPadrão() {
        controleDeProdutoPage.clicarNoBotaoCriar();
        // TODO: Remover esse clique duplo assim que o sistema for corrigido.
        controleDeProdutoPage.clicarNoBotaoCriar();

        String mensagemModalTittleProduto = controleDeProdutoPage.obterMensagemModalTittleProduto();
        assertEquals(Constants.DESCRICAO_MODAL_TITTLE_PRODUTO, mensagemModalTittleProduto);

        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleDeProdutoPage);

        produtoBuilder.builder();
        controleDeProdutoPage.clicarNoBotaoSair();
    }

}
