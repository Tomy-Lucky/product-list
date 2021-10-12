package com.example.assignment.repository

import com.example.assignment.model.ProductModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<ProductModel, Long>{
    @Query(
        """
    from ProductModel 
    where id in :idList
  """
    )
    fun findAllByIdList(
        @Param("idList") idList: List<Long>
    ): List<ProductModel>
}
