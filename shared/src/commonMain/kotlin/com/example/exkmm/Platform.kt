package com.example.exkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform