package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DreamsDiaryPage;
import utils.BaseTest;
// ... other imports

public class DreamDiaryPageTest extends BaseTest {
    
    private DreamsDiaryPage dreamsDiaryPage;

    // The @BeforeClass setup for navigation remains the same.
    @BeforeClass
    public void pageSetup() {
        // ... navigation and tab switching logic ...
        dreamsDiaryPage = new DreamsDiaryPage(driver);
    }
    
    @Test(priority = 1, description = "Validate exactly 10 dream entries.")
    public void testRowCount() throws InterruptedException {
    	Thread.sleep(3000);
        // We directly call the check method and provide the expected value.
        dreamsDiaryPage.getDreamRowCount(10);
        System.out.println("TC_Diary_1: Row count = 10 -> Passed.");
    }

    @Test(priority = 2, description = "Dream types are only Good or Bad.")
    public void testDreamTypesAreValid() throws InterruptedException {
    	Thread.sleep(3000);
        // This method will cause the test to fail if any type is invalid.
        dreamsDiaryPage.getDreamTypes();
        System.out.println("TC_Diary_2: Dream type column contains only Good/Bad -> Passed.");
    }
    

    @Test(priority = 3, description = "Each row has 3 filled columns.")
    public void testAllRowsAreFilled() throws InterruptedException {
    	Thread.sleep(3000);
        // This method will cause the test to fail if any cell is blank.
        dreamsDiaryPage.areAllRowsFilled();
        System.out.println("TC_Diary_3: Each row has all 3 columns filled (no blanks) -> Passed.");
    }
}

