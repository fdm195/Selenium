package com.dataart.selenium.pages;

import com.dataart.selenium.framework.BasePage;
import com.dataart.selenium.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.dataart.selenium.framework.Utils.isElementPresent;
import static com.dataart.selenium.pages.BasicPage.registrationRg;

public class LoginPage extends BasePage {

    @FindBy(id = USER_NAME_TEXT_FIELD_ID)
    WebElement userNameTextField;
    @FindBy(id = USER_PASSWORD_TEXT_FIELD_ID)
    WebElement passwordTextField;
    @FindBy(xpath = LOGIN_BUTTON_XPATH)
    WebElement loginButton;

    public HomePage loginAs(User user) {
        login(user);
        return initPage(HomePage.class);
    }

    public LoginPage incorectLoginAs(User user) {
        login(user);
        return initPage(LoginPage.class);
    }

    private void login(User user){
        userNameTextField.clear();
        passwordTextField.clear();
        userNameTextField.sendKeys(user.getUsername());
        passwordTextField.sendKeys(user.getPassword());
        loginButton.click();
    }

    public boolean isLoginButtonPresent(){
        return isElementPresent(By.xpath(LOGIN_BUTTON_XPATH));
    }

    public RegistrationPage clickRegisterLink() {
        driver.findElement(By.linkText(REGISTER_LINK_TEXT)).click();
        return initPage(RegistrationPage.class);
    }

    public static final String USER_NAME_TEXT_FIELD_ID = "j_username";
    public static final String USER_PASSWORD_TEXT_FIELD_ID = "j_password";
    public static final String LOGIN_BUTTON_XPATH = "//input[@value='Login']";
    public static final String REGISTER_LINK_TEXT = "Register as a new user";
}
