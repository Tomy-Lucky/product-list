package com.example.assignment.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class ProductNotFoundByIdException(id: Long) : RuntimeException("No such product with id: $id")

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
class IncorrectAmountException(id: Long, amount: Long) : RuntimeException("Incorrect amount $amount for product with id: $id")
