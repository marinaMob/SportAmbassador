package il.spotrambs.iplay

import android.app.Application
import com.onesignal.OneSignal
import com.onesignal.debug.LogLevel
import il.spotrambs.iplay.data.Constants.ONESIGNAL_APP_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainAppClass: Application() {

    override fun onCreate() {
        super.onCreate()

        OneSignal.initWithContext(this, ONESIGNAL_APP_ID)
        OneSignal.Debug.logLevel = LogLevel.VERBOSE
        CoroutineScope(Dispatchers.IO).launch {
            OneSignal.Notifications.requestPermission(true)
        }
    }
}