package il.spotrambs.iplay

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import il.spotrambs.iplay.databinding.ActivityMainBinding
import il.spotrambs.iplay.game.baseball.BaseballInfoActivity
import il.spotrambs.iplay.game.basketball.BasketballInfoActivity
import il.spotrambs.iplay.game.cricket.CricketInfoActivity
import il.spotrambs.iplay.game.football.FootballInfoActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.imPolisy.setOnClickListener{
            openCustomTab("https://doc-hosting.flycricket.io/testapp-privacy-policy/ff23acb9-75f9-48d1-bd6e-6ca64f925662/privacy")
        }
        binding.btnFootball.setOnClickListener {
                val intent = Intent(this, FootballInfoActivity::class.java)
                startActivity(intent)
        }

        binding.btnBaseball.setOnClickListener {
            val intent = Intent(this, BaseballInfoActivity::class.java)
            startActivity(intent)
        }

        binding.btnBasketball.setOnClickListener {
            val intent = Intent(this, BasketballInfoActivity::class.java)
            startActivity(intent)
        }

        binding.btnCricket.setOnClickListener {
            val intent = Intent(this, CricketInfoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun openCustomTab(url: String) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(url))
    }
}