package com.dataart.selenium.pages;

import com.dataart.selenium.framework.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by User on 21.12.2016.
 */
public class MyAplicationPage extends BasePage {
    @FindBy(xpath = ADD_NEW_APLICAT)
    WebElement addAplicationLink;
    public MyAplicationPage addNewAplictionClic(){addAplicationLink.click(); return null;}

    public static final String ADD_NEW_APLICAT="//a[contains(text(), 'Click to add new application')]";
}
