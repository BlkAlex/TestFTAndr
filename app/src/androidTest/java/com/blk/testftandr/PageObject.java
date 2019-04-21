package com.blk.testftandr;

import android.graphics.Point;
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
}
