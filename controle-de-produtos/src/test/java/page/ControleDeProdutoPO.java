package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ControleDeProdutoPO extends BasePO {

    @FindBy(css = "ul>li>a.nav-link")
    public WebElement linkVoltar;

    public void clicarNoLinkVoltar() {
         linkVoltar.click();
    }

    @FindBy(css = "div>h4.modal-title")
    public WebElement modalTittleProduto;

    public String obterMensagemModalTittleProduto() {
       return modalTittleProduto.getText();
    }    
    
    @FindBy(id = "btn-adicionar")
    public WebElement buttonCriar;
    
    public void clicarNoBotaoCriar(){
        buttonCriar.click();
    }

    public ControleDeProdutoPO(WebDriver driver) {
        super(driver);
    }

}
