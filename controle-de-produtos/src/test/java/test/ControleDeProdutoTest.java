package test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import builder.ProdutoBuilder;
import page.ControleDeProdutoPO;
import page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends BaseTest {

    private static ControleDeProdutoPO controleDeProdutoPage;
    private static LoginPO loginPage;
    private static String TITULO_PAGINA_CONTROLE_DE_PRODUTOS = "Controle de Produtos";
    private static String MODAL_TITTLE_PRODUTO = "Produto";
    private String mensagem = "Todos os campos são obrigatórios para o cadastro!";
    
    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        controleDeProdutoPage = new ControleDeProdutoPO(driver);
        String tituloDaPagina = loginPage.obterTituloDaPagina();
        assertEquals(TITULO_PAGINA_CONTROLE_DE_PRODUTOS, tituloDaPagina); 
    }

    @Test
    public void TC001_naoDeveCadastrarProdutoComOCampoCodigoEmBranco(){
        controleDeProdutoPage.clicarNoBotaoCriar();
        //  TODO: Remover esse clique duplo assim que o sistema for corrigido.
        controleDeProdutoPage.clicarNoBotaoCriar();

         String mensagemModalTittleProduto = controleDeProdutoPage.obterMensagemModalTittleProduto();
        assertEquals(MODAL_TITTLE_PRODUTO, mensagemModalTittleProduto);

        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleDeProdutoPage);
        produtoBuilder
        .adicionarCodigo("")
        .builder();

        assertEquals(mensagem, controleDeProdutoPage.obterSpanMensagem());
        controleDeProdutoPage.clicarNoBotaoSair();
        
    }

    @Test
    public void TC002_deveCadastrarNovoProdutoPadrão(){
        controleDeProdutoPage.clicarNoBotaoCriar();
        //  TODO: Remover esse clique duplo assim que o sistema for corrigido.
        controleDeProdutoPage.clicarNoBotaoCriar();

        String mensagemModalTittleProduto = controleDeProdutoPage.obterMensagemModalTittleProduto();
        assertEquals(MODAL_TITTLE_PRODUTO, mensagemModalTittleProduto);

        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleDeProdutoPage);

        produtoBuilder.builder();
        controleDeProdutoPage.clicarNoBotaoSair();
    }

}
