package org.sopt.sample

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import org.sopt.sample.base.BindingActivity
import org.sopt.sample.databinding.ActivitySignUpBinding
import org.sopt.sample.signup.SignupViewModel
import java.util.regex.Pattern


class SignUpActivity : BindingActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    private val viewModel by viewModels<SignupViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // 버튼 클릭 이벤트
        var validEmail = false
        var validPw = false
        val EmailPattern = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z[0-9]]{6,10}$"
        val pattern1 = Pattern.compile(EmailPattern)
        val PwPattern = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&.])[A-Za-z[0-9]$@$!%*#?&.]{6,12}$"
        val pattern2 = Pattern.compile(PwPattern)



        binding.editTextEmail.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // 입력난에 변화가 있을 시 조치
                viewModel.inputEmail.value = binding.editTextEmail.text.toString()
            }
            override fun afterTextChanged(arg0: Editable) {
                // 입력이 끝났을 때 조치
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // 입력하기 전에 조치
            }
        })

        binding.editTextPw.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // 입력난에 변화가 있을 시 조치
                viewModel.inputPw.value = binding.editTextPw.text.toString()
            }
            override fun afterTextChanged(arg0: Editable) {
                // 입력이 끝났을 때 조치
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // 입력하기 전에 조치
            }
        })

        viewModel.inputEmail.observe(this) {
            val matcher1 = pattern1.matcher(it)
            if(matcher1.find() == true) {
                validEmail = true
                binding.editTextEmail.backgroundTintList =
                    ContextCompat.getColorStateList(applicationContext, R.color.edit_gray)
            }
            if(validEmail == false) {
                binding.tvEmailerror.visibility = View.VISIBLE
                binding.editTextEmail.backgroundTintList = ContextCompat.getColorStateList(applicationContext, R.color.red)
            }
            if(validEmail == true)
                binding.tvEmailerror.visibility = View.INVISIBLE
            if(validEmail == true && validPw == true)
                binding.finishBtn.isEnabled = true
        }

        viewModel.inputPw.observe(this) {
            val matcher2 = pattern2.matcher(it)
            if(matcher2.find() == true) {
                validPw = true
                binding.editTextPw.backgroundTintList =
                    ContextCompat.getColorStateList(applicationContext, R.color.edit_gray)
            }
            if(validPw == false) {
                binding.tvPwerror.visibility = View.VISIBLE
                binding.editTextPw.backgroundTintList = ContextCompat.getColorStateList(applicationContext, R.color.red)
            }
            if(validPw == true)
                binding.tvPwerror.visibility = View.INVISIBLE
            if(validEmail == true && validPw == true)
                binding.finishBtn.isEnabled = true
        }

        binding.finishBtn.setOnClickListener {
            viewModel.signup(
                binding.editTextEmail.text.toString(),
                binding.editTextPw.text.toString(),
                binding.editTextName.text.toString()
            )
        }

        viewModel.signupResult.observe(this) {
            startActivity(Intent(this,SignInActivity::class.java))
        }
    }
}