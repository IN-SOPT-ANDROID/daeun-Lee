package org.sopt.sample

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.sopt.sample.base.BindingActivity
import org.sopt.sample.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity :BindingActivity<ActivityMainBinding>(R.layout.activity_main){
    private val frame: FragmentContainerView by lazy { // activity_main의 화면 부분
        findViewById(R.id.main_container)
    }

    private val bottomNagivationView: BottomNavigationView by lazy { // 하단 네비게이션 바
        findViewById(R.id.bnv_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (frame == null) {
            supportFragmentManager.beginTransaction()
                .add(frame.id, HomeFragment())
                .commit()
        }

        bottomNagivationView.setOnNavigationItemSelectedListener {item ->
            when(item.itemId) {
                R.id.nav_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.nav_gallery -> {
                    replaceFragment(GalleryFragment())
                    true
                }
                R.id.nav_search -> {
                    replaceFragment(SearchFragment())
                    true
                }
                else -> false
            }
        }
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(frame.id, fragment).commit()
    }

}
