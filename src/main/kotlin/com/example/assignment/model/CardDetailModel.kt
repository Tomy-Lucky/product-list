package com.example.assignment.model

import com.example.assignment.dto.CardDetail
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "card_detail")
class CardDetailModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long,

    @Column
    var cardNumber: String,

    @Column
    var password: String,

    @Column
    var cash: Double
): Serializable

fun CardDetailModel.toDTO() = CardDetail(
    id = id,
    cardNumber = cardNumber,
    password = password,
    cash = cash
)
