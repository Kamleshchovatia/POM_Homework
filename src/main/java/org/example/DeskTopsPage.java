package org.example;

import org.openqa.selenium.By;

public class DeskTopsPage extends Utils{

    private By _buildYourOnComputer=By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own computer']");

    public void buildYourOnComputer()
    {
        clickElement(_buildYourOnComputer);
    }

}
