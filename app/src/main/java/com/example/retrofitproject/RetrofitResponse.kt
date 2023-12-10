package com.example.retrofitproject

import com.google.gson.annotations.SerializedName

data class RetrofitResponse(

	@field:SerializedName("RetrofitResponse")
	val retrofitResponse: List<RetrofitResponseItem?>? = null
)

data class RetrofitResponseItem(

	@field:SerializedName("albumId")
	val albumId: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("thumbnailUrl")
	val thumbnailUrl: String? = null
)
