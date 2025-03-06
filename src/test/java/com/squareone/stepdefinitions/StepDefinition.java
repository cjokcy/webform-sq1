package com.squareone.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import com.squareone.context.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.squareone.pages.WebFormPage;
import org.testng.Assert;


public class StepDefinition {

    private final WebFormPage webFormPage = new WebFormPage(DriverManager.getDriver());
    WebDriver driver = DriverManager.getDriver();


    @Given("the user is landing on the form")
    public void webFormLaunch() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @And("the user fill out the below fields with valid data")
    public void givenUserFillsOutFields(DataTable table) {
        String textInput = table.cell(1, 0);
        String password = table.cell(1, 1);
        String textarea = table.cell(1, 2);

        webFormPage.enterTextInput(textInput);
        webFormPage.enterPassword(password);
        webFormPage.enterTextArea(textarea);
    }

    @And("validate whether disable input is disabled or not")
    public void thenValidateDisabledInput() {
        boolean isDisabled = !webFormPage.disabledInput();
        Assert.assertTrue(isDisabled, "The disabled input field is not disabled!");
    }

    @And("validate readonly input field allow text to be read")
    public void thenValidateReadonlyInput() {
        String value = webFormPage.readOnlyInput();
        Assert.assertEquals(value, "Readonly input", "Readonly input value is not as expected!");
    }

    @And("the user selects dropdown option as {string} and datalist as {string}")
    public void givenUserSelectsDropdownAndDatalist(String dropdownOption, String datalistOption) {
        webFormPage.dropdownSelect(dropdownOption);
        webFormPage.dataList(datalistOption);
    }

    @And("the user uploads a file")
    public void givenUserUploadsFile() {
        webFormPage.fileUpload("src/test/resources/files/autofile.png");
    }

    @And("the user uncheck the checked checkbox and checks the default checkbox")
    public void givenUserUnchecksAndChecksCheckbox() {
        webFormPage.checkedCheckBoxUnCheck();
        webFormPage.checkDefaultCheckBox();
    }

    @And("the user selects the Default radio button")
    public void givenUserSelectsRadioButton() {
       webFormPage.selectDefaultRadioButton();
    }

    @And("the user change the colour to {string} and date picker as {string}")
    public void theUserChangeTheColourToAndDatePickerAs(String setColor, String date) {

        String existingColor = webFormPage.getSelectedColor();
        webFormPage.changeColorPicker(setColor);
        Assert.assertNotEquals(setColor, existingColor);
        String retrieveTheNewColor = webFormPage.getSelectedColor();
        Assert.assertEquals(setColor.toLowerCase(), retrieveTheNewColor);
        webFormPage.dateSelection(date);
    }

    @And("the user sets the example range")
    public void givenUserSetsRange()  {

        WebElement slider = driver.findElement(By.name("my-range"));

        Actions move = new Actions(driver);
        move.clickAndHold(slider).moveByOffset(50, 0).release().perform();
    }

    @And("the user submit the form")
    public void givenUserSubmitsForm() {
        webFormPage.formSubmit();
    }

    @And("the user see a confirmation message as below")
    public void thenUserSeesConfirmation(DataTable table) {
        String formSubmittedMsg = table.cell(0,0);
        String receivedMsg = table.cell(1, 0);
        Assert.assertEquals(webFormPage.formSubmissionMessage(), formSubmittedMsg, "FormSubmitted message did not match. Expected: " + formSubmittedMsg + " but got: " + webFormPage.formSubmissionMessage());
        Assert.assertEquals(webFormPage.receivedMessage(), receivedMsg, "Received message did not match. Expected: " + receivedMsg + " but got: " + webFormPage.receivedMessage());
    }

}
