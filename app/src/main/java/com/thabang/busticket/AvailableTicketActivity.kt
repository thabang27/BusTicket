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
import com.thabang.BusTicket.databinding.AvailableTicketsBinding

class AvailableTicketActivity : AppCompatActivity() {

    lateinit var binding : AvailableTicketsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.available_tickets)


        binding = AvailableTicketsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtrticketoute.setOnClickListener {
            val intent = Intent(this, TicketActivity::class.java)
            startActivity(intent)
        }
        binding.txttickettrips .setOnClickListener {
            val intent = Intent(this, TicketActivity::class.java)
            startActivity(intent)
        }

    }
}