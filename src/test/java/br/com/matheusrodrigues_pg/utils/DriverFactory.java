package br.com.matheusrodrigues_pg.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // ✨ Ativa o modo headless moderno do Chrome
        options.addArguments("--disable-gpu");     // Desativa aceleração de hardware (bom para CI/CD)
        options.addArguments("--window-size=1920,1080"); // Define um tamanho de tela padrão para evitar quebra de layout

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }
}