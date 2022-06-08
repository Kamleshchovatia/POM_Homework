package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class BuildYourOnComputer extends Utils {


    private By _emailAFriend = By.xpath("//button[normalize-space()='Email a friend']");

    public void emailAFriend() {
        clickElement(_emailAFriend);
    }

    public void selectProcessor() {
        Select processor = new Select(driver.findElement(By.xpath("//select[@id=\"product_attribute_1\"]")));
        processor.selectByValue("1");
    }

    public void selectRam() {
        driver.findElement(By.xpath("//label[contains(text(),'RAM')]"));
        Select ram = new Select(driver.findElement(By.xpath("//select[@id='product_attribute_2']")));
        ram.selectByVisibleText("2 GB");
    }

    public void select320gb() {
        driver.findElement(By.xpath("//input[@id='product_attribute_3_6']")).click();
    }

    public void selectVistaHomeFromOS() {
        driver.findElement(By.xpath("//input[@id='product_attribute_4_8']")).click();
    }

    public void selectMicrosoftOffice() {
        driver.findElement(By.xpath("//input[@id='product_attribute_5_10']"));
    }

    public void selectAcrobatReader() {
        driver.findElement(By.xpath("//input[@id='product_attribute_5_11']")).click();
    }

    public void selectTotalCommander() {
        driver.findElement(By.xpath("//input[@id='product_attribute_5_12']")).click();
    }

    public void clickOnAddToCardBasket() {
        driver.findElement(By.xpath("//button[@id='add-to-cart-button-1']")).click();
    }


}
