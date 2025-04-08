package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.Constants;

import java.time.Duration;

public class WaitUtils {

    private WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement esperarElementoVisivelEClicavel(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TEMPO_PADRAO_SEGUNDOS));
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void esperarElementoVisivel(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TEMPO_PADRAO_SEGUNDOS));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void esperarElementoInvisivel(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TEMPO_PADRAO_SEGUNDOS));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
}