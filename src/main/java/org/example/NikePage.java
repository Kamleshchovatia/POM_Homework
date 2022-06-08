package org.example;

import org.openqa.selenium.By;

public class NikePage extends Utils{

    //Assert verification for Nike products

    public void nikeProductVerification(){

        assertEquals("Search", By.xpath("//h1[contains(text(),'Search')]"),"Search product is not Nike");
    }


}
