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
import com.thabang.BusTicket.databinding.EftMethodBinding

class EftActivity : AppCompatActivity() {
    lateinit var binding : EftMethodBinding
    var price = 0
    var ticketno = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.buy_ticket)


        binding = EftMethodBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.txtrefno.text = UserInfo.globalTicketNo
        binding.txtamount.text = UserInfo.globalPrice.toString()
        binding.btneftdone.setOnClickListener {
            Toast.makeText(this, "Ticket bought succesfully, Awaits payment", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainMenuActivity::class.java)
            startActivity(intent)
        }

    }
}