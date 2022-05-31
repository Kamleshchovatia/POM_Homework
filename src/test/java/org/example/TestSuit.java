package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuit  extends BaseTest {

    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationPageSuccess registrationPageSuccess = new RegistrationPageSuccess();
    ComputerPage computerPage = new ComputerPage();
    DeskTopsPage deskTopsPage = new DeskTopsPage();
    BuildYourOnComputer buildYourOnComputer = new BuildYourOnComputer();



    @Test
    public void userShouldBeBaleToRegisterSuccessfully() {


        // click on register button
        homePage.registerButtonOnHomepage();

        //enter user firstname
        registrationPage.firstName();
        //enter last name
        registrationPage.lastName();
        //select male gender
        registrationPage.maleGender();
        //select birthday
        registrationPage.birthDateSelect();
        //select birthMonth
        registrationPage.birthMonthSelect();
        //select birthYear
        registrationPage.birthYearSelect();
        //select emailAddress
        registrationPage.emailAddress();
        //select password
        registrationPage.password();
        //select confirm password
        registrationPage.confirmPassword();

        // click on register button
        registrationPage.clickRegisterButton();


        // verify registration successful
        registrationPageSuccess.userVerifyRegistration();

    }
    @Test
    public void userShouldBeAbleToChangeCurrencyInEuro() {


        //click on currency bar
        homePage.selectCurrency();


        //select currency from dollar to euro
        homePage.selectCurrencyFromDollarToEuro();

        //scroll down on homepage,build your own computer to check the price
        //user should be able to see "€"in front of the price
        homePage.verifySelectCurrencyIsEuro();

    }

    @Test
    public void userShouldBeAbleToSendEmailToFriend(){

        // click on register button
        homePage.registerButtonOnHomepage();

        //enter user firstname
        registrationPage.firstName();
        //enter last name
        registrationPage.lastName();
        //select male gender
        registrationPage.maleGender();
        //select birthday
        registrationPage.birthDateSelect();
        //select birthMonth
        registrationPage.birthMonthSelect();
        //select birthYear
        registrationPage.birthYearSelect();
        //select emailAddress
        registrationPage.emailAddress();
        //select password
        registrationPage.password();
        //select confirm password
        registrationPage.confirmPassword();

        // click on register button
        registrationPage.clickRegisterButton();

        // verify registration successful
        registrationPageSuccess.userVerifyRegistration();

        //Click on computer
        //clickElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
         homePage.clickOnComputer();

        //Click on desktop
       // clickElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));
         computerPage.clickOnDeskTop();

        //click on Build your own computer
       // clickElement(By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own computer']"));
        deskTopsPage.buildYourOnComputer();

        //click on Email a friend
       // clickElement(By.xpath("//button[normalize-space()='Email a friend']"));
        buildYourOnComputer.emailAFriend();

        //enter Friend's email
        //driver.findElement(By.xpath("//input[@id='FriendEmail']")).sendKeys("12345678@gmail.com");
        homePage.emailFriendDetails();

        //click on send email button
        //driver.findElement(By.xpath("//button[contains(text(),'Send email')]")).click();
        homePage.clickOnSendMail();

        // verify after send email to Friend
       // String expectedMessage="Your message has been sent.";
        //String actualMessage=driver.findElement(By.xpath("//div[@class='result']")).getText();
        //Assert.assertEquals(expectedMessage,actualMessage,"Message has not been sent successfully");
        homePage.verifyEmailSendToFriend();

    }
    @Test
    public  void userShouldBeAbleToAddProductInShoppingCardSuccessfully(){

        //click on computers
       // driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")).click();
       homePage.clickOnComputer();

        //click on desktops
        driver.findElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));
       computerPage.clickOnDeskTop();

        //click on build your own computer
        //driver.findElement(By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own computer']")).click();
        deskTopsPage.buildYourOnComputer();

        //select 2.2Ghz from processor
       // Select processor = new Select(driver.findElement(By.xpath("//select[@id=\"product_attribute_1\"]")));
        //processor.selectByValue("1");
        buildYourOnComputer.selectProcessor();

        //click on Ram and select 2gb
//        driver.findElement(By.xpath("//label[contains(text(),'RAM')]"));
//        Select ram = new Select(driver.findElement(By.xpath("//select[@id='product_attribute_2']")));
//        ram.selectByVisibleText("2 GB");
        buildYourOnComputer.selectRam();

        //select320gb
       // driver.findElement(By.xpath("//input[@id='product_attribute_3_6']")).click();
        buildYourOnComputer.select320gb();

        //select vista home from OS
        //driver.findElement(By.xpath("//input[@id='product_attribute_4_8']")).click();
        buildYourOnComputer.selectVistaHomeFromOS();

        //select software microSoftOffice
        //driver.findElement(By.xpath("//input[@id='product_attribute_5_10']"));
        buildYourOnComputer.selectMicrosoftOffice();

        //select software Acrobat reader
       // driver.findElement(By.xpath("//input[@id='product_attribute_5_11']")).click();
         buildYourOnComputer.selectAcrobatReader();

        //select Total commander
        //driver.findElement(By.xpath("//input[@id='product_attribute_5_12']")).click();
        buildYourOnComputer.selectTotalCommander();

        //click on add to cart button
        //driver.findElement(By.xpath("//button[@id='add-to-cart-button-1']")).click();
        buildYourOnComputer.clickOnAddToCardBasket();

        //to verify the product is in shopping cart
        //driver.findElement(By.xpath("//span[@class=\"cart-label\"]")).click();
        homePage.verifyProductIsInShoppingCart();


        assertEquals("Shopping cart",By.xpath("//div[@class='page-title']"),"could not locate shopping cart" );

        assertEquals("Build your own computer", By.xpath("//a[@class=\"product-name\"]"),"Wrong product");

    }
    @Test
    public void userShouldBeAbleToVoteSuccessfully(){

        // click on Good radio button
       // clickElement(By.xpath("//label[contains(text(),'Good')]"));
        homePage.selectGoodRadioButton();

        //click on Vote button
       // clickElement(By.xpath("//button[@id='vote-poll-1']"));
        homePage.clickOnVoteButton();


        //verify only register user can vote
       // String expectedMessage="Only registered users can vote.";
        //String actualMessage = driver.findElement(By.id("block-poll-vote-error-1")).getText();
        //Assert.assertEquals(actualMessage,expectedMessage,"voting unsuccessful");

        //click on register button
        homePage.registerButtonOnHomepage();

        //enter user firstname
        registrationPage.firstName();
        //enter last name
        registrationPage.lastName();
        //select male gender
        registrationPage.maleGender();
        //select birthday
        registrationPage.birthDateSelect();
        //select birthMonth
        registrationPage.birthMonthSelect();
        //select birthYear
        registrationPage.birthYearSelect();
        //select emailAddress
        registrationPage.emailAddress();
        //select password
        registrationPage.password();
        //select confirm password
        registrationPage.confirmPassword();

        // click on register button
        registrationPage.clickRegisterButton();

        //click on homepage logo
        homePage.clickOnHomePageLogo();

        // click on Good radio button
        // clickElement(By.xpath("//label[contains(text(),'Good')]"));
        homePage.selectGoodRadioButton();

        //click on Vote button
        // clickElement(By.xpath("//button[@id='vote-poll-1']"));
        homePage.clickOnVoteButton();

        //verify the numbers of vote(s)
        String expectedmessage = " vote(s)...";
        String actualmessage = driver.findElement(By.xpath("//span[@class='poll-total-votes']")).getText().replaceAll("\\d+","");
        Assert.assertEquals(actualmessage, expectedmessage, "not voted");





    }


}
