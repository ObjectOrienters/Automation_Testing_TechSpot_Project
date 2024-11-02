package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class CrossBrowserBaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public void setUp(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().browserVersion("latest").setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                if (System.getProperty("os.name").contains("Mac")) {
                    driver = new SafariDriver();
                } else {
                    throw new IllegalArgumentException("Safari is only supported on macOS.");
                }
                break;
            default:
                throw new IllegalArgumentException("Browser " + browser + " is not supported.");
        }

        driver.manage().window().maximize();
        driver.get("http://localhost:3000/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
