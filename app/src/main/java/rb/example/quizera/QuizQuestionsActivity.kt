package rb.example.quizera

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.widget.TintableCompoundDrawablesView
import rb.example.quizera.databinding.ActivityMainBinding
import rb.example.quizera.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var binding: ActivityQuizQuestionsBinding

    private var mCurrentPosition:Int =1
    private var mQuestionsList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int =0
    private var mCorrectAnswers:Int=0
    private var mUserName:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityQuizQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN

        mUserName=intent.getStringExtra(Constants.USER_NAME)

         mQuestionsList = Constants.getQuestions()


        setQuestion()
        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)

    }
    private fun setQuestion(){

        val question:Question?= mQuestionsList!![mCurrentPosition-1]
        defaultOptionsView()
        if(mCurrentPosition==mQuestionsList!!.size){
            binding.btnSubmit.text="FINISH"
        }else{
            binding.btnSubmit.text="SUBMIT"
        }
        binding.progressBar.progress= mCurrentPosition
        binding.tvProgress.text="$mCurrentPosition"+"/" + binding.progressBar.max

        binding.tvQuestion.text = question!!.question
        binding.ivImage.setImageResource(question.image)
        binding.tvOptionOne.text= question.optionOne
        binding.tvOptionTwo.text= question.optionTwo
        binding.tvOptionThree.text= question.optionThree
        binding.tvOptionFour.text= question.optionFour

    }
    private fun defaultOptionsView(){
        val options= ArrayList<TextView>()
        options.add(0,binding.tvOptionOne)
        options.add(1,binding.tvOptionTwo)
        options.add(2,binding.tvOptionThree)
        options.add(3,binding.tvOptionFour)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            //A typeface is the design of lettering that can include variations in
            //size,weight(e.g bold),slope(e.g italic),width(e.g condensed)etc.Each of
            //these variations of the typeface is a font
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one->{
                selectedOptionView(binding.tvOptionOne,1)
            }
            R.id.tv_option_two->{
                selectedOptionView(binding.tvOptionTwo,2)
            }
            R.id.tv_option_three->{
                selectedOptionView(binding.tvOptionThree,3)
            }
            R.id.tv_option_four->{
                selectedOptionView(binding.tvOptionFour,4)
            }
            //R means the resources folder (res)
            R.id.btn_submit->{
                if(mSelectedOptionPosition==0){
                    mCurrentPosition++
                    //i.e if nothing is selected ,move to next question
                    when{
                        mCurrentPosition <= mQuestionsList!!.size->{
                            setQuestion()
                        }else->{
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer!= mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)

                    if(mCurrentPosition==mQuestionsList!!.size){
                        binding.btnSubmit.text="FINISH"
                    }else{
                        binding.btnSubmit.text="GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition=0
                }
            }
        }
    }
    private fun answerView(answer:Int,drawableView: Int){
        when(answer){
            1->{
                binding.tvOptionOne.background= ContextCompat.getDrawable(
                    this,drawableView
                )
            }
           2->{
               binding.tvOptionTwo.background=ContextCompat.getDrawable(
                   this,drawableView
               )
           }
            3->{
                binding.tvOptionThree.background=ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            4->{
                binding.tvOptionFour.background=ContextCompat.getDrawable(
                    this,drawableView
                )
            }


        }


    }
    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionsView()
        mSelectedOptionPosition= selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
        //the drawable that we generate are generally stored as integer

    }
}