package com.dataart.selenium.pages;

import com.dataart.selenium.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fest.assertions.Assertions.assertThat;

public class HeaderPage extends BasicPage {
    @FindBy(xpath = EDITACCOUNT_XPATH)
    WebElement editAccountLink;
    @FindBy(xpath = MYAPLICATION_XPATH)
    WebElement myAplicationLink;
    @FindBy(xpath = AJAX_TEST_LINK_XPATH)
    WebElement ajaxLink;

    public void clickEditAccount(){
        editAccountLink.click();
    }
    public void clickAjaxTestPageLink(){
        ajaxLink.click();
    }

    public String getWelcomeMessage() {
        return driver.findElement(By.cssSelector(".welcome")).getText();
    }
    public String getTitleText(){
        return driver.findElement(By.xpath("//div[contains(text(), 'Selenium test application')]")).getText();}
     public void assertTitle(){
        assertThat(getTitleText()).isEqualTo("Selenium test application");
     }

    public void assertHeader(User user){
        assertThat(getWelcomeMessage()).isEqualTo("Welcome " + user.getFname() + " " + user.getLname());
    }
    public void assertHederReg(User user){
        assertThat(getWelcomeMessage()).isEqualTo("Welcome " + user.getFname() + " " + user.getLname());
    }
    public boolean elementIsNotPresent(){
        return driver.findElements(By.xpath("//a[contains(text(), 'My applications')]")).isEmpty();
    }


    public HeaderPage myAplicationClic(){myAplicationLink.click(); return null;}
    public static final String EDITACCOUNT_XPATH = "//a[contains(text(), 'Edit account')]";
    public static final String MYAPLICATION_XPATH = "//a[contains(text(), 'My applications')]";
    public static final String AJAX_TEST_LINK_XPATH = "//a[contains(text(), 'Ajax test page')]";
}