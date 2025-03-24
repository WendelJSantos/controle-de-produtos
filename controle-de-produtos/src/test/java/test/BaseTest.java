package test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {    

    protected static WebDriver driver;
    private static final String URB_BASE = "http://127.0.0.1:5500/controle-de-produtos/src/test/java/resource/projeto/sistema/login.html";
    private static final String CAMINHO_DRIVER = "src/test/java/resource/chromedriver.exe";

    @BeforeClass
    public static void iniciar(){
        System.setProperty(("webdriver.chrome.driver"), CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URB_BASE);
    }

    @AfterClass
    public static void finalizar(){
        driver.quit();
    }


}
