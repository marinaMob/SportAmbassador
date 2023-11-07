package il.spotrambs.iplay.game.basketball.questions

import il.spotrambs.iplay.data.model.Question

class QuizDataBasketball {

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val questionOne = Question(
            1,
            "Which NBA player holds the record for the most points scored in a single game?",
            arrayListOf("Wilt Chamberlain", "Kobe Bryant", "Michael Jordan", "LeBron James"),
            0
        )
        questionsList.add(questionOne)

        val questionTwo = Question(
            2,
            "Which team has won the most NBA championships in history?",
            arrayListOf("Los Angeles Lakers", "Boston Celtics", "Chicago Bulls", "Golden State Warriors"),
            1
        )
        questionsList.add(questionTwo)

        val questionThree = Question(
            3,
            "Who is known as 'The Dream' and is considered one of the greatest centers in NBA history?",
            arrayListOf("Shaquille O'Neal", "Hakeem Olajuwon", "Kareem Abdul-Jabbar", "Tim Duncan"),
            1
        )
        questionsList.add(questionThree)

        val questionFour = Question(
            4,
            "Which NBA player holds the record for the most career points scored?",
            arrayListOf("LeBron James", "Kobe Bryant", "Karl Malone", "Michael Jordan"),
            2
        )
        questionsList.add(questionFour)

        val questionFive = Question(
            5,
            "What is the regulation height of an NBA basketball hoop?",
            arrayListOf("10 feet", "9 feet", "11 feet", "12 feet"),
            0
        )
        questionsList.add(questionFive)

        val questionSix = Question(
            6,
            "Who won the NBA MVP award for the 2020-2021 season?",
            arrayListOf("Giannis Antetokounmpo", "LeBron James", "Kevin Durant", "Stephen Curry"),
            0
        )
        questionsList.add(questionSix)

        val questionSeven = Question(
            7,
            "Which NBA team drafted Dirk Nowitzki in the 1998 NBA Draft before he was traded to the Dallas Mavericks?",
            arrayListOf("Los Angeles Lakers", "Milwaukee Bucks", "San Antonio Spurs", "Boston Celtics"),
            1
        )
        questionsList.add(questionSeven)

        val questionEight = Question(
            8,
            "Who is known for his famous 'Sky Hook' shot and played for the Los Angeles Lakers?",
            arrayListOf("LeBron James", "Shaquille O'Neal", "Magic Johnson", "Kareem Abdul-Jabbar"),
            3
        )
        questionsList.add(questionEight)

        val questionNine = Question(
            9,
            "Which college basketball team is known as the 'Tar Heels'?",
            arrayListOf("Duke Blue Devils", "Kentucky Wildcats", "North Carolina Tar Heels", "Kansas Jayhawks"),
            2
        )
        questionsList.add(questionNine)

        val questionTen = Question(
            10,
            "How many players are on the court for each team during a regulation NBA game?",
            arrayListOf("5", "6", "7", "8"),
            0
        )
        questionsList.add(questionTen)

        return questionsList
    }
}
