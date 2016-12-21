package com.dataart.selenium.tests;

import com.dataart.selenium.framework.BasePage;
import com.dataart.selenium.framework.BaseTest;
import com.dataart.selenium.framework.Settings;
import com.dataart.selenium.models.User;
import com.dataart.selenium.pages.BasicPage;
import com.dataart.selenium.pages.HeaderPage;
import com.dataart.selenium.pages.LoginPage;
import com.gargoylesoftware.htmlunit.WebWindow;
import com.sun.webkit.WebPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;

import static com.dataart.selenium.framework.BasePage.driver;
import static com.dataart.selenium.framework.Utils.isElementPresent;
import static com.dataart.selenium.models.UserBuilder.admin;
import static org.fest.assertions.Assertions.assertThat;
import static com.dataart.selenium.framework.BasePage.initPage;

public class LogoutTest extends BaseTest{
    private LoginPage loginPage;
    private BasicPage basicPage;
    private HeaderPage headerPage;
    private User user;

    @BeforeMethod(alwaysRun = true)
    public void openLoginPage() {
        basicPage = initPage(BasicPage.class);
        loginPage = basicPage.forceLogout();
        headerPage = initPage(HeaderPage.class);
        user = admin();
        loginPage.loginAs(user);
    }
    @Test
    public void test1(){
        loginPage.loginAs(user);




    }


}