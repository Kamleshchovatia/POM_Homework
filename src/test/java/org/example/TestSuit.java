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


//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
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
 //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
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
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test
    public void userShouldBeAbleToSendEmailToFriend(){

        // click on register button
        homePage.registerButtonOnHomepage();

        //enter  firstname
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
         homePage.clickOnComputer();

        //Click on desktop
         computerPage.clickOnDeskTop();

        //click on Build your own computer
        deskTopsPage.buildYourOnComputer();

        //click on Email a friend
        buildYourOnComputer.emailAFriend();

        //enter Friend's email
        homePage.emailFriendDetails();

        //click on send email button

        homePage.clickOnSendMail();

        // verify after send email to Friend
        homePage.verifyEmailSendToFriend();

    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test
    public  void userShouldBeAbleToAddProductInShoppingCardSuccessfully(){

        //click on computers
       homePage.clickOnComputer();

        //click on desktops

       computerPage.clickOnDeskTop();

        //click on build your own computer
        deskTopsPage.buildYourOnComputer();

        //select 2.2Ghz from processor
        buildYourOnComputer.selectProcessor();

        //click on Ram and select 2gb
        buildYourOnComputer.selectRam();

        //select320gb
        buildYourOnComputer.select320gb();

        //select vista home from OS
        buildYourOnComputer.selectVistaHomeFromOS();

        //select software microSoftOffice
        buildYourOnComputer.selectMicrosoftOffice();

        //select software Acrobat reader
         buildYourOnComputer.selectAcrobatReader();

        //select Total commander
        buildYourOnComputer.selectTotalCommander();

        //click on add to cart button
        buildYourOnComputer.clickOnAddToCardBasket();

        //to verify the product is in shopping cart
        homePage.verifyProductIsInShoppingCart();

        assertEquals("Shopping cart",By.xpath("//div[@class='page-title']"),"could not locate shopping cart" );

        assertEquals("Build your own computer", By.xpath("//a[@class=\"product-name\"]"),"Wrong product");

    }
 //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Test
    public void userShouldBeAbleToVoteSuccessfully(){

        // click on Good radio button
        homePage.selectGoodRadioButton();

        //click on Vote button

        homePage.clickOnVoteButton();


        // verify only register user can vote
        // String expectedMessage="Only registered users can vote.";
        // String actualMessage = driver.findElement(By.id("block-poll-vote-error-1")).getText();
        // Assert.assertEquals(actualMessage,expectedMessage,"voting unsuccessful");

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
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
