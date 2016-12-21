package com.dataart.selenium.tests;

import com.dataart.selenium.framework.BasePage;
import com.dataart.selenium.framework.BaseTest;
import com.dataart.selenium.framework.Settings;
import com.dataart.selenium.models.User;
import com.dataart.selenium.pages.*;
import com.gargoylesoftware.htmlunit.WebWindow;
import com.sun.webkit.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import javax.xml.soap.SOAPPart;

import static com.dataart.selenium.framework.BasePage.driver;
import static com.dataart.selenium.framework.Utils.isElementPresent;
import static com.dataart.selenium.models.UserBuilder.admin;
import static com.dataart.selenium.models.UserBuilder.denis;
import static org.fest.assertions.Assertions.assertThat;
import static com.dataart.selenium.framework.BasePage.initPage;

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
    }

     @Test
     public void registrNewUser()  {
         basicPage = initPage(BasicPage.class);
         registrationPage = initPage(RegistrationPage.class);
         basicPage.registrLink();
         registrationPage.registrAsUser(user);
         headerPage = initPage(HeaderPage.class);
         headerPage.assertHeader(user);
     }
     @Test
     public void registrNewUserAndLogin()  {
         basicPage = initPage(BasicPage.class);
         registrationPage = initPage(RegistrationPage.class);
         basicPage.registrLink();
         registrationPage.registrAsUser(user);
         loginPage = basicPage.forceLogout();
         headerPage = initPage(HeaderPage.class);
         loginPage.loginAs(user);
         headerPage.assertHeader(user);
     }

    @Test
    public void registerNewDeweloper() throws InterruptedException {
        basicPage = initPage(BasicPage.class);
        registrationPage = initPage(RegistrationPage.class);
        basicPage.registrLink();
        registrationPage.registrAsDeveloper(user);
        headerPage = initPage(HeaderPage.class);
        headerPage.myAplicationClic();
        Thread.sleep(3000);
        myAplicationPage=initPage(MyAplicationPage.class);
        myAplicationPage.addNewAplictionClic();
        newAplicationPage=initPage(NewAplicationPage.class);
        newAplicationPage.assertTextInPage();
     }
    @Test
    public void registerNewUserAndTruAddApllication() throws InterruptedException {
        basicPage = initPage(BasicPage.class);
        registrationPage = initPage(RegistrationPage.class);
        basicPage.registrLink();
        registrationPage.registrAsUser(user);
        Thread.sleep(5000);
        if (driver.findElements(By.xpath("//a[contains(text(), 'My applications')]")).isEmpty()) {
            registrationPage.registrAsUser(user);

        }

    }
}
