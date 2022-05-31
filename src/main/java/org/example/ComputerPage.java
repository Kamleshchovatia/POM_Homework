package org.example;

import org.openqa.selenium.By;

public class ComputerPage extends Utils {

    private By _clickondesktop= By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']");

    public void clickOnDeskTop()
    {
        clickElement(_clickondesktop);
    }

}
