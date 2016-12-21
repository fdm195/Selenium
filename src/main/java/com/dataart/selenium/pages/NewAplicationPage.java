package com.dataart.selenium.pages;

import com.dataart.selenium.framework.BasePage;
import com.dataart.selenium.models.User;
import com.sun.jna.Structure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.fest.assertions.Assertions.assertThat;


/**
 * Created by User on 20.12.2016.
 */
public class NewAplicationPage extends BasePage{
    @FindBy(name = TITLE_TEXT_FIELD)
    WebElement titleTextField;
    @FindBy(name = DESCRIPTION)
    WebElement descriptionTextField;
    @FindBy(name = CATEGORY)
    WebElement categorySelectList;
    @FindBy(name = IMAGE_ADD_BUTTON)
    WebElement imageAddButton;
    @FindBy(name = ICON_ADD_BUTTON)
    WebElement iconAddButton;
    @FindBy(css = CREATE_BUTTON)
    WebElement createButton;
    public String getTextInPage() {
        return driver.getCurrentUrl().toString();
    }
    public void assertTextInPage(){
        assertThat(getTextInPage()).isEqualTo("http://localhost:8080/new");
    }



    public static final String TITLE_TEXT_FIELD = "title";
    public static final String DESCRIPTION = "description";
    public static final String CATEGORY = "category";
    public static final String IMAGE_ADD_BUTTON = "image";
    public static final String ICON_ADD_BUTTON = "icon";
    public static final String CREATE_BUTTON = "html body div.content form p input";



}
