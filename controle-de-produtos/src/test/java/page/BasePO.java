package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para criação das novas Pages Objects.
 * Todas as pages devem ser herdadas dessa classe
 */
public abstract class BasePO {

    /* Driver base que será usadao pelas pages */
    protected static WebDriver driver;

    /**
     * Construtor base para criação da fabrica de elementos (PageFactory).
     * @param driver Driver da página atual
     */
    public BasePO (WebDriver driver){
        BasePO.driver = driver;
        PageFactory.initElements(driver, this);    
    }
    
    /**
     * Método que retorna o título da página atual
     * @return retorna o título da página
     */
    public String obterTituloDaPagina(){
        return driver.getTitle();
    }
    
    /**
     * Método que sabe escrever em qualquer WebElement do tipo input
     * @param input Input a qual será escrito
     * @param texto Texto que será escrito no input
     */
    public void escrever(WebElement input, String texto){
        input.clear();
        input.sendKeys(texto);
    }

}
