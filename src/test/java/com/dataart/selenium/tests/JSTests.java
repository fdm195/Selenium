package com.dataart.selenium.tests;

import com.dataart.selenium.framework.BaseTest;
import com.dataart.selenium.models.User;
import com.dataart.selenium.pages.*;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.dataart.selenium.framework.BasePage.initPage;
import static com.dataart.selenium.models.UserBuilder.admin;

/**
 * Created by User on 07.01.2017.
 */
public class JSTests extends BaseTest{
    private LoginPage loginPage;
    private BasicPage basicPage;
    private HeaderPage headerPage;
    private User user;
    private User user1;
    private MyAplicationPage myAplicationPage;
    private HomePage homePage;
    private AplicationPage aplicationPage;
    private NewAplicationPage newAplicationPage;
    private EditApplicationPage editApplicationPage;
    private ConfirmChangeApplicationPage confirmChangeApplicationPage;
    private PopularAppsPage popularAppsPage;
    private JSTestPage jsTestPage;

    @BeforeMethod(alwaysRun = true)
    public void openLoginPage() throws InterruptedException{
        basicPage = initPage(BasicPage.class);
        loginPage = basicPage.forceLogout();
        headerPage = initPage(HeaderPage.class);
        user = admin();
        loginPage.loginAs(user);
        headerPage=initPage(HeaderPage.class);
        basicPage.waitForElementPresent(By.xpath("//a[contains(text(), 'JS test page')]"),5);
        headerPage.clickJtestPageLink();
       Thread.sleep(2000);
       jsTestPage=initPage(JSTestPage.class);

    }

    @Test
    public void getCoordinatesTest() {
        jsTestPage.inputCorrectCoordinats();
        jsTestPage.clickProcessButton();
        jsTestPage.swichToWindowsGetText();
        jsTestPage.assertPositivResultControl();
    }

    @Test
    public void getCoordinatesNegativTest() {
        jsTestPage.inputIncorrectCoordinats();
        jsTestPage.clickProcessButton();
        jsTestPage.swichToWindowsGetText();
        jsTestPage.assertNegativResultControl();
        jsTestPage.clickOkButonInWindows();

    }
    @Test
    public void clickWithoutCoordinateTest(){
        jsTestPage.clickProcessButton();
        jsTestPage.assertNegativResultControl();
        jsTestPage.clickOkButonInWindows();
    }
}
