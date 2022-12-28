package org.sopt.sample

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import org.sopt.sample.base.BindingActivity
import org.sopt.sample.databinding.ActivitySignUpBinding
import org.sopt.sample.presentation.SignInActivity
import org.sopt.sample.signup.SignupRepository
import org.sopt.sample.signup.SignupViewModel
import org.sopt.sample.signup.SignupViewModelFactory


class SignUpActivity : BindingActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    private lateinit var viewModel: SignupViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, SignupViewModelFactory(SignupRepository()))
            .get(SignupViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        addListeners()
        addObservers()
    }

    private fun addListeners(){
        binding.finishBtn.setOnClickListener {
            viewModel.signup()
        }
    }

    private fun addObservers() {
        viewModel.signupResult.observe(this) {
            startActivity(Intent(this, SignInActivity::class.java))
            Toast.makeText(this,getString(R.string.sign_up_success_toast_msg), Toast.LENGTH_LONG).show()
        }
    }
}