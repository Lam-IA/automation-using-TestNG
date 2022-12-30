package org.LamiaQA.base;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestInitialPage extends CommonAPI{

    @org.junit.Test
    public void test1 () {
        String expected = "Swag Labs";
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
        System.out.println("page title validation success");
    }
    @Test
    public void test2 () {
        String expected = "Swag Labs";
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
        System.out.println("page title validation success");
        //username
        boolean userNameIsDisplayed=isDisplayed("#user-name");
        Assert.assertTrue(userNameIsDisplayed);
        System.out.println("username field is displayed");
        //password
        boolean passwordIsDisplayed=isDisplayed("#password");
        Assert.assertTrue(passwordIsDisplayed);
        System.out.println("password field is displayed");
        //login button
        boolean loginButtonISDisplayed= isDisplayed("#login-button");
        Assert.assertTrue(loginButtonISDisplayed);
        System.out.println("login button is displayed");
    }
}
