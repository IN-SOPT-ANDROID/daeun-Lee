package org.sopt.sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import org.sopt.sample.databinding.ActivitySignInBinding
import org.sopt.sample.login.LoginViewModel

class SignInActivity : AppCompatActivity() {
    private val viewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // 버튼 클릭 이벤트
        binding.loginBtn.setOnClickListener {
            viewModel.login(
                binding.editTextId.text.toString(),
                binding.editTextPw.text.toString()
            )
        }

        viewModel.loginResult.observe(this) {

            startActivity(Intent(this, MainActivity::class.java))
        }
        binding.registerBtn.setOnClickListener(){
            startActivity(Intent(this,SignUpActivity::class.java))
        }
    }
}