package com.thabang.busticket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.thabang.BusTicket.R
import com.thabang.BusTicket.databinding.MainMenuBinding
import com.thabang.BusTicket.databinding.PaymentMethodBinding

class PaymentMethodActivity : AppCompatActivity() {


    lateinit var binding : PaymentMethodBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.payment_method)


        binding = PaymentMethodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btneft.setOnClickListener {
            val intent = Intent(this, EftActivity::class.java)
            startActivity(intent)
        }
        binding.btncard.setOnClickListener {
            val intent = Intent(this, PayWithCardActivity::class.java)
            startActivity(intent)
        }
    }
}