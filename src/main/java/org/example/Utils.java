package org.example;

import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class  Utils extends BasePage {

    //static reusable methods

    public static void clickElement(By by) {

        driver.findElement(by).click();
    }
    //  -------------------------------------------------------------------------------
    public static void textType(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }
    // -------------------------------------------------------------------------------------
    public static String GetTextFromElement(By by) {

        return driver.findElement(by).getText();
    }
    // -------------------------------------------------------------------------------------
    public static void DriverWaitUnitURL(int time, String url) {
        WebDriverWait wait01 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait01.until(ExpectedConditions.urlToBe(url));
    }
    //---------------------------------------------------------------------------------------
    public static @NotNull String randomDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        return formatter.format(date);
    }
    //--------------------------------------------------------------------------------------
    public static void assertEquals(String expectedMessage,By by, String errormessage){
        String expectedmessage="expectedMessage";
        String actualMessage=driver.findElement(by).getText();
        Assert.assertEquals(actualMessage,expectedMessage,"errormessage");
    }
    //----------------------------------------------------------------------------------------

        public static void takeSnapshot(String a) {

            //Convert web driver object to take screenshot
            TakesScreenshot scrShot = ((TakesScreenshot) driver);

            // call getScreenshot as method to create image file
            File scrFile = scrShot.getScreenshotAs(OutputType.FILE);

            // copy file at destination
            try {
                FileUtils.copyFile(scrFile, new File("Screenshots" + a + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
//-------------------------------------------------------------------------------------------------
    }


