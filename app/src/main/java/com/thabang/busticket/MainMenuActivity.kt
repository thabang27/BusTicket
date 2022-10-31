package com.thabang.busticket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.thabang.BusTicket.R
import com.thabang.BusTicket.databinding.MainMenuBinding
import com.thabang.BusTicket.databinding.NavHeaderBinding

class MainMenuActivity  : AppCompatActivity()  {
    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var binding : MainMenuBinding
    lateinit var navbinding : NavHeaderBinding
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)

        val drawerLayout : DrawerLayout = findViewById(R.id.drawerlayout)
        val navView : NavigationView = findViewById(R.id.nav_view)


        binding = MainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navbinding = NavHeaderBinding.inflate(layoutInflater)
        setContentView(binding.root)




        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()



        binding.btnavailabletickets.setOnClickListener {
            val intent = Intent(this, AvailableTicketActivity::class.java)
            startActivity(intent)
        }
        binding.btnbuytickets.setOnClickListener {
            val intent = Intent(this, BuyTicketActivity::class.java)
            startActivity(intent)
        }
        binding.btnpurchasetrips.setOnClickListener {
            val intent = Intent(this, SelectTicketActivity::class.java)
            startActivity(intent)
        }
        binding.btnmapview.setOnClickListener {
            val intent = Intent(this, MapViewActivity::class.java)
            startActivity(intent)
        }


        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navbinding.emailET.text = UserInfo.globalEmail
        supportActionBar?.setDisplayHomeAsUpEnabled(true)




        navView.setNavigationItemSelectedListener {


            when(it.itemId){
                
                R.id.nav_main_menu-> Toast.makeText(applicationContext,"You are on main menu",Toast.LENGTH_SHORT).show()
                R.id.nav_ticket-> {val intent = Intent(this, AvailableTicketActivity::class.java)
                    startActivity(intent)}

            }
            true
        }
    }

    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if(firebaseUser != null){
            val email = firebaseUser.email

        }
        else{
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    }

