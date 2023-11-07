package il.spotrambs.iplay.game

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.content.ContextCompat
import il.spotrambs.iplay.R
import il.spotrambs.iplay.ResultActivity
import il.spotrambs.iplay.data.Constants
import il.spotrambs.iplay.data.QuizManager
import il.spotrambs.iplay.game.baseball.questions.QuizDataBaseball
import il.spotrambs.iplay.game.basketball.questions.QuizDataBasketball
import il.spotrambs.iplay.game.cricket.questions.QuizDataCricket
import il.spotrambs.iplay.game.football.questions.QuizDataFootball

class QuizQuestionsActivity : AppCompatActivity() {

    private lateinit var quizManager: QuizManager
    private lateinit var tvQuestion: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var tvProgress: TextView
    private lateinit var btnSubmit: Button
    private val tvAlternatives = ArrayList<TextView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        val activityType = intent.getStringExtra("activityType")

        quizManager = when (activityType) {
            "basketball" -> QuizManager(QuizDataBasketball().getQuestions())
            "baseball" -> QuizManager(QuizDataBaseball().getQuestions())
            "cricket" -> QuizManager(QuizDataCricket().getQuestions())
            else -> QuizManager(QuizDataFootball().getQuestions())
        }

        tvQuestion = findViewById(R.id.tvQuestion)
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        btnSubmit = findViewById(R.id.btnSubmit)
        tvAlternatives.add(findViewById(R.id.optionOne))
        tvAlternatives.add(findViewById(R.id.optionTwo))
        tvAlternatives.add(findViewById(R.id.optionThree))
        tvAlternatives.add(findViewById(R.id.optionFour))

        updateQuestion()

        btnSubmit.setOnClickListener {
            if (!quizManager.isAnswerChecked) {
                val anyAnswerIsChecked = quizManager.selectedAlternativeIndex != -1
                if (!anyAnswerIsChecked) {
                    Toast.makeText(this, "Please, select an alternative", Toast.LENGTH_SHORT).show()
                } else {
                    val currentQuestion = quizManager.getCurrentQuestion()
                    if (quizManager.selectedAlternativeIndex == currentQuestion.correctAnswerIndex) {
                        quizManager.totalScore++
                    }

                    quizManager.isAnswerChecked = true
                    btnSubmit.text = if (quizManager.isLastQuestion()) "FINISH" else "GO TO NEXT QUESTION"
                    quizManager.selectedAlternativeIndex = -1
                }
            } else {
                if (!quizManager.isLastQuestion()) {
                    quizManager.moveToNextQuestion()
                    updateQuestion()
                } else {
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra(Constants.QUESTIONS, quizManager.getTotalQuestions())
                    intent.putExtra(Constants.SCORE, quizManager.totalScore)
                    startActivity(intent)
                    finish()
                }

                quizManager.isAnswerChecked = false
            }
        }

        tvAlternatives.forEachIndexed { index, option ->
            option.setOnClickListener {
                if (!quizManager.isAnswerChecked) {
                    quizManager.selectedAlternativeView(option, index)
                }
            }
        }
    }

    private fun updateQuestion() {
        defaultAlternativesView()

        val currentQuestion = quizManager.getCurrentQuestion()
        tvQuestion.text = currentQuestion.questionText
        progressBar.progress = quizManager.getQuizCurrentQuestionIndex() + 1
        tvProgress.text = "${quizManager.getQuizCurrentQuestionIndex() + 1}/${quizManager.getTotalQuestions()}"

        currentQuestion.alternatives.forEachIndexed { index, alternative ->
            tvAlternatives[index].text = alternative
        }

        btnSubmit.text = if (quizManager.isLastQuestion()) "FINISH" else "SUBMIT"
    }


    private fun defaultAlternativesView() {
        tvAlternatives.forEach { alternativeTv ->
            alternativeTv.typeface = Typeface.DEFAULT
            alternativeTv.setTextColor(Color.parseColor("#7A8089"))
        }
    }

    private fun answerView(view: TextView, drawableId: Int) {
        view.background = ContextCompat.getDrawable(this, drawableId)
        tvAlternatives[quizManager.selectedAlternativeIndex].setTextColor(Color.parseColor("#FFFFFF"))
    }
}
