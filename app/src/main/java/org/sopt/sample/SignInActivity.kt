package org.sopt.sample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import org.sopt.sample.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                Snackbar.make(binding.root, "회원가입 성공", Snackbar.LENGTH_LONG).show()
                val id = it.data?.getStringExtra("id") ?: ""
                val pw = it.data?.getStringExtra("password") ?: ""
                val mbti = it.data?.getStringExtra("mbti") ?: ""

                binding.loginBtn.setOnClickListener {
                    if (binding.editTextId.text.toString().equals(id) &&
                        binding.editTextPw.text.toString().equals(pw)) {
                        Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("homeid",id.toString())
                        intent.putExtra("homembti",mbti.toString())
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        binding.registerBtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(intent)

        }
    }
}