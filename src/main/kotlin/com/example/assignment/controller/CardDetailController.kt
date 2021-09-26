package com.example.assignment.controller

import com.example.assignment.service.CardDetailService
import java.io.Serializable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/card-detail")
class CardDetailController(
    private val cardDetailService: CardDetailService
) {

    @PostMapping("/create-account")
    fun createAccount(@RequestBody input: CardDetailInput) = cardDetailService.createAccount(
        cardNumber = input.cardNumber,
        password = input.password,
        cash = input.cash
    )

    @PostMapping("/make-payment")
    fun makePayment(@RequestBody input: CardDetailInput) = cardDetailService.createAccount(
        cardNumber = input.cardNumber,
        password = input.password,
        cash = input.cash
    )
}

data class CardDetailInput(
    val cardNumber: String,
    val password: String,
    val cash: Double
) : Serializable
