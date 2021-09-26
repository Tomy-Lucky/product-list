package com.example.assignment.service

import com.example.assignment.exception.CardNotFoundByNumberAndPasswordException
import com.example.assignment.exception.IncorrectCashException
import com.example.assignment.model.CardDetailModel
import com.example.assignment.model.toDTO
import com.example.assignment.repository.CardDetailRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CardDetailService(
    private val cardDetailRepository: CardDetailRepository
) {

    @Transactional
    fun createAccount(
        cardNumber: String,
        password: String,
        cash: Double
    ) {
        cardDetailRepository.save(
            CardDetailModel(
                id = 0,
                cardNumber = cardNumber,
                password = password,
                cash = cash
            )
        )
    }

    @Transactional
    fun makePayment(
        cardNumber: String,
        password: String,
        cash: Double
    ) {
        val cardDetail = cardDetailRepository.findByCardNumberAndPassword(
            cardNumber = cardNumber,
            password = password
        ) ?: throw CardNotFoundByNumberAndPasswordException(cardNumber = cardNumber, password = password)

        if (cardDetail.cash < cash)
            throw IncorrectCashException(cardNumber = cardNumber, cash = cash)

        cardDetail.cash -= cash
    }
}