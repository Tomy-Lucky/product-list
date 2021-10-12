package com.example.assignment.service

import com.example.assignment.controller.AddProduct
import com.example.assignment.exception.IncorrectAmountException
import com.example.assignment.exception.ProductNotFoundByIdException
import com.example.assignment.model.ProductModel
import com.example.assignment.model.toDTO
import com.example.assignment.repository.ProductRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(
    private val productRepository: ProductRepository
) {

    fun findAll() = productRepository.findAll().map { it.toDTO() }

    fun findById(id: Long) = productRepository.findByIdOrNull(id)?.toDTO() ?: throw ProductNotFoundByIdException(id)

    fun getAllProductIdList(idList: List<Long>) = productRepository.findAllByIdList(idList = idList).map { it.toDTO() }

    @Transactional
    fun addProduct(addProduct: AddProduct) {
        productRepository.save(
            ProductModel(
                id = 0,
                name = addProduct.name,
                description = addProduct.description,
                price = addProduct.price,
                amount = addProduct.amount
            )
        )
    }

    @Transactional
    fun deleteProduct(id: Long) {
        productRepository.deleteById(id)
    }

    @Transactional
    fun decreaseAmount(id: Long, amount: Long) {
        val product = productRepository.findByIdOrNull(id) ?: throw ProductNotFoundByIdException(id)
        if (product.amount < amount) throw IncorrectAmountException(id = id, amount = amount)
        product.amount -= amount
    }
}
