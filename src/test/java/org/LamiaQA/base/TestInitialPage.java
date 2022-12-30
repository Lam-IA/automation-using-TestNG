package org.LamiaQA.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestInitialPage extends CommonAPI{

    @Test
    public void validateLandingPage () {
        String expected = "Swag Labs";
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
        System.out.println("page title validation success");
    }
    @Test
    public void validateLoginPageElements () {
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
