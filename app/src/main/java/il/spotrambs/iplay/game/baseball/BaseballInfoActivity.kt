package il.spotrambs.iplay.game.baseball

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import il.spotrambs.iplay.databinding.ActivityBaseballInfoBinding
import il.spotrambs.iplay.game.QuizQuestionsActivity

class BaseballInfoActivity : AppCompatActivity() {

    lateinit var binding: ActivityBaseballInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseballInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playBt1.setOnClickListener {
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            intent.putExtra("activityType", "baseball")
            startActivity(intent)
        }

        binding.baseballInfoText.text = "Baseball is often referred to as America's pastime, and it's one of the most popular sports in the United States. This bat-and-ball game is played between two teams, each consisting of nine players. The objective of the game is to score runs by hitting a pitched ball and then running around a series of bases to reach home plate.\n" +
                "\n" +
                "Baseball is known for its rich history and traditions. It's a sport that has captured the hearts of fans for generations. The game is played on a diamond-shaped field with four bases—first, second, third, and home plate. The team on offense tries to score runs, while the team on defense aims to prevent them.\n" +
                "\n" +
                "Key positions in baseball include the pitcher, who throws the ball to the batter, and the catcher, who receives the pitches. Fielders, including the first baseman, second baseman, shortstop, and third baseman, are responsible for defending the infield. Outfielders patrol the outfield to catch fly balls.\n" +
                "\n" +
                "Baseball has its own unique terminology, from \"home run\" when a batter hits the ball out of the park, to \"strikeout\" when the batter fails to hit a pitch. It's a sport that combines strategy, skill, and athleticism.\n" +
                "\n" +
                "The Major League Baseball (MLB) is the premier professional league in the world, featuring teams like the New York Yankees, Boston Red Sox, and Los Angeles Dodgers. The MLB season consists of regular games, playoffs, and the World Series, where the best teams compete for the championship.\n" +
                "\n" +
                "If you're a fan of baseball or want to test your knowledge of the sport, you can take our baseball quiz to see how well you know the game. Have fun and enjoy the world of baseball!"
    }
}