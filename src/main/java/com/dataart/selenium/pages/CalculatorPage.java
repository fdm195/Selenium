package com.dataart.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by User on 22.12.2016.
 */
public class CalculatorPage extends BasicPage {
    @FindBy(xpath = INSTRUCTION_TEXY_XPATH)
    WebElement instructionText;
    @FindBy(id = X_TEXT_FIELD_ID)
    WebElement xTextField;
    @FindBy(id = Y_TEXT_FIELD_ID)
    WebElement yTextField;
    @FindBy(id = RESULT_TEXT_ID)
    WebElement resultTextField;
    @FindBy(id = SUMM_BUTTON_ID)
    WebElement cleackSummButton;
    @FindBy(xpath = GO_BECK_LINK_XPATH)
    WebElement goBeckLink;

    public CalculatorPage enterValidNumberInXAndY(){
    xTextField.clear();
    yTextField.clear();
    xTextField.sendKeys("23");
    yTextField.sendKeys("27");
    return initPage(CalculatorPage.class);
    }

    public CalculatorPage enterValidNumberAndString(){
        xTextField.clear();
        yTextField.clear();
        xTextField.sendKeys("23");
        yTextField.sendKeys("test");
        return initPage(CalculatorPage.class);
    }

    public void clickResultButton(){
        cleackSummButton.click();
    }
    public void assertPositivResultControl(){
        assertThat(getResult()).isEqualTo("Result is: 50.0");
    }
    public void assertNegativResultControl(){
        assertThat(getResult()).isEqualTo("Result is: Incorrect data");
    }
    public String getResult(){
    return driver.findElement(By.id("result")).getText();}



    public static final String INSTRUCTION_TEXY_XPATH = "//p[contains(text(), 'Simple calculator. Enter x and y, press the button, wait for result and verify it')]";
    public static final String X_TEXT_FIELD_ID = "x";
    public static final String Y_TEXT_FIELD_ID = "y";
    public static final String RESULT_TEXT_ID = "result";
    public static final String SUMM_BUTTON_ID = "calc";
    public static final String GO_BECK_LINK_XPATH = "//a[contains(text(), 'go back')]";
}
