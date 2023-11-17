package TableTests.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class TablePage {

    public TablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "tbody tr")
    private List<WebElement> rows;

    public List<TableRowPage> getRows() {
        List<TableRowPage> rowPages = new ArrayList<>();
        for (WebElement row : rows) {
            rowPages.add(new TableRowPage(row));
        }
        return rowPages;
    }


}
