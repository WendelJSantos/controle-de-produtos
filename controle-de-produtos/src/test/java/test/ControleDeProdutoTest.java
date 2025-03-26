package test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import page.ControleDeProdutoPO;
import page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends BaseTest {

    private static ControleDeProdutoPO controleDeProdutoPage;
    private static LoginPO loginPage;
    private static String TITULO_PAGINA_CONTROLE_DE_PRODUTOS = "Controle de Produtos";
    private static String MODAL_TITTLE_PRODUTO = "Produto";
    
    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        controleDeProdutoPage = new ControleDeProdutoPO(driver);

        String tituloDaPagina = loginPage.obterTituloDaPagina();
        assertEquals(TITULO_PAGINA_CONTROLE_DE_PRODUTOS, tituloDaPagina); 
    }

    @Test
    public void TC001_deveCadastrarProduto(){
        controleDeProdutoPage.clicarNoBotaoCriar();
        //  TODO: Remover esse clique duplo assim que o sistema for corrigido.
        controleDeProdutoPage.clicarNoBotaoCriar();
        String mensagemModalTittleProduto = controleDeProdutoPage.obterMensagemModalTittleProduto();
        assertEquals(MODAL_TITTLE_PRODUTO, mensagemModalTittleProduto);

        controleDeProdutoPage.cadastrarNovoProduto("1", "Refrigerante", "15", "7,99", "25/03/2025");
        controleDeProdutoPage.clicarNoBotaoSair();
        
    }

    @Test
    public void TC001_deveAbrirModalParaCadastroAoClicarEmCriar(){
        controleDeProdutoPage.clicarNoBotaoCriar();
        //  TODO: Remover esse clique duplo assim que o sistema for corrigido.
        controleDeProdutoPage.clicarNoBotaoCriar();

    }
}
