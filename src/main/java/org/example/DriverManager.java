package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class DriverManager extends Utils {

    LoadProp loadPage = new LoadProp();
    DesiredCapabilities caps = new DesiredCapabilities();

    public final String USERNAME = loadPage.getProperty("bsUsername");
    public final String AUTOMATE_KEY = loadPage.getProperty("bsAccessKey");
    public final String BrowserstackURL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    boolean cloud= Boolean.parseBoolean(System.getProperty("cloud"));


    String browserName =System.getProperty("browser");

    public void openBrowser() {

        //making decision cloud true or false
        //this will be run if cloud true (In cloud)

        if (cloud) {

            System.out.println(" running in cloud");

            //applying conditional loop for different browser options
            if (browserName.equalsIgnoreCase("Chrome")) {

                caps.setCapability("browserName", "Chrome");
                caps.setCapability("browserVersion", "latest");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "10");
                caps.setCapability("bstack:options", browserstackOptions);

            } if(browserName.equalsIgnoreCase("firefox")){

                System.out.println("Your test cases are running in Firefox browser");
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Firefox");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "4.1.0");
                
            }if(browserName.equalsIgnoreCase("edge")){
                System.out.println("your test cases running in Edge browser");
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Edge");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "4.1.0");
            }
            else
            {
                System.out.println("Wrong browser name OR Connection issue with browser");
            }

            try {
                driver = new RemoteWebDriver(new URL(BrowserstackURL),caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


        }else
        {
            //this wi
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

            }


            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.manage().window().maximize();
            driver.get(loadPage.getProperty("url"));
        }


    public void closeBrowser() {
        driver.quit();
    }


}
