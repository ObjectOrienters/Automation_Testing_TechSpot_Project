package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public static Properties config = new Properties();

    @BeforeAll
    public static void loadConfig() throws IOException {
        FileReader fr = new FileReader(System.getProperty("user.dir") + "/src/main/resources/config.properties");
        config.load(fr);
        fr.close();
    }

    @BeforeEach
    public void setUp() {
        switch (config.getProperty("browser").toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser " + config.getProperty("browser") + " is not supported.");
        }

        driver.manage().window().maximize();
        driver.get(config.getProperty("url"));

        // Initialize WebDriverWait with the driver for each test
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Increase timeout as needed
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Helper methods for waiting conditions
    public boolean waitUrl(String url) {
        return wait.until(ExpectedConditions.urlContains(url));
    }

    public WebElement waitVisibilityOfElementLocated(By element) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
