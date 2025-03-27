package test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Classe base que serve de gerença para todas as classes de teste
 */
public class BaseTest {    

    /* Driver do navegador da página atual */
    protected static WebDriver driver;

    /* Caminho base da URL do sistema a ser testado. Host e Porta definido pela extensão do Live Server */
    private static final String URB_BASE = "http://127.0.0.1:5500/controle-de-produtos/src/test/java/resource/projeto/sistema/login.html";

    /* Caminho relativo do driver ao prjeto referente ao path */
    private static final String CAMINHO_DRIVER = "src/test/java/resource/chromedriver.exe";

    /* 
     * Metodo para inicializar o driver do navegador antes de qualquer classe de teste
     */
    @BeforeClass
    public static void iniciar(){
        System.setProperty(("webdriver.chrome.driver"), CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URB_BASE);
    }
    
    /* 
     * Metodo para finalizar o driver do navegador antes de qualquer classe de teste
     */
    @AfterClass
    public static void finalizar(){
        driver.quit();
    }

}
