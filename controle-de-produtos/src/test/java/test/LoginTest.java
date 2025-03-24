package test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {
    
    private static LoginPO loginPage;
    private static String MENSAGEM_CAMPOS_EM_BRANCO = "Informe usuário e senha, os campos não podem ser brancos.";
    private static String MENSAGEM_CAMPOS_INVALIDOS = "E-mail ou senha inválidos";
    private static String TITULO_PAGINA_CONTROLE_DE_PRODUTOS = "Controle de Produtos";

    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TC001_naoDeveLogarNoSistemaComOsCamposEmailESenhaVazios(){
        loginPage.executarAcaoDeLogar("", "");
        String mensagemExcecao = loginPage.obterMensagemExcecao();
        assertEquals(MENSAGEM_CAMPOS_EM_BRANCO, mensagemExcecao);
    }
    
    @Test
    public void TC002_naoDeveLogarNoSistemaComOCampoSenhaVazio(){
        loginPage.executarAcaoDeLogar("admin@admin.com", "");
        String mensagemExcecao = loginPage.obterMensagemExcecao();
        assertEquals(MENSAGEM_CAMPOS_EM_BRANCO, mensagemExcecao);
    }

    @Test
    public void TC003_naoDeveLogarNoSistemaComOCampoEmailVazio(){
        loginPage.executarAcaoDeLogar("", "admin@123");
        String mensagemExcecao = loginPage.obterMensagemExcecao();
        assertEquals(MENSAGEM_CAMPOS_EM_BRANCO, mensagemExcecao);
    }

    @Test
    public void TC004_naoDeveLogarNoSistemaComOsCamposEmailESenhaInvalidos(){
        loginPage.executarAcaoDeLogar("teste", "teste");
        String mensagemExcecao = loginPage.obterMensagemExcecao();
        assertEquals(MENSAGEM_CAMPOS_INVALIDOS, mensagemExcecao);
    }

    @Test
    public void TC005_naoDeveLogarNoSistemaComOCampoEmailInvalido(){
        loginPage.executarAcaoDeLogar("teste", "admin@123");
        String mensagemExcecao = loginPage.obterMensagemExcecao();
        assertEquals(MENSAGEM_CAMPOS_INVALIDOS, mensagemExcecao);
    }

    @Test
    public void TC006_naoDeveLogarNoSistemaComOCampoSenhaInvalido(){
        loginPage.executarAcaoDeLogar("admin@admin.com", "teste");
        String mensagemExcecao = loginPage.obterMensagemExcecao();
        assertEquals(MENSAGEM_CAMPOS_INVALIDOS, mensagemExcecao);
    }

    @Test
    public void TC007_deveLogarNoSistemaComOsCamposEmailESenhaCorretos(){
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        String tituloDaPagina = loginPage.obterTituloDaPagina();
        assertEquals(TITULO_PAGINA_CONTROLE_DE_PRODUTOS, tituloDaPagina); 
    }
}
