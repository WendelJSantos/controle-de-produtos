package test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import config.Constants;
import page.LoginPO;

/**
 * Classe responsável pelos testes da tela de login do sistema
 */
public class LoginTest extends BaseTest {

    private LoginPO loginPage;

    @BeforeEach
    public void setUp() {
        super.iniciar(); // Garante que o driver seja inicializado antes de usar
        loginPage = new LoginPO(driver); // Inicializa loginPage
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
