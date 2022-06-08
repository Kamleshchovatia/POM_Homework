package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeskTopsPage extends Utils {

    private By _buildYourOnComputer = By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own computer']");

    //locator for desktops
    private By _userIsOnDesktopsPage=By.xpath("//h1[contains(text(),'Desktops')]");

    //locator for select box
    private By _clickOnSortBySelectionBox=By.xpath("//select[@id='products-orderby']");

    //locator for select Z to A
    private By _selectZtoA=By.xpath("//select[@id='products-orderby']");

    public void buildYourOnComputer() {
        clickElement(_buildYourOnComputer);
    }

    public void userIsOnDesktopsPage() {
        assertEquals("Desktops", _userIsOnDesktopsPage, "user is not on desktop page");
    }
    public void clickOnSortBySelectBox() {
        clickElement(_clickOnSortBySelectionBox);
    }

    public void selectZtoA() {
        Select select= new Select(driver.findElement(_selectZtoA));
        select.selectByVisibleText("Name: Z to A");

    }

    public void productSortByZtoA(String product){
        List<WebElement> productTitles = driver.findElements(By.xpath(" //div[contains(@class,'product-grid')]//div[@class='item-box']//h2"));
        List<String> descendingProductTitles = new ArrayList<String>();
        for (WebElement e : productTitles) {
            descendingProductTitles.add(e.getText().substring(0, 1));
        }
        Collections.sort(descendingProductTitles, Collections.reverseOrder());
        System.out.println(descendingProductTitles);



         List<String> actualProductTitles = new ArrayList<String>();
        for (WebElement e : productTitles) {
            actualProductTitles.add(e.getText().substring(0, 1));

            System.out.println(actualProductTitles);
            Assert.assertTrue(actualProductTitles.equals(descendingProductTitles));


        }

    }




}
