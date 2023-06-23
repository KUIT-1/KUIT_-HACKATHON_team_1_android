package com.example.kuit_team1_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.example.kuit_team1_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var exit_millis : Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()
    }



    private fun initBottomNavigation() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()


        binding.mainBnv.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    val homeFragment = HomeFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.payFragment -> {
                    val payFragment = PayFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, payFragment)
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.orderFragment -> {
                    val orderFragment = OrderFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, orderFragment)
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.shopFragment -> {
                    val shopFragment = ShopFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, shopFragment)
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.otherFragment -> {
                    val otherFragment = OtherFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, otherFragment)
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }

        binding.mainBnv.itemIconTintList = null

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val fragment = supportFragmentManager.findFragmentById(R.id.main_frm)
                if (fragment is HomeFragment) {
                    killApp()
                }else{
                    binding.mainBnv.selectedItemId = R.id.homeFragment
                }
            }

        }
        onBackPressedDispatcher.addCallback(this, callback)
    }
    //2초 안에 뒤로가기 한번 더 누르면 앱 종료
    fun killApp(){
        if (System.currentTimeMillis() - exit_millis > 2000){
            exit_millis = System.currentTimeMillis()
            Toast.makeText(this, "뒤로가기 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show()
        } else{
            finish()
        }
    }
}