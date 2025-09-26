package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.DreamTotalPage;

import utils.BaseTest;

import java.util.*;

public class DreamsTotalTest extends BaseTest {
    
    // Class-level variables to store the data read from the page
    private List<String> allTypes;
    private List<String> allNames;
    
    @BeforeClass
    public void setupAndCalculateData() {
        System.out.println("\n Reading data from the diary table to verify statistics...");
        DreamTotalPage dreamsPage = new DreamTotalPage(driver);
        dreamsPage.goToDiaryPage();
        
        // --- GET DATA ONCE ---
        allTypes = dreamsPage.getAllDreamTypes();
        allNames = dreamsPage.getAllDreamNames();
    }

    @Test(priority = 1, description = "Verify Good Dreams count")
    public void testGoodDreamsCount()  {
    	
        long goodDreams = allTypes.stream().filter(type -> type.equals("Good")).count();
        Assert.assertEquals(goodDreams, 6);
        System.out.println("TC_Total_01: Good Dreams = " + goodDreams + " -> ✅ Passed.");
    }

    @Test(priority = 2, description = "Verify Bad Dreams count")
    public void testBadDreamsCount()  {
    	
        long badDreams = allTypes.stream().filter(type -> type.equals("Bad")).count();
        Assert.assertEquals(badDreams, 4);
        System.out.println("TC_Total_02: Bad Dreams = " + badDreams + " -> ✅ Passed.");
    }

    @Test(priority = 3, description = "Verify Total Dreams count")
    public void testTotalDreamsCount() {
        Assert.assertEquals(allTypes.size(), 10);
        System.out.println("TC_Total_03: Total Dreams = " + allTypes.size() + " -> ✅ Passed.");
    }

    @Test(priority = 4, description = "Verify Recurring Dreams count")
    public void testRecurringDreamsCount()  {
    	
        Map<String, Long> nameCounts = new HashMap<>();
        for (String name : allNames) {
            nameCounts.put(name, nameCounts.getOrDefault(name, 0L) + 1);
        }
        long recurringCount = nameCounts.values().stream().filter(count -> count > 1).count();
        Assert.assertEquals(recurringCount, 2);
        System.out.println("TC_Total_04: Recurring Dreams = " + recurringCount + " -> ✅ Passed.");
    }

    @Test(priority = 5, description = "Verify Recurring Dream Names")
    public void testRecurringDreamNames() {
        Map<String, Long> nameCounts = new HashMap<>();
        for (String name : allNames) {
            nameCounts.put(name, nameCounts.getOrDefault(name, 0L) + 1);
        }
        
        List<String> recurringNames = new ArrayList<>();
        for (Map.Entry<String, Long> entry : nameCounts.entrySet()) {
            if (entry.getValue() > 1) {
                recurringNames.add(entry.getKey());
            }
        }
        
        List<String> expectedNames = Arrays.asList("Flying over mountains", "Lost in maze");
        Collections.sort(recurringNames);
        Collections.sort(expectedNames);
        
        Assert.assertEquals(recurringNames, expectedNames);
        System.out.println("TC_Total_05: Recurring dream names match expected -> " + recurringNames);
    }
}