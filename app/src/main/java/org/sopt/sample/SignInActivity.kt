package org.sopt.sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import org.sopt.sample.remote.RequestLoginDTO
import org.sopt.sample.remote.ResponseLoginDTO
import org.sopt.sample.databinding.ActivitySignInBinding
import org.sopt.sample.remote.ServicePool
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private val loginService = ServicePool.loginService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.loginBtn.setOnClickListener {
            loginService.login(
                RequestLoginDTO(
                    binding.editTextId.text.toString(),
                    binding.editTextPw.text.toString()
                )
                //서버에 요청을 보내기 위한 RequestData 생성
            ).enqueue(object : Callback<ResponseLoginDTO> {
                override fun onResponse(
                    call: Call<ResponseLoginDTO>,
                    response: Response<ResponseLoginDTO>
                ) {
                    Log.d("로그인", "${response.body()}")
                    if (response.isSuccessful) {
                        val intent = Intent(this@SignInActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else if (response.code() == 404) {
                        Snackbar.make(binding.root, "404 error", Snackbar.LENGTH_LONG)
                            .show()
                    } else if (response.code() == 401) {
                        Snackbar.make(binding.root, "401 error", Snackbar.LENGTH_LONG)
                            .show()
                    }
                }

                override fun onFailure(call: Call<ResponseLoginDTO>, t: Throwable) {
                    Snackbar.make(binding.root, "서버통신 실패", Snackbar.LENGTH_LONG).show()
                }
            })
        }
        binding.registerBtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}