package test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import page.LoginPO;
import config.Constants;

/**
 * Classe responsável pelos testes da tela de login do sistema
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {

    private static LoginPO loginPage;

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
        assertEquals(Constants.MENSAGEM_CAMPOS_EM_BRANCO, loginPage.obterMensagemExcecao());
    }

    /*
     * Metodo de teste responsável por validar que o sistema não permite efetuar o
     * login com o campo Senha vazio
     */
    @Test
    public void TC002_naoDeveLogarNoSistemaComOCampoSenhaVazio() {
        loginPage.executarAcaoDeLogar(Constants.EMAIL_VALIDO, "");
        assertEquals(Constants.MENSAGEM_CAMPOS_EM_BRANCO, loginPage.obterMensagemExcecao());
    }

    /*
     * Metodo de teste responsável por validar que o sistema não permite efetuar o
     * login com o campo Email vazio
     */
    @Test
    public void TC003_naoDeveLogarNoSistemaComOCampoEmailVazio() {
        loginPage.executarAcaoDeLogar("", Constants.SENHA_VALIDA);
        assertEquals(Constants.MENSAGEM_CAMPOS_EM_BRANCO, loginPage.obterMensagemExcecao());
    }

    /*
     * Metodo de teste responsável por validar que o sistema não permite efetuar o
     * login com os campos Email e Senha inválidos
     */
    @Test
    public void TC004_naoDeveLogarNoSistemaComOsCamposEmailESenhaInvalidos() {
        loginPage.executarAcaoDeLogar("teste", "teste");
        assertEquals(Constants.MENSAGEM_CAMPOS_INVALIDOS, loginPage.obterMensagemExcecao());
    }

    /*
     * Metodo de teste responsável por validar que o sistema não permite efetuar o
     * login com o campo Email inválido
     */
    @Test
    public void TC005_naoDeveLogarNoSistemaComOCampoEmailInvalido() {
        loginPage.executarAcaoDeLogar("teste", Constants.SENHA_VALIDA);
        assertEquals(Constants.MENSAGEM_CAMPOS_INVALIDOS, loginPage.obterMensagemExcecao());
    }

    /*
     * Metodo de teste responsável por validar que o sistema não permite efetuar o
     * login com o campo Senha inválido
     */
    @Test
    public void TC006_naoDeveLogarNoSistemaComOCampoSenhaInvalido() {
        loginPage.executarAcaoDeLogar(Constants.EMAIL_VALIDO, "teste");
        assertEquals(Constants.MENSAGEM_CAMPOS_INVALIDOS, loginPage.obterMensagemExcecao());
    }

    /*
     * Metodo de teste responsável por validar que o sistema permite efetuar o
     * login com os campos preenchidos corretamente
     */
    @Test
    public void TC007_deveLogarNoSistemaComOsCamposEmailESenhaCorretos() {
        loginPage.executarAcaoDeLogar(Constants.EMAIL_VALIDO, Constants.SENHA_VALIDA);
        assertEquals(Constants.TITULO_PAGINA_CONTROLE_DE_PRODUTOS, loginPage.obterTituloDaPagina());
    }
}
