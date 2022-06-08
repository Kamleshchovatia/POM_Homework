package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class NewReleasePage extends Utils{

    private By _titleSendKey=By.xpath("//input[@id='AddNewComment_CommentTitle']");

    private By _commentSendKey=By.xpath("//textarea[@id='AddNewComment_CommentText']");

    private By _clickOnNewCommentButton=By.xpath("//button[contains(text(),'New comment')]");


    // Assert verification for url
    public void assertVerificationForUrl()
    {

        assertVerificationWithUrl("https://demo.nopcommerce.com/nopcommerce-new-release", "URL is not matching");
    }

    // Assert verification for New release

    public void assertVerificationForGetText(){

        assertEquals("nopCommerce new release!", By.xpath("//div[@class='page-title']/h1"),"You are not on New release page");
    }

    //send key for title
    public void titleSendKey(){
        String title = "Namaste London";
        textType(_titleSendKey,title);
    }

    //send key for comment box
    public void commentSendKey(){
        textType(_commentSendKey,"Buckingham Palace");
    }

    //click on new comment button
    public void clickOnNewCommentButton(){

        clickElement(_clickOnNewCommentButton);
    }

    public void assertCommentAddedSuccessfully(){
        assertEquals("News comment is successfully added.",By.xpath("//div[@class='result']"),"News comment is NOT successfully Added");
    }
    public void checkYourCommentLastInTheList(){
        String title="Namaste London";
        List<WebElement> comments=driver.findElements(By.xpath("//div[@class='comment-title']"));
        List<String>listOfComments=new ArrayList<>();
        for (WebElement e:comments) {
            listOfComments.add(e.getText());
        }
        Assert.assertTrue(listOfComments.contains(title));
        String lastComment = listOfComments.get(listOfComments.size()-1);
        System.out.println(lastComment);
        Assert.assertEquals(lastComment,title, "comments is not in order");
    }


}
