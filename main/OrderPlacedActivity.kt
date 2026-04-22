package com.example.swiggyclone

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class OrderPlacedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_placed)

        // clear cart
        CartManager.cartList.clear()

        // auto close after 1.5 sec
        Handler(Looper.getMainLooper()).postDelayed({
            finish()
        }, 3000)
    }
}