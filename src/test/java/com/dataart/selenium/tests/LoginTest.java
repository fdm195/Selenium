package com.dataart.selenium.tests;

import com.dataart.selenium.framework.BaseTest;
import com.dataart.selenium.models.User;
import com.dataart.selenium.pages.BasicPage;
import com.dataart.selenium.pages.HeaderPage;
import com.dataart.selenium.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.dataart.selenium.framework.BasePage.driver;
import static com.dataart.selenium.models.UserBuilder.admin;
import static com.dataart.selenium.framework.BasePage.initPage;

public class LoginTest extends BaseTest {

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
    }

    @Test
    public void correctLoginTest() {
        loginPage.loginAs(user);
        headerPage.assertHeader(user);

    }

    @Test
    public void incorrectLoginTest() {
        user.setPassword(user.getPassword() + user.getPassword());
        loginPage.incorectLoginAs(user);
        Assert.assertTrue(loginPage.isLoginButtonPresent(),"jjjj");
        Assert.assertEquals(basicPage.getFlashMessage(), "You have entered an invalid username or password!");
    }

    @Test
    public void loginAndSwitchToTab() {
        loginPage.loginAs(user);
        String url=driver.getCurrentUrl();
        basicPage.switchToNewBrowserTab();
        driver.navigate().to(url);
        basicPage.forceLogout();
        basicPage.switchToPrevTab();
        headerPage=initPage(HeaderPage.class);
        headerPage.clickEditAccount();
        Assert.assertTrue(loginPage.isLoginButtonPresent(),"User should be logged out");
    }
}