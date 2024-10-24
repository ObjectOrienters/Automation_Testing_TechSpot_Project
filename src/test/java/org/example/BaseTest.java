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
import java.util.Properties;

public class BaseTest {
    public static WebDriver driver;
    public static Properties config = new Properties();


    @BeforeAll
    public static void setUp() throws IOException {
        FileReader fr = new FileReader(System.getProperty("user.dir")+"/src/main/resources/config.properties");
        config.load(fr);
        fr.close();
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
    }

    @BeforeEach
    public void beforeEach() {
        if (driver == null) {
            driver = new ChromeDriver();  // Ensure driver is initialized if it was quit
        }
        driver.get("http://localhost:3000/");
    }

    @AfterEach
    public void afterEach() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver is quit");
            driver = null;  // Avoid using driver after quit
        }
    }


}
