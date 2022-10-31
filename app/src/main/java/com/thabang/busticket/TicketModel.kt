package com.thabang.busticket

import android.provider.ContactsContract

data class TicketModel (
    val ticketId: String? = null,
    val email: String? = null,
    val buscompany: String? = null,
    val route: String? = null,
    val trips: Int? = null
    )