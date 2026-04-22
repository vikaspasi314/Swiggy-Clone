package com.example.swiggyclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, HomeFragment())
            .commit()

        bottomNav.setOnItemSelectedListener {

            when(it.itemId){

                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, HomeFragment())
                        .commit()
                }

                R.id.nav_search -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, SearchFragment())
                        .commit()
                }

                R.id.nav_cart -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, CartFragment())
                        .commit()
                }

                R.id.nav_account -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, AccountFragment())
                        .commit()
                }
            }

            true
        }
    }
}