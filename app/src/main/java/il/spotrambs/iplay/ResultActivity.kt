package il.spotrambs.iplay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import il.spotrambs.iplay.data.Constants

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        
        val totalQuestions = intent.getIntExtra(Constants.QUESTIONS, 0)
        val score = intent.getIntExtra(Constants.SCORE, 0)

        val scoreTv: TextView = findViewById(R.id.scoreTv)
        val btnRestart: Button = findViewById(R.id.btnRestart)

        scoreTv.text = "Your score is $score of $totalQuestions"
        btnRestart.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}