package com.example.assignment.dto

import java.io.Serializable

data class Product(
    val id: Long,
    val name: String,
    val description: String,
    val price: Double,
    val amount: Long
): Serializable
