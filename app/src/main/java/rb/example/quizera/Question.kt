package rb.example.quizera
//We have creaated a simple data class here , as we dont need any method here

data class Question(
    val id:Int,
    val question:String,
    val image:Int,
    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionFour:String,
    val correctAnswer:Int

)