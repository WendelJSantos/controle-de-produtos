package test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import page.LoginPO;

/**
 * Classe responsável pelos testes da tela de login do sistema
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {

    private static LoginPO loginPage;
    private static String MENSAGEM_CAMPOS_EM_BRANCO = "Informe usuário e senha, os campos não podem ser brancos.";
    private static String MENSAGEM_CAMPOS_INVALIDOS = "E-mail ou senha inválidos";
    private static String TITULO_PAGINA_CONTROLE_DE_PRODUTOS = "Controle de Produtos";

    /*
     * Metodo que prepara o sistema para realizar o login
     */
    @BeforeClass
    public static void prepararTestes() {
        loginPage = new LoginPO(driver);
    }

    /*
     * Metodo de teste responsável por validar que o sistema não permite efetuar o
     * login com os campos Email e Senha vazios
     */
    @Test
    public void TC001_naoDeveLogarNoSistemaComOsCamposEmailESenhaVazios() {
        loginPage.executarAcaoDeLogar("", "");
        String mensagemExcecao = loginPage.obterMensagemExcecao();
        assertEquals(MENSAGEM_CAMPOS_EM_BRANCO, mensagemExcecao);
    }

    /*
     * Metodo de teste responsável por validar que o sistema não permite efetuar o
     * login com o campo Senha vazio
     */
    @Test
    public void TC002_naoDeveLogarNoSistemaComOCampoSenhaVazio() {
        loginPage.executarAcaoDeLogar("admin@admin.com", "");
        String mensagemExcecao = loginPage.obterMensagemExcecao();
        assertEquals(MENSAGEM_CAMPOS_EM_BRANCO, mensagemExcecao);
    }

    /*
     * Metodo de teste responsável por validar que o sistema não permite efetuar o
     * login com o campo Email vazio
     */
    @Test
    public void TC003_naoDeveLogarNoSistemaComOCampoEmailVazio() {
        loginPage.executarAcaoDeLogar("", "admin@123");
        String mensagemExcecao = loginPage.obterMensagemExcecao();
        assertEquals(MENSAGEM_CAMPOS_EM_BRANCO, mensagemExcecao);
    }

    /*
     * Metodo de teste responsável por validar que o sistema não permite efetuar o
     * login com os campos Email e Senha inválidos
     */
    @Test
    public void TC004_naoDeveLogarNoSistemaComOsCamposEmailESenhaInvalidos() {
        loginPage.executarAcaoDeLogar("teste", "teste");
        String mensagemExcecao = loginPage.obterMensagemExcecao();
        assertEquals(MENSAGEM_CAMPOS_INVALIDOS, mensagemExcecao);
    }

    /*
     * Metodo de teste responsável por validar que o sistema não permite efetuar o
     * login com o campo Email inválido
     */
    @Test
    public void TC005_naoDeveLogarNoSistemaComOCampoEmailInvalido() {
        loginPage.executarAcaoDeLogar("teste", "admin@123");
        String mensagemExcecao = loginPage.obterMensagemExcecao();
        assertEquals(MENSAGEM_CAMPOS_INVALIDOS, mensagemExcecao);
    }

    /*
     * Metodo de teste responsável por validar que o sistema não permite efetuar o
     * login com o campo Senha inválido
     */
    @Test
    public void TC006_naoDeveLogarNoSistemaComOCampoSenhaInvalido() {
        loginPage.executarAcaoDeLogar("admin@admin.com", "teste");
        String mensagemExcecao = loginPage.obterMensagemExcecao();
        assertEquals(MENSAGEM_CAMPOS_INVALIDOS, mensagemExcecao);
    }

    /*
     * Metodo de teste responsável por validar que o sistema permite efetuar o
     * login com os campos preenchidos corretamente
     */
    @Test
    public void TC007_deveLogarNoSistemaComOsCamposEmailESenhaCorretos() {
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        String tituloDaPagina = loginPage.obterTituloDaPagina();
        assertEquals(TITULO_PAGINA_CONTROLE_DE_PRODUTOS, tituloDaPagina);
    }
}
