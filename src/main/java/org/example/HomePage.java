package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage extends Utils{

    //locator for registration button
    private By _registrationButton = By.className("ico-register");

    //locator for select currency
    private By _selectCurrency = By.id("customerCurrency");

    //locator for computer
    private By _selectComputer=By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']");

    private By _homepagelogo = By.xpath("//body/div[6]/div[1]/div[2]/div[1]/a[1]/img[1]");



    public void registerButtonOnHomepage(){

        // click on register button
    clickElement(_registrationButton);
        //  driver.findElement(By.className("ico-register")).click();

    }

    public void selectCurrency()
    {
        clickElement(_selectCurrency);
    }
    public void selectCurrencyFromDollarToEuro(){

        //select currency form dollar to euro
        Select currency = new Select(driver.findElement(By.id("customerCurrency")));
        currency.selectByVisibleText("Euro");

    }
    public void verifySelectCurrencyIsEuro(){
        //Build your own computer price in Euro
        String expectedCurrency="€1032.00";
        String actualCurrency=driver.findElement(By.xpath("//span[contains(text(),'€1032.00')]")).getText();
        Assert.assertEquals(expectedCurrency,actualCurrency,"Price is not in Euro ");

    }
    public void clickOnComputer()
    {
        clickElement(_selectComputer);
    }

    public void emailFriendDetails()
    {
        driver.findElement(By.xpath("//input[@id='FriendEmail']")).sendKeys("12345678@gmail.com");
    }

    public void clickOnSendMail()
    {
        driver.findElement(By.xpath("//button[contains(text(),'Send email')]")).click();
    }
    public void verifyEmailSendToFriend()
    {
        String expectedMessage="Your message has been sent.";
        String actualMessage=driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals(expectedMessage,actualMessage,"Message has not been sent successfully");
    }

    //to verify the product is in shopping cart
    public void verifyProductIsInShoppingCart()
    {
        driver.findElement(By.xpath("//span[@class=\"cart-label\"]")).click();
    }

    //select Good radio button
    public void selectGoodRadioButton(){
        clickElement(By.xpath("//label[contains(text(),'Good')]"));
    }

    // click on vote button
    public void clickOnVoteButton(){
        clickElement(By.xpath("//button[@id='vote-poll-1']"));
    }

    // Click on homepage logo
    public void clickOnHomePageLogo()
    {
        clickElement(_homepagelogo);
    }



}
