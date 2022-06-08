package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationPageSuccess extends Utils {

    public void userVerifyRegistration() {

        // verify registration successful
        String expectedMessage = "Your registration completed";
        String actualMessage = driver.findElement(By.className("result")).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Registration is not successful");

    }

}
