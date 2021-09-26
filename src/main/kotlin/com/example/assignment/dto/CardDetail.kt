package com.example.assignment.dto

import java.io.Serializable

data class CardDetail(
    val id: Long,
    val cardNumber: String,
    val password: String,
    val cash: Double
): Serializable
