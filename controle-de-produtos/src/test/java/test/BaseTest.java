package test;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import config.Constants;
import io.qameta.allure.Allure;
import utils.TestFailureTrackerExtensionUtils;

/** Classe base que serve de gerença para todas as classes de teste */
@ExtendWith(TestFailureTrackerExtensionUtils.class)
public class BaseTest {

    /* Driver do navegador da página atual */
    protected WebDriver driver;

    /*
     * Metodo para inicializar o driver do navegador antes de qualquer classe de
     * teste
     */
    @BeforeEach
    public void iniciar() {
        if (driver == null) {
            System.setProperty(("webdriver.chrome.driver"), Constants.CAMINHO_DRIVER);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(Constants.URB_BASE);
        }
    }

    /*
     * Metodo para finalizar o driver do navegador antes de qualquer classe de teste
     */
    @AfterEach
    public void finalizar(TestInfo testInfo) {
        try {
            if (TestFailureTrackerExtensionUtils.didTestFail() && driver != null) {
                System.out.println(">>> Teste falhou - capturando screenshot");
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

                String nomeDoTeste = testInfo.getTestMethod()
                        .map(Method::getName)
                        .orElse("teste_desconhecido");

                Allure.addAttachment(
                        "Screenshot após falha: " + nomeDoTeste,
                        "image/png",
                        new ByteArrayInputStream(screenshot),
                        ".png");

            }
        } catch (Exception e) {
            System.out.println(">>> Erro ao capturar screenshot no BaseTest: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }
    }
}
