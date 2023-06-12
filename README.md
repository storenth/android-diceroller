# android-diceroller
Basic activity app covered with tests using CI/CD practice

## First time Android
- android SDK 34
- android build tools
- android emulator
- google processor APIs

## Usage
- Use `./gradlew connectedAndroidTest` to run the tests on a connected emulator or device.
- Use `./gradlew test` to run the unit test on your local host.

## Roadmap
1. Use UI Automator locally
2. Use UI Automator on CI
3. BeforTest with build task
4. BeforTest with prebuilt app

## UI tests (Instrumented tests)
Instrumented tests run on Android devices, whether physical or emulated. As such, they can take advantage of the Android framework APIs. 
Instrumented tests therefore provide more fidelity than local tests, though they run much more slowly.
UI tests are usually Instrumented tests that verify the correct behavior of the UI.
### CI integration
[Set up continuous integration](https://developer.android.com/studio/projects/continuous-integration)
To run tests as part of the build, you need to either configure your continuous integration server to use the 
[Android Emulator](https://developer.android.com/studio/run/emulator-commandline) or use Firebase Test Lab to run your tests, so
[Gradle Managed Devices](https://developer.android.com/studio/test/gradle-managed-devices) or GMD improve consistency, performance, and reliability for your automated instrumented tests. This feature, available for API levels 27 and higher, allows you to configure virtual test devices in your project's Gradle files.
The build system uses the configurations to fully manage—that is, create, deploy, and tear down—those devices when executing your automated tests.
GMD runs with hardware acceleration by default (additional [setup](https://developer.android.com/studio/run/emulator-acceleration#vm-linux) needed), but to avoid settings use Automated Test Device (ATD).
[Accept Licence]
```bash
./gradlew build
./gradlew pixel3api30DebugAndroidTest
```

## Recommended links
1. [Emulator acceleration](https://developer.android.com/studio/run/emulator-acceleration)
2. [Manifest files](https://developer.android.com/guide/topics/manifest/manifest-intro)
3. [UI Automator article](https://medium.com/androiddevelopers/accessing-composables-from-uiautomator-cf316515edc2)
UiAutomator does just that, by delivering input events in a way a regular user would, but more consistent.
4. [Write automated tests with UI Automator](https://developer.android.com/training/testing/other-components/ui-automator)

## Known issues
1. Unresolved reference after changing SDK versions: `File > Invalidate Caches`