package org.example;

import org.openqa.selenium.By;

public class ComputerPage extends Utils {

    private By _clickondesktop = By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']");

    //locator for computer page
    private By _userIsOnComputersPage=By.xpath("//h1[contains(text(),'Computers')]");

    public void clickOnDeskTop() {
        clickElement(_clickondesktop);
    }

    public void userIsOnComputersPage(){
        //Assert verification user is on computers page
        assertEquals("Computers",_userIsOnComputersPage,"user is not on computers page");

    }


}
