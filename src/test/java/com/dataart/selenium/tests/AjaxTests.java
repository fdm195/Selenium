package com.dataart.selenium.tests;

import com.dataart.selenium.framework.BaseTest;
import com.dataart.selenium.models.User;
import com.dataart.selenium.pages.*;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import static com.dataart.selenium.models.UserBuilder.denis;
import static com.dataart.selenium.framework.BasePage.initPage;


/**
 * Created by User on 22.12.2016.
 */
public class AjaxTests extends BaseTest {
    private LoginPage loginPage;
    private BasicPage basicPage;
    private HeaderPage headerPage;
    private CalculatorPage calculatorPage;
    private MyAplicationPage myAplicationPage;
    private NewAplicationPage newAplicationPage;
    private User user;
    @BeforeMethod(alwaysRun = true)
    public void openLoginPage() {
        basicPage = initPage(BasicPage.class);
        loginPage = basicPage.forceLogout();
        user = denis();
        loginPage.loginAs(user);
        headerPage = initPage(HeaderPage.class);

        headerPage.clickAjaxTestPageLink();
        calculatorPage=initPage(CalculatorPage.class);
    }
    @Test
    public void enterTwoValidNumbers() throws InterruptedException {
        calculatorPage.enterValidNumberInXAndY();
        calculatorPage.clickResultButton();
        basicPage.waitForElementPresent(By.id("result"),5);
        calculatorPage.assertPositivResultControl();
    }

    @Test
    public void enterValidNumberAndString()throws InterruptedException{
        calculatorPage.enterValidNumberAndString();
        calculatorPage.clickResultButton();
        basicPage.waitForElementPresent(By.id("result"),5);
        calculatorPage.assertNegativResultControl();
        Thread.sleep(2000);

    }
    @Test
    public void enterStringAndValidNumberTest(){
        calculatorPage.enteerStringAndValidNumber();
        calculatorPage.clickResultButton();
        basicPage.waitForElementPresent(By.id("result"),5);
        calculatorPage.assertNegativResultControl();
    }
    @Test
    public void enterDataFromKeyboard(){
        calculatorPage.enterDataInFildX("5");
        calculatorPage.enterDataInFildY("45");
        calculatorPage.clickResultButton();
        basicPage.waitForElementPresent(By.id("result"),5);
        calculatorPage.assertPositivResultControl();
    }
    @Test
    public void ClickSumButtonWithoutData(){
        calculatorPage.clickResultButton();
        basicPage.waitForElementPresent(By.id("result"),5);
        calculatorPage.assertNegativResultControl();
    }
}
