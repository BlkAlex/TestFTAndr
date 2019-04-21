package com.blk.testftandr;

import android.graphics.Point;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.Until;

class PageObject {
    public PageObject(UiDevice device, String packageName) {
        this.device = device;
    }
    UiDevice device;

    void pressNavigate(){
        device.wait(Until.findObject(By.clazz(ImageButton.class)), 20000).click();
    }

    void scroll(){
        UiScrollable appViews1 = new UiScrollable(new UiSelector().resourceId("com.fastaccess.github.debug:id/design_navigation_view"));

        try {
            appViews1.scrollIntoView(new UiSelector().resourceId("com.fastaccess.github.debug:id/design_menu_item_text").textContains("Settings"));
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }

    }
    void  swipeToLEft(){

        device.wait(Until.findObject(By.res("com.fastaccess.github.debug:id/premium")),10000);
      //  device.swipe(device.getDisplaySizeDp().x,device.getDisplaySizeDp().y/2,0,device.getDisplaySizeDp().y/2,30);
      //  device.swipe(701,570,39,570,30);
        device.swipe(device.getDisplayWidth()-20,device.getDisplayHeight()/2,20,device.getDisplayHeight()/2,30);
       //device.swipe(device.getDisplayWidth(),device.getDisplayHeight()/2,0,device.getDisplayHeight()/2,30);

    }
    void pressOnField(String name,int timeout){
        device.wait(Until.findObject(By.clazz(TextView.class).textContains(name)),timeout).click();
    }

    void setTextOnField(String name, int timeout, String text){
        UiObject2 field= device.wait(Until.findObject(By.clazz(EditText.class)),timeout);
        field.click();
        field.setText(text);
    }

    String getTextFromEditableField(String field){
        return device.wait(Until.findObject(By.clazz(EditText.class)),20000).getText();
    }
    void pressOnMenuField(String name){
        UiScrollable appViews1 = new UiScrollable(new UiSelector().resourceId("com.fastaccess.github.debug:id/design_navigation_view"));

        try {
            appViews1.scrollIntoView(new UiSelector().resourceId("com.fastaccess.github.debug:id/design_menu_item_text").textContains(name));
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }

        device.findObject(By.res("com.fastaccess.github.debug:id/design_menu_item_text").textContains(name)).click();
    }
    boolean isPageVisible(String page,int timeout){
        return device.wait(Until.findObject(By.clazz(TextView.class).textContains(page)),timeout) != null;
    }

    void scrollToElement(String name){
        UiScrollable appViews1 = new UiScrollable(new UiSelector().resourceId("com.fastaccess.github.debug:id/design_navigation_view"));

        try {
            appViews1.scrollIntoView(new UiSelector().resourceId("com.fastaccess.github.debug:id/mal_list_card_title").textContains(name));
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }

    }

    boolean checks(){
        UiObject2 obj = device.wait(Until.findObject(By.res("com.fastaccess.github.debug:id/mal_item_image")),10000);
        return (obj != null);
    }

    void pressConfirmButton(){
        device.wait(Until.findObject(By.res("com.fastaccess.github.debug:id/submit").clazz(TextView.class)),10000).click();
    }

    void pressSendButton(){
        device.wait(Until.findObject(By.res("com.fastaccess.github.debug:id/submit").clazz(ImageButton.class)),10000).click();
    }

    void clickOk(){
        device.wait(Until.findObject(By.res("android:id/button1")),10000).click();
    }
}
