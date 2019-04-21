package com.blk.testftandr;

import android.content.Context;
import android.content.Intent;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;

import static org.junit.Assert.assertTrue;

public class TestApplication {

    private UiDevice device;
    private PageObject page;

    public TestApplication() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        device.pressHome();

        // Get launch intent
        String packageName = "";
        Context context = InstrumentationRegistry.getInstrumentation().getContext(); //gets the context based on the instrumentation

        Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.fastaccess.github.debug");  //sets the intent to start your app
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);  //clear out any previous task, i.e., make sure it starts on the initial screen
        context.startActivity(intent);

        // Stat application
        context.startActivity(intent);

        // Get page objects
        page = new PageObject(device, packageName);
    }

    public void checkOpenActivity(String activityName) {
        assertTrue(page.isPageVisible(activityName,20000));
    }

    public void openNavigationBar() {

        page.pressNavigate();
    }

    public void clickOnMenuField(String name) {
        page.pressOnMenuField(name);
    }
    public void pressOnField(String name){
        page.pressOnField(name,20000);
    }

    void swipeToLeft(){
        page.swipeToLEft();
    }
    public void scroll(){
        page.scroll();
    }
    public void close() {
        device.pressHome();
    }
}
