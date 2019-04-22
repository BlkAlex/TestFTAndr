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
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.fastaccess.github.debug");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
        page = new PageObject(device);
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

    public void pressOnMenuField(String name) {
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

    void pressOkDebugVersion() {
        page.pressOk();
    }
    void checkChangelogField(){
        page.isConfirmVisible();
    }

    void swipeFromRight() {
        page.swipeFromRight();
    }

    void pressConfirmThemeButton() {
        page.pressConfirmThemeButton();
    }

    void compareDeviceInfoWithTextInField() {
        String textInField = page.getTextFromEditableField();
        assertTrue(textInField.contains(Build.MANUFACTURER));
        assertTrue(textInField.contains(Build.BRAND));
        assertTrue(textInField.contains(Build.MODEL));
    }

}
