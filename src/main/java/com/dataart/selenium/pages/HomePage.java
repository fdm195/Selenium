package com.dataart.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasicPage {
    @FindBy(xpath = CLIC_TO_AD_NEW_APLICATION)
    WebElement clicToAddNewAplication;



    public HeaderPage getHeader() {
        return initPage(HeaderPage.class);
    }
    public static final String CLIC_TO_AD_NEW_APLICATION="//a[contains(text(), 'Click to add new application')]";

}