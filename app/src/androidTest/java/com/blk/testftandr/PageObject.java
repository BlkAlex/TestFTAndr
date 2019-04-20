package com.blk.testftandr;

import android.widget.ImageButton;
import android.widget.TextView;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.Until;

class PageObject {
    public PageObject(UiDevice device, String packageName) {
        this.device = device;
    }
    UiDevice device;

    void pressNavigate(){
        device.wait(Until.findObject(By.clazz(ImageButton.class)), 20000).click();
    }
    void pressOnField(String name){
        device.findObject(By.res("com.fastaccess.github.debug:id/design_menu_item_text").textContains(name)).click();
    }
    boolean isPageVisible(String page,int timeout){
        return device.wait(Until.findObject(By.clazz(TextView.class).textContains(page)),timeout) != null;
    }
}
