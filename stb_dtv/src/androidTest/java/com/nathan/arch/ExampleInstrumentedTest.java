package com.nathan.arch;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.nathan.arch.presentation.presenters.IDVBPlayPresenter;
import com.nathan.arch.presentation.presenters.impl.IDVBPlayPresenterImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;



import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
     private IDVBPlayPresenter mIDVBPlayPresenter;
     private IDVBPlayPresenter.Callback mMockedCallback;


    @Before
    public void setUp() throws Exception {
        mIDVBPlayPresenter = new IDVBPlayPresenterImpl();
        mIDVBPlayPresenter.attach(mMockedCallback);
    }

    @Test
    public void testWelcomeMessageNotFound() throws Exception {
        System.out.println(mIDVBPlayPresenter.getCurrentChannelInfo());

    }
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.nathan.arch.test", appContext.getPackageName());
    }
}
