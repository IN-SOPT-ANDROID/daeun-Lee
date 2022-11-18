package org.sopt.sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import org.sopt.sample.databinding.ActivitySignUpBinding
import org.sopt.sample.remote.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private val signupService = ServicePool.signupService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.finishBtn.setOnClickListener {
            signupService.signup(
                RequestSignupDTO(
                    binding.editTextEmail.text.toString(),
                    binding.editTextPw.text.toString(),
                    binding.editTextName.text.toString()
                )
                //서버에 요청을 보내기 위한 RequestData 생성
            ).enqueue(object : Callback<ResponseSignupDTO> {
                override fun onResponse(
                    call: Call<ResponseSignupDTO>,
                    response: Response<ResponseSignupDTO>
                ) {
                    if (response.isSuccessful) {
                        Log.d("회원가입 성공", "${response.body()}")
                    }
                    val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                override fun onFailure(call: Call<ResponseSignupDTO>, t: Throwable) {
                    Log.d("회원가입 실패", "${t}")
                    Snackbar.make(binding.root, "서버통신 실패", Snackbar.LENGTH_LONG).show()
                }
            })
        }

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