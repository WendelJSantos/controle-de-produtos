package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import config.Constants;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import page.LoginPO;
import utils.ScreenshotUtils;
import utils.Utils;



/**
 * Classe responsável pelos testes da tela de login do sistema
 */
@Feature("Login")
public class LoginTest extends BaseTest {

    private LoginPO loginPage;

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        super.iniciar(); // Garante que o driver seja inicializado antes de usar
        loginPage = new LoginPO(driver); // Inicializa loginPage
    }

    @Test
    public void testeSimples() {
        assertTrue(true);
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Teste para validação do login com os campos Email e Senha vazios.")
    @Test
    public void TC001_naoDeveLogarNoSistemaComOsCamposEmailESenhaVazios() {
        loginPage.executarAcaoDeLogar("", "", Utils.getNomeMetodoChamada(2));
        assertEquals(Constants.MENSAGEM_CAMPOS_EM_BRANCO, loginPage.obterMensagemExcecao());
        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Teste para validação do login com o campo Senha vazio.")
    @Test
    public void TC002_naoDeveLogarNoSistemaComOCampoSenhaVazio() {
        loginPage.executarAcaoDeLogar(Constants.EMAIL_VALIDO, "", Utils.getNomeMetodoChamada(2));
        assertEquals(Constants.MENSAGEM_CAMPOS_EM_BRANCO, loginPage.obterMensagemExcecao());
        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Teste para validação do login com o campo Email vazio.")
    @Test   
    public void TC003_naoDeveLogarNoSistemaComOCampoEmailVazio() {
        loginPage.executarAcaoDeLogar("", Constants.SENHA_VALIDA, Utils.getNomeMetodoChamada(2));
        assertEquals(Constants.MENSAGEM_CAMPOS_EM_BRANCO, loginPage.obterMensagemExcecao());
        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Teste para validação do login com os campos Email e Senha inválidos.")
    @Test
    public void TC004_naoDeveLogarNoSistemaComOsCamposEmailESenhaInvalidos() {
        loginPage.executarAcaoDeLogar("teste", "teste", Utils.getNomeMetodoChamada(2));
        assertEquals(Constants.MENSAGEM_CAMPOS_INVALIDOS, loginPage.obterMensagemExcecao());
        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Teste para validação do login com o campo Email inválido.")
    @Test
    public void TC005_naoDeveLogarNoSistemaComOCampoEmailInvalido() {
        loginPage.executarAcaoDeLogar("teste", Constants.SENHA_VALIDA, Utils.getNomeMetodoChamada(2));
        assertEquals(Constants.MENSAGEM_CAMPOS_INVALIDOS, loginPage.obterMensagemExcecao());
        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Teste para validação do login com o campo Senha inválido.")
    @Test
    public void TC006_naoDeveLogarNoSistemaComOCampoSenhaInvalido() {
        loginPage.executarAcaoDeLogar(Constants.EMAIL_VALIDO, "teste", Utils.getNomeMetodoChamada(2));
        assertEquals(Constants.MENSAGEM_CAMPOS_INVALIDOS, loginPage.obterMensagemExcecao());
        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Teste para validação do login efetuado com sucesso.")
    @Test
    public void TC007_deveLogarNoSistemaComOsCamposEmailESenhaCorretos() {
        loginPage.executarAcaoDeLogar(Constants.EMAIL_VALIDO, Constants.SENHA_VALIDA, Utils.getNomeMetodoChamada(2));
        assertEquals(Constants.TITULO_PAGINA_CONTROLE_DE_PRODUTOS, loginPage.obterTituloDaPagina());
        ScreenshotUtils.capturarScreenshot(driver, Utils.getNomeMetodoChamada(2));
    }
}
