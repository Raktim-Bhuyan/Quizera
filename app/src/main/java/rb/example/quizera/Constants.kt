package rb.example.quizera

object Constants{

    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS:String="correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val que1 = Question(1,
            "Name the world's largest river island?",
            R.drawable.majuli,
            "Majuli",
            "Umananda",
            "Dipor Bil",
            "Bora Bora",
            1
        )
        questionList.add(que1)

        //2
        val que2 = Question(2,
            "Identify this world's tallest statue?",
            R.drawable.statueofunity,
            "Statue of Liberty",
            "Statue of Unity",
            "Statue of Fraternity",
            "Statue of Equality",
            2
        )
        questionList.add(que2)

        //3
        val que3 = Question(3,
            "Who is the founder of Ahom Kingdom (that ruled Assam for nearly " +
                    "six centuries)?",
            R.drawable.ahom,
            "Purandar Singha",
            "Lachit Borphukon",
            "Maniram Dewam",
            "Chaolung Sukapha",
            4
        )
        questionList.add(que3)
        //4
        val que4 = Question(4,
            "Identify this premiere Technology Institute? ",
            R.drawable.silchar,
            "Massachusetts Institute of Technology",
            "National Institute of Technology,Silchar",
            "Indian Institute of Science,Bengaluru",
            "University of Hamburg,Germany",
            2
        )
        questionList.add(que4)

        //5
        val que5 = Question(5,
            "Identify this famous Indian Singer? ",
            R.drawable.zubeenda,
            "Zubeen Garg",
            "Vishal Mishra",
            "Angarag Mahanta",
            "Jubin Nautiyal",
            1
        )
        questionList.add(que5)

        //6
        val que6 = Question(6,
            "She is a famous Indian boxer.Identify her? ",
            R.drawable.lovely,
            "Chanu Saikhom Mirabai",
            "Lovlina Borgohain",
            "Mary Kom",
            "Dipa Karmakar",
            2
        )
        questionList.add(que6)
        //7
        val que7 =Question(6,
            "How many districts are there in Assam at present?",
            R.drawable.assam,
            "34",
            "35",
            "33",
            "36",
            1


        )
        questionList.add(que7)


        return questionList
    }
}