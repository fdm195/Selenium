package com.dataart.selenium.tests;

import com.dataart.selenium.framework.BaseTest;
import com.dataart.selenium.models.User;
import com.dataart.selenium.models.UserBuilder;
import com.dataart.selenium.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import static com.dataart.selenium.framework.BasePage.driver;
import static com.dataart.selenium.models.UserBuilder.denis;
import static com.dataart.selenium.framework.BasePage.initPage;
import static org.openqa.selenium.By.cssSelector;

public class RegistrationTest extends BaseTest {
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

     @Test
     public void registrNewUser()  throws InterruptedException{
         registrationPage.registrationUser(user);
         registrationPage.selectRoleUser();
         registrationPage.clickRegistrButton();
         headerPage = initPage(HeaderPage.class);
         headerPage.assertHeader(user);
     }

     @Test
     public void registrNewUserAndLogin()  {
         registrationPage.registrationUser(user);
         registrationPage.selectRoleUser();
         registrationPage.clickRegistrButton();
         loginPage = basicPage.forceLogout();
         headerPage = initPage(HeaderPage.class);
         loginPage.loginAs(user);
         headerPage.assertHeader(user);
     }

    @Test
    public void registerNewDeweloper() throws InterruptedException {
        registrationPage.registrationUser(user);
        registrationPage.selectRoleDeveloper();
        registrationPage.clickRegistrButton();
        headerPage = initPage(HeaderPage.class);
        headerPage.myAplicationClic();
        myAplicationPage=initPage(MyAplicationPage.class);
        basicPage.waitForElementPresent(By.xpath("//a[contains(text(), 'Click to add new application')]"),1);
        myAplicationPage.addNewAplictionClic();
        newAplicationPage=initPage(NewAplicationPage.class);
        newAplicationPage.assertTextInPage();
     }

    @Test
    public void registerNewUserAndTruAddApllication() throws InterruptedException {
        registrationPage.registrationUser(user);
        registrationPage.clickRegistrButton();
        Thread.sleep(5000);
        headerPage.elementIsNotPresent();
    }

    }
