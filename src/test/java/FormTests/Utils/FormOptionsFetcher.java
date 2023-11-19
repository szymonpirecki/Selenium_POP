package FormTests.Utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FormOptionsFetcher {

    public static List<String> getOptionsFromRadioButtons(List<WebElement> buttons) {
        return buttons.stream()
                .map(b -> b.getAttribute("value"))
                .toList();
    }

    public static List<String> getOptionsFromCheckboxes(List<WebElement> checkboxes) {
        return checkboxes.stream()
                .map(WebElement::getText)
                .toList();
    }

    public static List<String> getOptionsFromSelect(WebElement select) {
        return new Select(select).getOptions().stream()
                .filter(o -> !o.getAttribute("value").isBlank())
                .map(o -> o.getAttribute("value"))
                .toList();
    }
}
