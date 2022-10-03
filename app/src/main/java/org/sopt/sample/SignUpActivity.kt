package org.sopt.sample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import org.sopt.sample.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.finishBtn.setOnClickListener{
            if (binding.editTextId.text.length>=6 && binding.editTextId.text.length<10
                && binding.editTextPw.text.length>=8 && binding.editTextPw.text.length<12) {
                val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                intent.putExtra("id",binding.editTextId.text.toString())
                intent.putExtra("password", binding.editTextPw.text.toString())
                intent.putExtra("mbti", binding.editTextMbti.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}