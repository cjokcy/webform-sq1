package com.squareone.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Paths;
import java.util.Objects;

public class WebFormPage {

    public WebFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "my-text-id")
    private WebElement textInput;

    @FindBy(name = "my-password")
    private WebElement password;

    @FindBy(name = "my-textarea")
    private WebElement textarea;

    @FindBy(name = "my-disabled")
    private WebElement disabledInput;

    @FindBy(name = "my-readonly")
    private WebElement readOnlyInput;

    @FindBy(name = "my-select")
    private WebElement dropdownSelect;

    @FindBy(name = "my-datalist")
    private WebElement dataList;

    @FindBy(name = "my-file")
    private WebElement fileUpload;

    @FindBy(id = "my-check-1")
    private WebElement checkedCheckBox;

    @FindBy(id = "my-check-2")
    private WebElement defaultCheckBox;

    @FindBy(id = "my-radio-2")
    private WebElement defaultRadioButton;

    @FindBy(name = "my-colors")
    private WebElement colorPicker;

    @FindBy(name = "my-date")
    private WebElement datePicker;

    @FindBy(name = "my-range")
    private WebElement exampleRange;

    @FindBy(name = "my-colors")
    private WebElement colorpicker;

    @FindBy(css = ".btn")
    private WebElement submit;

    @FindBy(css = ".display-6")
      private WebElement formSubmittedMsg;

    @FindBy(id = "message")
    private WebElement receivedMsg;




    public void enterTextInput(String inputText) {
        textInput.sendKeys(inputText);
    }

    public void enterPassword(String passwordText) {
        password.sendKeys(passwordText);
    }

    public void enterTextArea(String textAreaInput) {
        textarea.sendKeys(textAreaInput);
    }

    public boolean disabledInput() {
        return disabledInput.isEnabled();
    }

    public String readOnlyInput() {
        return readOnlyInput.getAttribute("value");
    }

    public void dropdownSelect(String dropDownInput) {
        Select dropdown = new Select(dropdownSelect);
        dropdown.selectByVisibleText(dropDownInput);
    }

    public void dataList(String dataListInput) {
        dataList.sendKeys(dataListInput);
    }

    public void fileUpload(String path)  {

        String filePath = Paths.get("src", "test", "resources", "files", "autofile.png")
                .toAbsolutePath()
                .toString();

        fileUpload.sendKeys(filePath);
    }

    public void checkedCheckBoxUnCheck(){
        if (checkedCheckBox.isSelected()) {
            checkedCheckBox.click();
        }
    }

    public void checkDefaultCheckBox(){
        if (!defaultCheckBox.isSelected()) {
            defaultCheckBox.click();
        }
    }

    public void selectDefaultRadioButton(){
        if (!defaultRadioButton.isSelected()) {
            defaultRadioButton.click();
        }
    }

    public String getSelectedColor() {
        Objects.requireNonNull(colorPicker, "Color picker element not found.");
        return colorPicker.getAttribute("value");
    }

    public void changeColorPicker(String color) {
        colorPicker.sendKeys(color);
    }

    public void dateSelection(String dateInput){
        datePicker.sendKeys(dateInput);
        datePicker.sendKeys(Keys.TAB);
    }


    public void formSubmit(){
        submit.click();
    }

    public String formSubmissionMessage(){
       return formSubmittedMsg.getText();
    }

    public String receivedMessage(){
       return receivedMsg.getText();
    }

}
