package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DreamsDiaryPage {
    private WebDriver driver;

    // Locators for the dream diary table
    private By dreamTableRows = By.id("dreamsDiary");

    public DreamsDiaryPage(WebDriver driver) {
        this.driver = driver;
    }

    // --- Page Data Retrieval Methods ---

    /**
     * Gets the total number of dream entries (rows) in the table.
     * @param  
     * @return The count of rows.
     */
    public int getDreamRowCount(int i) {
        return driver.findElements(dreamTableRows).size();
    }

    /**
     * Extracts the text from the 'Dream Type' column for every row.
     * @return A list of strings, e.g., ["Good", "Bad", "Good", ...].
     */
    public List<String> getDreamTypes() {
        List<String> dreamTypes = new ArrayList<>();
        List<WebElement> rows = driver.findElements(dreamTableRows);

        // Loop through each row and get the text from the 3rd column (td)
        for (WebElement row : rows) {
           // String dreamType = row.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String dreamType = row.findElement(By.xpath("//th[normalize-space()='Dream Type']")).getText();
            dreamTypes.add(dreamType);
        }
        return dreamTypes;
    }

public boolean areAllRowsFilled() {
    List<WebElement> rows = driver.findElements(dreamTableRows);
    for (WebElement row : rows) {
        List<WebElement> columns = row.findElements(By.tagName("td"));
        if (columns.size() != 3) return false;
        for (WebElement column : columns) {
            if (column.getText().trim().isEmpty()) {
                return false; // Found a blank cell
            }
        }
    }
    return true; // All cells are filled
}
}

