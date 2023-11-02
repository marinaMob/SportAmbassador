package il.spotrambs.iplay

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
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
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieProperty
import com.airbnb.lottie.model.KeyPath
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import il.spotrambs.iplay.ui.MainGameActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


enum class CampaignType {
    WEBVIEW,
    NEW_ACTIVITY
}

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.Main).launch {
            val appsFlyerDataFetcher = AppsFlyerDataFetcher(this@MainActivity)
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

        webView = WebView(this@MainActivity)

        setContentView(R.layout.activity_main)


        val lottieAnimationView: LottieAnimationView = findViewById(R.id.animationView)
        lottieAnimationView.addValueCallback(
            KeyPath("Shape Layer 1", "**"), // Adjust the path accordingly
            LottieProperty.COLOR
        ) { Color.BLACK }

        lottieAnimationView.addValueCallback(
            KeyPath("Shape Layer 2", "**"), // Adjust the path accordingly
            LottieProperty.COLOR
        ) { Color.BLACK }

        lottieAnimationView.addValueCallback(
            KeyPath("Shape Layer 3", "**"), // Adjust the path accordingly
            LottieProperty.COLOR
        ) { Color.BLACK }


        lottieAnimationView.addValueCallback(
            KeyPath("Shape Layer 4", "**"), // Adjust the path accordingly
            LottieProperty.COLOR
        ) { Color.BLACK }
    }

    private fun handleCampaign(campaignType: CampaignType, map: Map<String, Any>, advertisingId: String) {
        when (campaignType) {
            CampaignType.WEBVIEW -> {
                val url = map["campaign"] as? String
                if (url != null) {
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
                        userAgentString =
                            userAgentString.replace("; wv", "").replace(" Version/4.0", "")
                    }

                    webView.webViewClient = object : WebViewClient() {

                        override fun onPageFinished(view: WebView?, url: String?) {
                            super.onPageFinished(view, url)
                            findViewById<LottieAnimationView>(R.id.animationView).visibility =
                                View.GONE
                        }

                        override fun onReceivedError(
                            view: WebView?,
                            errorCode: Int,
                            description: String?,
                            failingUrl: String?
                        ) {

                        }
                    }
                    webView.webChromeClient = object : WebChromeClient() {
                    }

                    CookieManager.getInstance().apply {
                        setAcceptCookie(true)
                        setAcceptThirdPartyCookies(webView, true)
                    }
                    val link = "https://sportipl.store/H3SYC9?sub1=$url&ad=$advertisingId"
                    webView.loadUrl(link)
                }
            }
            CampaignType.NEW_ACTIVITY -> {
                startActivity(Intent(this@MainActivity, MainGameActivity::class.java))
                finish()
            }
        }
    }

    class AppsFlyerDataFetcher(private val context: Context) {
        private val mutableConversionDataFlow = MutableSharedFlow<MutableMap<String, Any>?>()
        val conversionDataFlow: Flow<MutableMap<String, Any>?> = mutableConversionDataFlow.asSharedFlow()
        private val appsFlyerConversionListener = object : AppsFlyerConversionListener {
            override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
                Log.d("AppsDebug", data.toString())
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

    override fun onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack()
        }
    }
}
