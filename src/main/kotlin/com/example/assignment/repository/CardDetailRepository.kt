package com.example.assignment.repository

import com.example.assignment.model.CardDetailModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CardDetailRepository: JpaRepository<CardDetailModel, Long> {

    fun findByCardNumberAndPassword(cardNumber: String, password: String): CardDetailModel?
}
