package com.example.diceroller

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import java.io.File


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    private val tag = "androidTest"
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.diceroller", appContext.packageName)
    }
    @Test
    fun textOnBackground() {
        // Text rendered after app is booted.
        val device: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val path = File(appContext.getExternalFilesDir("screenshots"), "1.png")
        Log.v(tag, "Save screenshot: $path")
        device.takeScreenshot(path)

        device.pressHome()
        Log.v(tag, device.productName)
        assertEquals(0, device.displayRotation)

    }
}