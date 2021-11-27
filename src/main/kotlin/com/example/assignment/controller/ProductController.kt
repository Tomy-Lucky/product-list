package com.example.assignment.controller

import com.example.assignment.dto.Product
import com.example.assignment.service.ProductService
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty
import java.io.Serializable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product")
class ProductController(
    private val productService: ProductService
) {

    @HystrixCommand(
        fallbackMethod = "fallbackAllProducts",
        threadPoolKey = "findAll",
        threadPoolProperties = [
            HystrixProperty(name = "coreSize", value = "100"),
            HystrixProperty(name = "maxQueueSize", value = "50")
        ]
    )
    @GetMapping("/all")
    fun getAllProducts() = productService.findAll()

    private fun fallbackAllProducts() = "Request fails. It takes long time to response"

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = productService.findById(id = id)

    @PostMapping("/id-list")
    fun getById(@RequestBody input: RequestProductIdList): InputProductIdList {
       return InputProductIdList(
           productIdList = productService.getAllProductIdList(idList = input.productIdList)
       )
    }

    @PostMapping("/add-product")
    fun addProduct(@RequestBody input: AddProduct) {
        productService.addProduct(addProduct = input)
    }

    @DeleteMapping("/delete-product/{id}")
    fun deleteProduct(@PathVariable id: Long) {
        productService.deleteProduct(id = id)
    }

    @PostMapping("/decrease-amount")
    fun decreaseAmount(@RequestBody input: DecreaseAmount) {
        productService.decreaseAmount(id = input.id, amount = input.amount)
    }
}

data class AddProduct(
    val name: String,
    val description: String,
    val price: Double,
    val amount: Long
): Serializable

data class DecreaseAmount(
    val id: Long,
    val amount: Long
): Serializable

data class InputProductIdList(
    val productIdList: List<Product>
)

data class RequestProductIdList(
    val productIdList: List<Long>
)