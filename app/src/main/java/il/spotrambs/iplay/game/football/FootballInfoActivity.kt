package il.spotrambs.iplay.game.football

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import il.spotrambs.iplay.databinding.ActivityFootballInfoBinding
import il.spotrambs.iplay.game.QuizQuestionsActivity

class FootballInfoActivity : AppCompatActivity() {

    lateinit var binding: ActivityFootballInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFootballInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playBt1.setOnClickListener {
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            intent.putExtra("activityType", "football")
            startActivity(intent)
        }

        binding.footballInfoText.text = "Football, or soccer, is the world's most popular sport, uniting people across nations. It's played on a rectangular field with two goals, and the aim is simple: score by getting the ball into the opponent's net.\n" +
                "\n" +
                "Teams usually consist of eleven players each, and the game is celebrated for its continuous action and strategic gameplay. Players dribble the ball, pass to teammates, and take shots to outscore the opposing team.\n" +
                "\n" +
                "Key positions in football include forwards, responsible for scoring goals, and defenders who protect their own goal. The sport demands a blend of skills, such as dribbling, passing, and ball control.\n" +
                "\n" +
                "Football is renowned for its moments of brilliance, from stunning goals to incredible saves. It's a sport that brings people together and showcases the beauty of teamwork.\n" +
                "\n" +
                "The top professional leagues like the English Premier League (EPL), La Liga, and Serie A feature some of the world's best teams. The football season includes league matches, cup competitions, and international tournaments like the FIFA World Cup.\n" +
                "\n" +
                "If you're a football enthusiast or want to test your knowledge of the game, take our football quiz to see how well you know this beloved sport. Have fun and enjoy the world of football!"

    }
}