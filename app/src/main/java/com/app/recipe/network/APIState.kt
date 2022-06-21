package com.app.recipe.network

import com.app.recipe.network.baseModel.ErrorResponseModel

/**
 * State Management for UI & Data.
 */
sealed class State<T> {
    class Loading<T>(val isLoading: Boolean) : State<T>()

    data class Success<T>(val body: T?) : State<T>()

    data class Error<T>(val message: String, val errorBody: ErrorResponseModel?) : State<T>()

    data class Exception<T>(val exception: kotlin.Exception) : State<T>()

    companion object {

        /**
         * Returns [State.Loading] instance.
         */
        fun <T> loading(isLoading: Boolean) = Loading<T>(isLoading = isLoading)

        /**
         * Returns [State.Success] instance.
         * @param data Data to emit with status.
         */
        fun <T> success(data: T?) =
                Success(data)


        /**
         * Returns [State.Error] instance.
         * @param message Description of failure.
         */
        fun <T> error(message: String, errorBody: ErrorResponseModel?) =
                Error<T>(message, errorBody)

        /**
         * Returns [State.Exception] instance.
         * @param message Description of Exception.
         */
        fun <T> exception(message: kotlin.Exception) =
                Exception<T>(message)
    }
}