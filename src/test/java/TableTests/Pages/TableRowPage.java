package TableTests.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class TableRowPage {

    public TableRowPage(WebElement parent) {
        PageFactory.initElements(new DefaultElementLocatorFactory(parent), this);
    }

    @FindBy(css = "th")
    private WebElement rank;

    @FindBy(xpath = "./td[1]")
    private WebElement peak;

    @FindBy(xpath = "./td[2]")
    private WebElement mountainRange;

    @FindBy(xpath = "./td[3]")
    private WebElement state;

    @FindBy(xpath = "./td[4]")
    private WebElement height;


    public String getPeak(){
        return peak.getText();
    }

    public int getHeight(){
        return Integer.parseInt(height.getText());
    }

    public String getState(){
        return state.getText();
    }
}

