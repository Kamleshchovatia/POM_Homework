package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends Utils {

    LoadProp loadProp = new LoadProp();

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
        textType(_firstName, loadProp.getProperty("firstName"));
    }

    //method for lastname
    public void lastName() {
        textType(_lastName, loadProp.getProperty("LastName"));
    }

    // select gender
    public void maleGender() {
        driver.findElement(_maleGender).click();
    }

    // select birthday
    public void birthDateSelect() {
      //  Select birthday = new Select(driver.findElement(_birthdate));
       // birthday.selectByValue("19");
        selectByValue(_birthdate, loadProp.getProperty("birthday"));
    }

    //select month
    public void birthMonthSelect() {
       // Select birthmonth = new Select(driver.findElement(_birthMonth));
       // birthmonth.selectByValue("1");
        selectByValue(_birthMonth, loadProp.getProperty("birthmonth"));
    }

    public void birthYearSelect() {
        // select year
      //  Select birthyear = new Select(driver.findElement(_birthYear));
       // birthyear.selectByVisibleText("2014");
        selectByVisibleText(_birthYear, loadProp.getProperty("birthyear"));
    }

    public void emailAddress() {
        // enter Email address
       // textType(_emailAddress, "software.testing" + randomDate() + "@gmail.com");
        textType(_emailAddress, loadProp.getProperty("emailFirstPart")+randomDate()+ loadProp.getProperty("emailSecondPart"));
    }

    public void password() {
        // enter password
      //  textType(_password,"1234567");
        textType(_password, loadProp.getProperty("password"));
    }

    public void confirmPassword() {
        // Confirm password
      //  textType(_confirmPassword,"1234567");
        textType(_confirmPassword, loadProp.getProperty("ConfirmPassword"));

    }

    //---------------------------------------------------------------------------------------------------------------------
    public void clickRegisterButton() {

        // click register button
        clickElement(By.id("register-button"));

    }
//----------------------------------------------------------------------------------------------------------------------

}
