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
import com.thabang.BusTicket.databinding.SelectTicketBinding

class SelectTicketActivity : AppCompatActivity() {

    lateinit var binding : SelectTicketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pay_with_card)


        binding = SelectTicketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtcticketinfo.setOnClickListener {
            val intent = Intent(this, PurchaseTripsActivity::class.java)
            startActivity(intent)
        }
        binding.txtnotrips.setOnClickListener {
            val intent = Intent(this, PurchaseTripsActivity::class.java)
            startActivity(intent)
        }

    }
}
