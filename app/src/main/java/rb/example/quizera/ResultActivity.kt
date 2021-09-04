package rb.example.quizera

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import rb.example.quizera.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        val username = intent.getStringExtra(Constants.USER_NAME)
        binding.tvName.text=username
        val totalQuestions =intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        binding.tvScore.text= "Your score is $correctAnswers out of $totalQuestions"

        binding.btnFinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }


    }
}