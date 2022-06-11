package org.example;

import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class Utils extends BasePage {

    //static reusable methods

    public static void clickElement(By by) {

        driver.findElement(by).click();
    }

    //  -------------------------------------------------------------------------------
    public static void textType(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }

    public static void selectByValue(By by, String value){
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByValue(value);
    }

    public static void selectByVisibleText(By by,String value){
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByVisibleText(value);

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
    public static @NotNull String randomDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        return formatter.format(date);
    }

    //--------------------------------------------------------------------------------------
    public static void assertEquals(String expectedMessage, By by, String errormessage) {
        String expectedessage = "expectedMessage";
        String actualMessage = driver.findElement(by).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "errormessage");
    }
    //----------------------------------------------------------------------------------------

    public static void takeSnapshot(String a) {

        //Convert web driver object to take screenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);

        // call getScreenshot as method to create image file
        File scrFile = scrShot.getScreenshotAs(OutputType.FILE);

        // copy file at destination

        try {
            FileUtils.copyFile(scrFile, new File("ScreenShots\\" + a + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
        //Method for alert GetText and Accept
        public static void alertMethodForGetText (){

        //switching to alert
        Alert alert =driver.switchTo().alert();

        // capturing alert message
        String alertMessage=driver.switchTo().alert().getText();

        // Alert message display
        System.out.println(alertMessage);

        alert.getText();

        //
        alert.accept();

    }

    // Method for click on ok button

    public static void alertMethodForAccept(){

        // switching to alert
        Alert alert = driver.switchTo().alert();

        //pressing ok button on alert
        String alertMessage = driver.switchTo().alert().getText();

        System.out.println(alertMessage);

        alert.accept();


    }

    //Method for Assert equals URL
    public static void assertVerificationWithUrl(String url, String errorMessage ){

        String expectedMessage= url;
        String actualMessage = driver.getCurrentUrl();
        Assert.assertEquals(expectedMessage,actualMessage,"errorMessage");
    }







}
// -----------------------------------------------------------------------------------------------













