package br.com.produto.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.produto.page.ControleDeProdutoPO;
import br.com.produto.page.LoginPO;

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
    public void TC001_deveAbrirModalParaCadastroAoClicarEmCriar(){
        controleDeProdutoPage.clicarNoBotaoCriar();
        //  TODO: Remover esse clique duplo assim que o sistema for corrigido.
        controleDeProdutoPage.clicarNoBotaoCriar();
        String mensagemModalTittleProduto = controleDeProdutoPage.obterMensagemModalTittleProduto();
        assertEquals(MODAL_TITTLE_PRODUTO, mensagemModalTittleProduto);
    }
}
