package com.foodnow.tests;

import com.foodnow.fw.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() {
        app.init();

    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        app.stop();
    }
}
