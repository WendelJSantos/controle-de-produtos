package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para criação das novas Pages Objetcts.
 * Todas as pages devem ser herdadas dessa classe
 */

public abstract class BasePO {

    /** Driver base que será usadao pelas pages */
    protected WebDriver driver;

    /**
     * Construtor base para criação da fabrica de elementos (PageFactory).
     * @param driver Driver da página atual
     */
    public BasePO (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);    
    }
    
    public String obterTituloDaPagina(){
        return driver.getTitle();
    }

}
