package FormTests.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class FormPage {

    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#inputFirstName3")
    private WebElement firstnameInput;

    @FindBy(css = "#inputLastName3")
    private WebElement lastnameInput;

    @FindBy(css = "#inputEmail3")
    private WebElement emailInput;

    @FindAll(@FindBy(css = "[name=gridRadiosSex]"))
    private List<WebElement> sexRadioBtns;

    @FindBy(css = "#inputAge3")
    private WebElement ageInput;

    @FindAll(@FindBy(css = "[name=gridRadiosExperience]"))
    private List<WebElement> expRadioBtns;

    @FindAll(@FindBy(css = "[name='gridCheckboxProfession'] +label "))
    private List<WebElement> professionCheckboxes;

    @FindBy(css = "#selectContinents")
    private WebElement continentsSelect;

    @FindBy(css = "#selectSeleniumCommands")
    private WebElement selectSeleniumCommands;

    @FindBy(css = "#chooseFile")
    private WebElement sendFileInput;

    @FindBy(css = ".btn[type='submit']")
    private WebElement submitBtn;

    @FindBy(css = "#validator-message")
    private WebElement finalMessage;

    public FormPage setFirstname(String firstname) {
        firstnameInput.sendKeys(firstname);
        return this;
    }

    public FormPage setLastname(String lastname) {
        lastnameInput.sendKeys(lastname);
        return this;
    }

    public FormPage setEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public FormPage setAge(String age) {
        ageInput.sendKeys(age);
        return this;
    }

    public List<WebElement> getSexRadioBtns() {
        return sexRadioBtns;
    }

    public FormPage selectSexBtn(String sex) {
        for (WebElement sexBtn : sexRadioBtns) {
            if (sexBtn.getAttribute("value").equalsIgnoreCase(sex)) {
                sexBtn.click();
            }
        }
        return this;
    }

    public FormPage selectExpBtn(String yearOfExp) {
        for (WebElement expBtn : expRadioBtns) {
            if (expBtn.getAttribute("value").equals(yearOfExp)) {
                expBtn.click();
            }
        }
        return this;
    }

    public List<WebElement> getExpRadioBtns() {
        return expRadioBtns;
    }

    public FormPage selectProfession(String profession) {
        for (WebElement prof : professionCheckboxes) {
            if (prof.getText().equalsIgnoreCase(profession)) prof.click();
        }
        return this;
    }

    public List<WebElement> getProfessionCheckboxes() {
        return professionCheckboxes;
    }

    public FormPage selectContinent(String continent) {
        Select select = new Select(continentsSelect);
        select.selectByValue(continent);
        return this;
    }

    public WebElement getContinentSelect() {
        return continentsSelect;
    }

    public FormPage selectSeleniumCommands(List<String> commands) {
        Select select = new Select(selectSeleniumCommands);
        for (String command : commands) {
            select.selectByValue(command);
        }
        return this;
    }

    public FormPage sendFile(File file) {
        String absolutePath = file.getAbsolutePath();
        sendFileInput.sendKeys(absolutePath);
        return this;
    }

    public FormPage submitForm() {
        submitBtn.click();
        return this;
    }

    public String getMessage() {
        return finalMessage.getText();
    }
}
