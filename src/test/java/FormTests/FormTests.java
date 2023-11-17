package FormTests;

import FormTests.Pages.FormPage;
import FormTests.TestBase.FormTestBase;
import FormTests.Utils.RandomDataGenerator;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static FormTests.Utils.FileManager.getFileFromResources;
import static FormTests.Utils.RandomDataGenerator.getRandomOption;
import static org.assertj.core.api.Assertions.assertThat;

public class FormTests extends FormTestBase {

    @RepeatedTest(10)
    public void shouldFillFormTest() {
        FormPage formPage = new FormPage(driver);
        String message = formPage.setFirstname("Jacek")
                .setLastname("Góralski")
                .setEmail("jacek@gmail.com")
                .selectSexBtn(getRandomOption(RandomDataGenerator.sex))
                .setAge("31")
                .selectExpBtn(RandomDataGenerator.getRandomExp())
                .selectProfession(getRandomOption(RandomDataGenerator.professions))
                .selectContinent(getRandomOption(RandomDataGenerator.continents))
                .selectSeleniumCommands(List.of("wait-commands", "switch-commands"))
                .sendFile(getFileFromResources("test.txt"))
                .submitForm()
                .getMessage();
        assertThat(message).isEqualTo("Form send with success");


    }



}