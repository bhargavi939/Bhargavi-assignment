package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class HomePage {
    // This variable will hold the browser instance.
    private WebDriver driver;

    // These are the addresses for the elements on the page.
    private By loader = By.id("loadingAnimation");
    private By mainContent = By.id("mainContent");
    private By myDreamsButton = By.xpath("//button[text()='My Dreams']");

    // The constructor receives the browser instance from the test class.
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // --- Basic Actions ---

    // Navigates to the website URL.
    public void goTo() {
        driver.get("https://arjitnigam.github.io/myDreams/");
      
    }
   
    	
    public boolean isMainContentVisible() {
      return driver.findElement(mainContent).isDisplayed();
      
      }
   
    // Waits for the loading animation to disappear.
    public void waitForLoaderToFinish() {
        // This block forces a hard pause for 3 seconds.
        try {
            Thread.sleep(3000);// Pause for 3000 milliseconds
        } catch (InterruptedException e) {
            // This line handles a required Java exception for Thread.sleep
            e.printStackTrace();
        }
        
        // After the pause, we still wait for the loader to be invisible, just in case.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
    }
   /* public void waitForLoaderToFinish() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        
    }*/
    public boolean  isLoaderVisible() {
    	return driver.findElement(loader).isDisplayed();
    	
    }

    // Clicks the "My Dreams" button.
    public void clickMyDreamsButton() {
        driver.findElement(myDreamsButton).click();
    }
}