package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;



public class HomePage extends Utils {

    //locator for registration button
    private By _registrationButton = By.className("ico-register");

    //locator for select currency
    private By _selectCurrency = By.id("customerCurrency");

    //locator for computer
    private By _selectComputer = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']");

    // locator for homepage logo
    private By _homepagelogo = By.xpath("//body/div[6]/div[1]/div[2]/div[1]/a[1]/img[1]");

    //locator for enter Friend's email
    private By _emailFriendDetails = By.xpath("//input[@id='FriendEmail']");

    //locator for Good radio button
    private By _goodRadioButton = By.xpath("//label[contains(text(),'Good')]");

    //locator for Vote button
    private By _voteButton = By.xpath("//button[@id='vote-poll-1']");

    //locator for FBNopeCommerce
    private By _FBNopeCommerce =By.xpath("//a[contains(text(),'Facebook')]");

    //locator for nopeCommerce new release
    private By _NopeCommerceNewRelease=By.xpath("//a[contains(text(),'nopCommerce new release!')]/following::div[2]");

    // locator for product search
    private By _productSearch=By.xpath("//input[@id='small-searchterms']");

    //locator for click on search button
    private By _clickOnSearchButton=By.xpath("//button[contains(text(),'Search')]");


    public void registerButtonOnHomepage() {
        // click on register button
        clickElement(_registrationButton);
    }

    // select currency
    public void selectCurrency() {
        clickElement(_selectCurrency);
    }

    public void selectCurrencyFromDollarToEuro() {

        //select currency from dollar to euro
        Select currency = new Select(driver.findElement(By.id("customerCurrency")));
        currency.selectByVisibleText("Euro");
    }

    //Build your own computer price in Euro
    public void verifySelectCurrencyIsEuro() {   //Build your own computer price in Euro
        String expectedCurrency = "€1032.00";
        String actualCurrency = driver.findElement(By.xpath("//span[contains(text(),'€1032.00')]")).getText();
        Assert.assertEquals(expectedCurrency, actualCurrency, "Price is not in Euro ");

    }

    //click on computer
    public void clickOnComputer() {
        clickElement(_selectComputer);
    }

    // enter friend's email
    public void emailFriendDetails() {
        driver.findElement(_emailFriendDetails).sendKeys("12345678@gmail.com");
    }

    // click on send Email
    public void clickOnSendMail() {
        driver.findElement(By.xpath("//button[contains(text(),'Send email')]")).click();
    }

    //verify email send to Friend
    public void verifyEmailSendToFriend() {
        String expectedMessage = "Your message has been sent.";
        String actualMessage = driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals(expectedMessage, actualMessage, "Message has not been sent successfully");
    }

    //to verify the product is in shopping cart
    public void verifyProductIsInShoppingCart() {
        driver.findElement(By.xpath("//span[@class=\"cart-label\"]")).click();
    }

    //select Good radio button
    public void selectGoodRadioButton() {
        clickElement(_goodRadioButton);
    }

    // click on vote button
    public void clickOnVoteButton() {
        clickElement(_voteButton);
    }

    // Click on homepage logo
    public void clickOnHomePageLogo() {
        clickElement(_homepagelogo);
    }



    public void getProductList() {

        List<WebElement> productTitles = driver.findElements(By.xpath("//div[contains(@class,'product-grid')]//div[@class='item-box']//h2"));

        for (WebElement e : productTitles) {
            System.out.println(e.getText());
        }

    }

    public void verificationUserOnHomePage(){
        assertEquals("Welcome to our store",By.xpath("//div[@class='topic-block-title']/h2"), "User is NOT on homepage");


    }

    public void verificationForAlertTextAndAccept(){

        alertMethodForGetText();
    }

    public void FBNopeCommerce(){

        clickElement(_FBNopeCommerce);
    }

    public void clickOnNopeCommerceNewReleaseDetailsButton(){

        clickElement(_NopeCommerceNewRelease);
    }

    //search the product in search box
    public void typeInSearchBox(String product){

        textType(_productSearch,product);
    }

    // method for click on search button
    public void clickOnSearchButton(){

        clickElement(_clickOnSearchButton);
    }


//    public void checkYourCommentLastInTheList(){
//        String title="Namaste London";
//        List<WebElement>comments=driver.findElements(By.xpath("//div[@class='comment-title']"));
//        List<String>listOfComments=new ArrayList<>();
//        for (WebElement e:comments) {
//            listOfComments.add(e.getText());
//        }
//        Assert.assertTrue(listOfComments.contains(title));
//        String lastComment = listOfComments.get(listOfComments.size()-1);
//        System.out.println(lastComment);
//        Assert.assertEquals(lastComment,title, "comments is not in order");
//    }

}
