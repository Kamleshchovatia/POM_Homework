package org.example;

import java.util.Iterator;
import java.util.Set;

public class FaceBookPage extends Utils {


    public void FBNopeCommerceChildWindow() {
        // To handle all new opened window.

        String MainWindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();

            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

                // Switching to Child window
                driver.switchTo().window(ChildWindow);


            }


        }
    }

    public void assertVerificationForUrl() {

        assertVerificationWithUrl("https://www.facebook.com/nopCommerce", "URL is not matching");

    }

}
