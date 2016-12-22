package com.dataart.selenium.tests;

import com.dataart.selenium.framework.BaseTest;
import com.dataart.selenium.models.User;
import com.dataart.selenium.models.UserBuilder;
import com.dataart.selenium.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.dataart.selenium.framework.BasePage.driver;
import static com.dataart.selenium.framework.BasePage.initPage;
import static com.dataart.selenium.models.UserBuilder.denis;
import static org.openqa.selenium.By.cssSelector;

/**
 * Created by User on 22.12.2016.
 */
public class RegistrationDDTTest extends BaseTest {
    private LoginPage loginPage;
    private BasicPage basicPage;
    private HeaderPage headerPage;
    private RegistrationPage registrationPage;
    private MyAplicationPage myAplicationPage;
    private NewAplicationPage newAplicationPage;
    private User user;



    @BeforeMethod(alwaysRun = true)
    public void openLoginPage()  {
        basicPage = initPage(BasicPage.class);
        loginPage = basicPage.forceLogout();
        headerPage = initPage(HeaderPage.class);
        user = denis();
        basicPage = initPage(BasicPage.class);
        registrationPage = initPage(RegistrationPage.class);
        loginPage.clickRegisterLink();
    }
    @Test(dataProvider = "userList",dataProviderClass =UserBuilder.class)
    public void Registration5UserWithDifrentRoles(String userName, String firstName, String
            lastName, String password, String role) {
        try {
            WebElement login = driver.findElement(By.name("name"));
            login.clear();
            login.sendKeys(userName);
            WebElement fName = driver.findElement(By.name("fname"));
            fName.clear();
            fName.sendKeys(firstName);
            WebElement lname = driver.findElement(By.name("lname"));
            lname.clear();
            lname.sendKeys(lastName);
            WebElement passwodr = driver.findElement(By.name("password"));
            passwodr.clear();
            passwodr.sendKeys(password);
            WebElement confirmpasswodr = driver.findElement(By.name("passwordConfirm"));
            confirmpasswodr.clear();
            confirmpasswodr.sendKeys(password);
            WebElement roleType=driver.findElement(By.name("role"));//какогото х.. не меняет роль
            roleType.sendKeys(role);
        } catch (Error e) {
            //Capture and append Exceptions/Errors
        }
        registrationPage.clickRegistrButton();
        headerPage.waitForElementPresent(cssSelector(".welcome"),3);
        headerPage = initPage(HeaderPage.class);
        headerPage.assertTitle();

    }
}
