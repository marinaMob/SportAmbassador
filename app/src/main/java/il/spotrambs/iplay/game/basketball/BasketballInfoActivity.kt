package il.spotrambs.iplay.game.basketball

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import il.spotrambs.iplay.databinding.ActivityBasketballInfoBinding
import il.spotrambs.iplay.game.QuizQuestionsActivity

class BasketballInfoActivity : AppCompatActivity() {

    lateinit var binding: ActivityBasketballInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBasketballInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playBt1.setOnClickListener {
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            intent.putExtra("activityType", "basketball")
            startActivity(intent)
        }

        binding.basketballInfoText.text = "Basketball is a dynamic sport that has captured the hearts of fans around the world. It is played on a rectangular court with a hoop at each end. The objective is simple: score points by shooting a ball through the opponent's hoop.\n" +
                "\n" +
                "Teams typically consist of five players each, and the game is known for its fast-paced and high-scoring nature. Players dribble the ball, pass to teammates, and take shots to outscore the opposing team.\n" +
                "\n" +
                "Key positions in basketball include point guards, who are often playmakers, and centers, who dominate in the paint. The sport demands a combination of skills, including shooting, passing, and defense.\n" +
                "\n" +
                "Basketball is famous for its exciting moments, from slam dunks to three-pointers. It's a sport that showcases the incredible athleticism and agility of its players.\n" +
                "\n" +
                "The National Basketball Association (NBA) is the premier professional league, featuring iconic teams like the Los Angeles Lakers, Chicago Bulls, and Boston Celtics. The NBA season includes regular games, playoffs, and the NBA Finals, where the top teams compete for the championship.\n" +
                "\n" +
                "If you're a basketball enthusiast or want to test your knowledge of the game, take our basketball quiz to see how well you know this thrilling sport. Have fun and enjoy the world of basketball!"

    }
}