package com.leads.capita_alpha

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform