package com.blk.testftandr;
import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;
import androidx.test.uiautomator.UiDevice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
public class ExampleInstrumentedTest {
    private TestApplication myApp;

    @Before
    public void setUp() throws Exception {
        myApp = new TestApplication();
//        MockitoAnnotations.initMocks(this);
//        final TiPresenterInstructor<LoginMvp.View> instructor = new TiPresenterInstructor<>(new LoginPresenter());
//        instructor.attachView(view);
    }

    @Test public void onTokenResponse() throws Exception {
        myApp.openNavigationBar();
        myApp.clickOnField("Trending");
        myApp.checkOpenActivity("Trending");
    }

    @Test public void onHandleAuthIntent() throws Exception {

    }

    @Test public void onUserResponse() throws Exception {

    }

    @Test public void login() throws Exception {

    }

}
