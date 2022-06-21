package com.app.recipe.network.baseModel

data class ErrorResponseModel(
        var code: Int,
        var message: String?
) {
    fun getMessageError(): String {
        return message ?: "Some thing went wrong"
    }
}