package il.spotrambs.iplay.data

import android.graphics.Color
import android.graphics.Typeface
import android.widget.TextView
import il.spotrambs.iplay.data.model.Question

class QuizManager(private val questionsList: ArrayList<Question>) {

    var currentQuestionIndex = 0
        private set

    var selectedAlternativeIndex = -1

    var isAnswerChecked = false
        set(value) {
            field = value
            if (!value) {
                selectedAlternativeIndex = -1
            }
        }

    var totalScore = 0

    fun getCurrentQuestion(): Question {
        return questionsList[currentQuestionIndex]
    }

    fun getTotalQuestions(): Int {
        return questionsList.size
    }

    fun getQuizCurrentQuestionIndex(): Int {
        return currentQuestionIndex
    }

    fun isLastQuestion(): Boolean {
        return currentQuestionIndex == questionsList.size - 1
    }

    fun moveToNextQuestion() {
        if (currentQuestionIndex < questionsList.size - 1) {
            currentQuestionIndex++
        }
    }

    fun selectedAlternativeView(option: TextView, index: Int) {
        selectedAlternativeIndex = index
        option.setTextColor(Color.parseColor("#363A43"))
        option.setTypeface(option.typeface, Typeface.BOLD)
    }
}
