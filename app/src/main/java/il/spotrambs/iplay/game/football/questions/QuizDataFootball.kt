package il.spotrambs.iplay.game.football.questions

import il.spotrambs.iplay.data.model.Question

class QuizDataFootball {

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val questionOne = Question(
            1,
            "Which country has won the most FIFA World Cup titles?",
            arrayListOf("Brazil", "Germany", "Italy", "Argentina"),
            0
        )
        questionsList.add(questionOne)

        val questionTwo = Question(
            2,
            "Who is the all-time top scorer in the FIFA World Cup?",
            arrayListOf("Miroslav Klose", "Pele", "Diego Maradona", "Cristiano Ronaldo"),
            0
        )
        questionsList.add(questionTwo)

        val questionThree = Question(
            3,
            "Which country hosted the 2018 FIFA World Cup?",
            arrayListOf("Russia", "Brazil", "France", "Germany"),
            0
        )
        questionsList.add(questionThree)

        val questionFour = Question(
            4,
            "Who is known as the 'Hand of God' for his infamous handball goal in the 1986 World Cup?",
            arrayListOf("Diego Maradona", "Lionel Messi", "Pele", "Cristiano Ronaldo"),
            0
        )
        questionsList.add(questionFour)

        val questionFive = Question(
            5,
            "Which player has the most appearances in FIFA World Cup history?",
            arrayListOf("Lothar Matthaus", "Cafu", "Xavi Hernandez", "Cristiano Ronaldo"),
            1
        )
        questionsList.add(questionFive)

        val questionSix = Question(
            6,
            "Which nation won the first-ever FIFA World Cup in 1930?",
            arrayListOf("Uruguay", "Argentina", "Brazil", "Germany"),
            0
        )
        questionsList.add(questionSix)

        val questionSeven = Question(
            7,
            "Who is the only player to have won the FIFA Ballon d'Or five times?",
            arrayListOf("Lionel Messi", "Cristiano Ronaldo", "Pele", "Diego Maradona"),
            0
        )
        questionsList.add(questionSeven)

        val questionEight = Question(
            8,
            "Which stadium is known as the 'Theatre of Dreams' and is the home of Manchester United?",
            arrayListOf("Old Trafford", "Anfield", "Camp Nou", "Santiago Bernabeu"),
            0
        )
        questionsList.add(questionEight)

        val questionNine = Question(
            9,
            "In which year did the United States host the FIFA World Cup?",
            arrayListOf("1994", "2002", "2010", "1998"),
            0
        )
        questionsList.add(questionNine)

        val questionTen = Question(
            10,
            "Which country's national team is known as the 'Socceroos'?",
            arrayListOf("Australia", "England", "France", "Spain"),
            0
        )
        questionsList.add(questionTen)

        return questionsList
    }
}
