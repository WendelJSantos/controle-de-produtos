package test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import config.Constants;

/** Classe base que serve de gerença para todas as classes de teste */
public class BaseTest {

    /* Driver do navegador da página atual */
    protected static WebDriver driver;

    /*
     * Metodo para inicializar o driver do navegador antes de qualquer classe de
     * teste
     */
    @BeforeClass
    public static void iniciar() {
        System.setProperty(("webdriver.chrome.driver"), Constants.CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Constants.URB_BASE);
    }

    /*
     * Metodo para finalizar o driver do navegador antes de qualquer classe de teste
     */
    @AfterClass
    public static void finalizar() {
        driver.quit();
    }

}
