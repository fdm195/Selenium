package com.dataart.selenium.pages;

import com.dataart.selenium.framework.BasePage;
import com.dataart.selenium.models.User;
import com.sun.jna.Structure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


/**
 * Created by User on 19.12.2016.
 */
public class RegistrationPage extends BasePage {
    @FindBy(name = NAME_TEXT_ID)
    WebElement userName;
    @FindBy(name = FIRSTNAME_TEXT)
    WebElement fistnameText;
    @FindBy(name = LASTNAME_TEXT)
    WebElement lastnameText;
    @FindBy(name = USER_PASSWORD)
    WebElement passwordText;
    @FindBy(name = USER_PASSWORD_CONFIRM)
    WebElement passwordTextConfirm;
    @FindBy(name = USER_ROLE)
    WebElement userRole;
    @FindBy(xpath = REGISTR_BUTTON_XPATH)
    WebElement registrButton;
    public RegistrationPage registrationUser(User user) {
        userName.clear();
        fistnameText.clear();
        lastnameText.clear();
        passwordText.clear();
        passwordTextConfirm.clear();
        userName.sendKeys(user.getUsername());
        fistnameText.sendKeys(user.getFname());
        lastnameText.sendKeys(user.getLname());
        passwordText.sendKeys(user.getPassword());
        passwordTextConfirm.sendKeys(user.getPassword());
        return initPage(RegistrationPage.class);
    }
    public RegistrationPage selectRoleUser(){
        WebElement selectgender = driver.findElement(By.name("role"));
        selectgender.sendKeys("USER");
        return initPage(RegistrationPage.class);
    }

    public RegistrationPage selectRoleDeveloper(){
        WebElement selectgender = driver.findElement(By.name("role"));
        selectgender.sendKeys("DEVELOPER");
        return initPage(RegistrationPage.class);
    }

    public void clickRegistrButton(){
        registrButton.click();
    }

    public RegistrationPage getRegistrationPage() {
        return initPage(RegistrationPage.class);
    }




    public static final String NAME_TEXT_ID = "name";
    public static final String FIRSTNAME_TEXT = "fname";
    public static final String LASTNAME_TEXT = "lname";
    public static final String USER_PASSWORD="password";
    public static final String USER_PASSWORD_CONFIRM = "passwordConfirm";
    public static final String USER_ROLE="role";
    public static final String REGISTR_BUTTON_XPATH = "//input[@value='Register']";


}
