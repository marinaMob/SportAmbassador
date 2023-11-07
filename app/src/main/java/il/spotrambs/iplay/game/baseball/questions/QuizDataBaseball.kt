package il.spotrambs.iplay.game.baseball.questions

import il.spotrambs.iplay.data.model.Question

class QuizDataBaseball {

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val questionOne = Question(
            1,
            "Which baseball player holds the record for the most career home runs in MLB?",
            arrayListOf("Babe Ruth", "Hank Aaron", "Barry Bonds", "Willie Mays"),
            2
        )
        questionsList.add(questionOne)

        val questionTwo = Question(
            2,
            "Which team has won the most World Series titles in MLB history?",
            arrayListOf("New York Yankees", "Los Angeles Dodgers", "Boston Red Sox", "St. Louis Cardinals"),
            0
        )
        questionsList.add(questionTwo)

        val questionThree = Question(
            3,
            "What is the distance between the pitcher's mound and home plate in Major League Baseball?",
            arrayListOf("50 feet", "55 feet", "60 feet 6 inches", "65 feet"),
            2
        )
        questionsList.add(questionThree)

        val questionFour = Question(
            4,
            "Who is known as 'The Sultan of Swat' and is regarded as one of the greatest baseball players of all time?",
            arrayListOf("Ty Cobb", "Lou Gehrig", "Jackie Robinson", "Babe Ruth"),
            3
        )
        questionsList.add(questionFour)

        val questionFive = Question(
            5,
            "Which baseball player holds the record for the most stolen bases in a single MLB season?",
            arrayListOf("Rickey Henderson", "Lou Brock", "Maury Wills", "Vince Coleman"),
            0
        )
        questionsList.add(questionFive)

        val questionSix = Question(
            6,
            "Which team is known as the 'Bronx Bombers' and has a rich history of success in baseball?",
            arrayListOf("New York Mets", "Boston Red Sox", "Los Angeles Dodgers", "New York Yankees"),
            3
        )
        questionsList.add(questionSix)

        val questionSeven = Question(
            7,
            "In baseball, what is the term for a batter hitting the ball out of the park for a home run with the bases loaded?",
            arrayListOf("Grand Slam", "Triple Play", "Steal Home", "Sacrifice Fly"),
            0
        )
        questionsList.add(questionSeven)

        val questionEight = Question(
            8,
            "Who is known for his powerful swing and the phrase 'Say Hey Kid' in the world of baseball?",
            arrayListOf("Yogi Berra", "Willie Mays", "Hank Aaron", "Mickey Mantle"),
            1
        )
        questionsList.add(questionEight)

        val questionNine = Question(
            9,
            "In baseball, what is the term for a pitch that is so fast it's difficult to hit and often results in a strikeout?",
            arrayListOf("Curveball", "Knuckleball", "Slider", "Fastball"),
            3
        )
        questionsList.add(questionNine)

        val questionTen = Question(
            10,
            "Which city is home to the Baseball Hall of Fame in the United States?",
            arrayListOf("Boston", "Chicago", "New York", "Cooperstown"),
            3
        )
        questionsList.add(questionTen)

        return questionsList
    }
}
