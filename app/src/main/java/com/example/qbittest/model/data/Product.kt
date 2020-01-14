package com.example.qbittest.model.data

import com.google.gson.annotations.SerializedName

data class Product(

    @field:SerializedName("id_products")
    val idProducts: Int? = null,

    @field:SerializedName("name_products")
    val nameProducts: String? = null,

    @field:SerializedName("image_product")
    val imageProducts: String? = null

)
