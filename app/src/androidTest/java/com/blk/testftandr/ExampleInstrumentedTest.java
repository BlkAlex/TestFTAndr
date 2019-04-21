package com.blk.testftandr;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
public class ExampleInstrumentedTest {
    private TestApplication myApp;

    @Before
    public void setUp()  {
        myApp = new TestApplication();
    }

    @Test public void testTrending()  {
        myApp.openNavigationBar();
        myApp.clickOnMenuField("Trending");
        myApp.checkOpenActivity("Trending");
    }

    @Test public void testTheme()  {
        myApp.openNavigationBar();
        myApp.clickOnMenuField("Settings");
        myApp.pressOnField("Theme");
        myApp.swipeToLeft();
    }

    @Test public void testRestorePurchases()  {
        myApp.openNavigationBar();
        myApp.clickOnMenuField("Restore Purchases");
    }

    @Test public void testSendFeedback()  {
        myApp.openNavigationBar();
        myApp.clickOnMenuField("Send feedback");
        myApp.clickOkDebugVersion();
        myApp.pressOnEditableField("Title","hello");
        myApp.pressOnField("Description");
        myApp.compareDeviceInfoWithTextInField("android.widget.EditText","FastHub Version");
        myApp.pressConfirmButton();
        myApp.presSendMesageButton();
    }


    @Test public void testAbout()  {
        myApp.openNavigationBar();
        myApp.clickOnMenuField("About");
        myApp.scrollToBlock("About");
        myApp.checkChangelogField();
    }


}
