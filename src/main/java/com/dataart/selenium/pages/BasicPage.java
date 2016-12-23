package com.dataart.selenium.pages;

import com.dataart.selenium.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static com.dataart.selenium.framework.Utils.isElementPresent;

public class BasicPage extends BasePage {

    public final static By logoutBy = By.xpath("//a[contains(text(), 'Logout')]");
    public final static By registrationRg = By.xpath("//a[contains(text(), 'Register as a new user')]");
    public final static By flash = By.xpath("//p[@class='flash']");
    public final static By rolList=By.name("role");


    public void waitForElementPresent(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public LoginPage forceLogout() {
        driver.get(settings.getBaseUrl());
        if (isElementPresent(logoutBy)) {
            driver.findElement(logoutBy).click();
        }
        return initPage(LoginPage.class);
    }

    public String getFlashMessage() {
        if (isElementPresent(flash)) {
            return driver.findElement(flash).getText();
        }
        return null;
    }



    public  RegistrationPage rolList(){
        driver.get(settings.getBaseUrl());
        driver.findElement(rolList).getTagName();
        return null;
    }

    public void switchToNewBrowserTab(){
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public HomePage switchToPrevTab(){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        return initPage(HomePage.class);
    }

}

