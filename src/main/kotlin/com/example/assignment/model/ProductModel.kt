package com.example.assignment.model

import com.example.assignment.dto.Product
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "product")
class ProductModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long,

    @Column
    var name: String,

    @Column
    var description: String,

    @Column
    var price: Double,

    @Column
    var amount: Long
): Serializable

fun ProductModel.toDTO() = Product(
    id = id,
    name = name,
    description = description,
    price = price,
    amount = amount
)

