package sprint.base;

import org.testng.annotations.*;

public class FormTest extends BaseUI {

    @BeforeClass
    public void testSetUp() {
        //invoke Browser
        invokeBrowser("browserName");

        // open Website
        openURL("websiteURL");
    }

    @Test
    public void testOne()
    {
        System.out.println("success");
    }

    @AfterClass
    public void endTest(){
        quit();
    }
}
