package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.BaseTest;

public class HomePageTest extends BaseTest {

    // Declare HomePage at the class level so all test methods can access it.
    private HomePage homePage;

    // This method runs once before any of the @Test methods in this class.
    // We'll navigate to the page here to avoid repeating it in every test.
    @BeforeClass
    public void pageSetup() {
        homePage = new HomePage(driver);
        System.out.println("🚀 GIVEN: The user is on the Dream Portal home page");
        homePage.goTo();
    }

    @Test(priority = 1, description = "Verify loading animation appears on page load.")
    public void testLoaderIsVisible() {
        Assert.assertTrue(homePage.isLoaderVisible(), "Test Case 1 FAILED: Loader was not visible initially.");
        System.out.println("TC_HomePage_01: Loader is visible initially -> Appears.-> ✅ Passed");
        		}
    @Test(priority = 2, description = "Verify loading animation disappears after ~3 seconds.")
    public void testLoaderDisappears() {
        homePage.waitForLoaderToFinish(); // This action is the core of the test
        // The success of this test is that the next step doesn't time out.
        System.out.println("TC_HomePage_02: Loader disappears after 3 seconds -> Not visible.-> ✅ Passed");
    }

    @Test(priority = 3, description = "Verify main content is visible after loader disappears.")
    public void testMainContentIsVisible() {
        Assert.assertTrue(homePage.isMainContentVisible(), "Test Case 3 FAILED: Main content was not visible.");
        System.out.println("TC_HomePage_03: Main content visible after loader -> Content shown.-> ✅ Passed");
    }

    @Test(priority = 4, description = "Verify 'My Dreams' button is clickable.")
    public void testMyDreamsButtonIsClickable() {
        homePage.clickMyDreamsButton(); // The test will fail if the button isn't clickable
        System.out.println("TC_HomePage_4: 'My Dreams' button is clickable -> Button works.-> ✅ Passed.");
    }

    @Test(priority = 5, description = "Verify clicking 'My Dreams' button opens two new tabs.")
    public void testNewTabsOpenOnClick() {
        int numberOfOpenTabs = driver.getWindowHandles().size();
        Assert.assertEquals(numberOfOpenTabs, 3, "Test Case 5 FAILED: Expected 3 tabs, but found " + numberOfOpenTabs);
        System.out.println("TC_HomePage_ 5: Clicking 'My Dreams' opens 2 new tabs -> " + numberOfOpenTabs + " tabs total.->✅ Passed.");
    }
}