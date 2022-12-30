package org.LamiaQA.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends CommonAPI{
    @Test
    public void loginWithValidCredentials () {
        //check user land on the right page
        String expected = "Swag Labs";
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        System.out.println("page title validation success");

        //enter username
        type("#user-name","standard_user");
        System.out.println("enter username success");
        //enter password
        type("#password","secret_sauce" );
        System.out.println("enter password success");

        //click login button
        click("#login-button");
        System.out.println("login button click success");
        boolean productHeaderIsDisplayed = isDisplayed(".title");
        Assert.assertTrue(productHeaderIsDisplayed);
        System.out.println("Products header is displayed success");
    }
    @Test
    // negative test
    public void LoginAttemptWithoutUsername ()  {
        //check user land on the right page
        String expected = "Swag Labs";
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        System.out.println("page title validation success");;

        //enter username
        type("#user-name","");

        //enter password
        type("#password","secret_sauce" );
        System.out.println("enter password is success");

        //click login button
        click("#login-button");
        System.out.println("login button click success");
        String textError = getWebElementText(".error-message-container.error");
        System.out.println("error message"+textError);
        Assert.assertEquals("Epic sadface: Username is required",textError);
        System.out.println("error message validation success");
    }
    @Test
    public void LoginAttemptWithoutPassword() {
        //check user land on the right page
        String expected = "Swag Labs";
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        System.out.println("page title validation success");

        //enter username
        type("#user-name","standard_user" );
        System.out.println("enter username success");

        //enter password
        type("#password","" );
        waitFor(3);

        //click login button
        click("#login-button");
        System.out.println("login button click success");
        String textError = getWebElementText(".error-message-container.error");
        System.out.println("error message:"+textError);
        Assert.assertEquals("Epic sadface: Password is required",textError);
        System.out.println("error message validation success");
    }
}
