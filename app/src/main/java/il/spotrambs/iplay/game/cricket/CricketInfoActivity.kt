package il.spotrambs.iplay.game.cricket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import il.spotrambs.iplay.databinding.ActivityCricketInfoBinding
import il.spotrambs.iplay.game.QuizQuestionsActivity

class CricketInfoActivity : AppCompatActivity() {

    lateinit var binding: ActivityCricketInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCricketInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playBt1.setOnClickListener {
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            intent.putExtra("activityType", "cricket")
            startActivity(intent)
        }

        binding.cricketInfoText.text = "Cricket is a bat-and-ball game that has a dedicated following in many countries. It's played on an oval field with a pitch at the center, and the objective is to score runs by hitting the ball and running between wickets.\n" +
                "\n" +
                "Teams usually consist of eleven players each, and the game is celebrated for its strategic gameplay and extended format. Players take turns batting and fielding, and cricket requires a wide range of skills, from powerful batting to precise bowling and agile fielding.\n" +
                "\n" +
                "Key positions in cricket include batsmen, bowlers, and wicketkeepers. Batsmen aim to score runs, while bowlers attempt to dismiss them. Wicketkeepers play a crucial role behind the stumps.\n" +
                "\n" +
                "Cricket matches can last for various durations, from one-day games to Test matches that span five days. The sport is known for its diverse formats, including T20, ODI, and Test cricket.\n" +
                "\n" +
                "Cricket is famous for thrilling moments, such as centuries, hat-tricks, and stunning catches. It's a sport that demands both patience and aggression.\n" +
                "\n" +
                "The International Cricket Council (ICC) oversees the game's global events, including the ICC Cricket World Cup and ICC World Twenty20.\n" +
                "\n" +
                "If you're a cricket enthusiast or want to test your knowledge of the game, take our cricket quiz to see how well you know this captivating sport. Enjoy the world of cricket!"

    }
}