package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DreamTotalPage {
    private WebDriver driver;

    // Correct XPaths for table columns
    private By dreamNamesColumn = By.xpath("//table//tbody/tr/td[1]");
    private By dreamTypesColumn = By.xpath("//table//tbody/tr/td[3]");

    public DreamTotalPage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate directly to diary page
    public void goToDiaryPage() {
        driver.get("https://arjitnigam.github.io/myDreams/dreams-diary.html");
        System.out.println("Opened page: " + driver.getTitle());
    }
    
    	     
    	    public List<String> getAllDreamNames() {
    	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(dreamNamesColumn));

    	        List<String> names = new ArrayList<>();
    	        List<WebElement> cells = driver.findElements(dreamNamesColumn);
    	        for (WebElement cell : cells) {
    	            names.add(cell.getText().trim());
    	        }
    	        return names;
    	    }
    // Get all dream types (Good/Bad)
    public List<String> getAllDreamTypes() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(dreamTypesColumn));

        List<String> types = new ArrayList<>();
        for (WebElement cell : driver.findElements(dreamTypesColumn)) {
            types.add(cell.getText().trim());
        }
       // System.out.println("Dream Types: " + types);
        return types;
    }

	

    
}
