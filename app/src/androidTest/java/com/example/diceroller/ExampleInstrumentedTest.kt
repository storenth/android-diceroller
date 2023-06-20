package com.example.diceroller

import java.io.File

import android.util.Log
import android.content.Context
import android.content.Intent

import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import androidx.test.uiautomator.UiObject2

import org.junit.Test
import org.junit.Before
import org.junit.Assert.*
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
private const val BASIC_SAMPLE_PACKAGE = "com.example.diceroller"
private const val LAUNCH_TIMEOUT = 5000L
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    private lateinit var device: UiDevice
    private val tag = "androidTest"
    @Before
    fun startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        // Start from the home screen
        device.pressHome()

        // Wait for launcher
        val launcherPackage: String = device.launcherPackageName
        assertFalse("Failed to launch the dev app", launcherPackage.isEmpty())
        device.wait(
            Until.hasObject(By.pkg(launcherPackage).depth(0)),
            LAUNCH_TIMEOUT
        )

        // Launch the app
        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager.getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE)
        intent?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)

        // Wait for the app to appear
        device.wait(
            Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
            LAUNCH_TIMEOUT
        )
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.diceroller", appContext.packageName)
    }
    @Test
    fun takeScreenshot() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val path = File(appContext.getExternalFilesDir("screenshots"), "1.png")
        Log.v(tag, "Save screenshot: $path")
        device.takeScreenshot(path)

        Log.v(tag, device.productName)
        assertEquals(0, device.displayRotation)
    }
    @Test
    fun getWidgetAllText() {
        val wdgt = device.findObject(By.text("Hello Android!"))
        Log.v(tag, "wdgt=${wdgt.text}")
        Log.v(tag, "wdgt=${wdgt.className}")
        Log.v(tag, "wdgt=${wdgt.displayId}")
        Log.v(tag, "wdgt=${wdgt.resourceName}")
        Log.v(tag, "wdgt=${wdgt.parent}")

        val widgets = device.findObjects(By.clazz(android.widget.TextView::class.java))
        for (view in widgets) {
            Log.v(tag, "view.text=${view.text}")  // `11:20` (current time clock) & `Hello Android!`
            Log.v(tag, "view.className=${view.className}")  // android.widget.TextView
            Log.v(tag, "view.displayId=${view.displayId}")  // 0
            Log.v(tag, "view.isFocused=${view.isFocused}")  // false
            Log.v(tag, "view.isClickable=${view.isClickable}")  // false
            Log.v(tag, "view.isSelected=${view.isSelected}")  // false
            Log.v(tag, "view.resourceName=${view.resourceName}")  // null & com.android.systemui:id/clock
            Log.v(tag, "view.parent=${view.parent}")  // androidx.test.uiautomator.UiObject2@ab98f
        }
        assertTrue(widgets.any {it.text == "Hello Android!"})
    }
}