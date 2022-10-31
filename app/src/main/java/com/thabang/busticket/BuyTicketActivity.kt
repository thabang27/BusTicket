package com.thabang.busticket

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.thabang.BusTicket.R
import com.thabang.BusTicket.databinding.BuyTicketBinding
import java.text.FieldPosition
import java.text.SimpleDateFormat
import java.util.*
import com.thabang.busticket.SignInActivity

class BuyTicketActivity : AppCompatActivity() {


    lateinit var binding : BuyTicketBinding
    lateinit var buscompany : Spinner
    lateinit var route : Spinner
    lateinit var trips :Spinner
    lateinit var price : TextView
    var noOfTrips = 0
    var selectedbusservice = "leeto"
    var selectedroute = ""
    var selectedtrips = ""
    var ticketPrice = 0.00
    var ticketNo = null

    lateinit var firebaseAuth: FirebaseAuth
    lateinit var dbRef : DatabaseReference



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.buy_ticket)


        binding = BuyTicketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buscompany = findViewById(R.id.bus_company) as Spinner
        route = findViewById(R.id.sproute) as Spinner
        trips = findViewById(R.id.sptrips) as Spinner
        price = findViewById(R.id.txtprice) as TextView


        dbRef = FirebaseDatabase.getInstance().getReference("Tickets")


        val options = arrayOf("Leeto","GreatNorth bus service")
        buscompany.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        val options2 = arrayOf("Seshego To Polokwane CBD","Polokwane CBD to Savanna","Polokwane CBD to Mall of the North","Polokwane CBD to Fauna Park")
        route.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options2)
        val options3 = arrayOf("1 Trip","Weekly Trips","Monthly Trips")
        trips.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options3)

        buscompany.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            @SuppressLint("SetTextI18n")
            override fun onNothingSelected(p0: AdapterView<*>?) {
                price.text = "R 0.00"
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedbusservice = options[position]
            }
        }
        route.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            @SuppressLint("SetTextI18n")
            override fun onNothingSelected(p0: AdapterView<*>?) {
                price.text = "R 6.00"
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedroute = options2[position]
            }
        }
        trips.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            @SuppressLint("SetTextI18n")
            override fun onNothingSelected(p0: AdapterView<*>?) {
                price.text = "R 6.00"
            }

            @SuppressLint("SetTextI18n")
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                selectedtrips = options3[position]
                if(selectedtrips == "1 Trip"){
                    price.text = "R6.00"
                    noOfTrips = 1
                    ticketPrice = 6.00
                }
                else if(selectedtrips == "Weekly Trips"){
                    price.text = "R56.00"
                    noOfTrips = 14
                    ticketPrice = 56.00
                }
                if(selectedtrips == "Monthly Trips"){
                    price.text = "R580.00"
                    noOfTrips = 62
                    ticketPrice = 580.00

                }
            }
        }

        binding.btnpay.setOnClickListener {

            createTicket()
            val intent = Intent(this, PaymentMethodActivity::class.java)
            startActivity(intent)
        }

    }

    @SuppressLint("SimpleDateFormat")
    private fun createTicket() {
        val buscompanyEt = buscompany.selectedItem.toString()
        val routeEt = route.selectedItem.toString()
        val tripsEt = noOfTrips
        val email = UserInfo.globalEmail
        UserInfo.globalPrice = ticketPrice




        val ticketId = dbRef.push().key!!
        val ticket = TicketModel(ticketId,email,buscompanyEt,routeEt,tripsEt)
        UserInfo.globalTicketNo = ticketId
        dbRef.child(ticketId).setValue(ticket)
            .addOnCompleteListener {

            }
            .addOnFailureListener {
                Toast.makeText(this, "Buying Ticket Failed", Toast.LENGTH_SHORT).show()
            }
    }
}