package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import config.Constants;

public class ScreenshotUtils {

    /**
     * Captura um screenshot da tela inteira e salva com nome baseado no teste.
     *
     * @param driver      Instância atual do WebDriver
     * @param nomeDoTeste Nome identificador do teste
     */
    public static void capturarScreenshot(WebDriver driver, String nomeDoTeste) {
        try {
            // Gera timestamp para o nome do arquivo
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            // Cria pasta com data atual
            String pastaData = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Path diretorio = Path.of(Constants.CAMINHO_PASTA_SCREENSHOTS, pastaData);
            Files.createDirectories(diretorio);

            // Define o caminho final
            String nomeArquivo = nomeDoTeste + "_" + timestamp + ".png";
            File destino = diretorio.resolve(nomeArquivo).toFile();

            // Captura e salva o screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, destino);

            System.out.println("Screenshot salvo em: " + destino.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("Erro ao salvar screenshot: " + e.getMessage());
        }
    }

}
