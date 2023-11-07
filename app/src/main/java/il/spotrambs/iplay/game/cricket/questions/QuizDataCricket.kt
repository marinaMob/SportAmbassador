package il.spotrambs.iplay.game.cricket.questions

import il.spotrambs.iplay.data.model.Question

class QuizDataCricket {

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val questionOne = Question(
            1,
            "Which country won the ICC Cricket World Cup in 2019?",
            arrayListOf("India", "Australia", "England", "Pakistan"),
            2
        )
        questionsList.add(questionOne)

        val questionTwo = Question(
            2,
            "Who holds the record for the highest individual score in a One Day International (ODI) cricket match?",
            arrayListOf("Rohit Sharma", "Sachin Tendulkar", "Virender Sehwag", "Chris Gayle"),
            0
        )
        questionsList.add(questionTwo)

        val questionThree = Question(
            3,
            "In cricket, what is the term for a batsman being dismissed without scoring any runs?",
            arrayListOf("Zeroed Out", "Duck", "Noughted", "Blanked"),
            1
        )
        questionsList.add(questionThree)

        val questionFour = Question(
            4,
            "Which country is known for the famous 'Baggy Green' caps worn by its cricket team?",
            arrayListOf("India", "England", "Australia", "South Africa"),
            2
        )
        questionsList.add(questionFour)

        val questionFive = Question(
            5,
            "What is the maximum number of overs a bowler can bowl in a One Day International (ODI) cricket match?",
            arrayListOf("10 overs", "15 overs", "20 overs", "25 overs"),
            2
        )
        questionsList.add(questionFive)

        val questionSix = Question(
            6,
            "Who is often referred to as the 'Little Master' in the world of cricket?",
            arrayListOf("Sachin Tendulkar", "Brian Lara", "Ricky Ponting", "Vivian Richards"),
            0
        )
        questionsList.add(questionSix)

        val questionSeven = Question(
            7,
            "In Test cricket, what is the maximum number of deliveries allowed in an over?",
            arrayListOf("5", "6", "7", "8"),
            1
        )
        questionsList.add(questionSeven)

        val questionEight = Question(
            8,
            "What is the term for the situation in cricket when a batsman is declared out without facing a ball?",
            arrayListOf("Duck", "Hit Wicket", "Mankaded", "LBW"),
            2
        )
        questionsList.add(questionEight)

        val questionNine = Question(
            9,
            "Which international cricket team is known as the 'Proteas'?",
            arrayListOf("India", "England", "Australia", "South Africa"),
            3
        )
        questionsList.add(questionNine)

        val questionTen = Question(
            10,
            "In Twenty20 cricket, what is the maximum number of overs per side in a match?",
            arrayListOf("10 overs", "15 overs", "20 overs", "25 overs"),
            2
        )
        questionsList.add(questionTen)

        return questionsList
    }
}
