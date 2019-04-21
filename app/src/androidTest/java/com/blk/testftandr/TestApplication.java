package com.blk.testftandr;

import android.content.Context;
import android.content.Intent;
import android.os.Build;

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

    public void presSendMesageButton(){
        page.pressSendButton();
    }

    public void pressConfirmButton(){
        page.pressConfirmButton();
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
    public void pressOnEditableField(String name,String text){
        page.setTextOnField(name,20000,text);
    }

    void scrollToBlock(String name){
        page.scrollToElement(name);
    }
    void clickOkDebugVersion(){
        page.clickOk();
    }
    void checkChangelogField(){
        page.checks();
    }
    void swipeToLeft(){
        page.swipeToLEft();
    }

    void compareDeviceInfoWithTextInField(String field,String text){
        String textInField = page.getTextFromEditableField(text);
        assertTrue(textInField.contains(Build.MANUFACTURER));
        assertTrue(textInField.contains(Build.BRAND));
        assertTrue(textInField.contains(Build.MODEL));
    }
    public void scroll(){
        page.scroll();
    }
    public void close() {
        device.pressHome();
    }
}
