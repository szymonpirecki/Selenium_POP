package TableTests;

import TableTests.Pages.TablePage;
import TableTests.Pages.TableRowPage;
import TableTests.TestBase.TableTestBase;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TableTests extends TableTestBase {

    @RepeatedTest(10)
    public void shouldReturnAllSwissMountainsHigherThan4KTest() {
        List<String> expectedResult = List.of("Dufourspitze", "Dom", "Weisshorn", "Matterhorn", "Finsteaarhorn", "Jungfrau");
        TablePage tablePage = new TablePage(driver);
        List<String> filteredMountains = tablePage.getRows().stream()
                .filter(r -> r.getHeight() > 4000)
                .filter(r -> r.getState().contains("Switzerland"))
                .map(TableRowPage::getPeak)
                .toList();
        assertThat(filteredMountains).containsExactlyInAnyOrderElementsOf(expectedResult)
                .size().isEqualTo(6);
    }
}
