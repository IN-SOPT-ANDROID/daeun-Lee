package org.sopt.sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.sample.databinding.ActivitySignUpBinding
import org.sopt.sample.remote.ApiFactory

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //binding.finishBtn.setOnClickListener{
          //  if (binding.editTextId.text.length in 6..10
            //    && binding.editTextPw.text.length in 8..12) {
              //  val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
               // intent.putExtra("id",binding.editTextId.text.toString())
                //intent.putExtra("password", binding.editTextPw.text.toString())
                //intent.putExtra("mbti", binding.editTextMbti.text.toString())
                //setResult(Activity.RESULT_OK, intent)
                //finish()
            //}
        //}

    }
}