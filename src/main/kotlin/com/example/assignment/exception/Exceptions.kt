package com.example.assignment.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class CardNotFoundByNumberAndPasswordException(cardNumber: String, password: String) : RuntimeException("No such card with number: $cardNumber, password: $password")

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
class IncorrectCashException(cardNumber: String, cash: Double) : RuntimeException("Incorrect cash $cash for product with card number: $cardNumber")
