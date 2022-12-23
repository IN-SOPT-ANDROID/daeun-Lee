package org.sopt.sample

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import org.sopt.sample.base.BindingActivity
import org.sopt.sample.databinding.ActivitySignInBinding
import org.sopt.sample.login.LoginViewModel

class SignInActivity: BindingActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        addListeners()
        addObservers()
    }
    private fun addListeners(){
        binding.loginBtn.setOnClickListener {
            viewModel.login(
                binding.editTextId.text.toString(),
                binding.editTextPw.text.toString()
            )
        }

        binding.registerBtn.setOnClickListener(){
            startActivity(Intent(this,SignUpActivity::class.java))
        }
    }

    private fun addObservers() {
        viewModel.loginResult.observe(this) {
            Toast.makeText(this, getString(R.string.sign_in_success_toast_msg), Toast.LENGTH_LONG).show()
            moveToMain()
        }
    }

    private fun moveToMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}