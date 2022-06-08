package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends Utils {

    LoadPage loadPage = new LoadPage();

    // locator for first name
    private By _firstName = By.xpath("//input[@name='FirstName']");

    // locator for last name
    private By _lastName = By.id("LastName");

    //locator for male gender
    private By _maleGender = By.xpath("//label[@for='gender-male']");

    // locator for birthdate
    private By _birthdate = By.xpath("//select[@name=\"DateOfBirthDay\"]");

    //locator for birthMonth
    private By _birthMonth = By.xpath("//select[@name=\"DateOfBirthMonth\"]");

    //locator for birthYear
    private By _birthYear = By.xpath("//select[@name=\"DateOfBirthYear\"]");

    //locator for email address
    private By _emailAddress = By.id("Email");

    //locator for password
    private By _password = By.id("Password");

    //locator for confirm password
    private By _confirmPassword = By.id("ConfirmPassword");


//----------------------------------------------------------------------------------------------------------------------

    //  method for firstname
    public void firstName() {
        textType(_firstName, loadPage.getProperty("firstName"));
    }

    //method for lastname
    public void lastName() {
        textType(_lastName, loadPage.getProperty("LastName"));
    }

    // select gender
    public void maleGender() {
        driver.findElement(_maleGender).click();
    }

    // select birthday
    public void birthDateSelect() {
        Select birthday = new Select(driver.findElement(_birthdate));
        birthday.selectByValue("19");
    }

    //select month
    public void birthMonthSelect() {
        Select birthmonth = new Select(driver.findElement(_birthMonth));
        birthmonth.selectByValue("1");
    }

    public void birthYearSelect() {
        // select year
        Select birthyear = new Select(driver.findElement(_birthYear));
        birthyear.selectByVisibleText("2014");
    }

    public void emailAddress() {
        // enter Email address
        textType(_emailAddress, "testingpatel22" + randomDate() + "@gmail.com");
    }

    public void password() {
        // enter password
        textType(_password,loadPage.getProperty("123456"));
    }

    public void confirmPassword() {
        // Confirm password
        textType(By.id("ConfirmPassword"), loadPage.getProperty("123456"));

    }

    //---------------------------------------------------------------------------------------------------------------------
    public void clickRegisterButton() {

        // click register button
        clickElement(By.id("register-button"));

    }
//----------------------------------------------------------------------------------------------------------------------

}
