package org.LamiaQA.base;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogin extends CommonAPI{
    @Test
    public void loginWithValidCredentials () {
        //check user land on the right page
        String expected = "Swag Labs";
        //String actual = driver.getTitle();
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
        System.out.println("page title validation success");
        //Thread.sleep(3000);
        waitFor(3);

        //enter username
        //note ici y a pas de validation du coup on a pas besoin de assert
        //on aura pas besoin de web element car on a fait appel a type()
        //WebElement usernameField=driver.findElement(By.id("user-name"));
        //usernameField.sendKeys("standard_user");
        type("#user-name","standard_user");
        System.out.println("enter username success");
        waitFor(3);
        //enter password
        //pas de validation
        //WebElement passwordField=driver.findElement(By.id("password"));
        //passwordField.sendKeys("secret_sauce");
        type("#password","secret_sauce" );
        System.out.println("enter password is success");
        waitFor(3);

        //click login button
        //WebElement loginButton=driver.findElement(By.id("login-button"));
        //loginButton.click();
        click("#login-button");
        System.out.println("login button click success");
        boolean productHeaderIsDisplayed = isDisplayed(".title");
        //WebElement productHeader =driver.findElement(By.cssSelector(".title"));
        //boolean productHeaderIsDisplayed = productHeader.isDisplayed();
        Assert.assertTrue(productHeaderIsDisplayed);
        System.out.println("Products header is displayed success");
        waitFor(3);
    }
    @Test
    // negative test
    public void LoginAttenteWithoutUsername ()  {
        //check user land on the right page
        String expected = "Swag Labs";
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        System.out.println("page title validation success");
        waitFor(3);

        //enter username
        type("#username","");
        //System.out.println("enter username success");
        //enter password
        //pas de validation
        type("#password","secret_sauce" );
        System.out.println("enter password is success");
        waitFor(3);

        //click login button
        //WebElement loginButton=driver.findElement(By.id("login-button"));
        //loginButton.click();
        click("#login-button");
        System.out.println("login button click success");
        //WebElement errorAlert =driver.findElement(By.cssSelector(".error-message-container.error"));
        //String textError = errorAlert.getText();
        String textError = getWebElementText(".error-message-container.error");
        System.out.println("error message"+textError);
        Assert.assertEquals("Epic sadface: Username is required",textError);
        System.out.println("error message validation success");
        waitFor(3);
    }
    @Test
    public void LoginAttenteWithoutPassword() {
        //cette fois en manque de pass word
        //check user land on the right page
        String expected = "Swag Labs";
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        System.out.println("page title validation success");
        waitFor(3);

        //enter username
        type("#username","standard-user" );
        System.out.println("enter username success");

        //enter password
        //pas de validation
        type("#password","" );
        //System.out.println("enter password success");
        waitFor(3);

        //click login button
        click("#login-button"); //le bute de ne pas utiliser les instance driver
        System.out.println("login button click success");
        //WebElement errorAlert =driver.findElement(By.cssSelector(".error-message-container.error"));
        //String textError = errorAlert.getText();
        String textError = getWebElementText(".error-message-container.error");
        System.out.println("error message:"+textError);
        Assert.assertEquals("Epic sadface: Password is required",textError);
        System.out.println("error message validation success");
        waitFor(3);
    }
}
