package org.sopt.sample

import android.os.Bundle
import org.sopt.sample.base.BindingActivity
import org.sopt.sample.databinding.ActivityHomeBinding

class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.txtName.setText("이름: " + intent.getStringExtra("homeid"))
        binding.txtMbti.setText("MBTI: " + intent.getStringExtra("homembti"))
    }
}