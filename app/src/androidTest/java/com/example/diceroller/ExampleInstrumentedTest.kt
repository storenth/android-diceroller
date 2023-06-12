package com.example.diceroller

import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiObject2

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

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
        var device: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        Log.v(tag, device.currentPackageName)
        device.pressHome()
        Log.v(tag, device.currentPackageName)
        Log.v(tag, device.productName)
        assertEquals(0, device.displayRotation)

    }
}