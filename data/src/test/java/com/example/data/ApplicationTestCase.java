package com.example.data;

import android.content.Context;

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.model.Statement;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/**
 * Created by tinyfight on 2018/4/15.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, application = ApplicationStub.class, sdk = 26)
public abstract class ApplicationTestCase {
    @Rule
    public TestRule injectMocksRule = new TestRule() {
        @Override
        public Statement apply(Statement base, Description description) {
            MockitoAnnotations.initMocks(ApplicationTestCase.this);
            return base;
        }
    };

    public static Context context() {
        return RuntimeEnvironment.application;
    }

}
