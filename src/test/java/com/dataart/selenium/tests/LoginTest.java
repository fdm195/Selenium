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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.dataart.selenium.framework.BasePage.driver;
import static com.dataart.selenium.framework.Utils.isElementPresent;
import static com.dataart.selenium.models.UserBuilder.admin;
import static org.fest.assertions.Assertions.assertThat;
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
        loginPage.loginAs(user);
        assertThat(isElementPresent(basicPage.flash)).isTrue();
        assertThat(basicPage.getFlashMessage()).isEqualTo("You have entered an invalid username or password!");
    }
    @Test
    public void loginAndSwichToTab() throws InterruptedException {
        loginPage.loginAs(user);

        String url=driver.getCurrentUrl();
        basicPage.swichToNewWindowsWithOldUlr();
        driver.navigate().to(url);
        basicPage.forceLogout();
        basicPage.swichToPreTab();
        headerPage.editAccount();
        loginPage = initPage(LoginPage.class);
        assertThat(isElementPresent(LoginPage.REGISTER_LINK)).isTrue();
    }
}