package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.sql.SQLOutput;
import java.time.Duration;

public class DriverManager extends Utils {

    LoadPage loadPage = new LoadPage();

    String browserName = "Chrome";

    public void openBrowser() {

        if (browserName.equalsIgnoreCase("Chrome")) {

            System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
            // Chrome browser
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/java/drivers/geckodriver.exe");
            driver = new FirefoxDriver(); // firefox browser

        } else if (browserName.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", "src/test/java/drivers/msedgedriver.exe");
            driver = new EdgeDriver(); // edge browser

        } else {

            System.out.println("Either your browser name is wrong or not provided " + browserName);
        }


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(loadPage.getProperty("url"));
    }

    public void closeBrowser() {
        driver.quit();
    }


}
