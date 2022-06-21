package com.app.recipe.network

import androidx.annotation.MainThread
import com.app.recipe.network.baseModel.ErrorResponseModel
import com.app.recipe.utils.fromJson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response

@ExperimentalCoroutinesApi
abstract class MultiSourceResultParser<RESULT> {

    fun asFlow() = flow<State<RESULT>> {

        // Emit Loading State
        emit(State.loading(true))

        val dbResponse = fetchFromDB()

        if (dbResponse != null ) {
            delay(100) // added delay for fragment to get initialize properly
            emit(State.success(dbResponse))
            emit(State.loading(false))
            return@flow
        }
        // Fetch latest data from remote
        val apiResponse = fetchFromRemote()

        // Parse body
        val remoteData = apiResponse.body()

        // Check for response validation
        if (remoteData != null && apiResponse.isSuccessful) {
            updateDB(remoteData)
            emit(State.success(remoteData))
        } else {
            // Something went wrong! Emit Error state.
            val errorBody = apiResponse.errorBody()?.string()?.fromJson<ErrorResponseModel>()
            emit(State.error(errorBody?.getMessageError() ?: "Error parsing response", errorBody))
        }
        emit(State.loading(false))
    }.catch { e ->
        // Exception occurred! Emit error
        emit(State.exception(e as Exception))
        e.printStackTrace()
        emit(State.loading(false))
    }

    /**
     * Fetches [Response] from the remote end point.
     */
    protected abstract suspend fun fetchFromRemote(): Response<RESULT>
    protected abstract suspend fun fetchFromDB(): RESULT?
    protected abstract suspend fun updateDB(item: RESULT)
}
