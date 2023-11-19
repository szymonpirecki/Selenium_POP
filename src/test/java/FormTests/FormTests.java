package FormTests;

import FormTests.Pages.FormPage;
import FormTests.TestBase.FormTestBase;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static FormTests.Utils.FileManager.getFileFromResources;
import static FormTests.Utils.FormOptionsFetcher.*;
import static FormTests.Utils.RandomDataGenerator.getRandomOption;
import static org.assertj.core.api.Assertions.assertThat;

public class FormTests extends FormTestBase {

    @RepeatedTest(10)
    public void shouldFillFormTest() {
        FormPage formPage = new FormPage(driver);
        String message = formPage.setFirstname("Jacek")
                .setLastname("Góralski")
                .setEmail("jacek@gmail.com")
                .selectSexBtn(getRandomOption(getOptionsFromRadioButtons(formPage.getSexRadioBtns())))
                .setAge("31")
                .selectExpBtn(getRandomOption(getOptionsFromRadioButtons(formPage.getExpRadioBtns())))
                .selectProfession(getRandomOption(getOptionsFromCheckboxes(formPage.getProfessionCheckboxes())))
                .selectContinent(getRandomOption(getOptionsFromSelect(formPage.getContinentSelect())))
                .selectSeleniumCommands(List.of("wait-commands", "switch-commands"))
                .sendFile(getFileFromResources("test.txt"))
                .submitForm()
                .getMessage();
        assertThat(message).isEqualTo("Form send with success");
    }
}