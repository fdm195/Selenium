package com.dataart.selenium.pages;

import com.dataart.selenium.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fest.assertions.Assertions.assertThat;

public class HeaderPage extends BasicPage {
    @FindBy(xpath = EDITACCOUNT)
    WebElement editAccountLink;
    @FindBy(xpath = MYAPLICATION)
    WebElement myAplicationLink;
    public HomePage editAccount(){
        editAccountLink.click();
        return null;
    }

    public String getWelcomeMessage() {
        return driver.findElement(By.cssSelector(".welcome")).getText();
    }

    public void assertHeader(User user){
        assertThat(getWelcomeMessage()).isEqualTo("Welcome " + user.getFname() + " " + user.getLname());
    }
    public void assertHederReg(User user){
        assertThat(getWelcomeMessage()).isEqualTo("Welcome " + user.getFname() + " " + user.getLname());
    }
    public boolean elementIsNotPresent(String xpath){
        return driver.findElements(By.xpath("//a[contains(text(), 'My applications')]")).isEmpty();
    }


    public HeaderPage myAplicationClic(){myAplicationLink.click(); return null;}
    public static final String EDITACCOUNT = "//a[contains(text(), 'Edit account')]";
    public static final String MYAPLICATION = "//a[contains(text(), 'My applications')]";
}